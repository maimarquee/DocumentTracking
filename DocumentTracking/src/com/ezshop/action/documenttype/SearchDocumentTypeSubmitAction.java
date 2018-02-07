package com.ezshop.action.documenttype;

import com.ezshop.dao.DocumentTypeDAO;
import com.ezshop.dto.DocumentTypeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.pagination.Pagination;

public class SearchDocumentTypeSubmitAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setCurrentLink(sessionInfo.getPreviousLink());
	}
	
	protected void validateInput() {
		Pagination pagination = (Pagination) getSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_PAGINATION);
		String searchCriteria = getRequestString("cboSearchCriteria");
		String searchValue = getRequestString("txtSearchValue");
		if(searchCriteria.equalsIgnoreCase("SearchByNameCode")) {
			pagination.setRecordList(new DocumentTypeDAO().getDocumentTypeList(searchValue));
			if(pagination.getTotalPage() == 0) {
				message.constructMsg(message.MSG_CLASS_ACTION_FAIL, new String[] {"No Record Found"});
			}
		}
		pagination.setSearchCriteria(searchCriteria);
		pagination.setSearchValue(searchValue);//pagination.setSearchValue(""); make like this in the document accept so that he/she can search simultaneously
		pagination.setCurrentPage(1);
		setSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_PAGINATION, pagination);
	}
}
