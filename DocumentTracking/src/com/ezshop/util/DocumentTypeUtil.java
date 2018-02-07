package com.ezshop.util;

import java.util.List;

import com.ezshop.dto.DocumentTypeDTO;
import com.mytechnopal.DataAndSessionBase;

public class DocumentTypeUtil extends DataAndSessionBase {

	private static final long serialVersionUID = 1L;

	public static String[][] getTableBody(@SuppressWarnings("rawtypes") List list) {
		String[][] result = new String[list.size()][];
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.size(); j++) {
				DocumentTypeDTO documenttype = (DocumentTypeDTO) list.get(j);
				result[j] = documenttype.getTableData();
			}
		}
		return result;
	}
	
	public static String[]  getTableHeader() {
		return new String[] {"Code", "Name", ""};
	}
}
