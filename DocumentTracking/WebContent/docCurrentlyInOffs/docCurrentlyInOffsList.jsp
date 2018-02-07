<%@ page import="java.util.*" %>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.pagination.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.ezshop.dto.*" %>  
<%@ page import="com.ezshop.util.*" %>

<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
DocCurrentlyInOffsDTO docCurrentlyInOffs = (DocCurrentlyInOffsDTO)session.getAttribute(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS);
	Pagination pagination = (Pagination)session.getAttribute(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS_PAGINATION);
	//List<DTOBase> forward = (ArrayList<DTOBase>) session.getAttribute(ActiveOfficeDTO.SESSION_ACTIVE_OFFICE_LIST);
	List<DTOBase> documenttype = (ArrayList<DTOBase>) session.getAttribute(DocumentTypeDTO.SESSION_DOCUMENT_TYPE_LIST);
	List<DTOBase> list = pagination.getCurrentPageRecordList();
	
	//Variable Data
	DocCurrentlyInOffsDTO selectedRecord = (DocCurrentlyInOffsDTO)session.getAttribute(DocCurrentlyInOffsDTO.SESSION_DOC_CURRENTLY_IN_OFFS);
	//Variable Data
%>

<div class="dataTables_wrapper form-inline dt-bootstrap col-md-12">
	<%=WebUtil.getPaginationHeader(sessionInfo, sessionInfo.getCurrentPagination(), "searchByNameCode", "Search Name or Code") %>		
	<%=WebUtil.getTableByCode(sessionInfo, "table table-bordered table-striped table-hover dataTable", "table table-bordered table-striped dataTable", DocCurrentlyInOffsUtil.getTableHeader(), DocCurrentlyInOffsUtil.getTableBody(list), "gradeX", selectedRecord.getCode()) %>
			    <%-- <tr role="row">
		    	<td><%=docCurrentlyInOffs.getCode()%></td>
		        <td><%=docCurrentlyInOffs.getName()%></td>
		        <td><%=docCurrentlyInOffs.getDescription()%></td>
		        <td align="center">
		        <%
	        	LinkButtonWebControl linkButtonView = new LinkButtonWebControl(sessionInfo, "", sessionInfo.getLinkByCode("U228").getImgSource(), false, "onclick=\"recordAction('" + docCurrentlyInOffs.getId() + "', 'U275')\"");
		       // if(sessionInfo.getCurrentUser().getCode().equalsIgnoreCase(doc.getAddedBy())) {
		        	if(sessionInfo.isCurrentUserHasLink("U228")) {
			        	LinkButtonWebControl linkButtonUpdate = new LinkButtonWebControl(sessionInfo, "", sessionInfo.getLinkByCode("U228").getImgSource(), false, "onclick=\"recordAction('" + docCurrentlyInOffs.getId() + "', 'U228')\"");
		        %>
		        		<%=linkButtonUpdate.getLinkButtonWebControl()%>
		        <%	
		        	}
		      //  }
		        %>
		        	<%=linkButtonView.getLinkButtonWebControl()%>
		        </td>
		    </tr> --%>
	<%=WebUtil.getPaginationFooter(sessionInfo) %>
</div>
