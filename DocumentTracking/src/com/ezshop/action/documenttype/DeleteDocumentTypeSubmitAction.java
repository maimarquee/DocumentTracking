package com.ezshop.action.documenttype;
import java.util.List;

import com.ezshop.dao.DocumentTrackingDAO;
import com.ezshop.dto.DocumentTypeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.Message;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.util.DTOUtil;
public class DeleteDocumentTypeSubmitAction extends ActionBase{

	private static final long serialVersionUID = 1L;

	protected void validateInput() {
		Pagination pagination = (Pagination) getSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_PAGINATION);
		String code = getRequestString("txtSelectedRecord");
		DTOBase userObj = DTOUtil.getObjByCode(pagination.getCurrentPageRecordList(), code);
		DocumentTypeDTO documenttype = (DocumentTypeDTO) userObj;
		setSessionBeforeTrans(DocumentTypeDTO.SESSION_DOCUMENT_TYPE, documenttype);
	
		if(sessionInfo.isCurrentLinkDeleteSubmit()) {
			List<DTOBase> list = new DocumentTrackingDAO().getDocumentTrackingByDocumentType(documenttype.getCode());
			if(list.size() > 0){
				message.constructMsg(Message.MSG_CLASS_ACTION_FAIL, "This DOCUMENT TYPE is currently being used in one of the Documents.");
			}
		}
	}
	
	protected void setSessionVars() {
		setSessionLinkOnSubmit();
	}
}
