package com.ezshop.action.acceptdocument;


import com.ezshop.dto.AcceptDocumentDTO;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.StaffUtil;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.util.UserUtil;

public class AcceptDocumentAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void setInput() {
		AcceptDocumentDTO dcio = (AcceptDocumentDTO) getSessionAttribute(AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT);

	DTOBase obj = UserUtil.getUserByUserCode(sessionInfo.getCurrentUser().getCode());
	StaffDTO staff = StaffUtil.getStaff(obj);
	
	dcio.setOffice(staff.getOffice().getCode());
	dcio.setForward("NO");
	}
}
