package com.ezshop.action.completetracking;

import java.util.Date;
import java.util.List;

import com.ezshop.dto.CompleteTrackingDTO;
import com.ezshop.dto.DocCurrentlyInOffsDTO;
import com.ezshop.dto.DocumentTypeDTO;
import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.util.DTOUtil;

public class CompleteTrackingAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void setInput() {
		CompleteTrackingDTO completeTrack = (CompleteTrackingDTO) getSessionAttribute(CompleteTrackingDTO.SESSION_COMPLETE_TRACKING);

		//String name = getRequestString("txtName");
		//String description = getRequestString("txtDescription");
		//DocumentTypeDTO documenttype = ((DocumentTypeDTO) DTOUtil.getObjById((List<DTOBase>) getSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST), getRequestInt("cboDocument Type")));
		//String requestingPerson = getRequestString("txtRequesting Person");
		//Double amount = getRequestDouble("txtAmount");
		//String barcode = getRequestString("txtBarcode");
		//String uploadImage = getRequestString("txtImage");//for uploading image not yet in use
		//OfficeDTO office = ((OfficeDTO) DTOUtil.getObjById((List<DTOBase>) getSessionAttribute(OfficeDTO.SESSION_OFFICE_LIST), getRequestInt("cboOffice")));
		//String forward = getRequestString("cboForward");
		String completeTracking = getRequestString("cboTrackingComplete");
		//Date transactionDate = getRequestDateTime("txtDate", "MM/dd/yy");
		Date completeTrackingDate = getRequestDateTime("txtTrackingCompleteDate", "MM/dd/yy");

		//merchandiseTransaction.setDate(transactionDate);
		//completeTrack.setName(name);
		//completeTrack.setDescription(description);
		//completeTrack.setDocument_type(documenttype);
	//	completeTrack.setRequesting_person(requestingPerson);
		//completeTrack.setAmount(amount);
		//dcio.setBarcode(barcode);
		//dcio.setOffice(office);
		//dcio.setForward(forward);
		completeTrack.setTrackingComplete(completeTracking);
		completeTrack.setTrackingCompleteDate(completeTrackingDate);
	}
	protected void validateInput() {
		CompleteTrackingDTO ct = (CompleteTrackingDTO) getSessionAttribute(CompleteTrackingDTO.SESSION_COMPLETE_TRACKING);
		if(ct.getTrackingComplete().equalsIgnoreCase("NO")) {
			message.constructMsg(Message.MSG_CLASS_INVALID, "Need to select Yes First");
		}
		if(ct.getTrackingCompleteDate() == null) {
			message.constructMsg(Message.MSG_CLASS_INVALID, "Need to provide DATE");
		}
	}
}
