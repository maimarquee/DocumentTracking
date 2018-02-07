package com.ezshop.action.staff;

import java.util.List;

import com.ezshop.dao.OfficeDAO;
import com.ezshop.dto.OfficeDTO;
import com.ezshop.dto.StaffDTO;
import com.ezshop.util.SettingsUtil;
import com.mytechnopal.ActionBase;
import com.mytechnopal.DTOBase;
import com.mytechnopal.dao.CityDAO;
import com.mytechnopal.dao.ReligionDAO;
import com.mytechnopal.dto.CityDTO;
import com.mytechnopal.dto.ReligionDTO;
import com.mytechnopal.util.DTOUtil;

public class AddStaffAction extends ActionBase {
	private static final long serialVersionUID = 1L;

	@Override
	protected void setSessionVars() {
		sessionInfo.setTransitionLink(new String[] {"U021", "U026"}, new String[] {"U022", "U027", "U029"}, new String[] {"U023", "U028", "U030"}, "U024", "U025");
		//previous link not equal to submit action
		if(!sessionInfo.isPreviousLinkAddSubmit()&& !sessionInfo.getPreviousLink().getCode().equalsIgnoreCase("U180") && !sessionInfo.getPreviousLink().getCode().equalsIgnoreCase("U182")) {
			StaffDTO staff = new StaffDTO();
			List<DTOBase> religionList = new ReligionDAO().getReligionList();
			List<DTOBase> cityList = new CityDAO().getCityList();
			List<DTOBase> office = new OfficeDAO().getOfficeList();

			staff.setOffice((OfficeDTO) office.get(0));
			staff.setCityPermanent((CityDTO) DTOUtil.getObjByCode(cityList, SettingsUtil.DEFAULT_CITY));
			staff.setCityPresent((CityDTO) DTOUtil.getObjByCode(cityList, SettingsUtil.DEFAULT_CITY));
			staff.setReligion((ReligionDTO) DTOUtil.getObjByCode(religionList, SettingsUtil.DEFAULT_RELIGION));

			setSessionAttribute(CityDTO.SESSION_CITY_LIST, cityList);
			setSessionAttribute(ReligionDTO.SESSION_RELIGION_LIST, religionList);
			setSessionAttribute(OfficeDTO.SESSION_OFFICE_LIST, office);
			setSessionBeforeTrans(StaffDTO.SESSION_STAFF, staff);
		}
	}
}
