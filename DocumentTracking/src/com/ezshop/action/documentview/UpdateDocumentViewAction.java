package com.ezshop.action.documentview;

import com.ezshop.dto.DocumentViewDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.util.DTOUtil;

public class UpdateDocumentViewAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void setSessionVars(){
		if(!sessionInfo.isPreviousLinkUpdateSubmit()) {
			Pagination pagination = (Pagination) getSessionAttribute(DocumentViewDTO.SESSION_DOCUMENT_VIEW_PAGINATION);
			String code = getRequestString("txtSelectedRecord");
			DTOBase userObj = DTOUtil.getObjByCode(pagination.getCurrentPageRecordList(), code);
			DocumentViewDTO dcio = (DocumentViewDTO) userObj;
			
			setSessionAttribute(DocumentViewDTO.SESSION_DOCUMENT_VIEW + "_ORIG", dcio);
			setSessionBeforeTrans(DocumentViewDTO.SESSION_DOCUMENT_VIEW,  dcio.getDocumentView());
		}
	}
}

