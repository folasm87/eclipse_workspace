<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="jquery/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="jquery/jquery.DOMWindow.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="jquery/jquery.dataTables.css" />
<script>
	$(function() {
		$("#resignDate").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
</script>
<script type="text/javascript">
	function closeWindow() {
		document.getElementById("inlineContent").style.display = "none";
	}
	function addRecord() {
		document.getElementById("formEm").action = "employeeprojectmapping.do?method=add";
		document.getElementById("formEm").submit();
	}
</script>
<script type="text/javascript">
	$(function() {
		$("#employeeProjectMaping").dataTable({
			"sPaginationType" : "full_numbers",
			"bJQueryUI" : true,
			"bAutoWidth" : false,
			"bFilter" : false
		});
	});
</script>
</head>
<body id="dt_example">
	<br>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="table_header" align="center"><bean:message
					key="employeemapping.page.header" /></td>
		</tr>
		<logic:messagesPresent message="true">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="5" class="msg_bg"><html:errors /> <html:messages
						id="employee_project_add_status" message="true">
						<bean:write name="employee_project_add_status" />
					</html:messages>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</logic:messagesPresent>
		<tr>
			<td><div style="border: 1px solid #000; padding: 20px;">
					<form id="formEm"
						action="/eHRMS/employeeprojectmapping.do?method=list"
						method="post">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td height="50px;"><bean:message
										key="employee.select.project" /></td>
								<td><html:select property="project.id"
										name="employeeprojectmappingForm" styleClass="input_field">
										<html:options collection="PROJECTS" property="id"
											labelProperty="name" />
									</html:select></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td width="50%" colspan="2" align="center" height="50px"><html:submit
										styleClass="button_background">
										<bean:message key="employee.getresource.List" />
									</html:submit> <html:button property="add" onclick="addRecord()"
										styleClass="button_background">
										<bean:message key="employee.add.resource" />
									</html:button></td>
							</tr>
						</table>
					</form>
				</div></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<logic:notEmpty name="EMPLOYEEPROJECTMAPING">

		<div id="container" style="width: 100%; align: left">
			<div id="demo_jui" style="width: 100%;">
				<table id="employeeProjectMaping" class="display" width="100%"
					cellpadding="0" cellspacing="0">
					<thead>
						<tr>
							<th><bean:message key="employee.sino" />
							</th>
							<th><bean:message key="employee.table.header.column.empname" />
							</th>
							<th><bean:message
									key="project.table.header.column.startdate" /></th>
							<th><bean:message key="project.table.header.column.enddate" />
							</th>
						</tr>
					</thead>
					<tbody>
						<bean:define id="employeeProject" name="EMPLOYEEPROJECTMAPING" />
						<%
							int i = 1;
						%>
						<logic:iterate id="emp" name="employeeProject">
							<tr>
								<td><a
									href="/eHRMS/employeeprojectmapping.do?method=edit&id=<bean:write name='emp' property='id' />"><font
										color="black"><%=i%></font> </a></td>
								<td><bean:write name="emp" property="employee.name" /></td>
								<td><bean:write name="emp" property="startDate" />
								</td>
								<td><bean:write name="emp" property="endDate" />
								</td>
							</tr>
							<%
								i++;
							%>
						</logic:iterate>
					</tbody>
				</table>
			</div>
		</div>
	</logic:notEmpty>

</body>
</html>