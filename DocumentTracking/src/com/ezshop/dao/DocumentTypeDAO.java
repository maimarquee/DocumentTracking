package com.ezshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ezshop.dto.DocumentTypeDTO;
import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.util.StringUtil;

public class DocumentTypeDAO extends DAOBase {
	private static final long serialVersionUID = 1L;

	private String qryDocumentTypeAdd = "DOCUMENT_TYPE_ADD";
	private String qryDocumentTypeLastCode = "DOCUMENT_TYPE_LAST_CODE";
	private String qryDocumentTypeList = "DOCUMENT_TYPE_LIST";
	private String qryDocumentTypeUpdate = "DOCUMENT_TYPE_UPDATE";
	private String qryDocumentTypeDelete = "DOCUMENT_TYPE_DELETE";
	private String qryDocumentTypeByCode = "DOCUMENT_TYPE_BY_CODE";
	private String qryDocumentTypeByName = "DOCUMENT_TYPE_BY_NAME";
	private String qryDocumentTypeListSearchByCodeName = "DOCUMENT_TYPE_LIST_SEARCHBY_CODENAME";

	@SuppressWarnings("unchecked")
	@Override
	public void executeAdd(DTOBase obj) {
		DocumentTypeDTO documenttype = (DocumentTypeDTO) obj;
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		documenttype.setCode(getGeneratedCode());
		documenttype.setBaseDataOnInsert();
		add(conn, prepStmntList, documenttype);
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}

	public String getGeneratedCode() {
		DocumentTypeDTO documenttype =  getDocumentTypeLast();
		String code = "D0001"; //default supplier code
		if(documenttype != null) {
			int nextNum = Integer.parseInt(StringUtil.getRight(documenttype.getCode(), 4)) + 1; 
			code =  "D"+ StringUtil.getPadded(String.valueOf(nextNum), 4, "0", true);
		}
		return code;
	}
	
	private DocumentTypeDTO getDocumentTypeLast() {
		return (DocumentTypeDTO) getDTO(qryDocumentTypeLastCode);
	}

	protected void add(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		DocumentTypeDTO documenttype = (DocumentTypeDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryDocumentTypeAdd));
			prepStmnt.setString(1, documenttype.getCode());
			prepStmnt.setString(2, documenttype.getName());
			prepStmnt.setString(3, documenttype.getAddedBy());
			prepStmnt.setTimestamp(4, documenttype.getAddedTimestamp());
			prepStmnt.setString(5, documenttype.getUpdatedBy());
			prepStmnt.setTimestamp(6, documenttype.getUpdatedTimestamp());	
		}
		catch (SQLException e) {
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
		DocumentTypeDTO documenttype = (DocumentTypeDTO) obj;
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		delete(conn, prepStmntList, documenttype);
	}

	@SuppressWarnings("unchecked")
	protected void delete(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		DocumentTypeDTO documenttype = (DocumentTypeDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryDocumentTypeDelete));
			prepStmnt.setInt(1, documenttype.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}
	
	@Override
	public void executeDeleteList(List<DTOBase> arg0) {
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public void executeUpdate(DTOBase obj) {
		Connection conn = daoConnector.getConnection();
		List<PreparedStatement> prepStmntList = new ArrayList<PreparedStatement>();
		DocumentTypeDTO documenttype = (DocumentTypeDTO) obj;
		documenttype.setBaseDataOnUpdate();
		update(conn, prepStmntList, documenttype);
		result.put(Message.SESSION_MESSAGE, executeIUD(conn, prepStmntList));
	}

	protected void update(Connection conn, List<PreparedStatement> prepStmntList, Object obj) {
		DocumentTypeDTO documenttype = (DocumentTypeDTO) obj;
		PreparedStatement prepStmnt = null;
		try {
			prepStmnt = conn.prepareStatement(getQueryStatement(qryDocumentTypeUpdate));
			prepStmnt.setString(1, documenttype.getName());
			prepStmnt.setString(2, documenttype.getUpdatedBy());
			prepStmnt.setTimestamp(3, documenttype.getUpdatedTimestamp());
			prepStmnt.setInt(4, documenttype.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		prepStmntList.add(prepStmnt);
	}

	public DocumentTypeDTO getDocumentTypeByCode(String code) {
		return (DocumentTypeDTO) getDTO(qryDocumentTypeByCode, code);
	}
	
	
	public DocumentTypeDTO getDocumentTypeByName(String name) {
		return (DocumentTypeDTO) getDTO(qryDocumentTypeByName, name);
	}
	
	public List<DTOBase> getDocumentTypeList() {
		return getDTOList(qryDocumentTypeList);
	}
	
	public List<DTOBase> getDocumentTypeList(String searchValue) {
		List<Object> paramList = new ArrayList<Object>();
		paramList.add("%" + searchValue + "%");
		paramList.add("%" + searchValue + "%");
		return getDTOList(qryDocumentTypeListSearchByCodeName, paramList);
	}
	
	@Override
	public void executeUpdateList(List<DTOBase> arg0) {
		// TODO Auto-generated method stub

	}
	
	@Override
	protected DTOBase rsToObj(ResultSet resultSet) {
		DocumentTypeDTO documenttype = new DocumentTypeDTO();
		documenttype.setId((Integer) getDBVal(resultSet, "id"));
		documenttype.setCode((String) getDBVal(resultSet, "code"));
		documenttype.setName((String) getDBVal(resultSet, "name"));
		documenttype.setAddedBy((String) getDBVal(resultSet, "added_by"));
		documenttype.setAddedTimestamp((Timestamp) getDBVal(resultSet, "added_timestamp"));
		documenttype.setUpdatedBy((String) getDBVal(resultSet, "updated_by"));
		documenttype.setAddedTimestamp((Timestamp) getDBVal(resultSet, "updated_timestamp"));
		documenttype.setDisplayText(documenttype.getName());
		return documenttype;
	}
}
