package com.ezshop.action.documentview;

import java.util.List;

import com.ezshop.dao.DocumentTypeDAO;
import com.ezshop.dao.DocumentViewDAO;
import com.ezshop.dao.OfficeDAO;
import com.ezshop.dto.DocumentTypeDTO;
import com.ezshop.dto.DocumentViewDTO;
import com.ezshop.dto.OfficeDTO;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.DocCurrentlyInOffsUtil;
import com.ezshop.util.DocumentViewUtil;
import com.ezshop.util.StaffUtil;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.util.UserUtil;

public class ListDocumentViewAction extends ActionBase{

	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setTransitionLink(new String[] {"", "U271"}, new String[] {"", "U272", ""}, new String[] {"", "U273", ""}, "U269", "U270");
		if(!sessionInfo.isPreviousLinkUpdate() && !sessionInfo.isPreviousLinkDeleteSubmit()) {
			DTOBase obj = UserUtil.getUserByUserCode(sessionInfo.getCurrentUser().getCode());
			StaffDTO staff = StaffUtil.getStaff(obj);

			setSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST, new DocumentTypeDAO().getDocumentTypeList());
			setSessionAttribute(OfficeDTO.SESSION_OFFICE_LIST, new OfficeDAO().getOfficeList());

			//this list would display the list of current documents in current user
			//List<DTOBase> list = DocCurrentlyInOffsUtil.getDocumentTrackingListByOfficeCode(staff.getOffice().getCode());
			//List<DTOBase> list = new DocumentViewDAO().getDocumentViewList();
			List<DTOBase> list = DocumentViewUtil.getDocumentTrackingViewList();
			setSessionOnPagination(DocumentViewDTO.SESSION_DOCUMENT_VIEW_PAGINATION, DocumentViewDTO.SESSION_DOCUMENT_VIEW, new DocumentViewDTO(), DocumentViewDTO.SESSION_DOCUMENT_VIEW_LIST, list);
		}
	}
}
