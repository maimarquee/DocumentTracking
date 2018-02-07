package com.ezshop.util;

import java.util.ArrayList;
import java.util.List;

import com.ezshop.dao.DocCurrentlyInOffsDAO;
import com.ezshop.dao.DocumentTrackingLogDAO;
import com.ezshop.dao.DocumentTrackingOfficeLogDAO;
import com.ezshop.dao.DocumentViewDAO;
import com.ezshop.dto.DocCurrentlyInOffsDTO;
import com.ezshop.dto.DocumentTrackingOfficeLogDTO;
import com.ezshop.dto.DocumentViewDTO;
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

	public static String[][] getTableBody(@SuppressWarnings("rawtypes") List list) {
		String[][] result = new String[list.size()][];
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.size(); j++) {
				DocumentViewDTO ct = (DocumentViewDTO) list.get(j);
				result[j] = ct.getTableData();
			}
		}
		return result;
	}
	
	public static String[]  getTableHeader() {
		return new String[] {"Code", "Document Name", "Description", "Status", ""};
	}
	
	
}
