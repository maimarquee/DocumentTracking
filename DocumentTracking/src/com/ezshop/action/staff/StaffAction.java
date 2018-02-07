package com.ezshop.action.staff;

import java.util.Date;
import java.util.List;

import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.dao.UserDAO;
import com.mytechnopal.dto.CityDTO;
import com.mytechnopal.dto.ReligionDTO;
import com.mytechnopal.dto.UserDTO;
import com.mytechnopal.util.DTOUtil;
import com.mytechnopal.util.DateTimeUtil;
import com.mytechnopal.util.StringUtil;
import com.mytechnopal.util.WebUtil;
import com.ezshop.dao.StaffDAO;
import com.ezshop.dto.OfficeDTO;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.SettingsUtil;

public class StaffAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	protected void setInput() {
		StaffDTO staff = (StaffDTO) getSessionAttribute(StaffDTO.SESSION_STAFF);
		
		String lastName = getRequestString("txtLastName");
		String firstName = getRequestString("txtFirstName");
		String middleName = getRequestString("txtMiddleName");
		String prefixName = getRequestString("cboPrefixName");
		String suffixName = getRequestString("cboSuffixName");
		String otherTitle = getRequestString("txtOtherTitle");
		String streetPermanent = getRequestString("txtStreetPermanent");
		String barangayPermanent = getRequestString("txtBarangayPermanent");
		CityDTO cityPermanent = ((CityDTO) DTOUtil.getObjById((List<DTOBase>) getSessionAttribute(CityDTO.SESSION_CITY_LIST), getRequestInt("cboCityPermanent"))).getCity();
		String streetPresent = "";
		String barangayPresent = "";
		CityDTO cityPresent = null;
		if(getRequestBoolean("chkSameAsPermanent")) {
			streetPresent = streetPermanent;
			barangayPresent = barangayPermanent;
			cityPresent = cityPermanent.getCity();
		}
		else {
			streetPresent = getRequestString("txtStreetPresent");
			barangayPresent = getRequestString("txtBarangayPresent");
			cityPresent = ((CityDTO) DTOUtil.getObjById((List<DTOBase>) getSessionAttribute(CityDTO.SESSION_CITY_LIST), getRequestInt("cboCityPresent"))).getCity();
		}
		Date birthDate = getRequestDateTime("txtBirthDate", "MM/dd/yyyy");
		String gender = getRequestString("cboGender");
		ReligionDTO religion = ((ReligionDTO) DTOUtil.getObjById((List<DTOBase>) getSessionAttribute(ReligionDTO.SESSION_RELIGION_LIST), getRequestInt("cboReligion"))).getReligion();
		String maritalStatus = getRequestString("cboMaritalStatus");

		String cpNumber = getRequestString("txtCpNumber");
		String emailAddress = getRequestString("txtEmailAddress");
		String programGraduated = getRequestString("txtProgramGraduated");
		String jobRole = getRequestString("txtJobRole");
	
		OfficeDTO office = ((OfficeDTO) DTOUtil.getObjById((List<DTOBase>) getSessionAttribute(OfficeDTO.SESSION_OFFICE_LIST), getRequestInt("cboOffice")));
		
		
		staff.setLastName(lastName);
		staff.setFirstName(firstName);
		staff.setMiddleName(middleName);
		staff.setPrefixName(prefixName);
		staff.setSuffixName(suffixName);
		staff.setOtherTitle(otherTitle);
		staff.setStreetPermanent(streetPermanent);
		staff.setBarangayPermanent(barangayPermanent);
		staff.setCityPermanent(cityPermanent);
		staff.setStreetPresent(streetPresent);
		staff.setBarangayPresent(barangayPresent);
		staff.setCityPresent(cityPresent);
		staff.setBirthDate(birthDate);
		staff.setGender(gender);
		staff.setReligion(religion);
		staff.setMaritalStatus(maritalStatus);
		staff.setCpNumber(cpNumber);
		staff.setEmailAddress(emailAddress);
		staff.setProgramGraduated(programGraduated);
		staff.setJobRole(jobRole);
		staff.setOffice(office);
	}
	
	protected void validateInput() {
		StaffDTO staff = (StaffDTO) getSessionAttribute(StaffDTO.SESSION_STAFF);
		if(StringUtil.isEmpty(staff.getLastName())) {
			message.constructMsg(Message.MSG_CLASS_EMPTY, "Last Name");
		}
		else if(StringUtil.isEmpty(staff.getFirstName())) {
			message.constructMsg(Message.MSG_CLASS_EMPTY, "First Name");
		}
		else if(StringUtil.isEmpty(staff.getMiddleName())) {
			message.constructMsg(Message.MSG_CLASS_EMPTY, "Middle Name");
		}
		else if(StringUtil.isEmpty(staff.getStreetPermanent())) {
			message.constructMsg(Message.MSG_CLASS_INVALID, "Permanent Address - Street");
		}
		else if(StringUtil.isEmpty(staff.getBarangayPermanent())) {
			message.constructMsg(Message.MSG_CLASS_INVALID, "Permanent Address - Barangay");
		}
		else if(StringUtil.isEmpty(staff.getStreetPresent())) {
			message.constructMsg(Message.MSG_CLASS_INVALID, "Present Address - Street");
		}
		else if(StringUtil.isEmpty(staff.getBarangayPresent())) {
			message.constructMsg(Message.MSG_CLASS_INVALID, "Present Address - Barangay");
		}
		else if(staff.getBirthDate() == null) {
			message.constructMsg(Message.MSG_CLASS_EMPTY, "Birth Date");
		}
		else if(!StringUtil.isEmpty(staff.getEmailAddress())  && !WebUtil.isValidEmail(staff.getEmailAddress())) {
			message.constructMsg(Message.MSG_CLASS_INVALID, "Email Address");
		}
		else if(StringUtil.isEmpty(staff.getJobRole())) {
			message.constructMsg(Message.MSG_CLASS_INVALID, "Job Role");
		}
		else {
			if(sessionInfo.isPreviousLinkAdd()) {
				List<DTOBase> existingUserList = new UserDAO().getUserListByLastNameFirstNameMiddleNameUserGroupCode(staff.getLastName(), staff.getFirstName(), staff.getMiddleName(), SettingsUtil.USER_GROUP_STAFF_CODE);
				String msg = "";
				if(existingUserList.size() >= 1) {
					if(existingUserList.size() == 1) {
						StaffDTO existingStaff = new StaffDAO().getStaffByCode(existingUserList.get(0).getCode());
						if(existingStaff != null) {
							msg = "Entered staff last, first and middle name is already existing in our database.  The existing record has a birthday of " + DateTimeUtil.getDateTimeToStr(existingStaff.getBirthDate(), "MM/dd/yyyy");
						}	
					}
					else {
						for(DTOBase userObj: existingUserList) {
							UserDTO user = (UserDTO) userObj;
							StaffDTO existingStaff = new StaffDAO().getStaffByCode(user.getCode());
							if(existingStaff != null) {
								if(StringUtil.isEmpty(msg)) {
									msg = "Entered staff last, first and middle name is already existing in our database.  The existing records has the following birthdays: ";
								}
								msg += "<br>" + DateTimeUtil.getDateTimeToStr(user.getBirthDate(), "MM/dd/yyyy");
							}
						}
					}
					if(!StringUtil.isEmpty(msg)) {
						msg += "<br>Proceeding will result to create a duplicate names unless they had been proven different.";
						message.constructMsg(message.MSG_CLASS_EXIST, msg);
					}
				}	
			}	
		}
	}
}