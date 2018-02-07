package com.ezshop.action.user;

import java.util.List;

import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.comparator.UserLastNameComparator;
import com.mytechnopal.dao.UserDAO;
import com.mytechnopal.dao.UserGroupDAO;
import com.mytechnopal.dto.UserDTO;
import com.mytechnopal.dto.UserGroupDTO;

public class ListUserAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setTransitionLink(new String[] {"", "U013"}, new String[] {"", "U014", ""}, new String[] {"", "U015", ""}, "U011", "U012");
		if(!sessionInfo.isPreviousLinkUpdate()) {
			setSessionAttribute(UserGroupDTO.SESSION_USER_GROUP_LIST, new UserGroupDAO().getUserGroupList(true));
			List<DTOBase> userList = new UserDAO().getUserList();
			new UserLastNameComparator().sort(userList);
			setSessionOnPagination(UserDTO.SESSION_USER_PAGINATION, UserDTO.SESSION_USER, new UserDTO(), UserDTO.SESSION_USER_LIST, userList);
		}
	}
}
