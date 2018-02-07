<%@ page import="java.util.*" %>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.dto.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>
<%@ page import="com.ezshop.dto.*" %>  

<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	StaffDTO staff = (StaffDTO)session.getAttribute(StaffDTO.SESSION_STAFF);
	//OfficeDTO office = (OfficeDTO)session.getAttribute(OfficeDTO.SESSION_OFFICE_LIST);
	List<DTOBase> cityList = (ArrayList)session.getAttribute(CityDTO.SESSION_CITY_LIST);
	List<DTOBase> religionList = (ArrayList)session.getAttribute(ReligionDTO.SESSION_RELIGION_LIST);
	List<DTOBase> office = (ArrayList)session.getAttribute(OfficeDTO.SESSION_OFFICE_LIST);
%>

<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-2", "Salutation", "PrefixName", UserDTO.PREFIX_NAME_LIST, staff.getPrefixName(), "", "", "")%>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-2 has-warning less-padding", "Last Name", "Last Name", "LastName", staff.getLastName(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-3 has-warning less-padding", "First Name", "First Name", "FirstName", staff.getFirstName(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-2 has-warning less-padding", "Middle Name", "Middle Name", "MiddleName", staff.getMiddleName(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-1 less-padding", "Suffix", "SuffixName", UserDTO.SUFFIX_NAME_LIST, staff.getSuffixName(), "", "", "")%>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-2", "Other Title", "Other Title", "OtherTitle", staff.getOtherTitle(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6 has-warning", "Job Role", "Job Role", "JobRole", staff.getJobRole(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Office", "Office", office, staff.getOffice(), "", "", "") %>

<div class="col-lg-6">
	<div class="panel panel-default">
    	<div class="panel-heading">
            Permanent Address
        </div>
        <div class="panel-body">
           <%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-12 has-warning", "Street", "Street", "StreetPermanent", staff.getStreetPermanent(), 180, TextBoxWebControl.DATA_TYPE_STRING, "onchange='setPresentAddressToPermanentAddress()'") %>
			<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6 has-warning", "Barangay", "Barangay", "BarangayPermanent", staff.getBarangayPermanent(), 45, TextBoxWebControl.DATA_TYPE_STRING, "onchange='setPresentAddressToPermanentAddress()'") %>
			<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6 has-warning", "City", "CityPermanent", cityList, staff.getCityPermanent(), "", "", "onchange='setPresentAddressToPermanentAddress()'")%>
        </div>
    </div>
</div>
<div class="col-lg-6">
    <div class="panel panel-default">
        <div class="panel-heading">
            Present Address
            <%
            if(sessionInfo.isCurrentLinkDataEntry()) {
            %>
            &nbsp;&nbsp;<input type="checkbox" id="chkSameAsPermanent" name="chkSameAsPermanent" onclick="setPresentAddressToPermanentAddressOnCheckboxClick()"> Same as Permanent
			<%
            }
			%>
        </div>
        <div class="panel-body">
           	<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-12 has-warning", "Street", "Street", "StreetPresent", staff.getStreetPresent(), 180, TextBoxWebControl.DATA_TYPE_STRING, "onblur='setEmergencyContactAddress()'") %>
			<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6 has-warning", "Barangay", "Barangay", "BarangayPresent", staff.getBarangayPresent(), 45, TextBoxWebControl.DATA_TYPE_STRING, "onblur='setEmergencyContactAddress()'") %>
			<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6 has-warning", "City", "CityPresent", cityList, staff.getCityPresent(), "", "", "")%>
        </div>
    </div>
</div>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-3 has-warning", "Birth Date", "Birth Date", "BirthDate", DateTimeUtil.getDateTimeToStr(staff.getBirthDate(), "MM/dd/yyyy"), 10, TextBoxWebControl.DATA_TYPE_DATE, "", "maxDate: '-24M', changeMonth: true, changeYear: true") %>
<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-3 has-warning", "Gender", "Gender", new String[] {UserDTO.GENDER_MALE, UserDTO.GENDER_FEMALE}, staff.getGender(), "", "", "")%>
<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-3 has-warning", "Religion", "Religion", religionList, staff.getReligion(), "", "", "")%>
<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-3 has-warning", "Status", "MaritalStatus", new String[] {UserDTO.MARITAL_STATUS_SINGLE, UserDTO.MARITAL_STATUS_MARRIED, UserDTO.MARITAL_STATUS_SEPERATED, UserDTO.MARITAL_STATUS_WIDOW}, staff.getMaritalStatus(), "", "", "")%>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-4", "Cellphone No.", "Cellphone No.", "CpNumber", staff.getCpNumber(), 11, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-4", "Email Address", "Email Address", "EmailAddress", staff.getEmailAddress(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-4", "Program Graduated", "Program Graduated", "ProgramGraduated", staff.getProgramGraduated(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%=new TransitionButtonWebControl().getTransitionButtonWebControl(sessionInfo, "col-sm-12", "btn btn-default", "align='center'") %> 
<%
if(sessionInfo.isCurrentLinkDataEntry()) {
	if(!StringUtil.isEmpty(staff.getStreetPermanent())) {
		if(staff.getStreetPermanent().equalsIgnoreCase(staff.getStreetPresent()) && staff.getBarangayPermanent().equalsIgnoreCase(staff.getBarangayPresent()) && staff.getCityPermanent().getCode().equalsIgnoreCase(staff.getCityPresent().getCode())) {
%>
	<script>
		document.getElementById("chkSameAsPermanent").checked = "checked";
		document.getElementById("txtStreetPresent").disabled = true;
		document.getElementById("txtBarangayPresent").disabled = true;
		document.getElementById("cboCityPresent").disabled = true;
	</script>
<%			
		}
		else {
%>
	<script>
		document.getElementById("chkSameAsPermanent").checked = "";
		document.getElementById("txtStreetPresent").disabled = false;
		document.getElementById("txtBarangayPresent").disabled = false;
		document.getElementById("cboCityPresent").disabled = false;
	</script>
<%			
		}
	}
}
%>

<script>
	function setPresentAddressToPermanentAddressOnCheckboxClick() {
		setPresentAddressToPermanentAddress();
		toggleEnable("txtStreetPresent");
		toggleEnable("txtBarangayPresent");
		toggleEnable("cboCityPresent");
	}
	
	function setPresentAddressToPermanentAddress() {
		if(document.getElementById("chkSameAsPermanent").checked) {
			document.getElementById("txtStreetPresent").value = document.getElementById("txtStreetPermanent").value;
			document.getElementById("txtBarangayPresent").value = document.getElementById("txtBarangayPermanent").value;
			document.getElementById("cboCityPresent").value = document.getElementById("cboCityPermanent").value;
		}
	}
	<%
	if(sessionInfo.isCurrentLinkAdd()) {
	%>
		document.getElementById("cboLevel").focus();
	<%
	}
	%>
</script>	