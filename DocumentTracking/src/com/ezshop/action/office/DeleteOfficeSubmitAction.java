package com.ezshop.action.office;
import java.util.List;
import com.ezshop.dao.OfficeDAO;
import com.ezshop.dao.StaffDAO;
import com.ezshop.dto.OfficeDTO;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.pagination.Pagination;
import com.mytechnopal.util.DTOUtil;
import com.mytechnopal.Message;

public class DeleteOfficeSubmitAction extends ActionBase {

	private static final long serialVersionUID = 1L;

	protected void validateInput() {
		Pagination pagination = (Pagination) getSessionAttribute(OfficeDTO.SESSION_OFFICE_PAGINATION);
		String code = getRequestString("txtSelectedRecord");
		DTOBase userObj = DTOUtil.getObjByCode(pagination.getCurrentPageRecordList(), code);
		OfficeDTO office = (OfficeDTO) userObj;
		setSessionBeforeTrans(OfficeDTO.SESSION_OFFICE, office);

		if(sessionInfo.isCurrentLinkDeleteSubmit()){
			List<DTOBase> list = new StaffDAO().getStaffListByOfficeCode(office.getCode());
			if(list.size() > 0){
				message.constructMsg(Message.MSG_CLASS_ACTION_FAIL, "This OFFICE is currently being used in the STAFF.");
			}
		}
	}
	
	protected void setSessionVars() {
		setSessionLinkOnSubmit();
	}
}
