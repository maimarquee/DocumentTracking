<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.dto.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.ezshop.util.*" %>
<%@ page import="com.ezshop.dto.*" %>  
<%@ page import="com.ezshop.dao.*" %>
<%@ page import="java.util.*" %>


<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
%>

<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.4 -->
<link href="common/user/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="common/user/bootstrap/css/bootstrap-horizon.css">
<!-- Font Awesome Icons -->
<link href="common/user/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- Ionicons -->
<link href="common/user/plugins/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
<!-- Bootstrap Color Picker -->
<link href="common/user/plugins/colorpicker/bootstrap-colorpicker.min.css" rel="stylesheet" type="text/css" />
<!-- daterange picker -->
<link href="common/user/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
<!-- Bootstrap time Picker -->
<link href="common/user/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet" type="text/css" />
<!-- Select2 -->
<link href="common/user/plugins/select2/select2.min.css" rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="common/user/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
<link href="common/user/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
<link href="common/user/plugins/jQuery/smoothness/jquery-ui-1.10.1.custom.css" rel="stylesheet" type="text/css"> 
<link href="common/user/plugins/jQuery/smoothness/jquery-ui-1.10.1.custom.min.css" rel="stylesheet" type="text/css"> 
<!-- iCheck -->
<link href="common/user/plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css" />
<!-- Morris chart -->
<link href="common/user/plugins/morris/morris.css" rel="stylesheet" type="text/css" />
<!-- jvectormap -->
<link href="common/user/plugins/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
<!-- Date Picker -->
<link href="common/user/plugins/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
<!-- bootstrap wysihtml5 - text editor -->
<link href="common/user/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
<!-- DATA TABLES -->
<link href="common/user/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />		


<!-- jQuery 2.1.4 -->
<script src="common/user/plugins/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
<!-- Bootstrap 3.3.2 JS -->
<script src="common/user/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<!-- jQuery UI 1.11.4 -->
<script src="common/user/plugins/jQueryUI/jquery-ui.min.js" type="text/javascript"></script>
<!-- bootstrap color picker -->
<script src="common/user/plugins/colorpicker/bootstrap-colorpicker.min.js" type="text/javascript"></script>
<!-- date-range-picker -->
<script src="common/user/plugins/moment/moment.min.js" type="text/javascript"></script>
<script src="common/user/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
<!-- bootstrap time picker -->
<script src="common/user/plugins/timepicker/bootstrap-timepicker.min.js" type="text/javascript"></script>
<!-- SlimScroll -->
<script src="common/user/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<!-- DATA TABES SCRIPT -->
<script src="common/user/plugins/datatables/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="common/user/plugins/datatables/dataTables.bootstrap.min.js" type="text/javascript"></script>
<!-- FastClick -->
<script src="common/user/plugins/fastclick/fastclick.min.js" type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="common/user/dist/js/app.min.js" type="text/javascript"></script>    
<!-- Calendar Specific -->
<link href='common/user/plugins/fullcalendar/fullcalendar.css' rel='stylesheet' />
<link href='common/user/plugins/fullcalendar/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='common/user/plugins/fullcalendar/moment.min.js'></script>
<script src='common/user/plugins/fullcalendar/fullcalendar.min.js'></script>
<!-- Morris.js charts -->
<script src="plugins/morris/morris.min.js" type="text/javascript"></script>
<!-- Sparkline -->
<script src="plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
<!-- jvectormap -->
<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
<!-- jQuery Knob Chart -->
<script src="plugins/knob/jquery.knob.js" type="text/javascript"></script>
<!-- datepicker -->
<script src="plugins/datepicker/bootstrap-datepicker.js" type="text/javascript"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
<!-- AdminLTE App -->
<script src="dist/js/app.min.js" type="text/javascript"></script>

