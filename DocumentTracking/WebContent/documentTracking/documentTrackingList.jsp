<%@ page import="java.util.*" %>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.pagination.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.ezshop.dto.*" %>  
<%@ page import="com.ezshop.util.*" %>

<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	Pagination pagination = (Pagination)session.getAttribute(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING_PAGINATION);
	//List<DTOBase> list = pagination.getRecordList();
	List<DTOBase> list = pagination.getCurrentPageRecordList();
	
	//Variable Datas
	DocumentTrackingDTO selectedRecord = (DocumentTrackingDTO)session.getAttribute(DocumentTrackingDTO.SESSION_DOCUMENT_TRACKING);
%>

<div class="dataTables_wrapper form-inline dt-bootstrap col-md-12">
	<%=WebUtil.getPaginationHeader(sessionInfo, sessionInfo.getCurrentPagination(), "searchByNameCode", "Search Name or Code") %>		
	<%=WebUtil.getTableByCode(sessionInfo, "table table-bordered table-striped table-hover dataTable", "table table-bordered table-striped dataTable", DocumentTrackingUtil.getTableHeader(), DocumentTrackingUtil.getTableBody(list), "gradeX", selectedRecord.getCode()) %>
	<%=WebUtil.getPaginationFooter(sessionInfo) %>
</div>

 
 
 