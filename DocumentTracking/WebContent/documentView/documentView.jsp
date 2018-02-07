<%@page import="com.ezshop.dao.OfficeDAO"%>
<%@page import="com.ezshop.dao.DocumentTypeDAO"%>
<%@page import="com.mytechnopal.dao.UserDAO"%>
<%@page import="com.ezshop.util.StaffUtil"%>
<%@ page import="java.util.*" %>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.dto.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>
<%@ page import="com.ezshop.dto.*" %>   
<%@ page import="com.ezshop.dao.*" %>   

	<%
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
		DocumentViewDTO dv = (DocumentViewDTO)session.getAttribute(DocumentViewDTO.SESSION_DOCUMENT_VIEW);
		List<DTOBase> documenttype = (ArrayList)session.getAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST);
		List<DTOBase> office = (ArrayList)session.getAttribute(OfficeDTO.SESSION_OFFICE_LIST);
		DocumentTypeDTO documentTypeName = new DocumentTypeDAO().getDocumentTypeByCode(dv.getDocument_type().getCode());	
	%>
	
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
			   <b>Document Details</b>
			</div>
			<div class="panel-body">
				<div class="col-sm-12">
					Document Code: <b><%=dv.getCode() %></b>
				</div>
				<div class="col-sm-12">
					Document Name: <b><%=dv.getName() %></b>
				</div>
				<div class="col-sm-12">
					Document Description: <b><%=dv.getDescription() %></b>
				</div>
				<div class="col-sm-6">
					Requesting Person: <b><%=dv.getRequesting_person() %></b>
				</div>
				<div class="col-sm-6">
					Amount: <b><%=dv.getAmount() %></b>
				</div>
				<div class="col-sm-6">
					Document Type: <b><%=documentTypeName.getName() %></b>
				</div>
			</div>
		</div>
	</div>
	
	<%for(DTOBase documentTrackingOfficeLogObj: dv.getDocumentOfficeLogList()) {
		DocumentTrackingOfficeLogDTO documentTrackingOfficeLog = (DocumentTrackingOfficeLogDTO)documentTrackingOfficeLogObj; //geting document log properties
		UserDTO user = new UserDAO().getUserByCode(documentTrackingOfficeLog.getStaff().getCode()); //getting user properties
		OfficeDTO officeName = new OfficeDAO().getOfficeByCode(documentTrackingOfficeLog.getOfficeCode()); //getting office properties
		String date = DateTimeUtil.getDateTimeToStr(documentTrackingOfficeLog.getAddedTimestamp(), "dd MMM YYYY");
		String time = DateTimeUtil.getDateTimeToStr(documentTrackingOfficeLog.getAddedTimestamp(), "hh:mm aa");
		//loop++;
		%>		
		<%if(documentTrackingOfficeLog.getStatus().equalsIgnoreCase(documentTrackingOfficeLog.STATUS_COMPLETED)) {%>
			<div class="col-lg-12">
				<center><img class="img-responsive" src="common/bagoCityHall/completed.png" style="width: 40%"></center>
			</div>	
		<%}%>
					
	<%}%>
	
	<div class="col-sm-12">
		<!-- Content Wrapper. Contains page content -->
	
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				Timeline
			</h1>
			</section>
	
			<!-- Main content -->
			<section class="content">
	
			<!-- row -->
			<div class="row">
				<div class="col-md-12">
			<!-- The time line -->
					<ul class="timeline">
					<li>
						<i class="fa fa-clock-o bg-gray"></i></br></br>
					</li>
					<%
					String datess = "";
					//int loop = 0;
					%>
				<%for(DTOBase documentTrackingOfficeLogObj: dv.getDocumentOfficeLogList()) {
					DocumentTrackingOfficeLogDTO documentTrackingOfficeLog = (DocumentTrackingOfficeLogDTO)documentTrackingOfficeLogObj; //geting document log properties
					UserDTO user = new UserDAO().getUserByCode(documentTrackingOfficeLog.getStaff().getCode()); //getting user properties
					OfficeDTO officeName = new OfficeDAO().getOfficeByCode(documentTrackingOfficeLog.getOfficeCode()); //getting office properties
					String date = DateTimeUtil.getDateTimeToStr(documentTrackingOfficeLog.getAddedTimestamp(), "dd MMM YYYY");
					String time = DateTimeUtil.getDateTimeToStr(documentTrackingOfficeLog.getAddedTimestamp(), "hh:mm aa");
					//loop++;
					%>
			<!-- timeline time label -->
					<%if(datess != "" && !datess.equalsIgnoreCase(date)){ %>
					<%//System.out.println("already have date to compare"); %>
						<%datess = date;%>
						<li class="time-label">
						<span class="bg-orange">
						<%=date%>
					<%}else if(datess == ""){ %>
					<%//System.out.println("compared date is empty and inputed date"); %>
						<%datess = date;%>
						<li class="time-label">
						<span class="bg-orange">
						<%=date%>
					<%}%>
						</span>
						</li>
			<!-- /.timeline-label -->
	
			<!-- timeline item -->
					<%if(documentTrackingOfficeLog.getStatus().equalsIgnoreCase(documentTrackingOfficeLog.STATUS_FORWARDED)) {%>
						<li>
						<i class="fa fa-user bg-blue"></i>
						<div class="timeline-item">
							<span class="time"><i class="fa fa-clock-o"></i> <%=time %></span>
							<h3 class="timeline-header ">Status:  <b><%=documentTrackingOfficeLog.getStatus() %></b> to: <b><%=officeName.getName() %></b></h3>
							<div class="timeline-body">
								Staff Name: <b><%=user.getName(true) %></b> </br>
								Courier Name: <b><%=documentTrackingOfficeLog.getCarrier() %></b>
							</div>
						</div>
						</li>
						</b></b>
					<%} %>
			<!-- END timeline item -->
	
			<!-- /.timeline-label -->
					<%if(documentTrackingOfficeLog.getStatus().equalsIgnoreCase(documentTrackingOfficeLog.STATUS_ACCEPTED)) {%>
						<!-- timeline item -->
						<li>
						<i class="fa fa-user bg-green"></i>
						<div class="timeline-item">
							<span class="time"><i class="fa fa-clock-o"></i> <%=time %></span>
							<h3 class="timeline-header ">Status:  <b><%=documentTrackingOfficeLog.getStatus() %></b> </h3>
							<div class="timeline-body">
								Office: <b><%=officeName.getName() %></b></br>
								Staff Name: <b><%=user.getName(true) %></b> </br>
							</div>
						</div>
						</li>
						</b></b>
					<%} %>
			<!-- END timeline item -->
						
			<!-- /.timeline-label -->
					<%if(documentTrackingOfficeLog.getStatus().equalsIgnoreCase(documentTrackingOfficeLog.STATUS_CREATED)) {%>
						<!-- timeline item -->
						<li>
						<i class="fa fa-envelope bg-aqua"></i>
						<div class="timeline-item">
							<span class="time"><i class="fa fa-clock-o"></i> <%=time %></span>
							<h3 class="timeline-header ">Status:  <b><%=documentTrackingOfficeLog.getStatus() %></b> </h3>
							<div class="timeline-body">
								Office: <b><%=officeName.getName() %></b></br>
								Staff Name: <b><%=user.getName(true) %></b> </br>
							</div>
						</div>
						</li>
						</b></b>
					<%} %>
			<!-- END timeline item -->
	
			<!-- /.timeline-label -->
					<%if(documentTrackingOfficeLog.getStatus().equalsIgnoreCase(documentTrackingOfficeLog.STATUS_COMPLETED)) {%>
						<!-- timeline item -->
						<li>
						<i class="fa fa-envelope bg-aqua"></i>
						<div class="timeline-item">
							<span class="time"><i class="fa fa-clock-o"></i> <%=time %></span>
							<h3 class="timeline-header ">Status:  <b><%=documentTrackingOfficeLog.getStatus() %></b> </h3>
							<div class="timeline-body">
								Office: <b><%=officeName.getName() %></b></br>
								Staff Name: <b><%=user.getName(true) %></b> </br>
							</div>
						</div>
						</li>
						</b></b>
					<%} %>
			<!-- END timeline item -->
			<%//System.out.println("This is the current day" + date); 
			//System.out.println("This is the date compared" + datess);
			//System.out.println("loop number" + loop);%>
				<%} %>
						<li>
							<i class="fa fa-clock-o bg-gray"></i>
						</li>
					</ul> 
				</div><!-- /.col -->
			</div><!-- /.row -->
		</section><!-- /.content -->
	</div>