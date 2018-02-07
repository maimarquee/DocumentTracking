package com.ezshop.action.user;

import java.util.List;

import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.dao.UserDAO;
import com.mytechnopal.dto.UserDTO;
import com.mytechnopal.pagination.Pagination;

public class SearchUserSubmitAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	@Override
	protected void setSessionVars() {
		sessionInfo.setCurrentLink(sessionInfo.getPreviousLink());
	}

	@Override
	protected void validateInput() {
		Pagination pagination = (Pagination) getSessionAttribute(UserDTO.SESSION_USER_PAGINATION);
		String searchCriteria = getRequestString("cboSearchCriteria");
		String searchValue = getRequestString("txtSearchValue");
		List<DTOBase> list = (List<DTOBase>) getSessionAttribute(UserDTO.SESSION_USER_LIST);
		if(searchCriteria.equalsIgnoreCase("searchByNameCode")) {
			pagination.setRecordList(new UserDAO().getUserListSearchByNameCode(searchValue));
		}
		pagination.setSearchCriteria(searchCriteria);
		pagination.setSearchValue(searchValue);
		pagination.setCurrentPage(1);

		if(pagination.getTotalPage() == 0) {
			message.constructMsg(message.MSG_CLASS_ACTION_FAIL, new String[]{"No Record Found"});
		}
	}
}
