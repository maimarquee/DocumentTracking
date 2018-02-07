<%@page import="com.ezshop.dao.DocumentTypeDAO"%>
<%@ page import="java.util.*" %>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.dto.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>
<%@ page import="com.ezshop.dto.*" %>  

<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	CompleteTrackingDTO completeTracking = (CompleteTrackingDTO)session.getAttribute(CompleteTrackingDTO.SESSION_COMPLETE_TRACKING);
	List<DTOBase> documenttype = (ArrayList)session.getAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST);
	List<DTOBase> office = (ArrayList)session.getAttribute(OfficeDTO.SESSION_OFFICE_LIST);
	DocumentTypeDTO documentTypeName = new DocumentTypeDAO().getDocumentTypeByCode(completeTracking.getDocument_type().getCode());	
%>

<div class="col-lg-12">
	<div class="panel panel-default">
		<div class="panel-heading">
		   <b>Document Details</b> 
		</div>
		<div class="panel-body">
			<div class="col-sm-12">
				Document Code: <b><%=completeTracking.getCode() %></b>
			</div>
			<div class="col-sm-12">
				Document Name: <b><%=completeTracking.getName() %></b>
			</div>
			<div class="col-sm-12">
				Document Description: <b><%=completeTracking.getDescription() %></b>
			</div>
			<div class="col-sm-6">
				Requesting Person: <b><%=completeTracking.getRequesting_person() %></b>
			</div>
			<div class="col-sm-6">
				Amount: <b><%=completeTracking.getAmount() %></b>
			</div>
			<div class="col-sm-6">
				Document Type: <b><%=documentTypeName.getName() %></b>
			</div>
		</div>
	</div>
</div>
<div class="col-lg-12">
	<div class="panel panel-default">
    	<div class="panel-heading">
           <b>Complete Tracking</b> 
        </div>
        <div class="panel-body">
           	<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-6", false, "TrackingComplete", "TrackingComplete", CompleteTrackingDTO.COMPLETE_TRACKING_LIST, completeTracking.getTrackingComplete(), "", "", "") %>
			<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6", "TrackingCompleteDate", "TrackingCompleteDate", "TrackingCompleteDate", DateTimeUtil.getDateTimeToStr(completeTracking.getTrackingCompleteDate(), "MM/dd/yyyy"), 45, TextBoxWebControl.DATA_TYPE_DATE, "")%>
        </div>
    </div>
</div>
<div class="col-sm-6">
	</div>

<%=new TransitionButtonWebControl().getTransitionButtonWebControl(sessionInfo, "col-sm-12", "btn btn-default", "align='center'") %> 
