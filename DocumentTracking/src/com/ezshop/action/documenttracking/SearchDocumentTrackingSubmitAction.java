package com.ezshop.action.documenttracking;

import com.ezshop.dao.DocumentTrackingDAO;
import com.ezshop.dto.DocumentTrackingDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.pagination.Pagination;

public class SearchDocumentTrackingSubmitAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void setSessionVars() {
		sessionInfo.setCurrentLink(sessionInfo.getPreviousLink());
	}
	
	protected void validateInput() {
		Pagination pagination = (Pagination) getSessionAttribute(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING_PAGINATION);
		String searchCriteria = getRequestString("cboSearchCriteria");
		String searchValue = getRequestString("txtSearchValue");
		if(searchCriteria.equalsIgnoreCase("SearchByNameCode")) {
			pagination.setRecordList(new DocumentTrackingDAO().getDocumentTrackingList(searchValue));
			if(pagination.getTotalPage() == 0) {
				message.constructMsg(message.MSG_CLASS_ACTION_FAIL, new String[] {"No Record Found"});
			}
		}
		pagination.setSearchCriteria(searchCriteria);
		pagination.setSearchValue(searchValue);
		pagination.setCurrentPage(1);
		setSessionAttribute(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING_PAGINATION, pagination);
	}
}
