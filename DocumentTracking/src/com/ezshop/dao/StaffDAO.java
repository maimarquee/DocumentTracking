package com.ezshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.dao.LinkDAO;
import com.mytechnopal.dao.UserDAO;
import com.mytechnopal.dao.UserGroupLinkDAO;
import com.mytechnopal.dto.UserDTO;
import com.mytechnopal.util.StringUtil;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.SettingsUtil;

public class StaffDAO extends DAOBase {
	private static final long serialVersionUID = 1L;
	private String qryStaffAdd = "STAFF_ADD";
	private String qryStaffUpdate = "STAFF_UPDATE";
	private String qryStaffDelete = "STAFF_DELETE";
	private String qryStaffLastCode = "STAFF_LAST_CODE";
	private String qryStaffByCode = "STAFF_BY_CODE";
	private String qryStaffList = "STAFF_LIST";
	private String qryStaffListByOfficeCode = "STAFF_LIST_BY_OFFICECODE";

	@Override
	public void executeAdd(DTOBase obj) {
		StaffDTO staff = (StaffDTO) obj;
		staff.getUserGroup().setCode(SettingsUtil.USER_GROUP_STAFF_CODE);
		List<DTOBase> userGroupLinkListByUserGroup = new UserGroupLinkDAO().getUserGroupLinkListByUserGroupCode(staff.getUserGroup().getCode());
		List<DTOBase> linkList = new LinkDAO().getLinkList();
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		staff.setCode(getGeneratedCode());
		staff.setUserName(staff.getCode());
		staff.setPassword(StringUtil.getUniqueId(3, 3));
		staff.setActive(true);
		staff.setBaseDataOnInsert();
		//User
		new UserDAO().add(conn, prepStmntList, staff);
		//Staff
		add(conn, prepStmntList, staff);
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}

	public String getGeneratedCode() {
		StaffDTO staff = getStaffLast();
		String code = "S001"; //default staff code
		if(staff != null) {
			int nextProfNum = Integer.parseInt(StringUtil.getRight(staff.getCode(), 3)) + 1; 
			code =  "S"+ StringUtil.getPadded(String.valueOf(nextProfNum), 3, "0", true);
		}
		return code;
	}

	private StaffDTO getStaffLast() {
		return (StaffDTO) getDTO(qryStaffLastCode);
	}

	protected void add(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		StaffDTO staff = (StaffDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryStaffAdd));
			prepStmnt.setString(1, staff.getCode());
			prepStmnt.setString(2, staff.getProgramGraduated());
			prepStmnt.setString(3, staff.getJobRole());
			prepStmnt.setString(4, staff.getOffice().getCode());
			prepStmnt.setString(5, staff.getAddedBy());
			prepStmnt.setTimestamp(6, staff.getAddedTimestamp());
			prepStmnt.setString(7, staff.getUpdatedBy());
			prepStmnt.setTimestamp(8, staff.getUpdatedTimestamp());	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
	}

	@Override
	public void executeAddList(List<DTOBase> arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void executeDelete(DTOBase obj) {
		StaffDTO staff = (StaffDTO) obj;
		//User
		UserDTO user = new UserDAO().getUserByCode(staff.getCode());
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		//delete staff
		delete(conn, prepStmntList, staff);
		//delete user
		new UserDAO().delete(conn, prepStmntList, user);
		//delete user link list
		//new UserLinkDAO().delete(conn, prepStmntList, user);
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}

	protected void delete(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		StaffDTO staff = (StaffDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryStaffDelete));	
			prepStmnt.setInt(1, staff.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
	}

	@Override
	public void executeDeleteList(List<DTOBase> arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void executeUpdate(DTOBase obj) {
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		StaffDTO staff = (StaffDTO) obj;
		staff.setBaseDataOnUpdate();
		//User
		new UserDAO().update (conn, prepStmntList, staff);
		//Staff
		update(conn, prepStmntList, staff);
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}

	protected void update(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		StaffDTO staff = (StaffDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryStaffUpdate));
			prepStmnt.setString(1, staff.getProgramGraduated());
			prepStmnt.setString(2, staff.getJobRole());
			prepStmnt.setString(3, staff.getOffice().getCode());
			prepStmnt.setString(4, staff.getUpdatedBy());
			prepStmnt.setTimestamp(5, staff.getUpdatedTimestamp());		
			prepStmnt.setInt(6, staff.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
	}

	public StaffDTO getStaffByCode(String code) {
		return (StaffDTO) getDTO(qryStaffByCode, code);
	}

	public List<DTOBase> getStaffList() {
		return getDTOList(qryStaffList);
	}
	
	public List<DTOBase> getStaffListByOfficeCode(String code) {
		return getDTOList(qryStaffListByOfficeCode, code);
	}

	@Override
	public void executeUpdateList(List<DTOBase> arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	protected DTOBase rsToObj(ResultSet resultSet) { //this would get the value from the database and put into object for returning values for editing
		StaffDTO staff = new StaffDTO();
		staff.setId((Integer) getDBVal(resultSet, "id"));
		staff.setCode((String) getDBVal(resultSet, "code"));
		staff.setProgramGraduated((String) getDBVal(resultSet, "program_graduated"));
		staff.setJobRole((String) getDBVal(resultSet, "job_role"));
		staff.getOffice().setCode((String) getDBVal(resultSet, "assigned_office"));
		staff.setDisplayText(staff.getName());
		return staff;
	}
}
