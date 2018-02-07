package com.ezshop.dto;

import com.mytechnopal.DTOBase;

public class UserRfIdDTO extends DTOBase{

	private static final long serialVersionUID = 1L;

	private String rfid;
	private String lastName;
	private String firstName;
	private String middleName;
	private String profilePict;
	
	public UserRfIdDTO() {
		super();
		rfid = "";
		lastName = "";
		firstName = "";
		middleName = "";
		profilePict = "";
	}

	public UserRfIdDTO getUserRfIdDTO() {
		UserRfIdDTO userRfIdDto =  new UserRfIdDTO();
		userRfIdDto.setCode(super.getCode());
		userRfIdDto.setRfid(rfid);
		userRfIdDto.setLastName(lastName);
		userRfIdDto.setFirstName(firstName);
		userRfIdDto.setMiddleName(middleName);
		userRfIdDto.setProfilePict(profilePict);
		return userRfIdDto;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getProfilePict() {
		return profilePict;
	}

	public void setProfilePict(String profilePict) {
		this.profilePict = profilePict;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
}
