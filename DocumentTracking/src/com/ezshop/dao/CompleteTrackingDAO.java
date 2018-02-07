package com.ezshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ezshop.dto.CompleteTrackingDTO;
import com.ezshop.dto.DocumentTrackingOfficeLogDTO;
import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.util.DateTimeUtil;
import com.mytechnopal.util.StringUtil;

public class CompleteTrackingDAO extends DAOBase{
	
	private static final long serialVersionUID = 1L;


	//private String qryDocumentTrackingAdd = "DOCUMENT_TRACKING_ADD";
	private String qryCompleteTrackingUpdate = "COMPLETE_TRACKING_UPDATE";
	//private String qryDocumentTrackingDelete = "DOCUMENT_TRACKING_DELETE";
	//private String qryDocCurrentlyInOffsLastCode = "DOC_CURRENTLY_IN_OFFS_LAST_CODE";
	private String qryCompleteTrackingByCode = "COMPLETE_TRACKING_BY_CODE";
	private String qryCompleteTrackingByName = "COMPLETE_TRACKING_BY_NAME";
	private String qryCompleteTrackingByOffsCode = "COMPLETE_TRACKING_BY_OFFSCODE";
	private String qryCompleteTrackingList = "COMPLETE_TRACKING_LIST";
	private String qryCompleteTrackingByCodeName = "COMPLETE_TRACKING_LIST_SEARCHBY_CODENAME";

	
	
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
		CompleteTrackingDTO dcio = (CompleteTrackingDTO) obj;
		dcio.setBaseDataOnUpdate();
		update(conn, prepStmntList, dcio);
		
		//document log
		DocumentTrackingOfficeLogDTO documentLog = new DocumentTrackingOfficeLogDTO();
		documentLog.setCode(dcio.getCode() + StringUtil.getUniqueId(2, 2));
		documentLog.setDocumentTrackingCode(dcio.getCode());
		documentLog.getStaff().setCode(dcio.getUpdatedBy());
		documentLog.setOfficeCode(dcio.getOffice().getCode());
		documentLog.setStatus(documentLog.STATUS_COMPLETED);
		documentLog.setAddedBy(dcio.getUpdatedBy());
		documentLog.setAddedTimestamp(dcio.getAddedTimestamp());
		documentLog.setBaseDataOnInsert();
		new DocumentTrackingOfficeLogDAO().add(conn, prepStmntList, documentLog);

		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}

	protected void update(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		CompleteTrackingDTO ct = (CompleteTrackingDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryCompleteTrackingUpdate));
			prepStmnt.setString(1, ct.getName());
			prepStmnt.setString(2, ct.getDescription());
			prepStmnt.setString(3, ct.getDocument_type().getCode());
			prepStmnt.setString(4, ct.getRequesting_person());
			prepStmnt.setDouble(5, ct.getAmount());
			prepStmnt.setString(6, ct.getTrackingComplete());
			prepStmnt.setString(7, DateTimeUtil.getDateTimeToStr(ct.getTrackingCompleteDate(), "yyyy-MM-dd") );
			prepStmnt.setString(8, ct.getUpdatedBy());
			prepStmnt.setTimestamp(9, ct.getUpdatedTimestamp());
			prepStmnt.setInt(10, ct.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
	}

	public CompleteTrackingDTO getCompleteTrackingByCode(String code) {
		return (CompleteTrackingDTO) getDTO(qryCompleteTrackingByCode, code);
	}

	public CompleteTrackingDTO getCompleteTrackingByName(String name) {
		return (CompleteTrackingDTO) getDTO(qryCompleteTrackingByName, name);
	}
	
	@SuppressWarnings("unchecked")
	public List<DTOBase> getCompleteTrackingByOffsCode(String officeCode) {
		return getDTOList(qryCompleteTrackingByOffsCode, officeCode);
	}

	public List<DTOBase> getCompleteTrackingList() {
		return getDTOList(qryCompleteTrackingList);
	}

	public List<DTOBase> getCompleteTrackingList(String searchValue) {
		List<Object> paramList = new ArrayList<Object>();
		paramList.add("%" + searchValue + "%");
		paramList.add("%" + searchValue + "%");
		return getDTOList(qryCompleteTrackingByCodeName, paramList);
	}

	@Override
	public void executeUpdateList(List<DTOBase> arg0) {
	}

	@Override
	protected DTOBase rsToObj(ResultSet resultSet) {
		CompleteTrackingDTO ct = new CompleteTrackingDTO();
		ct.setId((Integer) getDBVal(resultSet, "id"));
		ct.setCode((String) getDBVal(resultSet, "code"));
		ct.setName((String) getDBVal(resultSet, "name"));
		ct.setDescription((String) getDBVal(resultSet, "description"));
		ct.getDocument_type().setCode((String) getDBVal(resultSet, "document_type"));
		ct.setRequesting_person((String) getDBVal(resultSet, "requesting_person"));
		ct.setAmount((Double) getDBVal(resultSet, "amount"));
		ct.getOffice().setCode((String) getDBVal(resultSet, "active_office"));;
		//ct.setBarcode((String) getDBVal(resultSet, "barcode"));
		//dcio.getActiveOffice().setCode((String) getDBVal(resultSet, "active_office"));
		//dcio.getActiveOffice().setCode((String) getDBVal(resultSet, "active_office"));
		//dcio.getActiveOffice().setCode((String) getDBVal(resultSet, "active_office"));
		//ct.setForward((String) getDBVal(resultSet, "forward"));
		//ct.getOffice().setCode((String) getDBVal(resultSet, "active_office"));
		ct.setTrackingComplete((String) getDBVal(resultSet, "tracking_complete"));
		//merchandiseTransaction.setDate((java.util.Date) getDBVal(resultSet, "date"));
		ct.setTrackingCompleteDate((java.util.Date) getDBVal(resultSet, "tracking_complete_date"));
		ct.setUpdatedBy((String) getDBVal(resultSet, "updated_by"));
		ct.setUpdatedTimestamp((Timestamp) getDBVal(resultSet, "updated_timestamp"));
		ct.setDisplayText(ct.getName());
		return ct;
	}
}
