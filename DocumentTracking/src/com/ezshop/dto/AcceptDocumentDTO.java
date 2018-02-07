package com.ezshop.dto;
import com.mytechnopal.DTOBase;

public class AcceptDocumentDTO extends DTOBase{

	private static final long serialVersionUID = 1L;

	public static final String SESSION_ACCEPT_DOCUMENT = "SESSION_ACCEPT_DOCUMENT";
	public static final String SESSION_ACCEPT_DOCUMENT_LIST = "SESSION_ACCEPT_DOCUMENT_LIST";
	public static final String SESSION_ACCEPT_DOCUMENT_PAGINATION = "SESSION_ACCEPT_DOCUMENT_PAGINATION";
	
	private String name;
	private String description;
	private DocumentTypeDTO document_type;
	private String requesting_person;
	private Double amount;
	private String barcode;
	private String office;
	private String forward;
	
	public AcceptDocumentDTO(){
		super();
		name = "";
		description ="";
		document_type = new DocumentTypeDTO();
		requesting_person = "";
		amount = (double) 0;
		barcode = "";
		office = "";
		forward = "";
	}
	
	public AcceptDocumentDTO getAcceptDocument() {
		AcceptDocumentDTO ad = new AcceptDocumentDTO();
		ad.setCode(super.getCode());
		ad.setAddedBy(super.getAddedBy());
		ad.setAddedTimestamp(super.getAddedTimestamp());
		ad.setUpdatedBy(super.getUpdatedBy());
		ad.setUpdatedTimestamp(super.getUpdatedTimestamp());
		ad.setId(this.getId());
		ad.setName(name);
		ad.setDescription(description);
		ad.setDocument_type(document_type);
		ad.setRequesting_person(requesting_person);
		ad.setAmount(amount);
		ad.setBarcode(barcode);
		ad.setOffice(office);
		ad.setForward(forward);
		return ad;
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

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}
}