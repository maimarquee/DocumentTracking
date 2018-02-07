package com.ezshop.action.guest;

import com.mytechnopal.ActionBase;
import com.mytechnopal.Message;
import com.mytechnopal.dao.UserDAO;
import com.mytechnopal.dto.LinkDTO;
import com.mytechnopal.dto.UserDTO;
import com.mytechnopal.util.BaseSettingsUtil;
import com.mytechnopal.util.DateTimeUtil;
import com.mytechnopal.util.StringUtil;

public class LoginSubmitAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	protected void validateInput() {
		UserDTO user = (UserDTO) getSessionAttribute(UserDTO.SESSION_USER);
		String userName = request.getParameter("txtUserName");
		String password = request.getParameter("txtPassword");
		
		user.setUserName(userName);
		user.setPassword(password);
		
		if(StringUtil.isEmpty(userName)) {
			message.constructMsg(Message.MSG_CLASS_EMPTY, new String[]{"User Name"});
		}
		else if(StringUtil.isEmpty(password)) {
			message.constructMsg(Message.MSG_CLASS_EMPTY, new String[]{"Password"});
		}
		else {
			UserDAO userDAO = new UserDAO();
			user = userDAO.getUserByUserNamePassword(userName, password);
			if(user == null) {
				message.constructMsg(Message.MSG_CLASS_INVALID, new String[]{"Combination of user name and password found."});
			}
			else {
				if(!user.isActive()) {
					message.constructMsg(Message.MSG_CLASS_ACTION_FAIL, new String[]{"Your profile is already inactive.  Please contact the administrator"});
				}
				else {
					user.setLastLoginTimestamp(DateTimeUtil.getCurrentTimestamp());
					user.setLastLoginIPAddress(getClientIpAddress());
					userDAO.executeUpdateUserLastLogin(user);
				}
				setSessionAttribute(UserDTO.SESSION_USER, user);
			}
		}
	}
	
	protected void executeLogic() {
		UserDTO user = (UserDTO) getSessionAttribute(UserDTO.SESSION_USER);
		resetSessionInfo(new LinkDTO(), sessionInfo.getUserByCode(user.getCode()), new LinkDTO());
		
		LinkDTO link = null;
		LinkDTO homeLink = null;
		link = sessionInfo.getLinkByCode(BaseSettingsUtil.USER_TP_HOME_LINK_CODE);
		homeLink = sessionInfo.getLinkByCode(link.getCode());
		sessionInfo.setCurrentLink(link);
		sessionInfo.setHomeLink(homeLink);
		new HomeAction().executeAction(request, response, sessionInfo);
	}

	protected void setSessionVars() {
		setSessionLinkOnSubmit();
	}
}
