<%@page import="com.multivision.ehrms.business.SubMenuManagement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ page import="com.multivision.ehrms.business.RoleMenuAccess"%>

<%@page import="java.util.*"%>
<script>
	$(function() {
		$("#accordion").accordion();
	});
</script>

<div class="demo">
	<div id="accordion">
		<h3><a href="#"><bean:message key="label.home" /></a></h3>
		<div>
		<!--
		<table width="100%" border="0" cellpadding="3">
			<tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/home.do?method=list"><bean:message key="label.home" /></a></td>
			</tr>
		</table>
		-->
		<a style="margin-left:10%;" href="/eHRMS/home.do?method=list"><bean:message key="label.home" /></a>
		</div>

<%
List<RoleMenuAccess> menuList = (List<RoleMenuAccess>)session.getAttribute("menList");

boolean flag = false;
//for(int i=0;i<menuList.size();i++){
for( RoleMenuAccess roleMenuAccess : menuList ) {
	//RoleMenuAccess roleMenuAccess = menuList.get(i);
	SubMenuManagement submenu = roleMenuAccess.getSubMenuManagement(); 

	if( submenu.getParentid().getName().equalsIgnoreCase("Access Management") && flag == false ) { %>
		<h3><a href="#"><bean:message key="label.access.management" /></a></h3>
		<div>
		<%
		flag = true;
	}
	if( submenu.getName().equalsIgnoreCase("Role")) { %>
		<table width="100%" border="0" cellpadding="3">
			<tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/systemRoles.do">
				<bean:message key="sysrole.table.header.column.role" />
				</a>
				</td>
			</tr>
		</table>
	<%
	}
}
if( flag == true ) { %></div><% }

//List<RoleMenuAccess> menuList1 = (List<RoleMenuAccess>)session.getAttribute("menList");
flag = false;	
//for(int i=0;i<menuList1.size();i++){
for(int i=0;i<menuList.size();i++){
	RoleMenuAccess roleMenuAccess = menuList.get(i);

	if(roleMenuAccess.getSubMenuManagement().getParentid().getName().equalsIgnoreCase("Employee Management")
	&& flag == false) {
		%>
		<h3><a href="#"><bean:message key="label.employee.management" /></a></h3>
		<div>
		<%
		flag = true;
	}
	
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Employee")){ %>
		<table width="100%" border="0" cellpadding="3">
			<tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/employees.do?method=list">
				<bean:message key="employee.page.header" />
				</a>
				</td>
			</tr>
		</table>
	<%
	}
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Leave Request")){ %>
		<table width="100%" border="0" cellpadding="3">
			<tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/leaveRequest.do?method=list">
				<bean:message key="leaverequest.page.header" />
				</a>
				</td>
			</tr>
		</table>
	<%
	}
}



if( flag == true ) { %></div><% }

flag = false;
//List<RoleMenuAccess> menuList2 = (List<RoleMenuAccess>)session.getAttribute("menList");
for( int i=0; i<menuList.size(); i++ ){
	RoleMenuAccess roleMenuAccess = menuList.get(i);
	if(roleMenuAccess.getSubMenuManagement().getParentid().getName().equalsIgnoreCase("Project Management")
		&& flag == false) {%>
		<h3><a href="#"><bean:message key="projectmanagement.page.header" /></a></h3>
		<div>
	<%	flag = true;
	}
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Project")){ %>
		<table width="100%" border="0" cellpadding="3">	
			<tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/projects.do?method=list">
				<bean:message key="project.page.header" />
				</a>
				</td>
			</tr>
		</table>
	<%
	}
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Resource Mapping")) {
		%>
		<table width="100%" border="0" cellpadding="3">
			<tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/employeeprojectmapping.do?method=getProjects">
				<bean:message key="resourcemapping.page.header" />
				</a>
				</td>
			</tr>
		</table>
	<%
	}
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Task Management")) {
		%>
		<table width="100%" border="0" cellpadding="3">
			 <tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/tasks.do?method=list">
				<bean:message key="task.page.header" />
				</a>
				</td>
			</tr>
			<%-- <tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/taskNull.do">
				<bean:message key="task.page.header" />
				</a>
				</td>
			</tr> --%>
		</table>
	<%
	}
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Resource Management")) {
		%>
		<table width="100%" border="0" cellpadding="3">
			<tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/resources.do?method=list">
				<bean:message key="resource.page.header" />
				</a>
				</td>
			</tr>
		</table>
	<%
	}
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Issues")) {
		%>
		<table width="100%" border="0" cellpadding="3">
			<tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/issues.do?method=list">
				<bean:message key="issue.page.header" />
				</a>
				</td>
			</tr>
		</table>
	<%
	}
}
if( flag == true ) { %></div><% }

