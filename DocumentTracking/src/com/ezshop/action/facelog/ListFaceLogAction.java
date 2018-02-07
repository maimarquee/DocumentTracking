package com.ezshop.action.facelog;

import com.mytechnopal.ActionBase;

public class ListFaceLogAction extends ActionBase{

	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setTransitionLink(new String[] {"", ""}, new String[] {"", "", ""}, new String[] {"", "", ""}, "", "");
	}
}
