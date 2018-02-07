package com.ezshop.action.staff;

import com.mytechnopal.ActionBase;
import com.mytechnopal.DAOBase;
import com.ezshop.dao.StaffDAO;
import com.ezshop.dto.StaffDTO;

public class UpdateStaffConfirmAction extends ActionBase {
	private static final long serialVersionUID = 1L;
	
	protected void validateInput() {
		validateTrans();
	}
	
	protected void setSessionVars() {
		setSessionLinkOnConfirm();
		if(message.isMessageTypeSuccess()) {
			replaceObjByCode(StaffDTO.SESSION_STAFF_PAGINATION, StaffDTO.SESSION_STAFF_LIST, StaffDTO.SESSION_STAFF);
			sessionInfo.setCurrentLink(sessionInfo.getListLink());
		}
	}
	
	protected void executeLogic() {
		execute(StaffDTO.SESSION_STAFF, new StaffDAO(), DAOBase.DAO_ACTION_UPDATE);
	}
}
