package com.ezshop.action.documentview;


import com.ezshop.dao.DocumentViewDAO;
import com.ezshop.dto.DocumentViewDTO;
import com.ezshop.util.DocumentViewUtil;
import com.mytechnopal.ActionBase;
import com.mytechnopal.pagination.Pagination;

public class SearchDocumentViewAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void setSessionVars() {
		sessionInfo.setCurrentLink(sessionInfo.getPreviousLink());
	}
	
	protected void validateInput() {
		Pagination pagination = (Pagination) getSessionAttribute(DocumentViewDTO.SESSION_DOCUMENT_VIEW_PAGINATION);
		String searchCriteria = getRequestString("cboSearchCriteria");
		String searchValue = getRequestString("txtSearchValue");
		if(searchCriteria.equalsIgnoreCase("SearchByNameCode")) {
			pagination.setRecordList(DocumentViewUtil.getDocumentTrackingViewListBySearchText(searchValue));
			if(pagination.getTotalPage() == 0) {
				message.constructMsg(message.MSG_CLASS_ACTION_FAIL, new String[] {"No Record Found"});
			}
		}
		pagination.setSearchCriteria(searchCriteria);
		pagination.setSearchValue(searchValue);
		pagination.setCurrentPage(1);
		setSessionAttribute(DocumentViewDTO.SESSION_DOCUMENT_VIEW_PAGINATION, pagination);
	}
}
