<%@page import="com.ezshop.dao.DocumentTypeDAO"%>
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
	DocumentTypeDTO documentTypeName = new DocumentTypeDAO().getDocumentTypeByCode(documenttracking.getDocument_type().getCode());																															//add document type
	LinkButtonWebControl lbAddDocumentType = new LinkButtonWebControl(sessionInfo, "btn", "fa fa-plus", sessionInfo.getLinkByCode("U169"));
%>

<div class="col-lg-12">
	<div class="panel panel-default">
		<div class="panel-heading">
		   <b>Document Details</b> 
		</div>
		<div class="col-lg-12" id="div-id-name">
			<div class="panel-body">
				<div class="col-sm-12">
					<%-- <center><img class="img-responsive" src="common/barcode/<%=docCurrentlyInOffs.getCode() %>.jpg"></center>
				 --%></div>
				<div class="col-sm-12">
					<center><h1><b><%=documenttracking.getCode() %></b></h1> </center>
					<center>Document Code</center></br>
				</div>
				<div class="col-sm-12">
					Document Name: <b><%=documenttracking.getName() %></b>
				</div>
				<div class="col-sm-12">
					Document Description: <b><%=documenttracking.getDescription() %></b>
				</div>
				<div class="col-sm-6">
					Document Type: <b><%=documentTypeName.getName() %></b>
				</div>
				<div class="col-sm-6">
					Amount: <b><%=documenttracking.getAmount() %></b>
				</div>
				<div class="col-sm-6">
					Requesting Person: <b><%=documenttracking.getRequesting_person() %></b>	
				</div>
			</div>
		</div>
	</div>
</div>
<div class="col-sm-12">
 <h3>
<center><button type="button" class="btn btn-default" onclick="javascript:printlayer('div-id-name')">Print Tracking</button></center>
</h3>
</div>
<%=new TransitionButtonWebControl().getTransitionButtonWebControl(sessionInfo, "col-sm-12", "btn btn-default", "align='center'") %> 
<script type = "text/javascript">
function printlayer(layer)
{
	var generator = window.open(",'name,'");
	var layetext = document.getElementById(layer);
	generator.document.write(layetext.innerHTML.replace("Print Me"));
	generator.document.close();
	generator.print();
	generator.close();
}
</script>

