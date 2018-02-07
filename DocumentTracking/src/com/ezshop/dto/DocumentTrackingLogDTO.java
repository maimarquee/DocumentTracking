package com.ezshop.dto;

import java.util.ArrayList;
import java.util.List;

import com.mytechnopal.DTOBase;
import com.mytechnopal.UploadedFile;

public class DocumentTrackingLogDTO extends DTOBase {
	private static final long serialVersionUID = 1L;

	public static final String SESSION_DOCUMENT_LOG = "SESSION_DOCUMENT_LOG";
	public static final String SESSION_DOCUMENT_LOG_LIST = "SESSION_DOCUMENT_LOG_LIST";
	
	public static final String STATUS_COMMENTED = "COMMENTED";
	
	private String documentTrackingCode;
	private StaffDTO staff;
	private String comment;
	private String status;
	private UploadedFile uploadedFile;
	private List<DTOBase> documentTrackList;

	
	public DocumentTrackingLogDTO() {
		super();
		documentTrackingCode = "";
		staff = new StaffDTO();
		comment = "";
		uploadedFile = new UploadedFile();
		documentTrackList = new ArrayList<DTOBase>();
	}
	
	public DocumentTrackingLogDTO getDocumentTrackingLog() {
		DocumentTrackingLogDTO documentTrackingLog = new DocumentTrackingLogDTO();
		documentTrackingLog.setId(super.getId());
		documentTrackingLog.setDocumentTrackingCode(this.documentTrackingCode);
		documentTrackingLog.setStaff(this.staff);
		documentTrackingLog.setComment(this.comment);
		documentTrackingLog.setStatus(this.status);
		documentTrackingLog.setUploadedFile(this.uploadedFile);
		documentTrackingLog.setDocumentTrackList(this.documentTrackList);
		return documentTrackingLog;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public List<DTOBase> getDocumentTrackList() {
		return documentTrackList;
	}

	public void setDocumentTrackList(List<DTOBase> documentTrackList) {
		this.documentTrackList = documentTrackList;
	}
}