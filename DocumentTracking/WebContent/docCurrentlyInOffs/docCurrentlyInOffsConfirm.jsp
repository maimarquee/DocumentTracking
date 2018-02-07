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
<%-- <script type = "text/javascript">
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

<div class="col-lg-12" id="div-id-name">
	<center>
	<img class="img-responsive" src="common/barcode/<%=documenttracking.getCode()%>.jpg">
	</center>
	<div class="col-lg-12">
		<div class="panel panel-default">
	    	<div class="panel-heading">
	           <b>Document Name & Description</b> 
	        </div>
	        <div class="panel-body">
	        	<tr>
	        		<td>Code:</td>
		            <td><%=documenttracking.getCode()%></td>
        		</tr>
        			</br>
	         	<tr>
					<td>Name:</td>
		            <td><%=documenttracking.getName()%></td>
        		</tr>
        			</br>
				<tr>
					<td>Description:</td>
			        <td><%=documenttracking.getDescription()%></td>
		        </tr>
	        </div>
	    </div>
	</div>
</div>

	<div class="col-lg-12">
		<div class="panel panel-default">
	    	<div class="panel-heading">
	           <b>Forward Document</b> 
	        </div>
	        <div class="panel-body">
	           	<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Forward?", "Forward", DocCurrentlyInOffsDTO.FORWARD_LIST, documenttracking.getForward(), "", "", "") %>
				<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Select Office", "Office", office, documenttracking.getOffice(), "", "", "") %>
	
	        </div>
	    </div>
	</div>

	<div class="col-sm-12">
		</div>
	<%//=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Forward", "Forward", forward, documenttracking.getActiveOffice(), "", "", "") %>
	<%//=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-12", "Name", "Name", "Name", documenttracking.getName(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
	<%//=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-12", "Description", "Description", "Description", documenttracking.getDescription(), 90, TextBoxWebControl.DATA_TYPE_STRING, "") %>
	<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6", "Requesting Person", "Requesting Person", "Requesting Person", documenttracking.getRequesting_person(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
	<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6", "Amount", "Amount", "Amount", StringUtil.getFormattedNum(documenttracking.getAmount(), StringUtil.NUMERIC_STANDARD_FORMAT_NO_COMMA), 9, TextBoxWebControl.DATA_TYPE_DOUBLE, "")%>
	<%//=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6", "Barcode", "Barcode", "Barcode", documenttracking.getBarcode(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>
	<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Document Type", "Document Type", documenttype, documenttracking.getDocument_type(), "", "", "") %>
	<%//=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "Forward", "Forward", forward, documenttracking.getActiveOffice(), "", "", "") %>
	
	//this is for COMMENT TABLE ADD AND DISPLAY
	<div class="col-sm-6 col-xs-offset-right-6"></div>
	<%//=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-5 nopadding", true, "Remarks", "Remarks", "RemarksDetails", merchandiseTransaction.getMerchandiseTransactionDetails().getRemarks() , 180, TextBoxWebControl.DATA_TYPE_STRING, "")%>
	<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-4", true, "Comment ID", "Comment ID", commentIdList, documenttracking.getCommentId().getCommentId(), "", "", "")%>
	<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-5", true, "Comment", "Comment", "Comment", documenttracking.getComment().getCommentDocument(), 180, TextBoxWebControl.DATA_TYPE_STRING, "")%>
	<div class="col-sm-1 nopadding">
		<%=lbAddTransactionDetails.getLinkButtonWebControl()%>
	</div>
	<div class="col-sm-6">
		<%=WebUtil.getTableById(sessionInfo, "table table-striped table-hover table-bordered", "table table-bordered", CommentUtil.getTableHeader(), CommentUtil.getTableBody(documenttracking.getCommentList()), "gradeX", 0, new LinkButtonWebControl(sessionInfo, "", "", sessionInfo.getLinkByCode("U210")))%>
	</div>

 --%>
 <div class="col-lg-12">
	<div class="panel panel-default">
		<div class="panel-heading">
		   <b>Document Details</b> 
		</div>
		<div class="col-lg-12" id="div-id-name">
			<div class="panel-body">
				<div class="col-sm-12">
					<%-- <center><img class="img-responsive" src="common/barcode/<%=docCurrentlyInOffs.getCode() %>.jpg"></center> --%>
				</div>
				<div class="col-sm-12">
					Document Code: <b><%=docCurrentlyInOffs.getCode() %></b>
				</div>
				<div class="col-sm-12">
					Document Name: <b><%=docCurrentlyInOffs.getName() %></b>
				</div>
				<div class="col-sm-12">
					Document Description: <b><%=docCurrentlyInOffs.getDescription() %></b>
				</div>
				<div class="col-sm-6">
					Requesting Person: <b><%=docCurrentlyInOffs.getRequesting_person() %></b>
				</div>
				<div class="col-sm-6">
					Amount: <b><%=docCurrentlyInOffs.getAmount() %></b>
				</div>
				<div class="col-sm-6">
					<%-- Document Type: <b><%//=documentTypeName.getName() %></b> --%>
				</div>
			</div>
		</div>
	</div>
</div>
<%//= new FileWebControl().getFileWebControl(sessionInfo, "", "btn btn-default", "<span class='fa fa-w fa-upload'></span>&nbsp;Upload Pict", "Pict", documenttracking.getPic(), "") %>
	<%=new TransitionButtonWebControl().getTransitionButtonWebControl(sessionInfo, "col-sm-12", "btn btn-default", "align='center'") %> 
