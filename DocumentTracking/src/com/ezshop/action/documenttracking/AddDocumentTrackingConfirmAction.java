package com.ezshop.action.documenttracking;

import com.ezshop.dao.DocumentTrackingDAO;
import com.ezshop.dto.DocumentTrackingDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DAOBase;

public class AddDocumentTrackingConfirmAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	protected void validateInput() {
		validateTrans();
	}
	
	protected void setSessionVars() {
		setSessionLinkOnConfirm();
	}
	
	protected void executeLogic() {
		DocumentTrackingDTO documenttracking = (DocumentTrackingDTO) getSessionAttribute(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING);
		execute(documenttracking, new DocumentTrackingDAO(), DAOBase.DAO_ACTION_ADD);
	}

}
