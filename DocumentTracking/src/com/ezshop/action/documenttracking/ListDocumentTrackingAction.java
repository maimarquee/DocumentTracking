package com.ezshop.action.documenttracking;

import com.ezshop.dao.DocumentTrackingDAO;
import com.ezshop.dao.DocumentTypeDAO;
import com.ezshop.dto.DocumentTrackingDTO;
import com.ezshop.dto.DocumentTypeDTO;
import com.mytechnopal.ActionBase;

public class ListDocumentTrackingAction extends ActionBase{

	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setTransitionLink(new String[] {"U191", "U196"}, new String[] {"U192", "U197", "U199"}, new String[] {"U193", "U198", "U200"}, "U194", "U195");
		if(!sessionInfo.isPreviousLinkUpdate() && !sessionInfo.isPreviousLinkDeleteSubmit()) {
			setSessionOnPagination(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING_PAGINATION, DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING, new DocumentTrackingDTO(), DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING_LIST, new DocumentTrackingDAO().getDocumentTrackingList());
			setSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST, new DocumentTypeDAO().getDocumentTypeList());
		}
	}
}
