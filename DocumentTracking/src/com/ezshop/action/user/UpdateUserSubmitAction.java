package com.ezshop.action.user;

import java.util.ArrayList;
import java.util.List;

import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.dto.LinkDTO;
import com.mytechnopal.dto.UserDTO;
import com.mytechnopal.dto.UserGroupDTO;
import com.mytechnopal.util.DTOUtil;
import com.mytechnopal.util.StringUtil;
import com.mytechnopal.util.UserUtil;

public class UpdateUserSubmitAction extends ActionBase {
	private static final long serialVersionUID = 1L;
	
	protected void setInput() {
		UserDTO user = (UserDTO) getSessionAttribute(UserDTO.SESSION_USER);
		
		String userName = getRequestString("txtUserName");
		String password = getRequestString("txtPassword");
		int userGroupId = getRequestInt("cboUserGroup");
		boolean isActive = getRequestString("rbStatus").equalsIgnoreCase("Active")?true:false;
				
		user.setUserName(userName);
		user.setPassword(password);
		user.setUserGroup((UserGroupDTO) DTOUtil.getObjById((List<DTOBase>) getSessionAttribute(UserGroupDTO.SESSION_USER_GROUP_LIST), userGroupId));
		user.setActive(isActive);
		
		String[] userLinkArr = request.getParameterValues("chkUserLink");
		List<DTOBase> linkList = new ArrayList<DTOBase>();
		
		if(userLinkArr != null) {
			//add link group list to newUserLinkList 
			for(int i=0; i<userLinkArr.length; i++) {
				LinkDTO currentLink = sessionInfo.getLinkByCode(userLinkArr[i]);
				for(DTOBase linkDTO: sessionInfo.getLinkGroupList(currentLink.getLinkGroup())) {
				    	LinkDTO link = (LinkDTO) linkDTO;
					linkList.add(link);
				}
			}
			
			//get parent menu link list
			List<LinkDTO> parentMenuLinkList = new ArrayList<LinkDTO>();
			for(DTOBase linkDTO: linkList) {
			    	LinkDTO userLink = (LinkDTO) linkDTO;
				for(LinkDTO parentMenuLink: sessionInfo.getParentMainLinkListByLinkGroup(userLink.getLinkGroup())) {
					parentMenuLinkList.add(parentMenuLink);
				}
			}
			
			//add parent menu link to new user link list
			for(LinkDTO parentMenuLink: parentMenuLinkList) {
				boolean isFound = false;
				for(DTOBase linkDTO: linkList) {
				    	LinkDTO newUserLink = (LinkDTO) linkDTO;
					if(parentMenuLink.getId() == newUserLink.getId()) {
						isFound = true;
						break;
					}
				}
				if(!isFound) {
					linkList.add(parentMenuLink); 
					//add link group for parent link not equal to main link
					if(!parentMenuLink.getLinkGroup().endsWith("0")) {
						for(LinkDTO link: sessionInfo.getLinkGroupList(parentMenuLink.getLinkGroup())) {
							if(link.getId()!=parentMenuLink.getId()) {
								linkList.add(link);
							}
						}
					}
				}
			}
		}
		user.setUserLinkList(linkList);
	}
	
	protected void validateInput() {
		UserDTO user = (UserDTO) getSessionAttribute(UserDTO.SESSION_USER);
		UserDTO userOrig = (UserDTO) getSessionAttribute(UserDTO.SESSION_USER + "_ORIG");
		if(StringUtil.isEmpty(user.getUserName())) {
			message.constructMsg(message.MSG_CLASS_EMPTY, "User Name");
		}
		else if(StringUtil.isEmpty(user.getPassword())) {
			message.constructMsg(message.MSG_CLASS_EMPTY, "Password");
		}
		else {
			if(!user.getUserName().equalsIgnoreCase(userOrig.getUserName())) {
				if(UserUtil.getUserByUserName(user.getUserName()) != null) {
					message.constructMsg(message.MSG_CLASS_EXIST, "User Name");
				}
			}
		}
	}

	protected void setSessionVars() {
		setSessionLinkOnSubmit();
	}

}
