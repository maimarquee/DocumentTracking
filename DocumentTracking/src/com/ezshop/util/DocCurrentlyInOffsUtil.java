package com.ezshop.util;

import java.util.ArrayList;
import java.util.List;

import com.ezshop.dao.DocCurrentlyInOffsDAO;
import com.ezshop.dao.DocumentTrackingLogDAO;
import com.ezshop.dao.StaffDAO;
import com.ezshop.dto.DocCurrentlyInOffsDTO;
import com.ezshop.dto.DocumentTrackingLogDTO;
import com.ezshop.dto.StaffDTO;
import com.mytechnopal.DTOBase;
import com.mytechnopal.DataAndSessionBase;

public class DocCurrentlyInOffsUtil extends DataAndSessionBase {

	private static final long serialVersionUID = 1L;
	
	public static List<DTOBase> getDocumentTrackingListByOfficeCode(String officeCode) {
		List<DTOBase> list = new ArrayList<DTOBase>();
		for(DTOBase documentObj: new DocCurrentlyInOffsDAO().getDocCurrentlyInOffsByOffsCode(officeCode)) {
			DocCurrentlyInOffsDTO document = (DocCurrentlyInOffsDTO) documentObj;
				document.setDocumentLogList(new DocumentTrackingLogDAO().getDocumentTrackingLogListByDocumentCode(document.getCode()));
	/*			for(DTOBase logObj: document.getDocumentLogList()){
					DocumentTrackingLogDTO dtl = (DocumentTrackingLogDTO) logObj;
					dtl.setStaff(StaffUtil.getStaff(dtl.getStaff()));
				}*/
				list.add(document);
		}
		return list;
	}
	
	public static List<DTOBase> getDocumentTrackingListBySearchText(String searchValue) {
		List<DTOBase> list = new ArrayList<DTOBase>();
		for(DTOBase documentObj: new DocCurrentlyInOffsDAO().getDocCurrentlyInOffsList(searchValue)) {
			DocCurrentlyInOffsDTO document = (DocCurrentlyInOffsDTO) documentObj;
				document.setDocumentLogList(new DocumentTrackingLogDAO().getDocumentTrackingLogListByDocumentCode(document.getCode()));
	/*			for(DTOBase logObj: document.getDocumentLogList()){
					DocumentTrackingLogDTO dtl = (DocumentTrackingLogDTO) logObj;
					dtl.setStaff(StaffUtil.getStaff(dtl.getStaff()));
				}*/
				list.add(document);
		}
		return list;
	}
	

	public static String[][] getTableBody(@SuppressWarnings("rawtypes") List list) {
		String[][] result = new String[list.size()][];
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.size(); j++) {
				DocCurrentlyInOffsDTO dcio = (DocCurrentlyInOffsDTO) list.get(j);
				result[j] = dcio.getTableData();
			}
		}
		return result;
	}
	
	public static String[]  getTableHeader() {
		return new String[] {"Code", "Document Name", "Description", ""};
	}
}
