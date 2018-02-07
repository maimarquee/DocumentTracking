package com.ezshop.dto;

import java.util.List;

import com.ezshop.dao.OfficeDAO;
import com.mytechnopal.DTOBase;
import com.mytechnopal.dto.UserDTO;
import com.mytechnopal.util.DateTimeUtil;
import com.mytechnopal.util.StringUtil;
import com.mytechnopal.util.WebUtil;


public class StaffDTO extends UserDTO {
	private static final long serialVersionUID = 1L;
	
	public static final String SESSION_STAFF = "SESSION_STAFF";
	public static final String SESSION_STAFF_LIST = "SESSION_STAFF_LIST";
	public static final String SESSION_STAFF_PAGINATION = "SESSION_STAFF_PAGINATION";
	
	private String programGraduated;
	private String jobRole;
	private OfficeDTO office;
	
	public StaffDTO() {
		super();
		programGraduated = "";
		jobRole = "";
		office = new OfficeDTO();
	}
	
	public StaffDTO getStaff() {
		StaffDTO staff = new StaffDTO();

		staff.setUserName(super.getUserName());
		staff.setPassword(super.getPassword());
		staff.setUserGroup(super.getUserGroup());
		staff.setLastName(super.getLastName());
		staff.setFirstName(super.getFirstName());
		staff.setMiddleName(super.getMiddleName());
		staff.setPrefixName(super.getPrefixName());
		staff.setSuffixName(super.getSuffixName());
		staff.setOtherTitle(super.getOtherTitle());
		staff.setStreetPermanent(super.getStreetPermanent());
		staff.setBarangayPermanent(super.getBarangayPermanent());
		staff.setCityPermanent(super.getCityPermanent());
		staff.setStreetPresent(super.getStreetPresent());
		staff.setBarangayPresent(super.getBarangayPresent());
		staff.setCityPresent(super.getCityPresent());
		staff.setBirthDate(super.getBirthDate());
		staff.setGender(super.getGender());
		staff.setReligion(super.getReligion());
		staff.setMaritalStatus(super.getMaritalStatus());
		staff.setCpNumber(super.getCpNumber());
		staff.setEmailAddress(super.getEmailAddress());
		staff.setActive(super.isActive());
		staff.setLastLoginTimestamp(super.getLastLoginTimestamp());
		staff.setLastLoginIPAddress(super.getLastLoginIPAddress());
		
		staff.setId(this.getId());
		staff.setCode(this.getCode());
		staff.setProgramGraduated(programGraduated);
		staff.setJobRole(jobRole);
		staff.setOffice(office);
		staff.setDisplayText(this.getName());
		
		return staff;
	}

	public String[] getTableData() {
		//make last column an code for table data that needs to be updated or deleted //DateTimeUtil.getDateTimeToStr(getBirthDate(), "MM/dd/yyyy")
		OfficeDTO officeName = new OfficeDAO().getOfficeByCode(getOffice().getCode());
		return new String[] {getCode(), getLastName(), getFirstName(), getMiddleName(), officeName.getName(), getCode()};
	}
	
	public String getName() {
		return WebUtil.encodeRegHTML(StringUtil.getFullName(super.getLastName(), super.getFirstName(), super.getMiddleName(), "", false, true));
	}
	
	public String getProgramGraduated() {
		return programGraduated;
	}

	public void setProgramGraduated(String programGraduated) {
		this.programGraduated = programGraduated;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public OfficeDTO getOffice() {
		return office;
	}
	
	public void setOffice(OfficeDTO office) {
		this.office = office;
	}
}
