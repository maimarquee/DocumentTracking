package com.ezshop.action.acceptdocument;

import java.util.List;

import com.ezshop.dao.AcceptDocumentDAO;
import com.ezshop.dao.DocumentTypeDAO;
import com.ezshop.dao.OfficeDAO;
import com.ezshop.dto.AcceptDocumentDTO;
import com.ezshop.dto.DocumentTypeDTO;
import com.ezshop.dto.OfficeDTO;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.StaffUtil;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.util.UserUtil;

public class ListAcceptDocumentAction extends ActionBase{

	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setTransitionLink(new String[] {"", "U252"}, new String[] {"", "U253", ""}, new String[] {"", "U254", ""}, "U250", "U251");
		if(!sessionInfo.isPreviousLinkUpdate() && !sessionInfo.isPreviousLinkDeleteSubmit()) {
			DTOBase obj = UserUtil.getUserByUserCode(sessionInfo.getCurrentUser().getCode());
			StaffDTO staff = StaffUtil.getStaff(obj);

			setSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST, new DocumentTypeDAO().getDocumentTypeList());
			setSessionAttribute(OfficeDTO.SESSION_OFFICE_LIST, new OfficeDAO().getOfficeList());

			//this list would display the list of current documents in current user
			List<DTOBase> list = new AcceptDocumentDAO().getAcceptDocumentByOffsCode(staff.getOffice().getCode());
			setSessionOnPagination(AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT_PAGINATION, AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT, new AcceptDocumentDTO(), AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT_LIST, list);
		}
	}
}
