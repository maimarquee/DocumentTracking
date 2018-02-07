package com.ezshop.dto;

import com.mytechnopal.DTOBase;

public class OfficeDTO extends DTOBase {

	private static final long serialVersionUID = 1L;
	
	public static final String SESSION_OFFICE = "SESSION_OFFICE";
	public static final String SESSION_OFFICE_LIST = "SESSION_OFFICE_LIST";
	public static final String SESSION_OFFICE_PAGINATION = "SESSION_OFFICE_PAGINATION";
	
	private String name;
	private String for_active_office;

	public OfficeDTO() {
		super();
		for_active_office = "";
		name = "";
	}
	
	public OfficeDTO getOffice() {
		OfficeDTO office = new OfficeDTO();
		office.setCode(super.getCode());
		office.setAddedBy(super.getAddedBy());
		office.setAddedTimestamp(super.getAddedTimestamp());
		office.setUpdatedBy(super.getUpdatedBy());
		office.setUpdatedTimestamp(super.getUpdatedTimestamp());
		office.setId(this.getId());
		office.setName(this.name);
		office.setFor_active_office(for_active_office);
		return office;
	}
	
	public String[] getTableData() {
		return new String[] {getCode(), getName(), getCode()};
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFor_active_office() {
		return for_active_office;
	}

	public void setFor_active_office(String for_active_office) {
		this.for_active_office = for_active_office;
	}
	
	
}
