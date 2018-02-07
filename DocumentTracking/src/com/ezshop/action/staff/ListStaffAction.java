package com.ezshop.action.staff;


import com.mytechnopal.ActionBase;
import com.mytechnopal.dao.CityDAO;
import com.mytechnopal.dao.ReligionDAO;
import com.mytechnopal.dao.UserDAO;
import com.mytechnopal.dto.CityDTO;
import com.mytechnopal.dto.ReligionDTO;
import com.ezshop.dao.OfficeDAO;
import com.ezshop.dto.OfficeDTO;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.SettingsUtil;

public class ListStaffAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	protected void setSessionVars() {
		sessionInfo.setTransitionLink(new String[] {"U021", "U026"}, new String[] {"U022", "U027", "U029"}, new String[] {"U023", "U028", "U030"}, "U024", "U025");
		if(!sessionInfo.isPreviousLinkUpdate() && !sessionInfo.isPreviousLinkDeleteSubmit()) {
			setSessionAttribute(CityDTO.SESSION_CITY_LIST, new CityDAO().getCityList());
			setSessionAttribute(OfficeDTO.SESSION_OFFICE_LIST, new OfficeDAO().getOfficeList());
			setSessionAttribute(ReligionDTO.SESSION_RELIGION_LIST, new ReligionDAO().getReligionList());
			setSessionOnPagination(StaffDTO.SESSION_STAFF_PAGINATION, StaffDTO.SESSION_STAFF, new StaffDTO(), StaffDTO.SESSION_STAFF_LIST, new UserDAO().getUserListByUserGroupCode(SettingsUtil.USER_GROUP_STAFF_CODE));
		}
	}
}