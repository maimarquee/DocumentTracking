package com.ezshop.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	
	//WARN BY THIS, THIS MIGHT NOT BE IN USE BY NOW
/*	public static String getDocumentTrackingOfficeLogStatusByCode(List<DTOBase> documentTrackingOfficeLogList, String documentTrackingCode) {
		String status = "";
		for(DTOBase dtolscObj: documentTrackingOfficeLogList) {
			DocumentTrackingOfficeLogDTO dtol = (DocumentTrackingOfficeLogDTO) dtolscObj;
			if(dtol.getDocumentTrackingOfficeLog().getCode().equalsIgnoreCase(documentTrackingCode)) {
				status = dtol.getDocumentTrackingOfficeLog().getStatus();
			}
		}
		return status;
	}*/

	//THIS SHOULD BE THE ONE IM GONNA BE USING//but it not trying to filter the list by code so it should have to filter the code first
	public static List<DTOBase> getDocumentTrackingOfficeLogListFilterByCode(List<DTOBase> documentTrackingOfficeLogList, String code) {
		List<DTOBase> list = new ArrayList<DTOBase>();
		for(DTOBase obj: documentTrackingOfficeLogList){
			DocumentTrackingOfficeLogDTO dtol = (DocumentTrackingOfficeLogDTO) obj;
			if(dtol.getCode().equalsIgnoreCase(code)){
				list.add(dtol);
			}
		}

		//i guess i dont need this anymore;
		/*Collections.sort(list, new Comparator<DTOBase>() {//this should sort the list in ascending or descending order
			@Override
			public int compare(DTOBase arg1, DTOBase arg0) {//but i do not know why it is not getting the properties of officelog
				return Integer.valueOf(arg0.getId()).compareTo(arg1.getId());
			}
		});*/
		return list;
	}
}
