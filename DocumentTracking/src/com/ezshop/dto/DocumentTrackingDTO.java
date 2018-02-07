package com.ezshop.dto;

import java.util.Date;

import com.mytechnopal.DTOBase;
import com.mytechnopal.util.DateTimeUtil;

public class DocumentTrackingDTO extends DTOBase{

	private static final long serialVersionUID = 1L;

	public static final String SESSION_DOCUMENT_TRACKING = "SESSION_DOCUMENT_TRACKING";
	public static final String SESSION_DOCUMENT_TRACKING_LIST = "SESSION_DOCUMENT_TRACKING_LIST";
	public static final String SESSION_DOCUMENT_TRACKING_PAGINATION = "SESSION_DOCUMENT_TRACKING_PAGINATION";
	
	public static final String FORWARD_YES = "YES";
	public static final String FORWARD_NO = "NO";
	
	private String name;
	private String description;
	private DocumentTypeDTO document_type;
	private String requesting_person;
	private Double amount;
	private String barcode;
	private Date date;
	private String active_office;
	private String forward;

	public DocumentTrackingDTO(){
		super();
		name = "";
		description = "";
		document_type = new DocumentTypeDTO();
		requesting_person = "";
		amount = (double) 0;
		barcode =  "";
		date = DateTimeUtil.getCurrentTimestamp();
		active_office = "";
		forward = "";
	}

	public DocumentTrackingDTO getDocumentTracking() {
		DocumentTrackingDTO documentTracking = new DocumentTrackingDTO();
		documentTracking.setCode(super.getCode());
		documentTracking.setAddedBy(super.getAddedBy());
		documentTracking.setAddedTimestamp(super.getAddedTimestamp());
		documentTracking.setUpdatedBy(super.getUpdatedBy());
		documentTracking.setUpdatedTimestamp(super.getUpdatedTimestamp());
		documentTracking.setId(this.getId());
		documentTracking.setName(this.getName());
		documentTracking.setDescription(this.getDescription());
		documentTracking.setDocument_type(this.getDocument_type());
		documentTracking.setRequesting_person(this.getRequesting_person());
		documentTracking.setAmount(this.getAmount());
		documentTracking.setBarcode(this.getBarcode());
		documentTracking.setActive_office(active_office);
		documentTracking.setForward(this.getForward());
		return documentTracking;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DocumentTypeDTO getDocument_type() {
		return document_type;
	}

	public void setDocument_type(DocumentTypeDTO document_type) {
		this.document_type = document_type;
	}

	public String getRequesting_person() {
		return requesting_person;
	}

	public void setRequesting_person(String requesting_person) {
		this.requesting_person = requesting_person;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public String getActive_office() {
		return active_office;
	}

	public void setActive_office(String active_office) {
		this.active_office = active_office;
	}

	public String[] getTableData() {
		//make last column an code for table data that needs to be updated or deleted
		return new String[] {getCode(), getName(), getCode()};
	}
}
