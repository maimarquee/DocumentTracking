package com.ezshop.action.documenttype;

import com.ezshop.dto.DocumentTypeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.util.DTOUtil;

public class UpdateDocumentTypeAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void setSessionVars() {
		if(!sessionInfo.isPreviousLinkUpdateSubmit()){
			Pagination pagination = (Pagination) getSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_PAGINATION);
			String code = getRequestString("txtSelectedRecord");
			DTOBase userObj = DTOUtil.getObjByCode(pagination.getCurrentPageRecordList(), code);
			DocumentTypeDTO documenttype = (DocumentTypeDTO) userObj;
			
			setSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE + "_ORIG", documenttype);
			setSessionBeforeTrans(DocumentTypeDTO.SESSION_DOCUMENT_TYPE, documenttype.getDocumentType());
		}
	}

}