<!-- Site wrapper -->
<div class="wrapper">
	<header class="main-header">
	<%
	DTOBase obj = UserUtil.getUserByUserCode(sessionInfo.getCurrentUser().getCode());
	StaffDTO staff = StaffUtil.getStaff(obj);
	OfficeDTO officeName = new OfficeDAO().getOfficeByCode(staff.getOffice().getCode());
	%>
	 <!-- Logo -->
	 	<a href="#" onclick="openLink('U001')" class="logo">
	   	<!-- mini logo for sidebar mini 50x50 pixels -->
	  		<span class="logo-mini"><%=SettingsUtil.OWNER_CODE%></span>
	  		<!-- logo for regular state and mobile devices -->
	  		<span class="logo-sm"><b><%=SettingsUtil.OWNER_NAME_SHORTCUT%></b></span>
   		</a>
  			<!-- Header Navbar: style can be found in header.less -->
  			<nav class="navbar navbar-static-top" role="navigation">
	   	<!-- Sidebar toggle button onclick="openLink('9901')"-->
	   	<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
		  <span class="sr-only">Toggle navigation</span>
		  <span class="icon-bar"></span>
		  <span class="icon-bar"></span>
		  <span class="icon-bar"></span>
	   	</a>
					<div class="navbar-custom-menu">
	  				<ul class="nav navbar-nav">
	  					<!-- BELL ALERT -->
							<%
							List<DTOBase> list = new AcceptDocumentDAO().getAcceptDocumentByOffsCode(staff.getOffice().getCode());
		 					if(list.size() >= 1) {
		 					%>
								<li class="dropdown notifications-menu">
									<a aria-expanded="true" href="#" class="dropdown-toggle" data-toggle="dropdown">
										<i class="fa fa-bell-o"></i>
										<span class="label label-warning"><%="NEW DOCUMENT TO ACCEPT "+ list.size()%></span>
								  	</a>
								  	<%} %>
								  	<ul class="dropdown-menu">
										<li>
											<!-- inner menu: contains the actual data -->
											<div style="position: relative; overflow: hidden; width: auto; height: auto;" class="slimScrollDiv">
												<ul style="overflow: hidden; width: 100%; height: auto;" class="menu">
										  		<%
										  		for(DTOBase documentObj: list) {
										  			AcceptDocumentDTO ad = (AcceptDocumentDTO)documentObj;
										  		%>

										  		<!-- onclick=\"openLink('"+  getCode() +"','U208')\"> -->
										  		<!-- <a href="#" onclick= openLink('U204')> accept document link -->

										  		<a href="#" onclick="recordAction('<%=ad.getCode()%>', 'U250')">
										  		<li>
										  		Dument Name: <%=ad.getName() %></li>
												<!-- <hr> -->
										  		</li>
										  		</a>
										  		<%} %>
												</ul>
											</div>
									  	</li>
									</ul>
							<!-- BELL ALERT -->

							<!-- User Account: style can be found in dropdown.less -->
							<li class="dropdown user user-menu">
			  					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										<%-- <img src="common/user/dist/img/<%=user.getAvatar()%>.png" class="user-image" alt="User Image" /> --%>
										<img src="common/user/dist/img/avatar_neutral.png" class="user-image" alt="User Image" />
										<span class="hidden-xs"><%=sessionInfo.getCurrentUser().getName(true)%></span> :::
										<%=officeName.getName()%>
			 				 		</a>
			  					<ul class="dropdown-menu">
										<!-- User image -->
										<li class="user-header">
				  						<%-- <img src="common/user/dist/img/<%=user.getAvatar()%>.png" class="img-circle" alt="User Image" /> --%>
				  						<img src="common/user/dist/img/avatar_neutral.png" class="img-circle" alt="User Image" />
				  						<p><%=sessionInfo.getCurrentUser().getFirstName()%>&nbsp;(<%=sessionInfo.getCurrentUser().getCode()%>)</p>
										</li>
										<!-- Menu Footer-->
										<li class="user-footer">
				  						<div class="pull-left">
												<!-- <a href="#" onclick="openLink('U003')" class="btn btn-default btn-flat">Profile</a> -->
				  						</div>
				  						<div class="pull-right">
												<a href="#" onclick="openLink('U002')" class="btn btn-default btn-flat">Sign out</a>
				  						</div>
										</li>
			  					</ul>
	   	 				</li>
	   	 				<!-- Help Button -->
	   					<li>
	   					<a target="_blank" href="<%=sessionInfo.getCurrentLink().getHelpPage() %>">HELP<i class=""></i></a> <!-- fa fa-fw fa-question -->
		 					<%-- <%System.out.println("current Link: " + sessionInfo.getCurrentLink().getCode()); %> --%>
		 					<%-- <a target="_blank" 
		 					<%System.out.println("current Link: " + sessionInfo.getCurrentLink().getCode()); %>
		 					<%if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U001")){ //home page%>
		 						href="help/admin/userListHelp.html"
		 					<%}else if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U011")) {//user List U013 update user%>
		 						href="common/help/listStaff.jsp"
		 					<%}else if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U021")) {// add staff %>
		 						href="common/help/listStaff.jsp"
		 					<%}else if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U024")) {// staff list U026 staff update U029 staff delete%>
		 						href="common/help/listStaff.jsp"
		 					<%}else if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U180")) {// add office%>
		 						href="common/help/listStaff.jsp"
		 					<%}else if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U183")) {// office list U185 office update U188 office delete%>
		 						href="common/help/listStaff.jsp"
		 					<%}else if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U169")) {// add document type%>
		 						href="common/help/listStaff.jsp"
		 					<%}else if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U172")) {// document type list U174 document type update U177 document type delete%>
		 						href="common/help/listStaff.jsp"
		 					<%}else if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U191")) {// document tracking%>
		 						href="common/help/listStaff.jsp"
		 					<%}else if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U194")) {// document tracking list U196 document tracking update U199 document tracking delete %>
		 						href="common/help/listStaff.jsp"
		 					<%}else if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U226")) {// doc currently in offs list U228 doc currently in offs update%>
		 						href="common/help/listStaff.jsp"
		 					<%}else if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U250")) {// accept document list U252 accept document update%>
		 						href="common/help/listStaff.jsp"
		 					<%}else if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U261")) {// complete tracking list U263 complete tracking update%>
		 						href="common/help/listStaff.jsp"
		 					<%}else if(sessionInfo.getCurrentLink().getCode().equalsIgnoreCase("U269")) {// document view list U271 document view view%>
		 						href="common/help/listStaff.jsp"
		 					<%}%>
		 					
		 					>HELP ?<i class=""></i></a> <!-- fa fa-fw fa-question --> --%>
		 					
	   					</li>

	  				<!-- Control Sidebar Toggle Button -->
	   					<li>
		 					<a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
		 					
	   					</li>
					</div>
  			</nav>
			</header>
			<!-- =============================================== -->
			<!-- Left side column. contains the sidebar -->
			<aside class="main-sidebar">
  			<!-- sidebar: style can be found in sidebar.less -->
  			<section class="sidebar">
					<!-- sidebar menu: : style can be found in sidebar.less -->
						<ul class="sidebar-menu">   
	   		<%
		for(int i=0; i<sessionInfo.getCurrentUserMainMenuLinkList().size(); i++) {
			LinkDTO mainMenuLink = (LinkDTO) sessionInfo.getCurrentUserMainMenuLinkList().get(i);
			List subMenuLinkList = sessionInfo.getCurrentUserSubMenuLinkListByMainGroup(mainMenuLink);
			%>
		   <li class=<%=mainMenuLink.getMainGroup().equalsIgnoreCase(sessionInfo.getCurrentLink().getMainGroup())?"active":""%>>	
		   	 <a href="#"><i class="<%=mainMenuLink.getImgSource()%>"></i> <span><%=mainMenuLink.getLabel()%></span> <i class="fa fa-angle-left pull-right"></i></a>
			 <ul class="treeview-menu">    	
<%
						String subMenu = "";
			for(int j=0; j<subMenuLinkList.size(); j++) {
				LinkDTO subMenuLink = (LinkDTO)subMenuLinkList.get(j);
				subMenu = subMenuLink.getLabel();
					%>				
				<li class="<%=subMenuLink.getCode().equalsIgnoreCase(sessionInfo.getCurrentLink().getCode())?"active":""%>"><a href="#" onclick="openLink('<%=subMenuLink.getCode()%>')"><i class="<%=subMenuLink.getCode().equalsIgnoreCase(sessionInfo.getCurrentLink().getCode())?"fa fa-circle-o text-yellow":"fa fa-circle-o"%>"></i><%=subMenu%></a></li>
<%
			}
%>
  							</ul>

  						</li>
<%
		}
