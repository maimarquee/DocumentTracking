package com.ezshop.action.user;

import com.mytechnopal.ActionBase;
import com.mytechnopal.DAOBase;
import com.mytechnopal.dao.UserDAO;
import com.mytechnopal.dto.UserDTO;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.util.DTOUtil;

public class UpdateUserConfirmAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	protected void executeLogic() {
		execute(UserDTO.SESSION_USER, new UserDAO(), DAOBase.DAO_ACTION_UPDATE);
	}

	protected void setSessionVars() {
		setSessionLinkOnConfirm();
		if(message.isMessageTypeSuccess()) {
			Pagination pagination = (Pagination) getSessionAttribute(UserDTO.SESSION_USER_PAGINATION);
			UserDTO user = (UserDTO) getSessionAttribute(UserDTO.SESSION_USER);
			pagination.setRecordList(DTOUtil.replaceObjByCode(pagination.getRecordList(), user));
			sessionInfo.setCurrentLink(sessionInfo.getListLink());
		}
	}

	protected void validateInput() {
		validateTrans();
	}
}
