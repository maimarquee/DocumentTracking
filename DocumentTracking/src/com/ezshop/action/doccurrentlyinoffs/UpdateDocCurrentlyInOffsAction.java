package com.ezshop.action.doccurrentlyinoffs;

import com.ezshop.dto.DocCurrentlyInOffsDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.DTOBase;
import com.mytechnopal.util.DTOUtil;

public class UpdateDocCurrentlyInOffsAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void setSessionVars(){
		if(!sessionInfo.isPreviousLinkUpdateSubmit()) {
			Pagination pagination = (Pagination) getSessionAttribute(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS_PAGINATION);
			String code = getRequestString("txtSelectedRecord");
			DTOBase userObj = DTOUtil.getObjByCode(pagination.getCurrentPageRecordList(), code);
			DocCurrentlyInOffsDTO dcio = (DocCurrentlyInOffsDTO) userObj;
			
			setSessionAttribute(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS + "_ORIG", dcio);
			setSessionBeforeTrans(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS,  dcio.getDocCurrentInOffs());
		}
	}
}

