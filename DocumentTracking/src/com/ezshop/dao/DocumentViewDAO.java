package com.ezshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ezshop.dto.DocumentViewDTO;
import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.util.DateTimeUtil;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.DateFormat;

public class DocumentViewDAO extends DAOBase{
	
	private static final long serialVersionUID = 1L;
	private String qryDocumentViewUpdate = "DOCUMENT_VIEW_UPDATE";
	private String qryDocumentViewByCode = "DOCUMENT_VIEW_BY_CODE";
	private String qryDocumentViewByName = "DOCUMENT_VIEW_BY_NAME";
	private String qryDocumentViewByOffsCode = "DOCUMENT_VIEW_BY_OFFSCODE";
	private String qryDocumentViewList = "DOCUMENT_VIEW_LIST";
	private String qryDocumentViewByCodeName = "DOCUMENT_VIEW_LIST_SEARCHBY_CODENAME";
	private String qryDocumentTrackingCreateListThisYear = "DOCUMENT_TRACKING_CREATE_LIST_BY_CURRENTYEAR";
	private String qryDocumentTrackingCreateListThisMonth = "DOCUMENT_TRACKING_CREATE_LIST_BY_CURRENTMONTH";
	//private String qryDocumentTrackingCreateListThisDay = "DOCUMENT_TRACKING_CREATE_LIST_BY_CURRENTDAY";
	private String qryDocumentTrackingCompleteListThisYear = "DOCUMENT_TRACKING_COMPLETE_LIST_BY_CURRENTYEAR";
	private String qryDocumentTrackingCompleteListThisMonth = "DOCUMENT_TRACKING_COMPLETE_LIST_BY_CURRENTMONTH";
	//private String qryDocumentTrackingCompleteListThisDay = "DOCUMENT_TRACKING_COMPLETE_LIST_BY_CURRENTDAY";
	
	
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
		DocumentViewDTO dcio = (DocumentViewDTO) obj;
		dcio.setBaseDataOnUpdate();
		update(conn, prepStmntList, dcio);

		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}

	protected void update(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		DocumentViewDTO ct = (DocumentViewDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryDocumentViewUpdate));
			prepStmnt.setString(1, ct.getName());
			prepStmnt.setString(2, ct.getDescription());
			prepStmnt.setString(3, ct.getDocument_type().getCode());
			prepStmnt.setString(4, ct.getRequesting_person());
			prepStmnt.setDouble(5, ct.getAmount());
			prepStmnt.setString(6, ct.getBarcode());
			prepStmnt.setString(7, ct.getForward());
			prepStmnt.setString(8, ct.getOffice().getCode());
			prepStmnt.setString(9, ct.getTrackingComplete());
			prepStmnt.setString(10, DateTimeUtil.getDateTimeToStr(ct.getTrackingCompleteDate(), "yyyy-MM-dd") );
			prepStmnt.setString(11, ct.getUpdatedBy());
			prepStmnt.setTimestamp(12, ct.getUpdatedTimestamp());
			prepStmnt.setInt(13, ct.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
	}

	public DocumentViewDTO getDocumentViewByCode(String code) {
		return (DocumentViewDTO) getDTO(qryDocumentViewByCode, code);
	}

	public DocumentViewDTO getDocumentViewByName(String name) {
		return (DocumentViewDTO) getDTO(qryDocumentViewByName, name);
	}
	
	public List<DTOBase> getDocumentViewCreateListThisYear(Integer currentYear) {
		return getDTOList(qryDocumentTrackingCreateListThisYear, currentYear);
	}
	
	public List<DTOBase> getDocumentViewCreateListThisMonth(String currentMonth) {
		return getDTOList(qryDocumentTrackingCreateListThisMonth, currentMonth);
	}
	
	/*public List<DTOBase> getDocumentViewCreateListThisDay(String currentDay) {
		return getDTOList(qryDocumentTrackingCreateListThisDay, currentDay);
	}*/
	
	public List<DTOBase> getDocumentViewCompleteListThisYear(Integer currentYear) {
		return getDTOList(qryDocumentTrackingCompleteListThisYear, currentYear);
	}
	
	public List<DTOBase> getDocumentViewCompleteListThisMonth(String currentMonth) {
		return getDTOList(qryDocumentTrackingCompleteListThisMonth, currentMonth);
	}
	
	/*public List<DTOBase> getDocumentViewCompleteListThisDay(String currentDay) {
		return getDTOList(qryDocumentTrackingCompleteListThisDay, currentDay);
	}*/
	
	@SuppressWarnings("unchecked")
	public List<DTOBase> getDocumentViewByOffsCode(String officeCode) {
		return getDTOList(qryDocumentViewByOffsCode, officeCode);
	}

	public List<DTOBase> getDocumentViewList() {
		return getDTOList(qryDocumentViewList);
	}

	public List<DTOBase> getDocumentviewList(String searchValue) {
		List<Object> paramList = new ArrayList<Object>();
		paramList.add("%" + searchValue + "%");
		paramList.add("%" + searchValue + "%");
		return getDTOList(qryDocumentViewByCodeName, paramList);
	}

	@Override
	public void executeUpdateList(List<DTOBase> arg0) {
	}

	@Override
	protected DTOBase rsToObj(ResultSet resultSet) {
		DocumentViewDTO documentView = new DocumentViewDTO();
		documentView.setId((Integer) getDBVal(resultSet, "id"));
		documentView.setCode((String) getDBVal(resultSet, "code"));
		documentView.setName((String) getDBVal(resultSet, "name"));
		documentView.setDescription((String) getDBVal(resultSet, "description"));
		documentView.getDocument_type().setCode((String) getDBVal(resultSet, "document_type"));
		documentView.setRequesting_person((String) getDBVal(resultSet, "requesting_person"));
		documentView.setAmount((Double) getDBVal(resultSet, "amount"));
		documentView.setBarcode((String) getDBVal(resultSet, "barcode"));
		documentView.setForward((String) getDBVal(resultSet, "forward"));
		documentView.getOffice().setCode((String) getDBVal(resultSet, "active_office"));
		documentView.setTrackingComplete((String) getDBVal(resultSet, "tracking_complete"));
		documentView.setTrackingCompleteDate((java.util.Date) getDBVal(resultSet, "tracking_complete_date"));
		documentView.setAddedBy((String) getDBVal(resultSet, "added_by"));
		documentView.setAddedTimestamp((Timestamp) getDBVal(resultSet, "added_timestamp"));
		documentView.setUpdatedBy((String) getDBVal(resultSet, "updated_by"));
		documentView.setUpdatedTimestamp((Timestamp) getDBVal(resultSet, "updated_timestamp"));
		documentView.setDisplayText(documentView.getName());
		return documentView;
	}
}
