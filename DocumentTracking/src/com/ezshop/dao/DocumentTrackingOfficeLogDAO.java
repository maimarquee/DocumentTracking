package com.ezshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.ezshop.dto.DocumentTrackingOfficeLogDTO;
import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;

public class DocumentTrackingOfficeLogDAO extends DAOBase {
	private static final long serialVersionUID = 1L;

	private final String qryDocumentTrackingOfficeLogAdd = "DOCUMENT_TRACKING_OFFICE_LOG_ADD";
	private final String qryDocumentTrackingOfficeLogListByDocumentCode = "DOCUMENT_TRACKING_OFFICE_LOG_LIST_BY_DOCUMENTCODE";
	private final String qryDocumentTrackingOfficeLogListByYesterday = "DOCUMENT_TRACKING_OFFICE_LOG_LIST_BYYESTERDAY";
	private final String qryDocumentTrackingOfficeLogList = "DOCUMENT_TRACKING_OFFICE_LOG_LIST";
	
	public String getLastDayOfTheMonth(String year, String month) {
		GregorianCalendar calendar = new GregorianCalendar();
		int yearInt = Integer.parseInt(year);
		int monthInt = Integer.parseInt(month);
		monthInt = monthInt - 1;
		calendar.set(yearInt, monthInt, 1);
		int dayInt = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		return Integer.toString(dayInt);
	}
	
	@Override
	public void executeAdd(DTOBase obj) {
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		DocumentTrackingOfficeLogDTO documentOfficeLog = (DocumentTrackingOfficeLogDTO) obj;
		documentOfficeLog.setBaseDataOnInsert();
		add(conn, prepStmntList, documentOfficeLog);
		
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}
	
	protected void add(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		DocumentTrackingOfficeLogDTO documentTrackingLog = (DocumentTrackingOfficeLogDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryDocumentTrackingOfficeLogAdd));
			prepStmnt.setString(1, documentTrackingLog.getCode());
			prepStmnt.setString(2, documentTrackingLog.getDocumentTrackingCode());
			prepStmnt.setString(3, documentTrackingLog.getStaff().getCode());
			prepStmnt.setString(4, documentTrackingLog.getOfficeCode());
			prepStmnt.setString(5, documentTrackingLog.getStatus());
			prepStmnt.setString(6, documentTrackingLog.getCarrier());
			prepStmnt.setString(7, documentTrackingLog.getAddedBy());
			prepStmnt.setTimestamp(8, documentTrackingLog.getAddedTimestamp());
			prepStmnt.setString(9, documentTrackingLog.getUpdatedBy());
			prepStmnt.setTimestamp(10, documentTrackingLog.getUpdatedTimestamp());
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
	public void executeDelete(DTOBase arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void executeDeleteList(List<DTOBase> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void executeUpdate(DTOBase arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void executeUpdateList(List<DTOBase> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public List<DTOBase> getDocumentTrackingOfficeLogListByDocumentCode(String documentCode) {
		return getDTOList(qryDocumentTrackingOfficeLogListByDocumentCode, documentCode);
	}
	
/*	public DocumentTrackingOfficeLogDTO getDocumentTrackingOfficeLogListByCode(String code) {
		return (DocumentTrackingOfficeLogDTO) getDTO(qryDocumentTrackingOfficeLogListByDocumentCode, code);
	}*/
	
	public List<DTOBase> getDocumentTrackingOfficeLogList() {
		return getDTOList(qryDocumentTrackingOfficeLogList);
	}
	
	public List<DTOBase> getDocumentTrackingOfficeLogListByCode(String code) {
		return getDTOList(qryDocumentTrackingOfficeLogListByDocumentCode, code , true);
	}

	public List<DTOBase> getDocumentTrackingOfficeLogListByYesterday(String yesterday) {
		return getDTOList(qryDocumentTrackingOfficeLogListByYesterday, yesterday);
	}
	
/*	public List<DTOBase> getDocumentTrackingOfficeLogListByCode(String searchValue) {
		List<Object> paramList = new ArrayList<Object>();
		paramList.add("%" + searchValue + "%");
		return getDTOList(qryDocumentTrackingOfficeLogListByCode, paramList);
	}
	*/
	@Override
	protected DTOBase rsToObj(ResultSet resultSet) {
		DocumentTrackingOfficeLogDTO obj = new DocumentTrackingOfficeLogDTO();
		obj.setId((Integer) getDBVal(resultSet, "id"));
		obj.setCode((String) getDBVal(resultSet, "code"));
		obj.setDocumentTrackingCode((String) getDBVal(resultSet, "document_tracking_code"));
		obj.getStaff().setCode((String) getDBVal(resultSet, "staff_code"));
		obj.setOfficeCode((String) getDBVal(resultSet, "office_code"));
		obj.setStatus((String) getDBVal(resultSet, "status"));
		obj.setCarrier((String) getDBVal(resultSet, "carrier"));
		obj.setAddedBy((String) getDBVal(resultSet, "added_by"));
		obj.setAddedTimestamp((Timestamp) getDBVal(resultSet, "added_timestamp"));
		return obj;
	}
}
