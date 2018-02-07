package com.ezshop.dto;

import com.mytechnopal.DTOBase;

public class DocumentTypeDTO extends DTOBase {

	private static final long serialVersionUID = 1L;
	
	public static final String SESSION_DOCUMENT_TYPE = "SESSION_DOCUMENT_TYPE";
	public static final String SESSION_DOCUMENT_TYPE_LIST = "SESSION_DOCUMENT_TYPE_LIST";
	public static final String SESSION_DOCUMENT_TYPE_PAGINATION = "SESSION_DOCUMENT_TYPE_PAGINATION";

	private String name;


	public DocumentTypeDTO(){
		super();
		name = "";
	}

	public DocumentTypeDTO getDocumentType(){ //used in updating
		DocumentTypeDTO documenttype = new DocumentTypeDTO();
		documenttype.setCode(super.getCode());
		documenttype.setAddedBy(super.getAddedBy());
		documenttype.setAddedTimestamp(super.getAddedTimestamp());
		documenttype.setUpdatedBy(super.getUpdatedBy());
		documenttype.setUpdatedTimestamp(super.getUpdatedTimestamp());
		documenttype.setId(this.getId());
		documenttype.setName(this.getName());
		return documenttype;
	}

	public String[] getTableData() {
		//make last column an code for table data that needs to be updated or deleted
		return new String[] {getCode(), getName(), getCode()};
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}