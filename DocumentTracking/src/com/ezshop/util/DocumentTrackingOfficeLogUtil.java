package com.ezshop.util;

import java.util.ArrayList;
import java.util.List;

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
	
	/*
	 * public static List<DTOBase> getMerchandiseTransactionTypeListByType(List<DTOBase> merchandiseTransactionTypeList, String type) {
		List<DTOBase> list = new ArrayList<DTOBase>();
		for(DTOBase obj: merchandiseTransactionTypeList) {
			MerchandiseTransactionTypeDTO mtt = (MerchandiseTransactionTypeDTO) obj;
			if(mtt.getType().equalsIgnoreCase(type)) {
				list.add(mtt);
			}
		}
		return list;
	}
	 */
	
	public static List<DTOBase> getDocumentTrackingOfficeLogList() {
		List<DTOBase> list = new ArrayList<DTOBase>();
		for(DTOBase obj: new DocumentTrackingOfficeLogDAO().getDocumentTrackingOfficeLogList()){
			DocumentTrackingOfficeLogDTO dtol = (DocumentTrackingOfficeLogDTO) obj;
			list.add(dtol);
		}
		return list;
		
	}
}
