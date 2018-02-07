package com.ezshop.action.staff;

import java.util.List;

import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.util.DTOUtil;
import com.ezshop.dao.OfficeDAO;
import com.ezshop.dao.StaffDAO;
import com.ezshop.dto.OfficeDTO;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.StaffUtil;

public class DeleteStaffSubmitAction extends ActionBase {
	private static final long serialVersionUID = 1L;
	
	protected void validateInput() {
		Pagination pagination = (Pagination) getSessionAttribute(StaffDTO.SESSION_STAFF_PAGINATION);
		String code = getRequestString("txtSelectedRecord");
		DTOBase userObj = DTOUtil.getObjByCode(pagination.getCurrentPageRecordList(), code);
		StaffDTO staff = StaffUtil.getStaff(userObj);
		setSessionBeforeTrans(StaffDTO.SESSION_STAFF, staff);
		
	
	
	}
	
	
	
	protected void setSessionVars() {
		setSessionLinkOnSubmit();
	}
}
