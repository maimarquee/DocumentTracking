package com.ezshop.action.staff;

import com.mytechnopal.ActionBase;
import com.mytechnopal.dao.UserDAO;
import com.mytechnopal.pagination.Pagination;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.SettingsUtil;

public class SearchStaffSubmitAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setCurrentLink(sessionInfo.getPreviousLink());
	}

	@Override
	protected void validateInput() {
		Pagination pagination = (Pagination) getSessionAttribute(StaffDTO.SESSION_STAFF_PAGINATION);
		String searchCriteria = getRequestString("cboSearchCriteria");
		String searchValue = getRequestString("txtSearchValue");
		if(searchCriteria.equalsIgnoreCase("searchByNameCode")) {
			pagination.setRecordList(new UserDAO().getUserListByUserGroupCodeSearchByNameCode(SettingsUtil.USER_GROUP_STAFF_CODE, searchValue));
			
			if(pagination.getTotalPage() == 0) {
				message.constructMsg(message.MSG_CLASS_ACTION_FAIL, new String[]{"No Record Found"});
			}
		}
		pagination.setSearchCriteria(searchCriteria);
		pagination.setSearchValue(searchValue);
		pagination.setCurrentPage(1);
		setSessionAttribute(StaffDTO.SESSION_STAFF_PAGINATION, pagination);
	}
}
