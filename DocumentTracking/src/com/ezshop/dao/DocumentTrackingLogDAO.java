package com.ezshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ezshop.dto.DocumentTrackingLogDTO;
import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;

public class DocumentTrackingLogDAO extends DAOBase {
	private static final long serialVersionUID = 1L;

	private final String qryDocumentTrackingLogAdd = "DOCUMENT_TRACKING_LOG_ADD";
	private final String qryDocumentTrackingLogListByDocumentCode = "DOCUMENT_TRACKING_LOG_LIST_BY_DOCUMENTCODE";

	@Override
	public void executeAdd(DTOBase obj) {
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		DocumentTrackingLogDTO documentLog = (DocumentTrackingLogDTO) obj;
		documentLog.setBaseDataOnInsert();
		System.out.println(documentLog);
		add(conn, prepStmntList, documentLog);
		
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}

	protected void add(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		DocumentTrackingLogDTO documentTrackingLog = (DocumentTrackingLogDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryDocumentTrackingLogAdd));
			prepStmnt.setString(1, documentTrackingLog.getCode());
			prepStmnt.setString(2, documentTrackingLog.getDocumentTrackingCode());
			prepStmnt.setString(3, documentTrackingLog.getStaff().getCode());
			prepStmnt.setString(4, documentTrackingLog.getComment());
			prepStmnt.setString(5, documentTrackingLog.getStatus());
			prepStmnt.setString(6, documentTrackingLog.getUploadedFile().getUploadFilename());
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
	public void executeDelete(DTOBase obj) {
	}

	@Override
	public void executeUpdate(DTOBase obj) {
	}

	@Override
	public void executeAddList(List<DTOBase> arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void executeDeleteList(List<DTOBase> arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void executeUpdateList(List<DTOBase> arg0) {
		// TODO Auto-generated method stub
	}
	
	public List<DTOBase> getDocumentTrackingLogListByDocumentCode(String documentCode) {
		return getDTOList(qryDocumentTrackingLogListByDocumentCode, documentCode);
	}

	@Override
	protected DTOBase rsToObj(ResultSet resultSet) {
		DocumentTrackingLogDTO obj = new DocumentTrackingLogDTO();
		obj.setId((Integer) getDBVal(resultSet, "id"));
		obj.setCode((String) getDBVal(resultSet, "code"));
		obj.setDocumentTrackingCode((String) getDBVal(resultSet, "document_code"));
		obj.getStaff().setCode((String) getDBVal(resultSet, "staff_code"));
		obj.setComment((String) getDBVal(resultSet, "comment"));
		obj.setStatus((String) getDBVal(resultSet, "status"));
		obj.getUploadedFile().setUploadFilename((String) getDBVal(resultSet, "uploaded_filename"));
		obj.setAddedBy((String) getDBVal(resultSet, "added_by"));
		obj.setAddedTimestamp((Timestamp) getDBVal(resultSet, "added_timestamp"));
		return obj;
	}
	
	public static void main(String[] a) {
	}

}
