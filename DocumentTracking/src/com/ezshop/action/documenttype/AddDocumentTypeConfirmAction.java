package com.ezshop.action.documenttype;

import java.util.List;

import com.ezshop.dao.DocumentTypeDAO;
import com.ezshop.dto.DocumentTrackingDTO;
import com.ezshop.dto.DocumentTypeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;

public class AddDocumentTypeConfirmAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void validateInput() {
		validateTrans();
	}
	
	protected void setSessionVars() {
		setSessionLinkOnConfirm();
	}
	
	protected void executeLogic() {
		execute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE, new DocumentTypeDAO(), DAOBase.DAO_ACTION_ADD);

		if(sessionInfo.getCallBackLink() != null) {
			sessionInfo.setCurrentLink(sessionInfo.getCallBackLink().getLinkDTO());
			sessionInfo.setTransitionLink(new String[] {"U191", "U196"}, new String[] {"U192", "U197", "U199"}, new String[] {"U193", "U198", "U200"}, "U194", "U195");
			sessionInfo.setTransactionFinished(false);
			
			DocumentTypeDTO documentType = (DocumentTypeDTO) getSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE);
			DocumentTrackingDTO documentTracking = (DocumentTrackingDTO) getSessionAttribute(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING);
			List<DTOBase> documentTypeList = (List<DTOBase>) getSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST);
			documentType.setDisplayText(documentType.getName());
			
			documentTypeList.add(documentType);
			documentTracking.setDocument_type(documentType);
		}
	}
}
