
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
	AcceptDocumentDTO documenttracking = (AcceptDocumentDTO)session.getAttribute(AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT);

	List<DTOBase> documenttype = (ArrayList)session.getAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST);
	List<DTOBase> office = (ArrayList)session.getAttribute(OfficeDTO.SESSION_OFFICE_LIST);
	//LinkButtonWebControl lbAddTransactionDetails = new LinkButtonWebControl(sessionInfo, "btn btn-default", "fa fa-plus", sessionInfo.getLinkByCode("U209"));
	//System.out.println(documenttracking.getCommentList().size());
%>
<div class="col-sm-12">

	</div>
<%//=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Forward", "Forward", forward, documenttracking.getActiveOffice(), "", "", "") %>
<%//=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-12", "Name", "Name", "Name", documenttracking.getName(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%//=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-12", "Description", "Description", "Description", documenttracking.getDescription(), 90, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%//=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6", "Requesting Person", "Requesting Person", "Requesting Person", documenttracking.getRequesting_person(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%//=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6", "Amount", "Amount", "Amount", StringUtil.getFormattedNum(documenttracking.getAmount(), StringUtil.NUMERIC_STANDARD_FORMAT_NO_COMMA), 9, TextBoxWebControl.DATA_TYPE_DOUBLE, "")%>
<%//=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6", "Barcode", "Barcode", "Barcode", documenttracking.getBarcode(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
<%//=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Document Type", "Document Type", documenttype, documenttracking.getDocument_type(), "", "", "") %>
<%//=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Forward", "Forward", forward, documenttracking.getActiveOffice(), "", "", "") %>
<%//=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-4", false, "Forward", "Forward", DocCurrentlyInOffsDTO.FORWARD_LIST, documenttracking.getForward(), "", "", "") %>
<%//=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Office", "Office", office, documenttracking.getOffice(), "", "", "") %>
<div class="col-lg-12">
		<div class="panel panel-default">
	    	<div class="panel-heading">
	           <b>Document Name & Description</b> 
	        </div>
	        <div class="panel-body">
	        	<tr>
		            <td>Code:</td>
		            <td><b><%=documenttracking.getCode()%></b></td>
        		</tr>
        			</br>
	           	<tr>
		            <td>Name:</td>
		            <td><b><%=documenttracking.getName()%></b></td>
        		</tr>
        			</br>
		        <tr>
		            <td>Description:</td>
			        <td><b><%=documenttracking.getDescription()%></b></td>
		        </tr>
	        </div>
	    </div>
	</div>

<%=new TransitionButtonWebControl().getTransitionButtonWebControl(sessionInfo, "col-sm-12", "btn btn-default", "align='center'") %> 
