package com.ezshop.action.guest;

import com.mytechnopal.ActionBase;
import com.mytechnopal.dto.UserDTO;

public class HomeAction extends ActionBase {
    private static final long serialVersionUID = 1L;

    protected void setSessionVars() {
    	sessionInfo.setTransitionLink(new String[] {"G001"}, new String[] {}, new String[] {}, "", "", "");
		setSessionBeforeTrans(UserDTO.SESSION_USER, new UserDTO());
    }
}
