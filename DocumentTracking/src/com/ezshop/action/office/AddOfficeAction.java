package com.ezshop.action.office;

import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.ActionBase;

public class AddOfficeAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setTransitionLink(new String[] {"U180", "U185"}, new String[] {"U181", "U186", "U188"}, new String[] {"U182", "U187", "U189"}, "U183", "U184");
		OfficeDTO office = new OfficeDTO();
		setSessionBeforeTrans(OfficeDTO.SESSION_OFFICE, office);
	}
}
