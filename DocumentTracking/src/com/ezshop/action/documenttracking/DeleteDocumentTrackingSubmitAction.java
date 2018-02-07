package com.ezshop.action.documenttracking;

import com.ezshop.dto.DocumentTrackingDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.util.DTOUtil;

public class DeleteDocumentTrackingSubmitAction extends ActionBase{

	private static final long serialVersionUID = 1L;

	protected void validateInput() {
		Pagination pagination = (Pagination) getSessionAttribute(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING_PAGINATION);
		String code = getRequestString("txtSelectedRecord");
		DTOBase userObj = DTOUtil.getObjByCode(pagination.getCurrentPageRecordList(), code);
		DocumentTrackingDTO documenttracking = (DocumentTrackingDTO) userObj;
		setSessionBeforeTrans(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING, documenttracking);
	}

	protected void setSessionVars() {
		setSessionLinkOnSubmit();
	}

}