flag = false;
//List<RoleMenuAccess> menuList3 = (List<RoleMenuAccess>)session.getAttribute("menList");
for( int i=0; i<menuList.size(); i++ ) {
	RoleMenuAccess roleMenuAccess = menuList.get(i);	
	if(roleMenuAccess.getSubMenuManagement().getParentid().getName().equalsIgnoreCase("Requirement Management")
		&& flag == false){%>
		<h3><a href="#"><bean:message key="requirementmanagement.page.header" /></a></h3>
		<div>
		<%
		flag = true;
	}
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Requirement")){ %>
		<table width="100%" border="0" cellpadding="3">
			<tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/requirement.do?method=list">
				<bean:message key="requirement.page.header" />
				</a>
				</td>
			</tr>
		</table>
	<%
	}
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Candidate Search")){ %>
		<table width="100%" border="0" cellpadding="3">

		<tr>
			<td width="10%">&nbsp;</td>
			<td><a href="/eHRMS/applicantSearch.do?method=add">
			<bean:message key="candidate.page.header" />
			</a>
			</td>
		</tr>
		</table>
	<%
	}
}
if( flag == true ) { %></div><% }

flag = false;
//List<RoleMenuAccess> menuList4 = (List<RoleMenuAccess>)session.getAttribute("menList");
for( int i=0; i < menuList.size(); i++ ) {
	RoleMenuAccess roleMenuAccess = menuList.get(i);
	
	if(roleMenuAccess.getSubMenuManagement().getParentid().getName().equalsIgnoreCase("Applicant Management")
		&& flag == false){%>	
		<h3><a href="#"><bean:message key="applicantmanagment.page.header" /></a></h3>
		<div>
		<%
		flag = true;
	}
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Update Profile")){
	%>
		<table width="100%" border="0" cellpadding="3">
			<tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/applicant.do?method=add">
				<bean:message key="applicantregister.page.header" />
				</a>
				</td>
			</tr>
		</table>
	<%
	}
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Job Search")){ %>
		<table width="100%" border="0" cellpadding="3">
			<tr>
			<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/jobSearch.do?method=list">
				<bean:message key="jobsearch.page.header" />
				</a>
				</td>
			</tr>
		</table>
	<%}
}
if( flag == true ) { %></div><% }

flag = false;
//List<RoleMenuAccess> menuList5 = (List<RoleMenuAccess>)session.getAttribute("menList");
for(int i=0;i<menuList.size();i++){
	RoleMenuAccess roleMenuAccess = menuList.get(i);	
	
	if(roleMenuAccess.getSubMenuManagement().getParentid().getName().equalsIgnoreCase("Time Sheet Management")
		&& flag == false){%>	
		<h3><a href="#"><bean:message key="timesheet.page.header" /></a></h3>
		<div>
		<%
		flag = true;
	}
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Employee Shift Time Update")){ %>
		<table width="100%" border="0" cellpadding="3">
			<tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/employeesShift.do?method=list">
				<bean:message key="employeetimesheet.page.header" />
				</a>
				</td>
			</tr>
		</table>
	<%
	}
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Leave Approval")) { %>
		<table width="100%" border="0" cellpadding="3">
			<tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/leaveApproval.do?method=list">
				<bean:message key="leaveapproval.page.header" />
				</a>
				</td>
			</tr>
		</table>
	<%
	}
}

if( flag == true ) { %></div><% }

//List<RoleMenuAccess> menuList1 = (List<RoleMenuAccess>)session.getAttribute("menList");
flag = false;	
//for(int i=0;i<menuList1.size();i++){
for(int i=0;i<menuList.size();i++){
	RoleMenuAccess roleMenuAccess = menuList.get(i);

	if(roleMenuAccess.getSubMenuManagement().getParentid().getName().equalsIgnoreCase("Inventory Management")
	&& flag == false) {
		%>
		<h3><a href="#"><bean:message key="label.inventory.management" /></a></h3>
		<div>
		<%
		flag = true;
	}
	
	if(roleMenuAccess.getSubMenuManagement().getName().equalsIgnoreCase("Add New Item")){ %>
		<table width="100%" border="0" cellpadding="3">
			<tr>
				<td width="10%">&nbsp;</td>
				<td><a href="/eHRMS/addNewItemNull.do">
				<bean:message key="addnewitem.page.header" />
				</a>
				</td>
			</tr>
		</table>
	<%
	}

}
if( flag == true ) { %></div><% }

%>
	</div> <!-- End accordian group -->
</div> <!-- End menu group -->