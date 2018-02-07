package com.ezshop.util;

import java.util.ArrayList;
import java.util.List;

import com.mytechnopal.DTOBase;
import com.mytechnopal.DataAndSessionBase;
import com.mytechnopal.dto.UserDTO;
import com.ezshop.dao.StaffDAO;
import com.ezshop.dto.StaffDTO;

public class StaffUtil extends DataAndSessionBase {
	private static final long serialVersionUID = 1L;
	
	//user list converted to staff list
	public static List<DTOBase> getStaffList(List<DTOBase> userList) {
		List<DTOBase> staffList = new ArrayList<DTOBase>();
		for(DTOBase userObj: userList) {
			staffList.add(getStaff(userObj));
		}
		return staffList;
	}
	
	//user obj converted to staff obj
	public static StaffDTO getStaff(DTOBase userObj) {
		UserDTO user = (UserDTO) userObj;
		StaffDTO staff = new StaffDAO().getStaffByCode(user.getCode());
		
		staff.setUserName(user.getUserName());
		staff.setPassword(user.getPassword());
		staff.setUserGroup(user.getUserGroup());
		staff.setLastName(user.getLastName());
		staff.setFirstName(user.getFirstName());
		staff.setMiddleName(user.getMiddleName());
		staff.setPrefixName(user.getPrefixName());
		staff.setSuffixName(user.getSuffixName());
		staff.setOtherTitle(user.getOtherTitle());
		staff.setStreetPermanent(user.getStreetPermanent());
		staff.setBarangayPermanent(user.getBarangayPermanent());
		//staff.setCityPermanent(new CityDAO().getCityByCode(user.getCityPermanent().getCode()));
		staff.setStreetPresent(user.getStreetPresent());
		staff.setBarangayPresent(user.getBarangayPresent());
		//staff.setCityPresent(new CityDAO().getCityByCode(user.getCityPresent().getCode()));
		staff.setBirthDate(user.getBirthDate());
		staff.setGender(user.getGender());
		//staff.setReligion(new ReligionDAO().getReligionByCode(user.getReligion().getCode()));
		staff.setMaritalStatus(user.getMaritalStatus());
		staff.setCpNumber(user.getCpNumber());
		staff.setEmailAddress(user.getEmailAddress());
		staff.setActive(user.isActive());
		staff.setLastLoginTimestamp(user.getLastLoginTimestamp());
		staff.setLastLoginIPAddress(user.getLastLoginIPAddress());
		return staff;
	}
	
	public static String[][] getTableBody(List list) {
		String[][] result = new String[list.size()][];
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.size(); j++) {
				StaffDTO staff = (StaffDTO) list.get(j);
				result[j] = staff.getTableData();
			}
		}
		return result;
	}
	
	public static String[]  getTableHeader() {
		return new String[] {"ID", "Last Name", "First Name", "Middle Name", "Office" ,""};
	}
}
