package com.ezshop.action.office;

import com.ezshop.dao.OfficeDAO;
import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DAOBase;

public class AddOfficeConfirmAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	protected void validateInput() {
		validateTrans();
	}
	
	protected void setSessionVars() {
		setSessionLinkOnConfirm();
	}
	
	protected void executeLogic() {
		OfficeDTO office = (OfficeDTO) getSessionAttribute(OfficeDTO.SESSION_OFFICE);
		execute(office, new OfficeDAO(), DAOBase.DAO_ACTION_ADD);
	}
}
