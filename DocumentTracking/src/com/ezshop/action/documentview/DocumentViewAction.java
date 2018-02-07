package com.ezshop.action.documentview;

import java.util.List;

import com.ezshop.dto.DocumentTypeDTO;
import com.ezshop.dto.DocumentViewDTO;
import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.util.DTOUtil;

public class DocumentViewAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void setInput() {
		DocumentViewDTO dcio = (DocumentViewDTO) getSessionAttribute(DocumentViewDTO.SESSION_DOCUMENT_VIEW);

		String name = getRequestString("txtName");
		String description = getRequestString("txtDescription");
		DocumentTypeDTO documenttype = ((DocumentTypeDTO) DTOUtil.getObjById((List<DTOBase>) getSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST), getRequestInt("cboDocument Type")));
		String requestingPerson = getRequestString("txtRequesting Person");
		Double amount = getRequestDouble("txtAmount");
		String barcode = getRequestString("txtBarcode");
		String uploadImage = getRequestString("txtImage");//for uploading image not yet in use
		OfficeDTO office = ((OfficeDTO) DTOUtil.getObjById((List<DTOBase>) getSessionAttribute(OfficeDTO.SESSION_OFFICE_LIST), getRequestInt("cboOffice")));
		String forward = getRequestString("cboForward");
		
		dcio.setName(name);
		dcio.setDescription(description);
		dcio.setDocument_type(documenttype);
		dcio.setRequesting_person(requestingPerson);
		dcio.setAmount(amount);
		dcio.setBarcode(barcode);
		dcio.setOffice(office);
		dcio.setForward(forward);
	}
}