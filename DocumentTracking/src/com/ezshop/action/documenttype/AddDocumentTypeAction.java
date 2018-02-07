package com.ezshop.action.documenttype;

import com.ezshop.dto.DocumentTypeDTO;
import com.mytechnopal.ActionBase;

public class AddDocumentTypeAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		
		if(sessionInfo.getPreviousLink().getCode().equalsIgnoreCase("U191")) {//add merchandise link
			sessionInfo.setTransitionLink(new String[] {"U169", "U174"}, new String[] {"U170", "U175", "U177"}, new String[] {"U171", "U176", "U178"}, "U172", "U173", sessionInfo.getPreviousLink().getCode());
		}
		else {
			sessionInfo.setTransitionLink(new String[] {"U169", "U174"}, new String[] {"U170", "U175", "U177"}, new String[] {"U171", "U176", "U178"}, "U172", "U173");
		}
		
		if(!sessionInfo.isPreviousLinkAddSubmit()) {
			DocumentTypeDTO documenttype = new DocumentTypeDTO();
			setSessionBeforeTrans(DocumentTypeDTO.SESSION_DOCUMENT_TYPE, documenttype);
		}
	}
}
