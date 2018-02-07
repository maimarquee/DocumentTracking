package com.ezshop.action.doccurrentlyinoffs;

import java.util.List;

import com.ezshop.dto.DocCurrentlyInOffsDTO;
import com.ezshop.dto.DocumentTrackingOfficeLogDTO;
import com.ezshop.dto.DocumentTypeDTO;
import com.ezshop.dto.OfficeDTO;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.StaffUtil;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.util.DTOUtil;
import com.mytechnopal.util.DateTimeUtil;
import com.mytechnopal.util.StringUtil;
import com.mytechnopal.util.UserUtil;

public class DocCurrentlyInOffsAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void setInput() {
		DocCurrentlyInOffsDTO dcio = (DocCurrentlyInOffsDTO) getSessionAttribute(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS);

		//DocumentTypeDTO documenttype = ((DocumentTypeDTO) DTOUtil.getObjById((List<DTOBase>) getSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST), getRequestInt("cboDocument Type")));
		//String requestingPerson = getRequestString("txtRequesting Person");
		//Double amount = getRequestDouble("txtAmount");
		OfficeDTO office = ((OfficeDTO) DTOUtil.getObjById((List<DTOBase>) getSessionAttribute(OfficeDTO.SESSION_OFFICE_LIST), getRequestInt("cboOffice")));
		String forward = getRequestString("cboForward");
		String carrier = getRequestString("txtCarrier");
		
		//dcio.setDocument_type(documenttype);
		//dcio.setRequesting_person(requestingPerson);
		//dcio.setAmount(amount);
		dcio.setOffice(office);
		dcio.setForward(forward);
		dcio.setCarrier(carrier);
		
	}

	protected void validateInput() {
		DocCurrentlyInOffsDTO dcio = (DocCurrentlyInOffsDTO) getSessionAttribute(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS);
		String carrier = getRequestString("txtCarrier");
		//System.out.println("Carrier info" + dcio.getCarrier());
		
/*		if(dcio.getCarrier() == null) {
			message.constructMsg(Message.MSG_CLASS_EMPTY, "Need to provide CARRIER NAME");
		}*/
		if(StringUtil.isEmpty(carrier)) {
			message.constructMsg(Message.MSG_CLASS_EMPTY, "Need to provide Courier");
		}
		if(dcio.getForward().equalsIgnoreCase("NO")) {
			message.constructMsg(Message.MSG_CLASS_INVALID, "Need to select Yes First");
		}
	}
}
