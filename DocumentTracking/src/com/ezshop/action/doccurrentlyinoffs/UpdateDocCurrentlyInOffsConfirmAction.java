package com.ezshop.action.doccurrentlyinoffs;


import com.ezshop.dao.DocCurrentlyInOffsDAO;
import com.ezshop.dto.DocCurrentlyInOffsDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DAOBase;

public class UpdateDocCurrentlyInOffsConfirmAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void validateInput() {
		validateTrans();
	}
	
	protected void setSessionVars(){
		setSessionLinkOnConfirm();
		if(message.isMessageTypeSuccess()) {
			removeObjByCode(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS_PAGINATION, DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS_LIST, DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS);
			sessionInfo.setCurrentLink(sessionInfo.getListLink());
			
		}
	}
	
	protected void executeLogic() {
		execute(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS, new DocCurrentlyInOffsDAO(), DAOBase.DAO_ACTION_UPDATE);
	}
}
