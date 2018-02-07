package com.ezshop.action.documenttracking;

import java.util.List;

import com.ezshop.dto.DocumentTrackingDTO;
import com.ezshop.dto.DocumentTypeDTO;
import com.ezshop.dto.OfficeDTO;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.StaffUtil;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.UploadedFile;
import com.mytechnopal.util.DTOUtil;
import com.mytechnopal.util.StringUtil;
import com.mytechnopal.util.UserUtil;

public class DocumentTrackingAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void setInput() {
		DocumentTrackingDTO documenttracking = (DocumentTrackingDTO) getSessionAttribute(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING);
		//UploadedFile uploadedFile = (UploadedFile) getSessionAttribute(UploadedFile.SESSION_UPLOADED_FILE);
		DTOBase obj = UserUtil.getUserByUserCode(sessionInfo.getCurrentUser().getCode());
		StaffDTO staff = StaffUtil.getStaff(obj);
		//OfficeDTO office = OfficeUtil.get
		String name = getRequestString("txtName");
		String description = getRequestString("txtDescription");
		String requestingPerson = getRequestString("txtRequesting Person");
		Double amount = getRequestDouble("txtAmount");
		DocumentTypeDTO documenttype = ((DocumentTypeDTO) DTOUtil.getObjById((List<DTOBase>) getSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST), getRequestInt("cboDocument Type")));
		
		
		documenttracking.setName(name);
		documenttracking.setDescription(description);
		documenttracking.setDocument_type(documenttype);
		documenttracking.setRequesting_person(requestingPerson);
		documenttracking.setAmount(amount);
		documenttracking.setForward(documenttracking.FORWARD_NO);
		documenttracking.setDocument_type(documenttype);
		documenttracking.setActive_office(staff.getOffice().getCode());
	}
	
	protected void validateInput() {
		String name = getRequestString("txtName");
		String description = getRequestString("txtDescription");
		String requestingPerson = getRequestString("txtRequesting Person");

		if(StringUtil.isEmpty(name)) {
			message.constructMsg(Message.MSG_CLASS_EMPTY, "Need to provide Document's Name");
		}
		if(StringUtil.isEmpty(description)) {
			message.constructMsg(Message.MSG_CLASS_EMPTY, "Need to provide Document's Description");
		}
		if(StringUtil.isEmpty(requestingPerson)) {
			message.constructMsg(Message.MSG_CLASS_EMPTY, "Need to provide Document's Requesting Person");
		}
	}
}
