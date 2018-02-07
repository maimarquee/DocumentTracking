package com.ezshop.action.doccurrentlyinoffs;

import com.ezshop.dao.DocumentTrackingLogDAO;
import com.ezshop.dto.DocCurrentlyInOffsDTO;
import com.ezshop.dto.DocumentTrackingLogDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DAOBase;
import com.mytechnopal.Message;
import com.mytechnopal.util.StringUtil;

public class AddDocumentTrackingLogCommentSubmitAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setCurrentLink(sessionInfo.getPreviousLink());
	}
	
	protected void executeLogic() {
		String comment = getRequestString("txtComment", true);
		if(StringUtil.isEmpty(comment)) {
			message.constructMsg(Message.MSG_CLASS_EMPTY, "Comment");
		}
		else {
			DocCurrentlyInOffsDTO dcio = (DocCurrentlyInOffsDTO) getSessionAttribute(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS);
			DocumentTrackingLogDTO documentTrackingLog = new DocumentTrackingLogDTO();
			documentTrackingLog.setCode(dcio.getCode() + StringUtil.getUniqueId(2, 2));
			documentTrackingLog.setDocumentTrackingCode(dcio.getCode());
			documentTrackingLog.getStaff().setCode(sessionInfo.getCurrentUser().getCode()); 
			documentTrackingLog.setComment(comment);
			documentTrackingLog.setStatus(DocumentTrackingLogDTO.STATUS_COMMENTED);
			
			//execute(documentTrackingLog, new DocumentTrackingLogDAO(), DAOBase.DAO_ACTION_ADD);
			
			//if(message.isMessageTypeSuccess()) {
			//System.out.println("comment code"+ dcio.getCode());
			//if(dcio.getCode() != null){
				dcio.getDocumentLogList().add(documentTrackingLog);
			//}
		}
	}
}
