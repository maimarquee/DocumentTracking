package com.ezshop.action.office;

import com.ezshop.dao.OfficeDAO;
import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.pagination.Pagination;

public class SearchOfficeSubmitAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setCurrentLink(sessionInfo.getPreviousLink());
	}
	
	protected void validateInput() {
		Pagination pagination = (Pagination) getSessionAttribute(OfficeDTO.SESSION_OFFICE_PAGINATION);
		String searchCriteria = getRequestString("cboSearchCriteria");
		String searchValue = getRequestString("txtSearchValue");
		if(searchCriteria.equalsIgnoreCase("SearchByNameCode")) {
			pagination.setRecordList(new OfficeDAO().getOfficeList(searchValue));
			if(pagination.getTotalPage() == 0) {
				message.constructMsg(message.MSG_CLASS_ACTION_FAIL, new String[] {"No Record Found"});
			}
		}
		pagination.setSearchCriteria(searchCriteria);
		pagination.setSearchValue(searchValue);
		pagination.setCurrentPage(1);
		setSessionAttribute(OfficeDTO.SESSION_OFFICE_PAGINATION, pagination);
	}
}
