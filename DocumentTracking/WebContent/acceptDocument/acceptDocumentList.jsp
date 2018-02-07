<%@ page import="java.util.*" %>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.pagination.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.ezshop.dto.*" %>  
<%@ page import="com.ezshop.util.*" %>

<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	Pagination pagination = (Pagination)session.getAttribute(AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT_PAGINATION);
	//List<DTOBase> forward = (ArrayList<DTOBase>) session.getAttribute(ActiveOfficeDTO.SESSION_ACTIVE_OFFICE_LIST);
	List<DTOBase> documenttype = (ArrayList<DTOBase>) session.getAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST);
	List<DTOBase> list = pagination.getCurrentPageRecordList();
	//List<DTOBase> list = StaffUtil.getStaffList((ArrayList<DTOBase>) pagination.getCurrentPageRecordList());
	
	
	//Variable Data
	AcceptDocumentDTO selectedRecord = (AcceptDocumentDTO)session.getAttribute(AcceptDocumentDTO.SESSION_ACCEPT_DOCUMENT);
	//Variable Data
%>

<div class="dataTables_wrapper form-inline dt-bootstrap col-md-12">
	<%=WebUtil.getPaginationHeader(sessionInfo, sessionInfo.getCurrentPagination(), "searchByNameCode", "Search Name or Code") %>		
	<%=WebUtil.getTableByCode(sessionInfo, "table table-bordered table-striped table-hover dataTable", "table table-bordered table-striped dataTable", AcceptDocumentUtil.getTableHeader(), AcceptDocumentUtil.getTableBody(list), "gradeX", selectedRecord.getCode()) %>
	<%=WebUtil.getPaginationFooter(sessionInfo) %>
</div>
