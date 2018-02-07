<%@ page import="java.util.*" %>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.pagination.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.ezshop.dto.*" %>  
<%@ page import="com.ezshop.util.*" %>

<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	Pagination pagination = (Pagination)session.getAttribute(StaffDTO.SESSION_STAFF_PAGINATION);
	List<DTOBase> office = (ArrayList<DTOBase>)session.getAttribute(OfficeDTO.SESSION_OFFICE_LIST);
	List<DTOBase> list = StaffUtil.getStaffList((ArrayList<DTOBase>) pagination.getCurrentPageRecordList());
	
	//Variable Data
	StaffDTO selectedRecord = (StaffDTO)session.getAttribute(StaffDTO.SESSION_STAFF);
	//Variable Data
%>
<div class="dataTables_wrapper form-inline dt-bootstrap col-md-12">
	<%=WebUtil.getPaginationHeader(sessionInfo, sessionInfo.getCurrentPagination(), "searchByNameCode", "Search Staff") %>		
	<%=WebUtil.getTableByCode(sessionInfo, "table table-bordered table-striped table-hover dataTable", "table table-bordered table-striped dataTable", StaffUtil.getTableHeader(), StaffUtil.getTableBody(list), "gradeX", selectedRecord.getCode()) %>
	<%=WebUtil.getPaginationFooter(sessionInfo) %>
</div>