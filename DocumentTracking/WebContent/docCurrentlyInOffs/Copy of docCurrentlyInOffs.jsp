<%@page import="com.mytechnopal.dao.UserDAO"%>
<%@page import="com.ezshop.util.StaffUtil"%>
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

<div class="col-sm-12">
	<div class="nav-tabs-custom">
		<ul class="nav nav-tabs">
																				<%//AddDocumentLogCommentSubmitAction %>		<%//UploadDocumentLogCommentSubmitAction %>
			<li class="<%=sessionInfo.getPreviousLink().getCode().equalsIgnoreCase("U275") || sessionInfo.getPreviousLink().getCode().equalsIgnoreCase("U228")?"":"active" %>"><a href="#document" data-toggle="tab">Document</a></li>
																				
			<li class="<%=sessionInfo.getPreviousLink().getCode().equalsIgnoreCase("U275") || sessionInfo.getPreviousLink().getCode().equalsIgnoreCase("U228")?"active":"" %>"><a href="#forward" data-toggle="tab">Forward</a></li>
		</ul>
		<div class="tab-content">
			<div class="row tab-pane <%=sessionInfo.getPreviousLink().getCode().equalsIgnoreCase("U275") || sessionInfo.getPreviousLink().getCode().equalsIgnoreCase("U228")?"":"active" %>" id="document">
<!-- start of content --><!-- start of content --><!-- start of content -->

<div class="col-lg-12">
	<div class="col-lg-12" id="div-id-name">
		<center>
		<img class="img-responsive" src="common/barcode/<%=docCurrentlyInOffs.getCode()%>.jpg">
		</center>
		<div class="panel panel-default">
	    	<div class="panel-heading">
	           <b>Document Name & Description</b> 
	        </div>
	        <div class="panel-body">
	        	<tr>
	        		<td>Code:</td>
		            <td><%=docCurrentlyInOffs.getCode()%></td>
        		</tr>
        			</br>
	         	<tr>
					<td>Name:</td>
		            <td><%=docCurrentlyInOffs.getName()%></td>
        		</tr>
        			</br>
				<tr>
					<td>Description:</td>
			        <td><%=docCurrentlyInOffs.getDescription()%></td>
		        </tr>
	        </div>
	    </div>
	</div>
</div>

	<div class="col-sm-12">
		</div>
	<%//=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Forward", "Forward", forward, documenttracking.getActiveOffice(), "", "", "") %>
	<%//=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-12", "Name", "Name", "Name", documenttracking.getName(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
	<%//=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-12", "Description", "Description", "Description", documenttracking.getDescription(), 90, TextBoxWebControl.DATA_TYPE_STRING, "") %>
	<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6", "Requesting Person", "Requesting Person", "Requesting Person", docCurrentlyInOffs.getRequesting_person(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
	<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6", "Amount", "Amount", "Amount", StringUtil.getFormattedNum(docCurrentlyInOffs.getAmount(), StringUtil.NUMERIC_STANDARD_FORMAT_NO_COMMA), 9, TextBoxWebControl.DATA_TYPE_DOUBLE, "")%>
	<%//=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6", "Barcode", "Barcode", "Barcode", documenttracking.getBarcode(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
	<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Document Type", "Document Type", documenttype, docCurrentlyInOffs.getDocument_type(), "", "", "") %>
	<%//=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Forward", "Forward", forward, documenttracking.getActiveOffice(), "", "", "") %>
	
<div class="col-sm-12">
 <h3>
<center><button type="button" class="btn btn-default" onclick="javascript:printlayer('div-id-name')">Print Tracking</button></center>
</h3>
</div>
	<div class="col-sm-12">
	            	<div class="box box-primary direct-chat direct-chat-success">
	                	<div class="box-header with-border">
	                		<h3 class="box-title">Comments</h3>
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
			                        	<%//=documentTrackingLog.getStatus() %>
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
<!-- end of content --><!-- end of content --><!-- end of content -->
			</div>
			<div class="row tab-pane <%=sessionInfo.getPreviousLink().getCode().equalsIgnoreCase("U275") || sessionInfo.getPreviousLink().getCode().equalsIgnoreCase("U228")?"active":"" %>" id="forward">
<!-- start of content --><!-- start of content --><!-- start of content -->
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
						<b>Forward Document</b> 
						</div>
						<div class="panel-body">
							<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Forward?", "Forward", DocCurrentlyInOffsDTO.FORWARD_LIST, docCurrentlyInOffs.getForward(), "", "", "") %>
							<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Select Office", "Office", office, docCurrentlyInOffs.getOffice(), "", "", "") %>
							<%=new TransitionButtonWebControl().getTransitionButtonWebControl(sessionInfo, "col-sm-12", "btn btn-default", "align='center'") %> 
						</div>
					</div>
				</div>
<!-- end of content --><!-- end of content --><!-- end of content -->
			</div>
		</div>		
	</div>
</div>

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