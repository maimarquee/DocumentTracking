package com.ezshop.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Timestamp;

import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.util.StringUtil;
import com.ezshop.dto.DocumentTrackingDTO;
import com.ezshop.dto.DocumentTrackingOfficeLogDTO;

public class DocumentTrackingDAO extends DAOBase{

	private String qryDocumentTrackingAdd = "DOCUMENT_TRACKING_ADD";
	private String qryDocumentTrackingUpdate = "DOCUMENT_TRACKING_UPDATE";
	private String qryDocumentTrackingDelete = "DOCUMENT_TRACKING_DELETE";
	private String qryDocumentTrackingLastCode = "DOCUMENT_TRACKING_LAST_CODE";
	private String qryDocumentTrackingByCode = "DOCUMENT_TRACKING_BY_CODE";
	private String qryDocumentTrackingByName = "DOCUMENT_TRACKING_BY_NAME";
	private String qryDocumentTrackingByCodeName = "DOCUMENT_TRACKING_LIST_SEARCHBY_CODENAME";
	private String qryDocumentTrackingList = "DOCUMENT_TRACKING_LIST";
	private String qryDocumentTrackingByDocumentType = "DOCUMENT_TRACKING_BY_DOCUMENTTYPE";

	private static final long serialVersionUID = 1L;

	@Override
	public void executeAdd(DTOBase obj) {
		DocumentTrackingDTO documenttracking = (DocumentTrackingDTO) obj;
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		documenttracking.setCode(getGeneratedCode());
		documenttracking.setBaseDataOnInsert();
		/*MyBarcodeGenerator barCodeUtil = new MyBarcodeGenerator(); // This will generate Bar-Code 128 format
		barCodeUtil.createBarCode128(getGeneratedCode());*/
		add(conn, prepStmntList, documenttracking);

		//document log
		DocumentTrackingOfficeLogDTO documentLog = new DocumentTrackingOfficeLogDTO();
		documentLog.setCode(documenttracking.getCode() + StringUtil.getUniqueId(2, 2));
		documentLog.setDocumentTrackingCode(documenttracking.getCode());
		documentLog.getStaff().setCode(documenttracking.getUpdatedBy());
		documentLog.setOfficeCode(documenttracking.getActive_office());
		documentLog.setStatus(documentLog.STATUS_CREATED);
		documentLog.setAddedBy(documenttracking.getUpdatedBy());
		documentLog.setAddedTimestamp(documenttracking.getAddedTimestamp());
		documentLog.setBaseDataOnInsert();
		new DocumentTrackingOfficeLogDAO().add(conn, prepStmntList, documentLog);
		
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
		//barCodeUtil.break();
	}

	public String getGeneratedCode() {
		DocumentTrackingDTO documenttrackinglastcode = getDocumentTrackingLastCode();
		Calendar now = Calendar.getInstance();
		int currentyear = now.get(Calendar.YEAR);
		//String code = currentyear + "00001";
		String code = "";
		if(documenttrackinglastcode == null || Integer.parseInt(StringUtil.getLeft(documenttrackinglastcode.getCode(), 4)) != currentyear) {
			code = currentyear + "00001";
		}
		else if(documenttrackinglastcode != null) {
			int lastpadedplusone = Integer.parseInt(StringUtil.getRight(documenttrackinglastcode.getCode(), 5)) + 1;
			code = currentyear + StringUtil.getPadded(String.valueOf(lastpadedplusone), 5, "0", true);
		}
		return code;
	}

	private DocumentTrackingDTO getDocumentTrackingLastCode() {
		return(DocumentTrackingDTO) getDTO(qryDocumentTrackingLastCode);
	}

