package com.ezshop.util;

import java.util.ArrayList;
import java.util.List;

import com.ezshop.dao.DocCurrentlyInOffsDAO;
import com.ezshop.dao.DocumentTrackingLogDAO;
import com.ezshop.dao.DocumentTrackingOfficeLogDAO;
import com.ezshop.dao.DocumentViewDAO;
import com.ezshop.dao.OfficeDAO;
import com.ezshop.dto.DocCurrentlyInOffsDTO;
import com.ezshop.dto.DocumentTrackingOfficeLogDTO;
import com.ezshop.dto.DocumentViewDTO;
import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.DTOBase;
import com.mytechnopal.DataAndSessionBase;

public class DocumentViewUtil extends DataAndSessionBase {

	private static final long serialVersionUID = 1L;
	
	public static List<DTOBase> getDocumentTrackingViewList() {
		List<DTOBase> list = new ArrayList<DTOBase>();
		for(DTOBase documentObj: new DocumentViewDAO().getDocumentViewList()) {
			DocumentViewDTO document = (DocumentViewDTO) documentObj;
				document.setDocumentOfficeLogList(new DocumentTrackingOfficeLogDAO().getDocumentTrackingOfficeLogListByDocumentCode(document.getCode()));
				list.add(document);
		}
		return list;
	}
	
	public static List<DTOBase> getDocumentTrackingViewListBySearchText(String searchValue) {
		List<DTOBase> list = new ArrayList<DTOBase>();
		for(DTOBase documentObj: new DocumentViewDAO().getDocumentviewList(searchValue)) {
			DocumentViewDTO document = (DocumentViewDTO) documentObj;
				document.setDocumentOfficeLogList(new DocumentTrackingOfficeLogDAO().getDocumentTrackingOfficeLogListByDocumentCode(document.getCode()));
				list.add(document);
		}
		return list;
	}
	
	//not un use yet
	public static String getIndividualDocumentStatus(List<DTOBase> documentTrackingOfficeLogList, String code){
		String status = "";
		List<DTOBase> documentTrackingOfficeListNew = new ArrayList<DTOBase>();
		for(DTOBase documentTrackingOfficeListObj: documentTrackingOfficeLogList) {
			DocumentTrackingOfficeLogDTO dtol = (DocumentTrackingOfficeLogDTO) documentTrackingOfficeListObj;
			if(dtol.getCode().equalsIgnoreCase(code)){//this is wrong
				//dtol.setDocumentStatusList();//how im gonna filter the list by code.
				documentTrackingOfficeListNew.add(dtol);
			}
		}
		int i = documentTrackingOfficeListNew.size();
		DocumentTrackingOfficeLogDTO ndtol = (DocumentTrackingOfficeLogDTO) documentTrackingOfficeListNew.get(0);
		status = code;
		return status;
	}
	
	//working but it is not handling in list id does by individually searching the database SLOW METHOD
	public static String getnewDocumentOfficeLogList(String code) {
		List<DTOBase> documentTrackingOfficeListNew = new ArrayList<DTOBase>();
		for(DTOBase documentTrackingOfficeListObj: new DocumentTrackingOfficeLogDAO().getDocumentTrackingOfficeLogListByDocumentCode(code)) {
			DocumentTrackingOfficeLogDTO dtol = (DocumentTrackingOfficeLogDTO) documentTrackingOfficeListObj;
			documentTrackingOfficeListNew.add(dtol);
		}
		DocumentTrackingOfficeLogDTO ndtol = (DocumentTrackingOfficeLogDTO) documentTrackingOfficeListNew.get(0);
		OfficeDTO office = new OfficeDAO().getOfficeByCode(ndtol.getOfficeCode());
		String returnValue = ndtol.getStatus() + " @ " + office.getName();
		return returnValue;
	}

	public static String[][] getTableBody(@SuppressWarnings("rawtypes") List list) {
		List<DTOBase> documentTrackingOfficeLogList = new DocumentTrackingOfficeLogDAO().getDocumentTrackingOfficeLogList();
		
		String[][] result = new String[list.size()][];
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.size(); j++) {
				DocumentViewDTO documentView = (DocumentViewDTO) list.get(j);
				result[j] = documentView.getTableData(documentTrackingOfficeLogList);
			}
		}
		return result;
	}
	
	public static String[]  getTableHeader() {
		return new String[] {"Code", "Document Name", "Description", "Status", ""};
	}
}
