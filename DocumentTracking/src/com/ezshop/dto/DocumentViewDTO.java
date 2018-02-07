package com.ezshop.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ezshop.dao.OfficeDAO;
import com.ezshop.util.DocumentTrackingOfficeLogUtil;
import com.mytechnopal.DTOBase;
import com.mytechnopal.util.DateTimeUtil;

public class DocumentViewDTO extends DTOBase{

	private static final long serialVersionUID = 1L;

	public static final String SESSION_DOCUMENT_VIEW = "SESSION_DOCUMENT_VIEW";
	public static final String SESSION_DOCUMENT_VIEW_LIST = "SESSION_DOCUMENT_VIEW_LIST";
	public static final String SESSION_DOCUMENT_VIEW_PAGINATION = "SESSION_DOCUMENT_VIEW_PAGINATION";
	
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
	private List<DTOBase> documentOfficeLogList;
	
	
	public DocumentViewDTO(){
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
		documentOfficeLogList = new ArrayList<DTOBase>();
	}

	public DocumentViewDTO getDocumentView() {
		DocumentViewDTO dv = new DocumentViewDTO();
		dv.setCode(super.getCode());
		dv.setId(this.getId());
		dv.setName(name);
		dv.setDescription(description);
		dv.setDocument_type(document_type);
		dv.setRequesting_person(requesting_person);
		dv.setAmount(amount);
		dv.setBarcode(barcode);
		dv.setOffice(office);
		dv.setForward(forward);
		dv.setTrackingComplete(trackingComplete);
		dv.setTrackingCompleteDate(trackingCompleteDate);
		dv.setDocumentOfficeLogList(documentOfficeLogList);
		return dv;
	}

	public String[] getTableData() {
		DocumentTrackingOfficeLogDTO dtol = new DocumentTrackingOfficeLogDTO();
		//DocumentTrackingOfficeLogUtil documentTrackingOfficeLog = new DocumentTrackingOfficeLogUtil();
		//make last column an code for table data that needs to be updated or deleted
		return new String[] {getCode(), getName(), getDescription() ,getCode()};
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

	public List<DTOBase> getDocumentOfficeLogList() {
		return documentOfficeLogList;
	}

	public void setDocumentOfficeLogList(List<DTOBase> documentOfficeLogList) {
		this.documentOfficeLogList = documentOfficeLogList;
	}
}