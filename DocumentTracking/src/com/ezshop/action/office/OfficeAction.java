package com.ezshop.action.office;

import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.Message;
import com.mytechnopal.util.StringUtil;

public class OfficeAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void setInput() {
		OfficeDTO office = (OfficeDTO) getSessionAttribute(OfficeDTO.SESSION_OFFICE);
		String name = getRequestString("txtName");
		office.setName(name);
	}

	/*protected void validateInput() {
		if(!sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U180")) {
			MerchandiseDTO merchandise = (MerchandiseDTO) getSessionAttribute(MerchandiseDTO.SESSION_MERCHANDISE);
			if(StringUtil.isEmpty(merchandise.getName())) {
				message.constructMsg(Message.MSG_CLASS_EMPTY, "Name");
			}
			else{
				if(sessionInfo.isPreviousLinkAdd()) {
					MerchandiseDTO merchandiseExist = new MerchandiseDAO().getMerchandiseByName(merchandise.getName());
					if(merchandiseExist!=null){
						message.constructMsg(Message.MSG_CLASS_EXIST, "Name");
					}
				}
			}
		}
	}*/
}
