package com.ezshop.action.user;

import com.mytechnopal.ActionBase;
import com.mytechnopal.SessionInfo;
import com.mytechnopal.dto.UserDTO;

public class LogoutAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	protected void executeLogic() {
		sessionInfo = new SessionInfo();
		UserDTO user = sessionInfo.getCurrentUser().getUser();
		user.setUserName("");
		user.setPassword("");
		setSessionAttribute(UserDTO.SESSION_USER, user);
	}
}
