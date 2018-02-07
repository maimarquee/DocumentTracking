package com.ezshop.action.documenttype;

import com.ezshop.dao.DocumentTypeDAO;
import com.ezshop.dto.DocumentTypeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.Message;
import com.mytechnopal.util.StringUtil;

public class DocumentTypeAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void setInput() {
		DocumentTypeDTO documenttype =(DocumentTypeDTO) getSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE);
		String name = getRequestString("txtName");
		documenttype.setName(name);
	}

	protected void validateInput() {
		DocumentTypeDTO documentType = (DocumentTypeDTO) getSessionAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE);
		if(StringUtil.isEmpty(documentType.getName())) {
			message.constructMsg(Message.MSG_CLASS_EMPTY, "Name");
		}
		else {
			DocumentTypeDTO documentTypeExist = new DocumentTypeDAO().getDocumentTypeByName(documentType.getName());
			if(documentTypeExist != null) {
				message.constructMsg(Message.MSG_CLASS_EXIST, "Name");	
			}
		}
	}
}
