package com.ezshop.action.completetracking;

import java.util.List;

import com.ezshop.dao.CompleteTrackingDAO;
import com.ezshop.dao.DocumentTypeDAO;
import com.ezshop.dao.OfficeDAO;
import com.ezshop.dto.CompleteTrackingDTO;
import com.ezshop.dto.DocumentTypeDTO;
import com.ezshop.dto.OfficeDTO;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.StaffUtil;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.util.UserUtil;

public class ListCompleteTrackingAction extends ActionBase{

	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setTransitionLink(new String[] {"", "U263"}, new String[] {"", "U264", ""}, new String[] {"", "U265", ""}, "U261", "U262");
		if(!sessionInfo.isPreviousLinkUpdate() && !sessionInfo.isPreviousLinkDeleteSubmit()) {
			DTOBase obj = UserUtil.getUserByUserCode(sessionInfo.getCurrentUser().getCode());
			StaffDTO staff = StaffUtil.getStaff(obj);

			setSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST, new DocumentTypeDAO().getDocumentTypeList());
			setSessionAttribute(OfficeDTO.SESSION_OFFICE_LIST, new OfficeDAO().getOfficeList());

			//this list would display the list of current documents in current user
			List<DTOBase> list = new CompleteTrackingDAO().getCompleteTrackingByOffsCode(staff.getOffice().getCode());
			setSessionOnPagination(CompleteTrackingDTO.SESSION_COMPLETE_TRACKING_PAGINATION, CompleteTrackingDTO.SESSION_COMPLETE_TRACKING, new CompleteTrackingDTO(), CompleteTrackingDTO.SESSION_COMPLETE_TRACKING_LIST, list);
		}
	}
}
