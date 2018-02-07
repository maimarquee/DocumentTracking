<%@ page import="java.util.*" %>
<%@ page import="com.mytechnopal.*" %>
<%@ page import="com.mytechnopal.dto.*" %>
<%@ page import="com.mytechnopal.util.*" %>
<%@ page import="com.mytechnopal.webcontrol.*" %>

<%
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(SessionInfo.SESSION_INFO);
	UserDTO user = (UserDTO)session.getAttribute(UserDTO.SESSION_USER);
	List<DTOBase> userGroupList = (ArrayList<DTOBase>)session.getAttribute(UserGroupDTO.SESSION_USER_GROUP_LIST);
%>
<div class="col-sm-12">Name: <%=user.getName(false)%></div>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-3", "Username", "Username", "UserName", user.getUserName(), 16, WebControlBase.DATA_TYPE_STRING, "") %>
<%=new TextBoxWebControl().getTextBoxWebControl(sessionInfo, "col-sm-3", "Password", "Password", "Password", user.getPassword(), 16, WebControlBase.DATA_TYPE_STRING, "") %>
<%=new ComboBoxWebControl().getComboBoxWebControl(sessionInfo, "col-sm-2", "Group", "UserGroup", userGroupList, user.getUserGroup(), "", "", "") %>
<%=new RadioButtonWebControl().getRadioButtonWebControl(sessionInfo, "col-sm-4", "Status", true, "Status", new String[] {"Active", "Inactive"}, user.isActive()?"Active":"Inactive", "") %>

<div class="col-lg-12">
	<div class="panel panel-default">
<%
int subLinkCtr = 0;
for(int i=0; i<sessionInfo.getMainLinkList().size(); i++) {
	LinkDTO mainLink = (LinkDTO)sessionInfo.getMainLinkList().get(i);
	if(!mainLink.getCode().equalsIgnoreCase("G001")) { //Login 
		LinkDTO previousMainLink = null;
		LinkDTO nextMainLink = null;
		if(i >= 1) {
			previousMainLink = (LinkDTO)sessionInfo.getMainLinkList().get(i-1);
		}
		if(i < sessionInfo.getMainLinkList().size()-1) {
			nextMainLink = (LinkDTO)sessionInfo.getMainLinkList().get(i+1);
		}
		
		if(mainLink.isMainMenu()) {	
%>
		<div class="panel-heading">
	<%-- 	 <input type="checkbox" id="chk<%=mainLink.getCode()%>" name="chk<%=mainLink.getCode()%>" style="vertical-align:top" >&nbsp;&nbsp;--%> 	<%=mainLink.getLabel()%> 
<%-- 		<%
		for(LinkDTO link: sessionInfo.getParentMainLinkListByParentLinkGroup(mainLink.getLinkGroup())) {
		%>
			<%=link.getCode() + "-" + link.getLabel() %>
		<%
		}
		%>  --%>
		
		</div>
<%	
		}
		else {
			if(previousMainLink != null && previousMainLink.isMainMenu()) {
%>
			<div class="panel-body">
	        	<div class="table-responsive">
	            	<table class="table table-striped table-bordered table-hover">
	                	<thead>
	                	</thead>
	                	<tbody>
	                       
<%
			}
			subLinkCtr++;
			if(subLinkCtr == 1) {
%>			
							<tr>
<%									
			}
			boolean hasLink = false;
			if(sessionInfo.isLinkExist(user.getUserLinkList(), mainLink)) {
				hasLink = true;
			}
			if(sessionInfo.isCurrentLinkDataEntry()) {
%>
								<td>&nbsp;&nbsp;&nbsp;<input type="checkbox" id="chk<%=mainLink.getCode()%>" name="chkUserLink" value="<%=mainLink.getCode()%>" <%=hasLink?"checked":""%>>&nbsp;<%=mainLink.getLabel()%></td>
<%				
			}	
			else {
				String iconStr = hasLink?"glyphicon glyphicon-ok":"glyphicon glyphicon-remove";
%>
								<td><span class="<%=iconStr%>" aria-hidden="true"></span>&nbsp;<%=mainLink.getLabel()%></td>
<%				
			}
%>	
<%
			if(i == sessionInfo.getMainLinkList().size()-1 || (nextMainLink != null && nextMainLink.isMainMenu()) || subLinkCtr == 5){
				subLinkCtr = 0;
%>
							</tr>			
<%			
			}
			if(i == sessionInfo.getMainLinkList().size()-1 || (nextMainLink != null && nextMainLink.isMainMenu())) {
				subLinkCtr = 0;
%>																	

						</tbody>
					</table>
				</div>	
			</div>	
<%		
			}
		}
	}
}
%>	
	</div>
</div>
<%=new TransitionButtonWebControl().getTransitionButtonWebControl(sessionInfo, "col-sm-12", "btn btn-default", "align='center'") %>  

