package com.ezshop.dto;

import java.util.ArrayList;
import java.util.List;

import com.mytechnopal.DTOBase;

public class DocumentTrackingOfficeLogDTO extends DTOBase {
	private static final long serialVersionUID = 1L;

	//public static final String DOCUMENT_TRACKING_OFFICE_LOG_ADD = "DOCUMENT_TRACKING_OFFICE_LOG_ADD";
	//public static final String DOCUMENT_TRACKING_OFFICE_LOG_LIST_BY_DOCUMENTCODE = "DOCUMENT_TRACKING_OFFICE_LOG_LIST_BY_DOCUMENTCODE";

	public static final String STATUS_CREATED = "CREATED";
	public static final String STATUS_ACCEPTED = "ACCEPTED";
	public static final String STATUS_FORWARDED = "FORWARDED";
	public static final String STATUS_COMPLETED = "COMPLETED";
	
	private String documentTrackingCode;
	private StaffDTO staff;
	private String officeCode;
	private String status;
	private String carrier;
	private List<DTOBase> documentTrackList;
	private List<DTOBase> documentTrackingOfficeLogList;
	
	public DocumentTrackingOfficeLogDTO() {
		super();
		documentTrackingCode = "";
		staff = new StaffDTO();
		officeCode = "";
		carrier = "";
		documentTrackList = new ArrayList<DTOBase>();
		documentTrackingOfficeLogList = new ArrayList<DTOBase>();
		
	}

	public DocumentTrackingOfficeLogDTO getDocumentTrackingOfficeLog() {
		DocumentTrackingOfficeLogDTO dtol = new DocumentTrackingOfficeLogDTO();
		dtol.setDocumentTrackingCode(documentTrackingCode);
		dtol.setStaff(staff);
		dtol.setOfficeCode(officeCode);
		dtol.setCarrier(carrier);
		dtol.setDocumentTrackList(documentTrackList);
		dtol.setDocumentTrackingOfficeLogList(documentTrackingOfficeLogList);
		return dtol;
	}
	
	public List<DTOBase> getDocumentTrackingOfficeLogList() {
		return documentTrackingOfficeLogList;
	}

	public void setDocumentTrackingOfficeLogList(
			List<DTOBase> documentTrackingOfficeLogList) {
		this.documentTrackingOfficeLogList = documentTrackingOfficeLogList;
	}
	
	public String getDocumentTrackingCode() {
		return documentTrackingCode;
	}

	public void setDocumentTrackingCode(String documentTrackingCode) {
		this.documentTrackingCode = documentTrackingCode;
	}

	public StaffDTO getStaff() {
		return staff;
	}

	public void setStaff(StaffDTO staff) {
		this.staff = staff;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<DTOBase> getDocumentTrackList() {
		return documentTrackList;
	}

	public void setDocumentTrackList(List<DTOBase> documentTrackList) {
		this.documentTrackList = documentTrackList;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
}
