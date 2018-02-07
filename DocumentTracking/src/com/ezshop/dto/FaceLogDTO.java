package com.ezshop.dto;

import java.sql.Timestamp;

import com.mytechnopal.DTOBase;
import com.mytechnopal.util.DateTimeUtil;

public class FaceLogDTO extends DTOBase{

	private static final long serialVersionUID = 1L;
	public static final String SESSION_FACE_LOG = "SESSION_FACE_LOG";
	public static final String SESSION_FACE_LOG_LIST = "SESSION_FACE_LOG_LIST";
	public static final String SESSION_FACE_LOG_PAGINATION = "SESSION_FACE_LOG_PAGINATION";
	

	private String userCode;
	private Timestamp timeLog;
	private Integer isIn;
	
	public FaceLogDTO() {
		super();
		userCode = "";
		timeLog =  DateTimeUtil.getCurrentTimestamp();
		isIn = 0;
	}

	public FaceLogDTO getFaceLogDTO() {
		FaceLogDTO faceLogDto =  new FaceLogDTO();
		faceLogDto.setId(super.getId());
		faceLogDto.setCode(super.getCode());
		faceLogDto.setUserCode(userCode);
		faceLogDto.setTimeLog(timeLog);
		faceLogDto.setIsIn(isIn);
		return faceLogDto;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Timestamp getTimeLog() {
		return timeLog;
	}

	public void setTimeLog(Timestamp timeLog) {
		this.timeLog = timeLog;
	}

	public Integer getIsIn() {
		return isIn;
	}

	public void setIsIn(Integer isIn) {
		this.isIn = isIn;
	}
}
