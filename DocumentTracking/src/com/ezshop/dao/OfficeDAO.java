package com.ezshop.dao;

/*import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ezshop.dto.OfficeDTO;
import com.mysql.jdbc.PreparedStatement;
import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.util.StringUtil;*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.util.StringUtil;

public class OfficeDAO extends DAOBase {

	private static final long serialVersionUID = 1L;
	
	private String qryOfficeAdd = "OFFICE_ADD";
	private String qryOfficeUpdate = "OFFICE_UPDATE";
	private String qryOfficeDelete = "OFFICE_DELETE";
	private String qryOfficeLastCode = "OFFICE_LAST_CODE";
	private String qryOfficeLastActiveOffice = "OFFICE_LAST_ACTIVE_OFFICE";
	private String qryOfficeByCode = "OFFICE_BY_CODE";
	private String qryOfficeByName = "OFFICE_BY_NAME";
	private String qryOfficeList = "OFFICE_LIST";
	private String qryOfficeListSearchByCodeName = "OFFICE_LIST_SEARCHBY_CODENAME";

	@Override
	public void executeAdd(DTOBase obj) {
		OfficeDTO office = (OfficeDTO) obj;
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		office.setCode(getGeneratedCode());
		office.setFor_active_office(getGeneratedCodeActiveOffice());
		office.setBaseDataOnInsert();
		add(conn, prepStmntList, office);
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}
	
	public String getGeneratedCode() {
		OfficeDTO office = getOfficeLast();
		String code = "RF0001";
		if(office != null) {
			int nextProfNum = Integer.parseInt(StringUtil.getRight(office.getCode(), 4)) + 1;
			code = "RF" + StringUtil.getPadded(String.valueOf(nextProfNum), 4, "0", true);
		}
		return code;
	}
	
	public String getGeneratedCodeActiveOffice() {
		OfficeDTO office = getOfficeLastActiveOffice();
		String code = "F0001";
		if(office != null) {
			int nextProfNum = Integer.parseInt(StringUtil.getRight(office.getCode(), 4)) + 1;
			code = "F" + StringUtil.getPadded(String.valueOf(nextProfNum), 4, "0", true);
		}
		return code;
	}
	
	private OfficeDTO getOfficeLast() {
		return (OfficeDTO) getDTO(qryOfficeLastCode);
	}
	
	private OfficeDTO getOfficeLastActiveOffice() {
		return (OfficeDTO) getDTO(qryOfficeLastActiveOffice);
	}
	
	protected void add(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		OfficeDTO office = (OfficeDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = (PreparedStatement) conn.prepareStatement(getQueryStatement(qryOfficeAdd));
			prepStmnt.setString(1, office.getCode());
			prepStmnt.setString(2, office.getFor_active_office());
			prepStmnt.setString(3, office.getName());
			prepStmnt.setString(4, office.getAddedBy());
			prepStmnt.setTimestamp(5, office.getAddedTimestamp());
			prepStmnt.setString(6, office.getUpdatedBy());
			prepStmnt.setTimestamp(7, office.getUpdatedTimestamp());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		OfficeDTO office = (OfficeDTO) obj;
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		delete(conn, prepStmntList, office);
	}
	
	protected void delete(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		OfficeDTO office = (OfficeDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryOfficeDelete));
			prepStmnt.setInt(1, office.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}

	@Override
	public void executeDeleteList(List<DTOBase> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeUpdate(DTOBase obj) {
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		OfficeDTO office = (OfficeDTO) obj;
		office.setBaseDataOnUpdate();
		update(conn, prepStmntList, office);
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}
	
	protected void update(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		OfficeDTO office = (OfficeDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryOfficeUpdate));
			prepStmnt.setString(1, office.getName());
			prepStmnt.setString(2, office.getFor_active_office());
			prepStmnt.setString(3, office.getUpdatedBy());
			prepStmnt.setTimestamp(4, office.getUpdatedTimestamp());
			prepStmnt.setInt(5, office.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
	}
	
	public OfficeDTO getOfficeByCode(String code) {
		return (OfficeDTO) getDTO(qryOfficeByCode, code);
	}
	
	public OfficeDTO getOfficeByName(String name) {
		return (OfficeDTO) getDTO(qryOfficeByName, name);
	}
	
	public List<DTOBase> getOfficeList() {
		return getDTOList(qryOfficeList);
	}
	
	public List<DTOBase> getOfficeList(String searchValue) {
		List<Object> paramList = new ArrayList<Object>();
		paramList.add("%" + searchValue + "%");
		paramList.add("%" + searchValue + "%");
		return getDTOList(qryOfficeListSearchByCodeName, paramList);
	}

	@Override
	public void executeUpdateList(List<DTOBase> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected DTOBase rsToObj(ResultSet resultSet) {
		OfficeDTO office = new OfficeDTO();
		office.setId((Integer) getDBVal(resultSet, "id"));
		office.setCode((String) getDBVal(resultSet, "code"));
		office.setFor_active_office((String) getDBVal(resultSet, "for_active_office"));
		office.setName((String) getDBVal(resultSet, "name"));
		office.setAddedBy((String) getDBVal(resultSet, "added_by"));
		office.setAddedTimestamp((Timestamp) getDBVal(resultSet, "added_timestamp"));
		office.setUpdatedBy((String) getDBVal(resultSet, "updated_by"));
		office.setUpdatedTimestamp((Timestamp) getDBVal(resultSet, "updated_timestamp"));
		office.setDisplayText(office.getName());
		return office;
	}
}
