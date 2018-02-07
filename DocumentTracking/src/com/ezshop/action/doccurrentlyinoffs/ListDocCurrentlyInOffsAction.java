package com.ezshop.action.doccurrentlyinoffs;


import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import com.ezshop.dao.DocCurrentlyInOffsDAO;
import com.ezshop.dao.DocumentTypeDAO;
import com.ezshop.dao.OfficeDAO;
import com.ezshop.dto.DocCurrentlyInOffsDTO;
import com.ezshop.dto.DocumentTypeDTO;
import com.ezshop.dto.OfficeDTO;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.DocCurrentlyInOffsUtil;
import com.ezshop.util.StaffUtil;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.util.UserUtil;

public class ListDocCurrentlyInOffsAction extends ActionBase{

	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setTransitionLink(new String[] {"", "U228"}, new String[] {"", "U229", ""}, new String[] {"", "U230", ""}, "U226", "U227");
		//if(!sessionInfo.isPreviousLinkUpdate() && !sessionInfo.isPreviousLinkDeleteSubmit()) {
			DTOBase obj = UserUtil.getUserByUserCode(sessionInfo.getCurrentUser().getCode());
			StaffDTO staff = StaffUtil.getStaff(obj);

			setSessionAttribute(StaffDTO.SESSION_STAFF_LIST, staff);
			setSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST, new DocumentTypeDAO().getDocumentTypeList());
			List<DTOBase> officeList = new OfficeDAO().getOfficeList();  //all the office list
			List<DTOBase> officeListnew = new ArrayList<DTOBase>();		//office list remove current office
			for(DTOBase Officeobj : officeList) {
				OfficeDTO office = (OfficeDTO) Officeobj;
				if(!staff.getOffice().getCode().equalsIgnoreCase(office.getCode())) {//if NOT == current office, display all list aside the current office
					officeListnew.add(office);
				}
			}
			setSessionAttribute(OfficeDTO.SESSION_OFFICE_LIST, officeListnew);

			//this list would display the list of current documents in current user
			//List<DTOBase> list = new DocCurrentlyInOffsDAO().getDocCurrentlyInOffsByOffsCode(staff.getOffice().getCode());
			List<DTOBase> list = DocCurrentlyInOffsUtil.getDocumentTrackingListByOfficeCode(staff.getOffice().getCode());
			setSessionOnPagination(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS_PAGINATION, DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS, new DocCurrentlyInOffsDTO(), DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS_LIST, list);
		//}
	}
}
