package com.ezshop.util;

import com.ezshop.dao.DocumentTrackingOfficeLogDAO;
import com.ezshop.dao.OfficeDAO;
import com.ezshop.dto.DocumentTrackingOfficeLogDTO;
import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.DTOBase;

public class DocumentTrackingOfficeLogUtil {

	public String getDocumentOfficeHistory(String searchValue) {
		String officeLogHistory = null;
		for(DTOBase documentTrackingOfficeLogObj: new DocumentTrackingOfficeLogDAO().getDocumentTrackingOfficeLogListByCode(searchValue)) {
			DocumentTrackingOfficeLogDTO documentTrackingOfficeLog = (DocumentTrackingOfficeLogDTO)documentTrackingOfficeLogObj;
			OfficeDTO officeName = new OfficeDAO().getOfficeByCode(documentTrackingOfficeLog.getOfficeCode()); //getting office properties
			if(documentTrackingOfficeLog.getStatus().equalsIgnoreCase(documentTrackingOfficeLog.STATUS_COMPLETED)){
				officeLogHistory = "COMPLETED";
			}else if (documentTrackingOfficeLog.getStatus().equalsIgnoreCase(documentTrackingOfficeLog.STATUS_ACCEPTED)){
				officeLogHistory = "A: " + officeName.getName();
			}else if (documentTrackingOfficeLog.getStatus().equalsIgnoreCase(documentTrackingOfficeLog.STATUS_FORWARDED)){
				officeLogHistory = "F: " + officeName.getName();
			}else if (documentTrackingOfficeLog.getStatus().equalsIgnoreCase(documentTrackingOfficeLog.STATUS_CREATED)){
				officeLogHistory = officeName.getName();
			}
		}
		return officeLogHistory;
	}
}