	protected void add(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		DocumentTrackingDTO documenttracking = (DocumentTrackingDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryDocumentTrackingAdd));
			prepStmnt.setString(1, documenttracking.getCode());
			prepStmnt.setString(2, documenttracking.getName());
			prepStmnt.setString(3, documenttracking.getDescription());
			prepStmnt.setString(4, documenttracking.getDocument_type().getCode());
			prepStmnt.setString(5, documenttracking.getRequesting_person());
			prepStmnt.setDouble(6, documenttracking.getAmount());
			prepStmnt.setString(7, documenttracking.getForward());
			prepStmnt.setString(8, documenttracking.getActive_office());
			prepStmnt.setString(9, documenttracking.getAddedBy());
			prepStmnt.setTimestamp(10, documenttracking.getAddedTimestamp());
			prepStmnt.setString(11, documenttracking.getUpdatedBy());
			prepStmnt.setTimestamp(12, documenttracking.getUpdatedTimestamp());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
	}
	
	@Override
	public void executeAddList(List<DTOBase> arg0) {
	}

	@Override
	public void executeDelete(DTOBase obj) {
		DocumentTrackingDTO documenttracking = (DocumentTrackingDTO) obj;
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		delete(conn, prepStmntList, documenttracking);
	}

	protected void delete(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		DocumentTrackingDTO documenttracking = (DocumentTrackingDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryDocumentTrackingDelete));
			prepStmnt.setInt(1, documenttracking.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}

	@Override
	public void executeDeleteList(List<DTOBase> arg0) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void executeUpdate(DTOBase obj) {
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		DocumentTrackingDTO documenttracking = (DocumentTrackingDTO) obj;
		documenttracking.setBaseDataOnUpdate();
		update(conn, prepStmntList, documenttracking);
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}

	protected void update(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		DocumentTrackingDTO documenttracking = (DocumentTrackingDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryDocumentTrackingUpdate));
			prepStmnt.setString(1, documenttracking.getName());
			prepStmnt.setString(2, documenttracking.getDescription());
			prepStmnt.setString(3, documenttracking.getDocument_type().getCode());
			prepStmnt.setString(4, documenttracking.getRequesting_person());
			prepStmnt.setDouble(5, documenttracking.getAmount());
			prepStmnt.setString(6, documenttracking.getUpdatedBy());
			prepStmnt.setTimestamp(7, documenttracking.getUpdatedTimestamp());
			prepStmnt.setInt(8, documenttracking.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
	}

	public DocumentTrackingDTO getDocumentTrackingByCode(String code) {
		return (DocumentTrackingDTO) getDTO(qryDocumentTrackingByCode, code);
	}

	public DocumentTrackingDTO getDocumentTrackingByName(String name) {
		return (DocumentTrackingDTO) getDTO(qryDocumentTrackingByName, name);
	}

	public List<DTOBase> getDocumentTrackingByDocumentType(String documentType) {
		return getDTOList(qryDocumentTrackingByDocumentType, documentType);
	}

	public List<DTOBase> getDocumentTrackingList() {
		return getDTOList(qryDocumentTrackingList);
	}

	public List<DTOBase> getDocumentTrackingList(String searchValue) {
		List<Object> paramList = new ArrayList<Object>();
		paramList.add("%" + searchValue + "%");
		paramList.add("%" + searchValue + "%");
		return getDTOList(qryDocumentTrackingByCodeName, paramList);
	}

	@Override
	public void executeUpdateList(List<DTOBase> arg0) {
	}

	@Override
	protected DTOBase rsToObj(ResultSet resultSet) {
		DocumentTrackingDTO documenttracking = new DocumentTrackingDTO();
		documenttracking.setId((Integer) getDBVal(resultSet, "id"));
		documenttracking.setCode((String) getDBVal(resultSet, "code"));
		documenttracking.setName((String) getDBVal(resultSet, "name"));
		documenttracking.setDescription((String) getDBVal(resultSet, "description"));
		documenttracking.getDocument_type().setCode((String) getDBVal(resultSet, "document_type"));
		documenttracking.setRequesting_person((String) getDBVal(resultSet, "requesting_person"));
		documenttracking.setAmount((Double) getDBVal(resultSet, "amount"));
		documenttracking.setForward((String) getDBVal(resultSet, "forward"));
		documenttracking.setActive_office((String) getDBVal(resultSet, "active_office"));
		documenttracking.setAddedBy((String) getDBVal(resultSet, "added_by"));
		documenttracking.setAddedTimestamp((Timestamp) getDBVal(resultSet, "added_timestamp"));
		documenttracking.setUpdatedBy((String) getDBVal(resultSet, "updated_by"));
		documenttracking.setUpdatedTimestamp((Timestamp) getDBVal(resultSet, "updated_timestamp"));
		documenttracking.setDisplayText(documenttracking.getName());
		return documenttracking;
	}
}
