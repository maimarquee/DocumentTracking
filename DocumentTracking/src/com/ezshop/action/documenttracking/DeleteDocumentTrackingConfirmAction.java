package com.ezshop.action.documenttracking;


import com.ezshop.dao.DocumentTrackingDAO;
import com.ezshop.dto.DocumentTrackingDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DAOBase;

public class DeleteDocumentTrackingConfirmAction extends ActionBase{

	private static final long serialVersionUID = 1L;

	protected void validateInput() {
		validateTrans();
	}
	
	protected void executeLogic() {
		execute(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING, new DocumentTrackingDAO(), DAOBase.DAO_ACTION_DELETE);
	}
	
	protected void setSessionVars() {
		setSessionLinkOnConfirm();
		if(message.isMessageTypeSuccess()) {
			removeObjByCode(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING_PAGINATION, DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING_LIST, DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING);
			sessionInfo.setCurrentLink(sessionInfo.getListLink());
		}
	}
}
