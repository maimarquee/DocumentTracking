package com.ezshop.action.documenttype;

import com.ezshop.dao.DocumentTypeDAO;
import com.ezshop.dto.DocumentTypeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DAOBase;

public class DeleteDocumentTypeConfirmAction extends ActionBase{

	private static final long serialVersionUID = 1L;

	protected void validateInput() {
		validateTrans();
	}
	
	protected void executeLogic() {
		execute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE, new DocumentTypeDAO(), DAOBase.DAO_ACTION_DELETE);
	}
	
	protected void setSessionVars() {
		setSessionLinkOnConfirm();
		if(message.isMessageTypeSuccess()) {
			removeObjByCode(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_PAGINATION, DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST, DocumentTypeDTO.SESSION_DOCUMENT_TYPE);
			sessionInfo.setCurrentLink(sessionInfo.getListLink());
		}
	}
}
