package com.ezshop.action.user;

import com.mytechnopal.ActionBase;
import com.mytechnopal.dto.UserDTO;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.util.DTOUtil;

public class UpdateUserAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	@Override
	protected void setSessionVars() {
		//is previous link from the list
		if(!sessionInfo.isPreviousLinkUpdateSubmit()) {
			Pagination pagination = (Pagination) getSessionAttribute(UserDTO.SESSION_USER_PAGINATION);
			int id = getRequestInt("txtSelectedRecord");
			UserDTO user = (UserDTO) DTOUtil.getObjById(pagination.getCurrentPageRecordList(), id);
			setSessionBeforeTrans(UserDTO.SESSION_USER + "_ORIG", user);
			setSessionBeforeTrans(UserDTO.SESSION_USER, user.getUser());
		}
	}
}
