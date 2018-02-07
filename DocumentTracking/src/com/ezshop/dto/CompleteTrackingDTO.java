package com.ezshop.dto;

import java.util.Date;

import com.mytechnopal.DTOBase;
import com.mytechnopal.util.DateTimeUtil;

public class CompleteTrackingDTO extends DTOBase{

	private static final long serialVersionUID = 1L;

	public static final String SESSION_COMPLETE_TRACKING = "SESSION_COMPLETE_TRACKING";
	public static final String SESSION_COMPLETE_TRACKING_LIST = "SESSION_COMPLETE_TRACKING_LIST";
	public static final String SESSION_COMPLETE_TRACKING_PAGINATION = "SESSION_COMPLETE_TRACKING_PAGINATION";
	
	public static String[] FORWARD_LIST = {"NO", "YES"};
	public static String[] COMPLETE_TRACKING_LIST = {"NO", "YES"};
	
	private String name;
	private String description;
	private DocumentTypeDTO document_type;
	private String requesting_person;
	private Double amount;
	private String barcode;
	private OfficeDTO office;
	private String forward;
	private String trackingComplete;
	private Date trackingCompleteDate;
	
	public CompleteTrackingDTO(){
		super();
		name = "";
		description ="";
		document_type = new DocumentTypeDTO();
		requesting_person = "";
		amount = (double) 0;
		barcode = "";
		office = new OfficeDTO();
		forward = "";
		trackingComplete = "";
		trackingCompleteDate = DateTimeUtil.getCurrentTimestamp();
	}

	public CompleteTrackingDTO getCompleteTracking() {
		CompleteTrackingDTO ct = new CompleteTrackingDTO();
		ct.setCode(super.getCode());
		ct.setId(this.getId());
		ct.setName(name);
		ct.setDescription(description);
		ct.setDocument_type(document_type);
		ct.setRequesting_person(requesting_person);
		ct.setAmount(amount);
		ct.setBarcode(barcode);
		ct.setOffice(office);
		ct.setForward(forward);
		ct.setTrackingComplete(trackingComplete);
		ct.setTrackingCompleteDate(trackingCompleteDate);
		return ct;
	}
	
	public String[] getTableData() {
		//make last column an code for table data that needs to be updated or deleted
		return new String[] {getCode(), getName(), getDescription(), getCode()};
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

	public OfficeDTO getOffice() {
		return office;
	}

	public void setOffice(OfficeDTO office) {
		this.office = office;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getTrackingComplete() {
		return trackingComplete;
	}

	public void setTrackingComplete(String trackingComplete) {
		this.trackingComplete = trackingComplete;
	}

	public Date getTrackingCompleteDate() {
		return trackingCompleteDate;
	}

	public void setTrackingCompleteDate(Date trackingCompleteDate) {
		this.trackingCompleteDate = trackingCompleteDate;
	}
}
