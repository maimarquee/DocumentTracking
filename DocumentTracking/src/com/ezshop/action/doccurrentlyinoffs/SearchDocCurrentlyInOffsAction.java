package com.ezshop.action.doccurrentlyinoffs;

import com.ezshop.dao.DocCurrentlyInOffsDAO;
import com.ezshop.dto.DocCurrentlyInOffsDTO;
import com.ezshop.util.DocCurrentlyInOffsUtil;
import com.mytechnopal.ActionBase;
import com.mytechnopal.pagination.Pagination;

public class SearchDocCurrentlyInOffsAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void setSessionVars() {
		sessionInfo.setCurrentLink(sessionInfo.getPreviousLink());
	}
	
	protected void validateInput() {
		Pagination pagination = (Pagination) getSessionAttribute(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS_PAGINATION);
		String searchCriteria = getRequestString("cboSearchCriteria");
		String searchValue = getRequestString("txtSearchValue");
		if(searchCriteria.equalsIgnoreCase("SearchByNameCode")) {
			pagination.setRecordList(DocCurrentlyInOffsUtil.getDocumentTrackingListBySearchText(searchValue));
			if(pagination.getTotalPage() == 0) {
				message.constructMsg(message.MSG_CLASS_ACTION_FAIL, new String[] {"No Record Found"});
			}
		}
		pagination.setSearchCriteria(searchCriteria);
		pagination.setSearchValue(searchValue);
		pagination.setCurrentPage(1);
		setSessionAttribute(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS_PAGINATION, pagination);
	}
}
