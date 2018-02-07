package com.ezshop.action.completetracking;

import com.ezshop.dto.CompleteTrackingDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.util.DTOUtil;

public class UpdateCompleteTrackingAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void setSessionVars(){
		if(!sessionInfo.isPreviousLinkUpdateSubmit()) {
			Pagination pagination = (Pagination) getSessionAttribute(CompleteTrackingDTO.SESSION_COMPLETE_TRACKING_PAGINATION);
			String code = getRequestString("txtSelectedRecord");
			DTOBase userObj = DTOUtil.getObjByCode(pagination.getCurrentPageRecordList(), code);
			CompleteTrackingDTO dcio = (CompleteTrackingDTO) userObj;
			
			setSessionAttribute(CompleteTrackingDTO.SESSION_COMPLETE_TRACKING + "_ORIG", dcio);
			setSessionBeforeTrans(CompleteTrackingDTO.SESSION_COMPLETE_TRACKING,  dcio.getCompleteTracking());
		}
	}
}
