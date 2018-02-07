<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.dto.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.ezshop.util.*" %>
<%@ page import="java.util.*" %>

<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	Message sessionMessage = (Message) session.getAttribute(Message.SESSION_MESSAGE);
	UserDTO user = (UserDTO) session.getAttribute(UserDTO.SESSION_USER);
%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Businnes, Portfolio, Corporate">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title><%=sessionInfo.getCurrentLink().getDescription()%> | <%=SettingsUtil.OWNER_NAME%></title>
    <!-- Technopal Specific -->
 	<link href="common/technopal/general.css" rel="stylesheet" type="text/css" media="screen" />
	<script src="common/technopal/general.js" language="javascript" type="text/javascript" ></script>
    <link rel="shortcut icon" href="common/guest/img/pcsnic_logo.png">
</head>

<body class="<%=sessionInfo.getCurrentUser().getHTMLBodyClass()%>">
	<form id="frmMain" name="frmMain" method="post" action="MainController" onSubmit="return false" style="margin:0; padding:0; outline:0">
		<input id="txtSkin" name="txtSkin" type="hidden" value="" />
		<input id="txtSelectedLink" name="txtSelectedLink" type="hidden" value="" />
		<input id="txtPageNum" name="txtPageNum" type="hidden" value="" />
		<input id="txtSelectedRecord" name="txtSelectedRecord" type="hidden" value="" />
		<%
		if(sessionInfo.getCurrentUser().getId() == SettingsUtil.USER_GUEST_USER_ID) {
		%>
			<jsp:include page="guest.jsp"></jsp:include>
		<%
		}
		else {
		%>
			<jsp:include page="user.jsp"></jsp:include>
		<%
		}
		%>
  		<jsp:include page="common/technopal/loading.jsp"></jsp:include>
  		<jsp:include page="common/technopal/messageDialog.jsp"></jsp:include>
  	</form>		
</body>
<!-- Technopal Specific -->
<script src="common/technopal/general.js" language="javascript" type="text/javascript" ></script>
<!-- Technopal Specific -->
</html>
