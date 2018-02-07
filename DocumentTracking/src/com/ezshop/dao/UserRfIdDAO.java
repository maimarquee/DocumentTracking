package com.ezshop.dao;

import java.sql.ResultSet;
import java.util.List;

import com.ezshop.dto.UserRfIdDTO;
import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;

public class UserRfIdDAO extends DAOBase{

	private static final long serialVersionUID = 1L;
	private String qryUserRfIdList = "USER_RFID_LIST";
	
	
	
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
	public void executeUpdate(DTOBase arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeUpdateList(List<DTOBase> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public List<DTOBase> getUserRfIdList() {
		return getDTOList(qryUserRfIdList);
	}

	@Override
	protected DTOBase rsToObj(ResultSet resultSet) {
		UserRfIdDTO userRfidDto = new UserRfIdDTO();
		userRfidDto.setId((Integer) getDBVal(resultSet, "id"));
		userRfidDto.setRfid((String) getDBVal(resultSet, "rfid"));
		userRfidDto.setCode((String)getDBVal(resultSet, "user_code"));
		userRfidDto.setLastName((String) getDBVal(resultSet, "last_name"));
		userRfidDto.setFirstName((String) getDBVal(resultSet, "first_name"));
		userRfidDto.setMiddleName((String) getDBVal(resultSet, "middle_name"));
		return userRfidDto;
	}

}
