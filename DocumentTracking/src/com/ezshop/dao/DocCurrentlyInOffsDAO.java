
package com.ezshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ezshop.dto.DocCurrentlyInOffsDTO;
import com.ezshop.dto.DocumentTrackingLogDTO;
import com.ezshop.dto.DocumentTrackingOfficeLogDTO;
import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.util.StringUtil;

public class DocCurrentlyInOffsDAO extends DAOBase{
	
	private static final long serialVersionUID = 1L;
	
	//private String qryDocumentTrackingAdd = "DOCUMENT_TRACKING_ADD";
	private String qryDocCurrentlyInOffsUpdate = "DOC_CURRENTLY_IN_OFFS_UPDATE";
	//private String qryDocumentTrackingDelete = "DOCUMENT_TRACKING_DELETE";
	//private String qryDocCurrentlyInOffsLastCode = "DOC_CURRENTLY_IN_OFFS_LAST_CODE";
	private String qryDocCurrentlyInOffsByCode = "DOC_CURRENTLY_IN_OFFS_BY_CODE";
	private String qryDocCurrentlyInOffsByName = "DOC_CURRENTLY_IN_OFFS_BY_NAME";
	private String qryDocCurrentlyInOffsList = "DOC_CURRENTLY_IN_OFFS_LIST";
	private String qryDocCurrentlyInOffsByCodeName = "DOC_CURRENTLY_IN_OFFS_LIST_SEARCHBY_CODENAME";
	private String qryDocCurrentlyInOffsByOffsCode = "DOC_CURRENTLY_IN_OFFS_BY_OFFSCODE";
	
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
		DocCurrentlyInOffsDTO dcio = (DocCurrentlyInOffsDTO) obj;
		dcio.setBaseDataOnUpdate();
		update(conn, prepStmntList, dcio);
		
/*		still working for this*********
 * 		for(DTOBase dllObj: dcio.getNewDocumentLogList(dcio.getCode())){
			DocumentTrackingLogDTO documentTracingLog = (DocumentTrackingLogDTO) dllObj;
			documentTracingLog.setAddedBy(dcio.getUpdatedBy());
			documentTracingLog.setAddedTimestamp(dcio.getUpdatedTimestamp());
			documentTracingLog.setUpdatedBy(dcio.getUpdatedBy());
			documentTracingLog.setUpdatedTimestamp(dcio.getUpdatedTimestamp());
			new DocumentTrackingLogDAO().add(conn, prepStmntList, documentTracingLog);
		}*/

		for(DTOBase dllObj: dcio.getDocumentLogList()){
			DocumentTrackingLogDTO documentTrackingLog = (DocumentTrackingLogDTO) dllObj;
			documentTrackingLog.setAddedBy(dcio.getUpdatedBy());
			documentTrackingLog.setAddedTimestamp(dcio.getUpdatedTimestamp());
			documentTrackingLog.setUpdatedBy(dcio.getUpdatedBy());
			documentTrackingLog.setUpdatedTimestamp(dcio.getUpdatedTimestamp());
			new DocumentTrackingLogDAO().add(conn, prepStmntList, documentTrackingLog);
		}
		
