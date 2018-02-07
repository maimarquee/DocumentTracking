<%@page import="com.ezshop.util.HomeUtil"%>
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
	DocumentTrackingOfficeLogDAO documentTrackingOfficeLog = new DocumentTrackingOfficeLogDAO();
	String lastMonth  = StringUtil.getPadded(String.valueOf(DateTimeUtil.getCurrentMonth()), 2, "0", true);
	String currentYear =  StringUtil.getPadded(String.valueOf(DateTimeUtil.getCurrentYear()), 4, "0", false);
	List<DTOBase> listDocumentType = new DocumentTypeDAO().getDocumentTypeList();
	List<DTOBase> listDocumentsCreatedThisYear = new DocumentViewDAO().getDocumentViewCreateListThisYear(DateTimeUtil.getCurrentYear());
	List<DTOBase> listDocumentsCreatedThisMonth = new DocumentViewDAO().getDocumentViewCreateListThisMonth(StringUtil.getPadded(String.valueOf(DateTimeUtil.getCurrentMonth()+1), 2, "0", true));
	List<DTOBase> listDocumentsCompletedThisYear = new DocumentViewDAO().getDocumentViewCompleteListThisYear(DateTimeUtil.getCurrentYear());
	List<DTOBase> listDocumentsCompletedThisMonth = new DocumentViewDAO().getDocumentViewCompleteListThisMonth(StringUtil.getPadded(String.valueOf(DateTimeUtil.getCurrentMonth()+1), 2, "0", true));
	List<DTOBase> documentTrackingOfficeLogListByYesterday = new DocumentTrackingOfficeLogDAO().getDocumentTrackingOfficeLogListByYesterday(StringUtil.getPadded(String.valueOf(DateTimeUtil.getCurrentDay()-1), 2, "0", true));
	List<DTOBase> documentTrackingOfficeLogListByLastDayOfTheMonth = new DocumentTrackingOfficeLogDAO().getDocumentTrackingOfficeLogListByYesterday(documentTrackingOfficeLog.getLastDayOfTheMonth(currentYear, lastMonth));
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	DTOBase obj = UserUtil.getUserByUserCode(sessionInfo.getCurrentUser().getCode());
	StaffDTO staff = StaffUtil.getStaff(obj);
	Integer birthYear = Integer.parseInt(StringUtil.getNumToStr(DateTimeUtil.getDateYear(staff.getBirthDate()), true));
	Integer currentYear2 = Integer.parseInt(currentYear);
	Integer age = currentYear2 - birthYear;
	Integer ageForCompare = Integer.valueOf(StringUtil.getRight(StringUtil.getNumToStr(age, true), 1));
	
	%>
	<%//=StringUtil.getPadded(String.valueOf(DateTimeUtil.getCurrentDay()-1), 2, "0", true)%>
	<div class="col-sm-12">
		<div class="nav-tabs-custom">
			<ul class="nav nav-tabs success">
				<li class=""><a href="#home" data-toggle="tab">Home</a></li>
				<li class="success"><a href="#thismonth" data-toggle="tab">This Month</a></li>
				<li class="success"><a href="#thisyear" data-toggle="tab">This Year</a></li>
			</ul>
			<div class="tab-content" style="margin-top: 5px; margin-left: 10px;">
				<div class="row tab-pane active"  id="home">
				<%-- <!-- inside home tab dont edit above --><!-- inside home tab dont edit above --><!-- inside home tab dont edit above --><!-- inside home tab dont edit above -->
				birthday month <%=DateTimeUtil.getDateMonth(staff.getBirthDate())+1 %></br>
				compared birthday month <%=StringUtil.getPadded(String.valueOf(DateTimeUtil.getCurrentMonth()+1), 2, "0", true) %></br>
				birthday <%=DateTimeUtil.getDateTimeToStr(staff.getBirthDate(), "dd") %></br>
				compared birthday <%=StringUtil.getPadded(String.valueOf(DateTimeUtil.getCurrentDay()), 2, "0", true) %>
				<%if(StringUtil.getPadded(String.valueOf(DateTimeUtil.getCurrentMonth()+1), 2, "0", true).equalsIgnoreCase(StringUtil.getNumToStr(DateTimeUtil.getDateMonth(staff.getBirthDate())+1, true)) && DateTimeUtil.getDateTimeToStr(staff.getBirthDate(), "dd").equalsIgnoreCase(StringUtil.getPadded(String.valueOf(DateTimeUtil.getCurrentDay()), 2, "0", true))){ %>
					<div class="col-lg-12"></br></br>
						<div class="col-lg-12">
							<center><h1><font style="color:red">Happy <%=age%><%if(ageForCompare == 1){%>st<%}else if(ageForCompare == 2){%>nd<%}else if(ageForCompare == 3){%>rd<%}else if(ageForCompare == 4 ||ageForCompare ==  5||ageForCompare == 6||ageForCompare == 7||ageForCompare == 8||ageForCompare == 9 || ageForCompare == 0){%>th<%}%></br> Birthday</br><%=staff.getFirstName()%>!!!</font></h1></center>
						</div>
						<div class="col-lg-12">
							<div class="col-lg-3">
							</div>
								<div class="col-lg-6">
									<center><h3><font style="color:black">Greetings From:</font><b><font style="color:red">T</font><font style="color:red">E</font><font style="color:orange">C</font><font style="color:orange">H</font><font style="color:green">N</font><font style="color:green">O</font><font style="color:blue">P</font><font style="color:indigo">A</font><font style="color:violet">L</font></b></h3></center>
								</div>
							<div class="col-lg-3">
							</div>
						</div>
					</div>
					<div class="col-lg-12"></br></br></br></br></br></br></br></div>
				<%}%> --%>
				<!-- <div class="col-lg-12"></br></br>
						<div class="col-lg-12">
							<div class="col-lg-3">
							</div>
								<div class="col-lg-6">
									<center><img class="img-responsive" src="common/bagoCityHall/cityHall.png" style="width: 40%"></center>
								</div>
							<div class="col-lg-3">
							</div>
						</div>
						<div class="col-lg-12">
							<div class="col-lg-3">
							</div>
								<div class="col-lg-6">
									<center><h3><b>
									<font style="color:red">CITY GOVERNMENT OF BAGO DOCUMENT TRACKING SYSTEM</font>
									</b></h3></center>
								</div>
							<div class="col-lg-3">
							</div>
						</div>
					</div> -->
					<!--this is everything that is  made yesterday --><!--this is everything that is  made yesterday --><!--this is everything that is  made yesterday -->
					<div class="col-lg-12"><center><h4><B>ACTIVITIES MADE YESTERDAY</B></h4></center></br></div>
	 				<div class="col-lg-6"> 
						<div class="box box-primary direct-chat direct-chat-success">
							<div class="box-header with-border">
								<div class="col-lg-12"><h3 class="box-title">CREATED DOCUMENTS </h3></br></div>
								<div class="col-lg-2">Code</div>
								<div class="col-lg-7">Name</div>
								<div class="col-lg-3">Time</div>
							</div>
							<div class="box-body">
								<div class="direct-chat-messages">
									<%if(DateTimeUtil.getCurrentDay() == 1){ %>
										<%
										for(DTOBase documentObj: documentTrackingOfficeLogListByLastDayOfTheMonth) {
											DocumentTrackingOfficeLogDTO ad = (DocumentTrackingOfficeLogDTO)documentObj;
											DocumentTrackingDTO docName = new DocumentTrackingDAO().getDocumentTrackingByCode(ad.getDocumentTrackingCode());
										%>
											<%if(ad.getStatus().equalsIgnoreCase("CREATED") && docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())&& docName.getForward().equalsIgnoreCase("NO")){ %> <!-- true -->
												<div class="col-lg-2"><%=ad.getDocumentTrackingCode() %></div>
												<div class="col-lg-7"><%=docName.getName() %></div>
												<div class="col-lg-3"><%=DateTimeUtil.getDateTimeToStr(ad.getAddedTimestamp(), "hh:mm aa")%></div>
											<%}%>
										<%} %>
									<%}else{ %>
										<%
										for(DTOBase documentObj: documentTrackingOfficeLogListByYesterday) {
											DocumentTrackingOfficeLogDTO ad = (DocumentTrackingOfficeLogDTO)documentObj;
											DocumentTrackingDTO docName = new DocumentTrackingDAO().getDocumentTrackingByCode(ad.getDocumentTrackingCode());
										%>
											<%if(ad.getStatus().equalsIgnoreCase("CREATED") && docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())&& docName.getForward().equalsIgnoreCase("NO")){ %> <!-- true -->
												<div class="col-lg-2"><%=ad.getDocumentTrackingCode() %></div>
												<div class="col-lg-7"><%=docName.getName() %></div>
												<div class="col-lg-3"><%=DateTimeUtil.getDateTimeToStr(ad.getAddedTimestamp(), "hh:mm aa")%></div>
											<%}%>
										<%} %>
									<%} %>
								</div>
							</div>
						</div>
					</div>
	 				<div class="col-lg-6">
						<div class="box box-primary direct-chat direct-chat-success">
							<div class="box-header with-border">
								<div class="col-lg-12"><h3 class="box-title">ACCEPTED DOCUMENTS </h3></br></div>
								<div class="col-lg-2">Code</div>
								<div class="col-lg-7">Name</div>
								<div class="col-lg-3">Time</div>
							</div>
							<div class="box-body">
								<div class="direct-chat-messages">
									<%if(DateTimeUtil.getCurrentDay() == 1){ %>
										<%
										for(DTOBase documentObj: documentTrackingOfficeLogListByLastDayOfTheMonth) {
											DocumentTrackingOfficeLogDTO ad = (DocumentTrackingOfficeLogDTO)documentObj;
											DocumentTrackingDTO docName = new DocumentTrackingDAO().getDocumentTrackingByCode(ad.getDocumentTrackingCode());
										%>
											<%if(ad.getStatus().equalsIgnoreCase("ACCEPTED") && docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())&& docName.getForward().equalsIgnoreCase("NO")){ %> <!-- true -->
												<div class="col-lg-2"><%=ad.getDocumentTrackingCode() %></div>
												<div class="col-lg-7"><%=docName.getName() %></div>
												<div class="col-lg-3"><%=DateTimeUtil.getDateTimeToStr(ad.getAddedTimestamp(), "hh:mm aa")%></div> <!-- dd MMM YYYY  -->
											<%}%>
										<%} %>
									<%}else{ %>
										<%
										for(DTOBase documentObj: documentTrackingOfficeLogListByYesterday) {
											DocumentTrackingOfficeLogDTO ad = (DocumentTrackingOfficeLogDTO)documentObj;
											DocumentTrackingDTO docName = new DocumentTrackingDAO().getDocumentTrackingByCode(ad.getDocumentTrackingCode());
										%>
											<%if(ad.getStatus().equalsIgnoreCase("ACCEPTED") && docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())&& docName.getForward().equalsIgnoreCase("NO")){ %> <!-- true -->
												<div class="col-lg-2"><%=ad.getDocumentTrackingCode() %></div>
												<div class="col-lg-7"><%=docName.getName() %></div>
												<div class="col-lg-3"><%=DateTimeUtil.getDateTimeToStr(ad.getAddedTimestamp(), "hh:mm aa")%></div>
											<%}%>
										<%} %>
									<%} %>
								</div>
							</div>
						</div>
					</div>
	 				<div class="col-lg-6"> 
						<div class="box box-primary direct-chat direct-chat-success">
							<div class="box-header with-border">
								<div class="col-lg-12"><h3 class="box-title">FORWARDED DOCUMENTS </h3></br></div>
								<div class="col-lg-2">Code</div>
								<div class="col-lg-7">Name</div>
								<div class="col-lg-3">Time</div>
							</div>
							<div class="box-body">
								<div class="direct-chat-messages">
									<%if(DateTimeUtil.getCurrentDay() == 1){ %>
										<%
										for(DTOBase documentObj: documentTrackingOfficeLogListByLastDayOfTheMonth) {
											DocumentTrackingOfficeLogDTO ad = (DocumentTrackingOfficeLogDTO)documentObj;
											DocumentTrackingDTO docName = new DocumentTrackingDAO().getDocumentTrackingByCode(ad.getDocumentTrackingCode());
										%>
											<%if(ad.getStatus().equalsIgnoreCase("FORWARDED") && docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())&& docName.getForward().equalsIgnoreCase("YES")){ %> <!-- true -->
												<div class="col-lg-2"><%=ad.getDocumentTrackingCode() %></div>
												<div class="col-lg-7"><%=docName.getName() %></div>
												<div class="col-lg-3"><%=DateTimeUtil.getDateTimeToStr(ad.getAddedTimestamp(), "hh:mm aa")%></div>
											<%}%>
										<%} %>
									<%}else{ %>
										<%
										for(DTOBase documentObj: documentTrackingOfficeLogListByYesterday) {
											DocumentTrackingOfficeLogDTO ad = (DocumentTrackingOfficeLogDTO)documentObj;
											DocumentTrackingDTO docName = new DocumentTrackingDAO().getDocumentTrackingByCode(ad.getDocumentTrackingCode());
										%>
											<%if(ad.getStatus().equalsIgnoreCase("FORWARDED") && docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())&& docName.getForward().equalsIgnoreCase("YES")){ %> <!-- true -->
												<div class="col-lg-2"><%=ad.getDocumentTrackingCode() %></div>
												<div class="col-lg-7"><%=docName.getName() %></div>
												<div class="col-lg-3"><%=DateTimeUtil.getDateTimeToStr(ad.getAddedTimestamp(), "hh:mm aa")%></div>
											<%}%>
										<%} %>
									<%} %>
								</div>
							</div>
						</div>
					</div>
	 				<div class="col-lg-6"> 
						<div class="box box-primary direct-chat direct-chat-success">
							<div class="box-header with-border">
								<div class="col-lg-12"><h3 class="box-title">PENDING FORWARDED DOCUMENTS </h3></br></div>
								<div class="col-lg-2">Code</div>
								<div class="col-lg-8">Name</div>
								<div class="col-lg-2">Status</div>
							</div>
							<div class="box-body">
								<div class="direct-chat-messages">
									<%if(DateTimeUtil.getCurrentDay() == 1){ %>
										<%String testCode = "";
										for(DTOBase documentObj: documentTrackingOfficeLogListByLastDayOfTheMonth) {
											DocumentTrackingOfficeLogDTO ad = (DocumentTrackingOfficeLogDTO)documentObj;
											DocumentTrackingDTO docName = new DocumentTrackingDAO().getDocumentTrackingByCode(ad.getDocumentTrackingCode());
										%>
											<%if(testCode == "" && ad.getStatus().equalsIgnoreCase("FORWARDED") && docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())&& docName.getForward().equalsIgnoreCase("YES")){ %> <!-- true -->
												<%testCode = ad.getDocumentTrackingCode();  %>
												<div class="col-lg-2"><%=ad.getDocumentTrackingCode() %></div>
												<div class="col-lg-8"><%=docName.getName() %></div>
												<%if(docName.getForward().equalsIgnoreCase("YES")&& docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())) {%>
												<div class="col-lg-2">PENDING</div>
												<%} %>
											<%}else if(!ad.getDocumentTrackingCode().equalsIgnoreCase(testCode) && ad.getStatus().equalsIgnoreCase("FORWARDED") && docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())&& docName.getForward().equalsIgnoreCase("YES")){ %>
												<%testCode = ad.getDocumentTrackingCode();  %>
												<div class="col-lg-2"><%=ad.getDocumentTrackingCode() %></div>
												<div class="col-lg-8"><%=docName.getName() %></div>
												<%if(docName.getForward().equalsIgnoreCase("YES")&& docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())) {%>
												<div class="col-lg-2">PENDING</div>
												<%} %>
											<%} %>
										<%} %>
									<%}else{ %>
										<%String testCode = "";
										for(DTOBase documentObj: documentTrackingOfficeLogListByYesterday) {
											DocumentTrackingOfficeLogDTO ad = (DocumentTrackingOfficeLogDTO)documentObj;
											DocumentTrackingDTO docName = new DocumentTrackingDAO().getDocumentTrackingByCode(ad.getDocumentTrackingCode());
										%>
											<%if(testCode == "" && ad.getStatus().equalsIgnoreCase("FORWARDED") && docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())&& docName.getForward().equalsIgnoreCase("YES")){ %> <!-- true -->
												<%testCode = ad.getDocumentTrackingCode();  %>
												<div class="col-lg-2"><%=ad.getDocumentTrackingCode() %></div>
												<div class="col-lg-8"><%=docName.getName() %></div>
												<%if(docName.getForward().equalsIgnoreCase("YES")&& docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())) {%>
												<div class="col-lg-2">PENDING</div>
												<%} %>
											<%}else if(!ad.getDocumentTrackingCode().equalsIgnoreCase(testCode) && ad.getStatus().equalsIgnoreCase("FORWARDED") && docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())&& docName.getForward().equalsIgnoreCase("YES")){ %>
												<%testCode = ad.getDocumentTrackingCode();  %>
												<div class="col-lg-2"><%=ad.getDocumentTrackingCode() %></div>
												<div class="col-lg-8"><%=docName.getName() %></div>
												<%if(docName.getForward().equalsIgnoreCase("YES")&& docName.getUpdatedBy().equalsIgnoreCase(staff.getCode())) {%>
												<div class="col-lg-2">PENDING</div>
												<%} %>
											<%} %>
										<%} %>
									<%} %>
								</div>
							</div>
						</div>
					</div>
				<!--this is everything that is  made yesterday --><!--this is everything that is  made yesterday --><!--this is everything that is  made yesterday -->
				</div>
				<!-- next tab dont touch below here --><!-- next tab dont touch below here --><!-- next tab dont touch below here --><!-- next tab dont touch below here -->
				<div class="row tab-pane" id="thisyear">
					<div class="col-lg-12" id="thisyears">
					<!-- CURRENT YEAR CURRENT YEAR CURRENT YEAR CURRENT YEAR CURRENT YEAR CURRENT YEAR CURRENT YEAR CURRENT YEAR CURRENT YEAR -->
						<div class="col-lg-12">
						<H3>CREATED DOCUMENTS BY THE YEAR <%=DateTimeUtil.getCurrentYear() %>: <%=listDocumentsCreatedThisYear.size() %><!-- or 100% PERCENTAGE--></H3>
							<div class="progress progress-m progress-striped active">
								<div class="progress-bar progress-bar-success" style="width: <%=(Double.valueOf(StringUtil.getNumToStr(listDocumentsCreatedThisYear.size(), false))/Double.valueOf(StringUtil.getNumToStr(listDocumentsCreatedThisYear.size(), false))*100)%>%"></div>
							</div>
						</div>
						</br>
						<%for(DTOBase documentTypeObj: listDocumentType) {
							DocumentTypeDTO documentType = (DocumentTypeDTO)documentTypeObj;
							List<DTOBase> documentTrackingListbyDocumenttypeThisYear = new ArrayList<DTOBase>();
							for(DTOBase listDocumentTypeThisYearYearObj: listDocumentsCreatedThisYear) {
								DocumentViewDTO documentView = (DocumentViewDTO)listDocumentTypeThisYearYearObj;
								if(documentView.getDocument_type().getCode().equalsIgnoreCase(documentType.getCode())){
									documentTrackingListbyDocumenttypeThisYear.add(documentView);
								}
							}
							Double percentageOfDocumentType = (Double.valueOf(StringUtil.getNumToStr(documentTrackingListbyDocumenttypeThisYear.size(), false))/Double.valueOf(StringUtil.getNumToStr(listDocumentsCreatedThisYear.size(), false))*100);
							%>
							<div class="col-lg-12">
								DOCUMENT TYPE: <%=documentType.getName() %>: <%=documentTrackingListbyDocumenttypeThisYear.size() %>  or <%=Math.round(percentageOfDocumentType) %>%
								<div class="progress progress-sm progress-striped active">
									<div class="progress-bar progress-bar-success" style="width: <%=percentageOfDocumentType %>%"></div>
								</div>
							</div>
						<%}%>
						<div class="col-lg-12">
						<H3>CREATED DOCUMENTS BY THE YEAR <%=DateTimeUtil.getCurrentYear() %>:<%=listDocumentsCompletedThisYear.size() %><!-- or 100% PERCENTAGE--></H3>
							<div class="progress progress-m progress-striped active">
								<div class="progress-bar progress-bar-success" style="width: <%=(Double.valueOf(StringUtil.getNumToStr(listDocumentsCompletedThisYear.size(), false))/Double.valueOf(StringUtil.getNumToStr(listDocumentsCompletedThisYear.size(), false))*100)%>%"></div>
							</div>
						</div>
						</br>
						<%for(DTOBase documentTypeObj: listDocumentType) {
							DocumentTypeDTO documentType = (DocumentTypeDTO)documentTypeObj;
							List<DTOBase> documentTrackingListCompletedbyDocumenttypeThisYear = new ArrayList<DTOBase>();
							for(DTOBase listDocumentTypeThisYearYearObj: listDocumentsCompletedThisYear) {
								DocumentViewDTO documentView = (DocumentViewDTO)listDocumentTypeThisYearYearObj;
								if(documentView.getDocument_type().getCode().equalsIgnoreCase(documentType.getCode())){
									documentTrackingListCompletedbyDocumenttypeThisYear.add(documentView);
								}
							}
							Double percentageOfDocumentTypeCompletedThisYear = (Double.valueOf(StringUtil.getNumToStr(documentTrackingListCompletedbyDocumenttypeThisYear.size(), false))/Double.valueOf(StringUtil.getNumToStr(listDocumentsCompletedThisYear.size(), false))*100);
							%>
							<div class="col-lg-12">
								DOCUMENT TYPE: <%=documentType.getName() %>: <%=documentTrackingListCompletedbyDocumenttypeThisYear.size() %>  or <%=Math.round(percentageOfDocumentTypeCompletedThisYear) %>%
								<div class="progress progress-sm progress-striped active">
									<div class="progress-bar progress-bar-success" style="width: <%=percentageOfDocumentTypeCompletedThisYear %>%"></div>
								</div>
							</div>
						<%}%>
						</div>
					<!-- CURRENT YEAR CURRENT YEAR CURRENT YEAR CURRENT YEAR CURRENT YEAR CURRENT YEAR CURRENT YEAR CURRENT YEAR CURRENT YEAR -->
				<center><button type="button" class="btn btn-default" onclick="javascript:printlayer('thisyears')">Print</button></center>
				</div>
				<div class="row tab-pane" id="thismonth">
				<div class="col-lg-12" id="thismonths">
					<!-- CURRENT MONTH CURRENT MONTH CURRENT MONTH CURRENT MONTH CURRENT MONTH CURRENT MONTH CURRENT MONTH CURRENT MONTH CURRENT MONTH  -->
						<div class="col-lg-12">
						<%HomeUtil homeUtil = new HomeUtil(); %>
						<H3>CREATED DOCUMENTS BY THE MONTH OF <%=homeUtil.getMonthString(DateTimeUtil.getCurrentMonth()+1)%>: <%=listDocumentsCreatedThisMonth.size() %><!-- or 100% PERCENTAGE--></H3>
							<div class="progress progress-m progress-striped active">
						        <div class="progress-bar progress-bar-success" style="width: <%=(Double.valueOf(StringUtil.getNumToStr(listDocumentsCreatedThisMonth.size(), false))/Double.valueOf(StringUtil.getNumToStr(listDocumentsCreatedThisMonth.size(), false))*100)%>%"></div>
						    </div>
					    </div>
						</br>
						<%for(DTOBase documentTypeObj: listDocumentType) {
							DocumentTypeDTO documentType = (DocumentTypeDTO)documentTypeObj;
							List<DTOBase> documentTrackingListbyDocumenttypeThisMonth = new ArrayList<DTOBase>();
							for(DTOBase listDocumenttypeThisMonthObj: listDocumentsCreatedThisMonth) {
								DocumentViewDTO documentView = (DocumentViewDTO)listDocumenttypeThisMonthObj;
								if(documentView.getDocument_type().getCode().equalsIgnoreCase(documentType.getCode())){
									documentTrackingListbyDocumenttypeThisMonth.add(documentView);
								}
							}
							Double percentageOfDocumentType = (Double.valueOf(StringUtil.getNumToStr(documentTrackingListbyDocumenttypeThisMonth.size(), false))/Double.valueOf(StringUtil.getNumToStr(listDocumentsCreatedThisMonth.size(), false))*100);
							%>
							<div class="col-lg-12">
								DOCUMENT TYPE: <%=documentType.getName() %>: <%=documentTrackingListbyDocumenttypeThisMonth.size() %>  or <%=Math.round(percentageOfDocumentType) %>% 
								<div class="progress progress-sm progress-striped active">
						        	<div class="progress-bar progress-bar-success" style="width: <%=percentageOfDocumentType %>%"></div>
						        </div>
					        </div>
						<%}%>
							<div class="col-lg-12">
							<H3>COMPLETED DOCUMENTS BY THE MONTH OF <%=homeUtil.getMonthString(DateTimeUtil.getCurrentMonth()+1)%>: <%=listDocumentsCompletedThisMonth.size() %><!-- or 100% PERCENTAGE--></H3>
								<div class="progress progress-m progress-striped active">
									<div class="progress-bar progress-bar-success" style="width: <%=(Double.valueOf(StringUtil.getNumToStr(listDocumentsCompletedThisMonth.size(), false))/Double.valueOf(StringUtil.getNumToStr(listDocumentsCompletedThisMonth.size(), false))*100)%>%"></div>
								</div>
							</div>
							</br>
							<%for(DTOBase documentTypeObj: listDocumentType) {
								DocumentTypeDTO documentType = (DocumentTypeDTO)documentTypeObj;
								List<DTOBase> documentTrackingListCompletedbyDocumenttypeThisMonth = new ArrayList<DTOBase>();
								for(DTOBase listDocumentTypeThisYearYearObj: listDocumentsCompletedThisMonth) {
									DocumentViewDTO documentView = (DocumentViewDTO)listDocumentTypeThisYearYearObj;
									if(documentView.getDocument_type().getCode().equalsIgnoreCase(documentType.getCode())){
										documentTrackingListCompletedbyDocumenttypeThisMonth.add(documentView);
									}
								}
								Double percentageOfDocumentType = (Double.valueOf(StringUtil.getNumToStr(documentTrackingListCompletedbyDocumenttypeThisMonth.size(), false))/Double.valueOf(StringUtil.getNumToStr(listDocumentsCompletedThisMonth.size(), false))*100);
								%>
								<div class="col-lg-12">
									DOCUMENT TYPE: <%=documentType.getName() %>: <%=documentTrackingListCompletedbyDocumenttypeThisMonth.size() %>  or <%=Math.round(percentageOfDocumentType) %>%
									<div class="progress progress-sm progress-striped active">
										<div class="progress-bar progress-bar-success" style="width: <%=percentageOfDocumentType %>%"></div>
									</div>
								</div>
							<%}%>
					<!-- CURRENT MONTH CURRENT MONTH CURRENT MONTH CURRENT MONTH CURRENT MONTH CURRENT MONTH CURRENT MONTH CURRENT MONTH CURRENT MONTH  -->
						</div>
					<center><button type="button" class="btn btn-default" onclick="javascript:printlayer('thismonths')">Print</button></center>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type = "text/javascript">
	function printlayer(layer) {
		var generator = window.open(",'name,'");
		var layetext = document.getElementById(layer);
		generator.document.write(layetext.innerHTML.replace("Print Me"));
		generator.document.close();
		generator.print();
		generator.close();
	}
	</script>