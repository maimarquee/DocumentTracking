<%@page import="com.mytechnopal.dao.UserDAO"%>
<%@page import="com.ezshop.util.StaffUtil"%>
<%@page import="com.ezshop.dao.DocumentTypeDAO"%>
<%@ page import="java.util.*" %>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.dto.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>
<%@ page import="com.ezshop.dto.*" %>  

<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	DocCurrentlyInOffsDTO docCurrentlyInOffs = (DocCurrentlyInOffsDTO)session.getAttribute(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS);
	List<DTOBase> documenttype = (ArrayList)session.getAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST);
	List<DTOBase> office = (ArrayList)session.getAttribute(OfficeDTO.SESSION_OFFICE_LIST);
	DocumentTypeDTO documentTypeName = new DocumentTypeDAO().getDocumentTypeByCode(docCurrentlyInOffs.getDocument_type().getCode());
	//LinkButtonWebControl lbAddTransactionDetails = new LinkButtonWebControl(sessionInfo, "btn btn-default", "fa fa-plus", sessionInfo.getLinkByCode("U209"));
	//System.out.println(documenttracking.getCommentList().size());
%>

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
					<center><h1><b><%=docCurrentlyInOffs.getCode() %></b></h1> </center>
					<center>Document Code</center></br>
				</div>
				<div class="col-sm-12">
					Document Name: <b><%=docCurrentlyInOffs.getName() %></b>
				</div>
				<div class="col-sm-12">
					Document Description: <b><%=docCurrentlyInOffs.getDescription() %></b>
				</div>
				<div class="col-sm-6">
					Document Type: <b><%=documentTypeName.getName() %></b>
				</div>
				<div class="col-sm-6">
					Amount: <b><%=docCurrentlyInOffs.getAmount() %></b>
				</div>
				<div class="col-sm-6">
					Requesting Person: <b><%=docCurrentlyInOffs.getRequesting_person() %></b>	
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
<!-- Comment start -->
<div class="col-sm-12">
	<div class="box box-primary direct-chat direct-chat-success">
		<div class="box-header with-border">
			<h3 class="box-title">Comments made in this Document</h3>
		</div>
		<div class="box-body">
			<div class="direct-chat-messages">
				<%
				for(DTOBase documentTrackingLogObj: docCurrentlyInOffs.getDocumentLogListByStatus(DocumentTrackingLogDTO.STATUS_COMMENTED)) { //get the status commented
					DocumentTrackingLogDTO documentTrackingLog = (DocumentTrackingLogDTO)documentTrackingLogObj;
					UserDTO user = new UserDAO().getUserByCode(documentTrackingLog.getStaff().getCode());
					if(documentTrackingLog.getAddedBy().equalsIgnoreCase(sessionInfo.getCurrentUser().getCode())) {
				%>
					<div class="direct-chat-msg right">
						<div class="direct-chat-info clearfix">
							<span class="direct-chat-name pull-right">ME</span>
							<span class="direct-chat-timestamp pull-left"><%=DateTimeUtil.getDateTimeToStr(documentTrackingLog.getAddedTimestamp(), "dd MMM YYYY hh:mm aa") %></span>
						</div><!-- /.direct-chat-info -->
						<%-- <img class="direct-chat-img" src="<%=SettingsUtil.USER_PICT_FILE%>/<%=documentLog.getStaff().getAvatar()%>" alt="message user image"> --%>
						<div class="direct-chat-text">
							<%=documentTrackingLog.getComment()%>
						</div>	
					</div>
				<%		
					}
					else {
				%>
					<div class="direct-chat-msg">
						<div class="direct-chat-info clearfix">
							<span class="direct-chat-name pull-left"><%=user.getName(true)%></span>
							<span class="direct-chat-timestamp pull-right"><%=DateTimeUtil.getDateTimeToStr(documentTrackingLog.getAddedTimestamp(), "dd MMM YYYY hh:mm aa") %></span>
						</div><!-- /.direct-chat-info -->
						<%-- <img class="direct-chat-img" src="<%=SettingsUtil.USER_PICT_FILE%>/<%=documentLog.getStaff().getAvatar()%>" alt="message user image"> --%>
						<div class="direct-chat-text">
							<%=documentTrackingLog.getComment()%>
						</div>	
					</div>
				<%
					}
				}
				%>	
			</div>
		</div>
		<div class="box-footer">
			<div class="input-group">
				<input id="txtComment" name="txtComment" class="form-control" placeholder="Type comment to this document..." />
				<div class="input-group-btn">
					<button class="btn btn-success" onclick="openLink('U275')"><i class="fa fa-plus"></i></button>
				</div>
			</div>
		</div>	
	</div>
</div>	
<!-- comment end -->
<!-- start of content --><!-- start of content --><!-- start of content -->
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
			<b>Forward Document</b> 
			</div>
			<div class="panel-body">
				<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Forward?", "Forward", DocCurrentlyInOffsDTO.FORWARD_LIST, docCurrentlyInOffs.getForward(), "", "", "") %>
				<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Select Office", "Office", office, docCurrentlyInOffs.getOffice(), "", "", "") %>
				<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6", "Courier", "Courier", "Carrier", docCurrentlyInOffs.getCarrier(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
				<%=new TransitionButtonWebControl().getTransitionButtonWebControl(sessionInfo, "col-sm-6", "btn btn-default", "align='center'") %> 
			</div>
		</div>
	</div>
<!-- end of content --><!-- end of content --><!-- end of content -->
	<div class="col-sm-12">
		</div>


<!-- end of content --><!-- end of content --><!-- end of content -->


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