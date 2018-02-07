package com.ezshop.action.office;

import com.ezshop.dao.OfficeDAO;
import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DAOBase;

public class UpdateOfficeConfirmAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void validateInput() {
		validateTrans();
	}
	
	protected void setSessionVars(){
		setSessionLinkOnConfirm();
		if(message.isMessageTypeSuccess()) {
			replaceObjByCode(OfficeDTO.SESSION_OFFICE_PAGINATION, OfficeDTO.SESSION_OFFICE_LIST, OfficeDTO.SESSION_OFFICE);
			sessionInfo.setCurrentLink(sessionInfo.getListLink());
		}
	}
	
	protected void executeLogic() {
		execute(OfficeDTO.SESSION_OFFICE, new OfficeDAO(), DAOBase.DAO_ACTION_UPDATE);
	}
}
