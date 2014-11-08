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
<script type="text/javascript">
	$(document).ready(function() {
		$("#employees").dataTable({
			"sPaginationType" : "full_numbers",
			"bJQueryUI" : true,
			"bAutoWidth" : false,
			"bFilter" : true
		});

		$('#example').dataTable({
			"aLengthMenu" : [ [ 5, 10, 25, -1 ], [ 5, 10, 25, "All" ] ]
		});
	});
</script>
<script type="text/javascript">
	function closeWindow() {
		document.getElementById("inlineContent").style.display = "none";
	}
</script>
</head>
<body id="dt_example">
	<br>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="table_header" align="center"><bean:message
					key="employee.page.header" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right"><p>
					<a href="/eHRMS/employees.do?method=add"><font color="black">
							<bean:message key="employee.add.page.header" /> </font> </a>
				</p></td>
		</tr>
		<logic:notEmpty name="ANNIV_EMP">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Employees celebrating their anniversary for this month: 
						<bean:write name="ANNIV_EMP" />
				</td>
			</tr>
		</logic:notEmpty>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="container" style="width: 100%; align: left">
		<div id="demo_jui" style="width: 100%;">
			<table id="employees" class="display" width="100%" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
						<th><bean:message key="employee.table.header.column.empid" />
						</th>
						<th><bean:message key="employee.table.header.column.empname" />
						</th>
						<th><bean:message key="employee.table.header.column.dob" />
						</th>
						<th><bean:message key="employee.table.header.column.mobile" />
						</th>
						<th><bean:message key="employee.table.header.column.oemail" />
						</th>
						<th><bean:message key="employee.table.header.column.jdate" />
						</th>
						<th><bean:message key="employee.table.header.column.desig" />
						</th>
						<th><bean:message key="sysrole.table.header.column.role" />
						</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<bean:define id="employees" name="EMPLOYEES" scope="request" />
					<logic:iterate id="emp" name="employees">
						<tr>
							<td><a
								href="/eHRMS/employees.do?method=edit&id=<bean:write name='emp' property='id' />"><font
									color="black"><bean:write name="emp" property="empId" />
								</font> </a></td>
							<td><bean:write name="emp" property="name" /></td>
							<td><bean:write name="emp" property="dob" /></td>
							<td><bean:write name="emp" property="mobile" /></td>
							<td><bean:write name="emp" property="workEmailId" /></td>
							<td><bean:write name="emp" property="joinDate" /></td>
							<td><bean:write name="emp" property="jobTitle" /></td>
							<td><bean:write name="emp" property="role.name" /></td>
							<td><a
								href="/eHRMS/employees.do?method=view&id=<bean:write name='emp' property='id' />"><font
									color="black">View 
							</a>&nbsp;&nbsp;<a
								href="/eHRMS/employees.do?method=delete&id=<bean:write name='emp' property='id' />">Resign</a>
								</font>
							</td>
						</tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>