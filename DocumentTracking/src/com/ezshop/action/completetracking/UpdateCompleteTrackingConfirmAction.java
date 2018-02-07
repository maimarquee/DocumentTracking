package com.ezshop.action.completetracking;

import com.ezshop.dao.CompleteTrackingDAO;
import com.ezshop.dto.CompleteTrackingDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DAOBase;

public class UpdateCompleteTrackingConfirmAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void validateInput() {
		validateTrans();
	}
	
	protected void setSessionVars(){
		setSessionLinkOnConfirm();
		if(message.isMessageTypeSuccess()) {
			removeObjByCode(CompleteTrackingDTO.SESSION_COMPLETE_TRACKING_PAGINATION, CompleteTrackingDTO.SESSION_COMPLETE_TRACKING_LIST, CompleteTrackingDTO.SESSION_COMPLETE_TRACKING);
			sessionInfo.setCurrentLink(sessionInfo.getListLink());
		}
	}
	
	protected void executeLogic() {
		execute(CompleteTrackingDTO.SESSION_COMPLETE_TRACKING, new CompleteTrackingDAO(), DAOBase.DAO_ACTION_UPDATE);
	}
}