		//document log
		DocumentTrackingOfficeLogDTO documentLog = new DocumentTrackingOfficeLogDTO();
		documentLog.setCode(dcio.getCode() + StringUtil.getUniqueId(2, 2));
		documentLog.setDocumentTrackingCode(dcio.getCode());
		documentLog.getStaff().setCode(dcio.getUpdatedBy());
		documentLog.setOfficeCode(dcio.getOffice().getCode());
		documentLog.setStatus(documentLog.STATUS_FORWARDED);
		documentLog.setCarrier(dcio.getCarrier());
		documentLog.setAddedBy(dcio.getUpdatedBy());
		documentLog.setAddedTimestamp(dcio.getAddedTimestamp());
		documentLog.setBaseDataOnInsert();
		new DocumentTrackingOfficeLogDAO().add(conn, prepStmntList, documentLog);

		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}

	protected void update(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		DocCurrentlyInOffsDTO dcio = (DocCurrentlyInOffsDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryDocCurrentlyInOffsUpdate));
			prepStmnt.setString(1, dcio.getName());
			prepStmnt.setString(2, dcio.getDescription());
			prepStmnt.setString(3, dcio.getDocument_type().getCode());
			prepStmnt.setString(4, dcio.getRequesting_person());
			prepStmnt.setDouble(5, dcio.getAmount());
			prepStmnt.setString(6, dcio.getForward());
			prepStmnt.setString(7, dcio.getOffice().getCode());
			prepStmnt.setString(8, dcio.getUpdatedBy());
			prepStmnt.setTimestamp(9, dcio.getUpdatedTimestamp());
			prepStmnt.setInt(10, dcio.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
	}

	public DocCurrentlyInOffsDTO getDocCurrentlyInOffsByCode(String code) {
		return (DocCurrentlyInOffsDTO) getDTO(qryDocCurrentlyInOffsByCode, code);
	}

	public DocCurrentlyInOffsDTO getDocCurrentlyInOffsByName(String name) {
		return (DocCurrentlyInOffsDTO) getDTO(qryDocCurrentlyInOffsByName, name);
	}
	
	@SuppressWarnings("unchecked")
	public List<DTOBase> getDocCurrentlyInOffsByOffsCode(String officeCode) {
		return getDTOList(qryDocCurrentlyInOffsByOffsCode, officeCode);
	}

	public List<DTOBase> getDocCurrentlyInOffsList() {
		return getDTOList(qryDocCurrentlyInOffsList);
	}

	public List<DTOBase> getDocCurrentlyInOffsList(String searchValue) {
		List<Object> paramList = new ArrayList<Object>();
		paramList.add("%" + searchValue + "%");
		paramList.add("%" + searchValue + "%");
		return getDTOList(qryDocCurrentlyInOffsByCodeName, paramList);
	}

	@Override
	public void executeUpdateList(List<DTOBase> arg0) {
	}

	@Override
	protected DTOBase rsToObj(ResultSet resultSet) {
		DocCurrentlyInOffsDTO dcio = new DocCurrentlyInOffsDTO();
		dcio.setId((Integer) getDBVal(resultSet, "id"));
		dcio.setCode((String) getDBVal(resultSet, "code"));
		dcio.setName((String) getDBVal(resultSet, "name"));
		dcio.setDescription((String) getDBVal(resultSet, "description"));
		dcio.getDocument_type().setCode((String) getDBVal(resultSet, "document_type"));
		dcio.setRequesting_person((String) getDBVal(resultSet, "requesting_person"));
		dcio.setAmount((Double) getDBVal(resultSet, "amount"));
		//dcio.setBarcode((String) getDBVal(resultSet, "barcode"));
		dcio.setPic((String) getDBVal(resultSet, "pic"));
		//dcio.getActiveOffice().setCode((String) getDBVal(resultSet, "active_office"));
		//dcio.getActiveOffice().setCode((String) getDBVal(resultSet, "active_office"));
		//dcio.getActiveOffice().setCode((String) getDBVal(resultSet, "active_office"));
		dcio.setForward((String) getDBVal(resultSet, "forward"));
		dcio.getOffice().setCode((String) getDBVal(resultSet, "active_office"));
		dcio.setAddedBy((String) getDBVal(resultSet, "added_by"));
		dcio.setAddedTimestamp((Timestamp) getDBVal(resultSet, "added_timestamp"));
		dcio.setUpdatedBy((String) getDBVal(resultSet, "updated_by"));
		dcio.setUpdatedTimestamp((Timestamp) getDBVal(resultSet, "updated_timestamp"));
		dcio.setDisplayText(dcio.getName());
		return dcio;
	}
}
