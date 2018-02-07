package com.ezshop.action.acceptdocument;


import com.ezshop.dto.AcceptDocumentDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.util.DTOUtil;

public class UpdateAcceptDocumentAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void setSessionVars(){
		if(!sessionInfo.isPreviousLinkUpdateSubmit()) {
			Pagination pagination = (Pagination) getSessionAttribute(AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT_PAGINATION);
			String code = getRequestString("txtSelectedRecord");
			DTOBase userObj = DTOUtil.getObjByCode(pagination.getCurrentPageRecordList(), code);
			AcceptDocumentDTO dcio = (AcceptDocumentDTO) userObj;
			
			setSessionAttribute(AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT + "_ORIG", dcio);
			setSessionBeforeTrans(AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT,  dcio.getAcceptDocument());
		}
	}
}