%>
						</ul>
  				</section>
  			<!-- /.sidebar -->
				</aside>
				<!-- =============================================== -->
				<!-- Content Wrapper. Contains page content -->
				<div class="content-wrapper">
  				<!-- Content Header (Page header) -->
  				<section class="content-header">
	  	<b><%=sessionInfo.getCurrentLink().getDescription()%></b>
						<p class="breadcrumb">

						</p>
  				</section>
  				<!-- Main content -->
 					<section class="content">
   	<div class="box box-solid">	
   		<div class="row" style="padding:10px">
			<jsp:include flush="true" page="<%=sessionInfo.getCurrentLink().getPage()%>"></jsp:include>	   
		</div>	
	</div>	
  				</section>
				</div><!-- /.content-wrapper -->
				<footer class="main-footer">
  				<div class="pull-right hidden-xs">
						<b>Version</b> 3.0 | Build <%=SettingsUtil.BUILD_SERIAL_NUM%> 
  				</div>
  				<strong>Copyright &copy; 2017 <a href="http://mytechnopal.com">Technopal Software</a>.</strong> All rights reserved.
				</footer>
				<!-- Control Sidebar -->
				<aside class="control-sidebar control-sidebar-dark">
					<jsp:include flush="true" page="user/userControlSidebar.jsp"></jsp:include>	  
				</aside>
<!-- The sidebar's background -->
<!-- This div must placed right after the sidebar for it to work-->
<div class="control-sidebar-bg"></div>
</div><!-- ./wrapper -->