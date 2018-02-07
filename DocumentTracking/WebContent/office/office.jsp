<%@ page import="java.util.*" %>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.dto.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>
<%@ page import="com.ezshop.dto.*" %>  

<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	OfficeDTO office = (OfficeDTO)session.getAttribute(OfficeDTO.SESSION_OFFICE);
%>

<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-6 has-warning", "Name", "Name", "Name", office.getName(), 45, TextBoxWebControl.DATA_TYPE_STRING, "") %>

<%=new TransitionButtonWebControl().getTransitionButtonWebControl(sessionInfo, "col-sm-12", "btn btn-default", "align='center'") %> 