package com.ezshop.action.completetracking;

import com.ezshop.dao.CompleteTrackingDAO;
import com.ezshop.dto.CompleteTrackingDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.pagination.Pagination;

public class SearchCompleteTrackingAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void setSessionVars() {
		sessionInfo.setCurrentLink(sessionInfo.getPreviousLink());
	}
	
	protected void validateInput() {
		Pagination pagination = (Pagination) getSessionAttribute(CompleteTrackingDTO.SESSION_COMPLETE_TRACKING_PAGINATION);
		String searchCriteria = getRequestString("cboSearchCriteria");
		String searchValue = getRequestString("txtSearchValue");
		if(searchCriteria.equalsIgnoreCase("SearchByNameCode")) {
			pagination.setRecordList(new CompleteTrackingDAO().getCompleteTrackingList(searchValue));
			if(pagination.getTotalPage() == 0) {
				message.constructMsg(message.MSG_CLASS_ACTION_FAIL, new String[] {"No Record Found"});
			}
		}
		pagination.setSearchCriteria(searchCriteria);
		pagination.setSearchValue(searchValue);
		pagination.setCurrentPage(1);
		setSessionAttribute(CompleteTrackingDTO.SESSION_COMPLETE_TRACKING_PAGINATION, pagination);
	}
}
