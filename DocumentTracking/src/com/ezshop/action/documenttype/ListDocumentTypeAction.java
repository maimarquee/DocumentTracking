package com.ezshop.action.documenttype;

import com.ezshop.dao.DocumentTypeDAO;
import com.ezshop.dto.DocumentTypeDTO;
import com.mytechnopal.ActionBase;

public class ListDocumentTypeAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void setSessionVars() {

		sessionInfo.setTransitionLink(new String[] {"U169",  "U174"}, new String[] {"U170",  "U175", "U177"}, new String[] {"U171",  "U176", "U178"}, "U172", "U173");
	
		if(!sessionInfo.isPreviousLinkUpdate() && !sessionInfo.isPreviousLinkDeleteSubmit()) {
			//setSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST, new DocumentTypeDAO().getDocumentTypeList());
			setSessionOnPagination(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_PAGINATION, DocumentTypeDTO.SESSION_DOCUMENT_TYPE, new DocumentTypeDTO(), DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST, new DocumentTypeDAO().getDocumentTypeList());
		}
	}
}
