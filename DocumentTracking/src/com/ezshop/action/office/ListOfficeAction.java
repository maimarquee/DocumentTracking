package com.ezshop.action.office;

import com.ezshop.dao.OfficeDAO;
import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.ActionBase;

public class ListOfficeAction extends ActionBase {

	private static final long serialVersionUID = 1L;
	
	protected void setSessionVars() {
		sessionInfo.setTransitionLink(new String[] {"U180", "U185"}, new String[] {"U181", "U186", "U188"}, new String[] {"U182", "U187", "U189"}, "U183", "U184");
		if(!sessionInfo.isPreviousLinkUpdate() && !sessionInfo.isPreviousLinkDeleteSubmit()) {
			setSessionOnPagination(OfficeDTO.SESSION_OFFICE_PAGINATION, OfficeDTO.SESSION_OFFICE, new OfficeDTO(), OfficeDTO.SESSION_OFFICE_LIST, new OfficeDAO().getOfficeList());
		}
	}
}
