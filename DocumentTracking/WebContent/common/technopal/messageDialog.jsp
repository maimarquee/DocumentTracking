<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.dto.*" %>
<%@ page import="com.mytechnopal.util.*" %>

<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	Message sessionMessage = (Message) session.getAttribute(Message.SESSION_MESSAGE);
%>

<%
if(!sessionMessage.getMessage().equalsIgnoreCase("")) {
	String imgFilename = "";
	if(sessionMessage.getMsgType().equalsIgnoreCase(sessionMessage.MSG_CLASS_SUCCESS)) {
		imgFilename = "big_check_mark.png";
	}
	else if(sessionMessage.getMsgType().equalsIgnoreCase(sessionMessage.MSG_CLASS_INFO)) {
		imgFilename = "big_info.png";
	}
	else {
		imgFilename = "big_warning.png";
	 }
%>	
	<div class="modal fade" id="divDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel"><%=sessionMessage.getMsgTitle()%></h4>
	            </div>
	            <div class="modal-body">
	            	<div class="row">
	            		<div class="col-sm-2"><img src="common/technopal/images/<%=imgFilename %>"></div>
	            		<div class="col-sm-10"><%=sessionMessage.getMessage()%></div>
	            	</div>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	        <!-- /.modal-content -->
	    </div>
	    <!-- /.modal-dialog -->
	</div>
	<script type="text/javascript">
		$('#divDialog').modal('show');
	</script>
<%
}
%>