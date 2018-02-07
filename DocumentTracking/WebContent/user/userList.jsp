<%@ page import="java.util.*" %>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.pagination.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.mytechnopal.dto.*" %>
<%@ page import="com.mytechnopal.dao.*" %>
<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	Pagination pagination = (Pagination)session.getAttribute(UserDTO.SESSION_USER_PAGINATION);
	List<DTOBase> list = (ArrayList) pagination.getCurrentPageRecordList();
	UserUtil.setUserList(list, new UserGroupDAO().getUserGroupList(true), new CityDAO().getCityList(), new ReligionDAO().getReligionList());
	//Variable Data
	UserDTO selectedUser = (UserDTO)session.getAttribute(UserDTO.SESSION_USER);
	//Variable Data
%>

<div class="dataTables_wrapper form-inline dt-bootstrap col-md-12">
	<%=WebUtil.getPaginationHeader(sessionInfo, "searchByNameCode", "Search User") %>	
	<%=WebUtil.getTableById(sessionInfo, "table table-striped table-hover", "table", new String[] {"ID",  "Last Name", "First Name", "Middle Name", "Group", ""}, UserUtil.getTable(list), "gradeX", selectedUser.getId()) %>
	<%=WebUtil.getPaginationFooter(sessionInfo) %>
</div>