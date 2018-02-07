<%@ page import="java.util.*" %>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.dto.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>
<%@ page import="com.ezshop.dto.*" %>  

	<!-- StaffDTO staff = (StaffDTO)session.getAttribute(StaffDTO.SESSION_STAFF);
	//OfficeDTO office = (OfficeDTO)session.getAttribute(OfficeDTO.SESSION_OFFICE_LIST);
	List<DTOBase> cityList = (ArrayList)session.getAttribute(CityDTO.SESSION_CITY_LIST);
	List<DTOBase> religionList = (ArrayList)session.getAttribute(ReligionDTO.SESSION_RELIGION_LIST);
	List<DTOBase> office = (ArrayList)session.getAttribute(OfficeDTO.SESSION_OFFICE_LIST); -->

<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	DocumentTrackingDTO documenttracking = (DocumentTrackingDTO)session.getAttribute(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING);
	List<DTOBase> documenttype = (ArrayList)session.getAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST);
																																//add document type
	LinkButtonWebControl lbAddDocumentType = new LinkButtonWebControl(sessionInfo, "btn", "fa fa-plus", sessionInfo.getLinkByCode("U169"));
%>
<div class="col-sm-12 nopadding">
<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-11", false, "Document Type", "Document Type", documenttype, documenttracking.getDocument_type(), "", "", "") %>
<div class="col-sm-1 nopadding"><%=lbAddDocumentType.getLinkButtonWebControl()%> </div>
</div>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-12", "Name", "Name", "Name", documenttracking.getName(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-12", "Description", "Description", "Description", documenttracking.getDescription(), 300, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6", "Requesting Person", "Requesting Person", "Requesting Person", documenttracking.getRequesting_person(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6", "Amount", "Amount", "Amount", StringUtil.getFormattedNum(documenttracking.getAmount(), StringUtil.NUMERIC_STANDARD_FORMAT_NO_COMMA), 9, TextBoxWebControl.DATA_TYPE_DOUBLE, "")%>
<%=new TransitionButtonWebControl().getTransitionButtonWebControl(sessionInfo, "col-sm-12", "btn btn-default", "align='center'") %> 
