package com.ezshop.action.staff;

import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.util.DTOUtil;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.StaffUtil;

public class UpdateStaffAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	@Override
	protected void setSessionVars() {
		//is previous link from the list
		if(!sessionInfo.isPreviousLinkUpdateSubmit()) {
			Pagination pagination = (Pagination) getSessionAttribute(StaffDTO.SESSION_STAFF_PAGINATION);
			String code = getRequestString("txtSelectedRecord");
			DTOBase userObj = DTOUtil.getObjByCode(pagination.getCurrentPageRecordList(), code);
			StaffDTO staff = StaffUtil.getStaff(userObj);
			//System.out.println("this should be the office"+staff.getOffice().getCode());
			setSessionAttribute(StaffDTO.SESSION_STAFF + "_ORIG", staff);
			setSessionBeforeTrans(StaffDTO.SESSION_STAFF, staff.getStaff());
		}
	}
}
