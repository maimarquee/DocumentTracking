package com.ezshop.action.documenttracking;

import java.util.List;


import com.ezshop.dao.DocumentTypeDAO;
import com.ezshop.dto.DocumentTrackingDTO;
import com.ezshop.dto.DocumentTypeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;

public class AddDocumentTrackingAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setTransitionLink(new String[] {"U191", "U196"}, new String[] {"U192", "U197", "U199"}, new String[] {"U193", "U198", "U200"}, "U194", "U195");
		//add unit action													add unit confirm action
if(!sessionInfo.isPreviousLinkAddSubmit() && !sessionInfo.getPreviousLink().getCode().equalsIgnoreCase("U169") && !sessionInfo.getPreviousLink().getCode().equalsIgnoreCase("U171")) {
		DocumentTrackingDTO documenttracking = new DocumentTrackingDTO();
		List<DTOBase> documenttype = new DocumentTypeDAO().getDocumentTypeList();
		documenttracking.setDocument_type((DocumentTypeDTO) documenttype.get(0));
		setSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST, documenttype);
		setSessionBeforeTrans(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING, documenttracking);
}
	}
}
