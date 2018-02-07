package com.ezshop.action.acceptdocument;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import com.ezshop.dao.AcceptDocumentDAO;
import com.ezshop.dto.AcceptDocumentDTO;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.StaffUtil;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DAOBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.util.UserUtil;

public class UpdateAcceptDocumentConfirmAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void validateInput() {
		validateTrans();
	}

	protected void setSessionVars(){
		setSessionLinkOnConfirm();
		//this will get the user and would generate the list by offs code
		DTOBase obj = UserUtil.getUserByUserCode(sessionInfo.getCurrentUser().getCode());
		StaffDTO staff = StaffUtil.getStaff(obj);
		List<DTOBase> list = new AcceptDocumentDAO().getAcceptDocumentByOffsCode(staff.getOffice().getCode());
		//***
		if(message.isMessageTypeSuccess()) {
			removeObjByCode(AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT_PAGINATION, AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT_LIST, AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT);
			sessionInfo.setCurrentLink(sessionInfo.getListLink());
			//setSessionOnPagination(AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT_PAGINATION, list);
		}
	}
	
	protected void executeLogic() {
		execute(AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT, new AcceptDocumentDAO(), DAOBase.DAO_ACTION_UPDATE);
	}
}
