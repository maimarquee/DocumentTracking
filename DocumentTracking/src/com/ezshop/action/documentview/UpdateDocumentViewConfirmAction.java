package com.ezshop.action.documentview;


import com.ezshop.dao.DocumentViewDAO;
import com.ezshop.dto.DocumentViewDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DAOBase;

public class UpdateDocumentViewConfirmAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void validateInput() {
		validateTrans();
	}
	
	protected void setSessionVars(){
		setSessionLinkOnConfirm();
		if(message.isMessageTypeSuccess()) {
			replaceObjByCode(DocumentViewDTO.SESSION_DOCUMENT_VIEW_PAGINATION, DocumentViewDTO.SESSION_DOCUMENT_VIEW_LIST, DocumentViewDTO.SESSION_DOCUMENT_VIEW);
			sessionInfo.setCurrentLink(sessionInfo.getListLink());
		}
	}
	
	protected void executeLogic() {
		execute(DocumentViewDTO.SESSION_DOCUMENT_VIEW, new DocumentViewDAO(), DAOBase.DAO_ACTION_UPDATE);
	}
}
