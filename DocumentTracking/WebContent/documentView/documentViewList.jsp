<%@ page import="java.util.*" %>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.pagination.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.ezshop.dto.*" %>  
<%@ page import="com.ezshop.util.*" %>

<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	Pagination pagination = (Pagination)session.getAttribute(DocumentViewDTO.SESSION_DOCUMENT_VIEW_PAGINATION);
	List<DTOBase> documenttype = (ArrayList<DTOBase>) session.getAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST);
	List<DTOBase> list = pagination.getCurrentPageRecordList();
	
	//Variable Data
	DocumentViewDTO selectedRecord = (DocumentViewDTO)session.getAttribute(DocumentViewDTO.SESSION_DOCUMENT_VIEW);
	//Variable Data
%>

<div class="dataTables_wrapper form-inline dt-bootstrap col-md-12">
	<%=WebUtil.getPaginationHeader(sessionInfo, sessionInfo.getCurrentPagination(), "searchByNameCode", "Search Name or Code") %>		
	<%=WebUtil.getTableByCode(sessionInfo, "table table-bordered table-striped table-hover dataTable", "table table-bordered table-striped dataTable", DocumentViewUtil.getTableHeader(), DocumentViewUtil.getTableBody(list), "gradeX", selectedRecord.getCode()) %>
	<%=WebUtil.getPaginationFooter(sessionInfo) %>
</div>
