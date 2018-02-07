package com.ezshop.action.documenttracking;
import com.ezshop.dto.DocumentTrackingDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.DTOBase;
import com.mytechnopal.util.DTOUtil;

public class UpdateDocumentTrackingAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void setSessionVars(){
		if(!sessionInfo.isPreviousLinkUpdateSubmit()) {
			Pagination pagination = (Pagination) getSessionAttribute(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING_PAGINATION);
			String code = getRequestString("txtSelectedRecord");
			DTOBase userObj = DTOUtil.getObjByCode(pagination.getCurrentPageRecordList(), code);
			DocumentTrackingDTO documenttracking = (DocumentTrackingDTO) userObj;
			
			setSessionAttribute(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING + "_ORIG", documenttracking);
			setSessionBeforeTrans(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING,  documenttracking.getDocumentTracking());
		}
	}
}
