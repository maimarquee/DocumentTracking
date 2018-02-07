package com.ezshop.action.office;

import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.util.DTOUtil;

public class UpdateOfficeAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void setSessionVars(){
		if(!sessionInfo.isPreviousLinkUpdateSubmit()) {
			Pagination pagination = (Pagination) getSessionAttribute(OfficeDTO.SESSION_OFFICE_PAGINATION);
			String code = getRequestString("txtSelectedRecord");
			DTOBase userObj = DTOUtil.getObjByCode(pagination.getCurrentPageRecordList(), code);
			OfficeDTO office = (OfficeDTO) userObj;
			
			setSessionAttribute(OfficeDTO.SESSION_OFFICE + "_ORIG", office);
			setSessionBeforeTrans(OfficeDTO.SESSION_OFFICE,  office.getOffice());
		}
	}
}
