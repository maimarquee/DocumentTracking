package com.ezshop.dao;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ezshop.dto.FaceLogDTO;
import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;

public class FaceLogDAO extends DAOBase{

	private static final long serialVersionUID = 1L;
	private String qryFaceLogList = "FACE_LOG_LIST";
	

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
	public List<DTOBase> getFaceLogList() {
		return getDTOList(qryFaceLogList);
	}

	@Override
	protected DTOBase rsToObj(ResultSet resultSet) {
		FaceLogDTO faceLogDto = new FaceLogDTO();
		faceLogDto.setId((Integer)getDBVal(resultSet, "id"));
		faceLogDto.setCode((String) getDBVal(resultSet, "code"));
		faceLogDto.setUserCode((String)getDBVal(resultSet, "user_code"));
		faceLogDto.setTimeLog((Timestamp) getDBVal(resultSet, "time_log"));
		faceLogDto.setIsIn((Integer)getDBVal(resultSet, "is_in"));
		return faceLogDto;
	}
	
/*	public static void main(String[] a) {
		FaceLogDAO faceLogDao = new FaceLogDAO();
		
		for(DTOBase faceLogDTOObj: faceLogDao.getFaceLogList()){
			FaceLogDTO facelogDto = (FaceLogDTO) faceLogDTOObj;
			System.out.println(facelogDto.getUserCode() + facelogDto.getIsIn());
		} 
	}*/
}
