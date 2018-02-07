package com.ezshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ezshop.dto.AcceptDocumentDTO;
import com.ezshop.dto.DocumentTrackingDTO;
import com.ezshop.dto.DocumentTrackingOfficeLogDTO;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.StaffUtil;
import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.util.StringUtil;
import com.mytechnopal.util.UserUtil;

public class AcceptDocumentDAO extends DAOBase{

	private static final long serialVersionUID = 1L;

	private String qryAcceptDocumentUpdate = "ACCEPT_DOCUMENT_UPDATE";
	private String qryAcceptDocumentByCode = "ACCEPT_DOCUMENT_BY_CODE";
	private String qryAcceptDocumentByName = "ACCEPT_DOCUMENT_BY_NAME";
	private String qryAcceptDocumentList = "ACCEPT_DOCUMENT_OFFS_LIST";
	private String qryAcceptDocumentByCodeName = "ACCEPT_DOCUMENT_LIST_SEARCHBY_CODENAME";
	private String qryAcceptDocumentByOffsCode = "ACCEPT_DOCUMENT_BY_OFFSCODE";

	@Override
	public void executeAdd(DTOBase arg0) {
		// TODO Auto-generated method stub
		
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
	public void executeUpdate(DTOBase obj) {
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		AcceptDocumentDTO acDocument = (AcceptDocumentDTO) obj;
		acDocument.setBaseDataOnUpdate();
		update(conn, prepStmntList, acDocument);
		
		//document log
			DocumentTrackingOfficeLogDTO documentLog = new DocumentTrackingOfficeLogDTO();
			documentLog.setCode(acDocument.getCode() + StringUtil.getUniqueId(2, 2));
			documentLog.setDocumentTrackingCode(acDocument.getCode());
			documentLog.getStaff().setCode(acDocument.getUpdatedBy());
			documentLog.setOfficeCode(acDocument.getOffice());
			documentLog.setStatus(documentLog.STATUS_ACCEPTED);
			documentLog.setAddedBy(acDocument.getUpdatedBy());
			documentLog.setAddedTimestamp(acDocument.getAddedTimestamp());
			documentLog.setBaseDataOnInsert();
			new DocumentTrackingOfficeLogDAO().add(conn, prepStmntList, documentLog);
				
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}

	protected void update(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		AcceptDocumentDTO acDocument = (AcceptDocumentDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryAcceptDocumentUpdate));
			prepStmnt.setString(1, acDocument.getForward());
			prepStmnt.setString(2, acDocument.getOffice());
			prepStmnt.setString(3, acDocument.getUpdatedBy());
			prepStmnt.setTimestamp(4, acDocument.getUpdatedTimestamp());
			prepStmnt.setInt(5, acDocument.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
	}

	public AcceptDocumentDTO getAcceptDocumentByCode(String code) {
		return (AcceptDocumentDTO) getDTO(qryAcceptDocumentByCode, code);
	}

	public AcceptDocumentDTO getAcceptDocumentByName(String name) {
		return (AcceptDocumentDTO) getDTO(qryAcceptDocumentByName, name);
	}
	
	@SuppressWarnings("unchecked")
	public List<DTOBase> getAcceptDocumentByOffsCode(String officeCode) {
		return getDTOList(qryAcceptDocumentByOffsCode, officeCode);
	}

	public List<DTOBase> getAcceptDocumentList() {
		return getDTOList(qryAcceptDocumentList);
	}

	public List<DTOBase> getAcceptDocumentList(String searchValue) {
		List<Object> paramList = new ArrayList<Object>();
		paramList.add("%" + searchValue + "%");
		paramList.add("%" + searchValue + "%");
		return getDTOList(qryAcceptDocumentByCodeName, paramList);
	}

	@Override
	public void executeUpdateList(List<DTOBase> arg0) {
	}

	@Override
	protected DTOBase rsToObj(ResultSet resultSet) {
		AcceptDocumentDTO acDocument = new AcceptDocumentDTO();
		acDocument.setId((Integer) getDBVal(resultSet, "id"));
		acDocument.setCode((String) getDBVal(resultSet, "code"));
		acDocument.setName((String) getDBVal(resultSet, "name"));
		acDocument.setDescription((String) getDBVal(resultSet, "description"));
		acDocument.getDocument_type().setCode((String) getDBVal(resultSet, "document_type"));
		acDocument.setRequesting_person((String) getDBVal(resultSet, "requesting_person"));
		acDocument.setAmount((Double) getDBVal(resultSet, "amount"));
		acDocument.setBarcode((String) getDBVal(resultSet, "barcode"));
		acDocument.setForward((String) getDBVal(resultSet, "forward"));
		acDocument.setOffice((String) getDBVal(resultSet, "active_office"));
		acDocument.setAddedBy((String) getDBVal(resultSet, "added_by"));
		acDocument.setAddedTimestamp((Timestamp) getDBVal(resultSet, "added_timestamp"));
		acDocument.setUpdatedBy((String) getDBVal(resultSet, "updated_by"));
		acDocument.setUpdatedTimestamp((Timestamp) getDBVal(resultSet, "updated_timestamp"));
		acDocument.setDisplayText(acDocument.getName());
		return acDocument;
	}
}
