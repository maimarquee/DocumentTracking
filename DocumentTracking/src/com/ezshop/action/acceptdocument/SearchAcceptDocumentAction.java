package com.ezshop.action.acceptdocument;

import com.ezshop.dao.AcceptDocumentDAO;
import com.ezshop.dto.AcceptDocumentDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.pagination.Pagination;

public class SearchAcceptDocumentAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void setSessionVars() {
		sessionInfo.setCurrentLink(sessionInfo.getPreviousLink());
	}
	
	protected void validateInput() {
		Pagination pagination = (Pagination) getSessionAttribute(AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT_PAGINATION);
		String searchCriteria = getRequestString("cboSearchCriteria");
		String searchValue = getRequestString("txtSearchValue");
		if(searchCriteria.equalsIgnoreCase("SearchByNameCode")) {
			pagination.setRecordList(new AcceptDocumentDAO().getAcceptDocumentList(searchValue));
			if(pagination.getTotalPage() == 0) {
				message.constructMsg(message.MSG_CLASS_ACTION_FAIL, new String[] {"No Record Found"});
			}
		}
		pagination.setSearchCriteria(searchCriteria);
		pagination.setSearchValue(searchValue);//this would save the search text in the search box
		pagination.setCurrentPage(1);
		setSessionAttribute(AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT_PAGINATION, pagination);
	}
}
