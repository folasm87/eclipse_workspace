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
<link rel="stylesheet" type="text/css"   href="jquery/jquery.dataTables.css" />

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
	function addRecord(){
	document.getElementById("formEm").action="employeemodulemapping.do?method=add";
	document.getElementById("formEm").submit();
	}
</script>
</head>
<body id="dt_example">
	<br>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="table_header"><bean:message
					key="employee.page.header" />
			</td>
		</tr>
		<tr>
			<td>
				<form id="formEm" action="/eHRMS/employeemodulemapping.do?method=list"
		method="post">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
				<td>Select the Module</td>
				<td>
				<html:select property="module.id" name="employeemodulemappingForm">
				
				<html:options collection="MODULES" property="id"
							labelProperty="name" />
				</html:select>
				</td>
				</tr>
				<tr><td colspan="2" align="center">
				<html:submit>Get List</html:submit>
				<html:button property="add" onclick="addRecord()">Add Module Mapping</html:button>
				
				</td></tr>
				</table>
				</form>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<logic:notEmpty name="EMPLOYEEPROJECTMAPING">

	<div id="container" style="width: 100%; align: left">
		<div id="demo_jui" style="width: 100%;">
			<table id="employeeModuleMaping" class="display" width="100%" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
					<th>Sl.No</th>
						<th>Name						</th>
					<th>&nbsp;</th>
						
					</tr>
				</thead>
				<tbody>
				<bean:define id="employeeModule" name="EMPLOYEEPROJECTMAPING" />
				<%int i=1; %>
					<logic:iterate id="emp" name="employeeModule">
						<tr>
							<td><!-- <a
								href="/eHRMS/employeemodulemapping.do?method=edit&id=<bean:write name='emp' property='id' />"><font
									color="black">
								</font> </a> --><%=i %>
							</td>
							<td><bean:write name="emp" property="employee.name" />
							</td>
							
							<td><a
								href="/eHRMS/employeemodulemapping.do?method=delete&id=<bean:write name='emp' property='id' />">
								<font color="black">Delete</font> 
							</a>&nbsp;&nbsp;<!-- <a
								href="/eHRMS/employeemodulemapping.do?method=delete&id=<bean:write name='emp' property='id' />">
								<font color="black">Delete</font></a>-->
								</td>
						</tr>
						<%i++; %>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
		<script type="text/javascript">
	$(function() {
		$("#employeeModuleMaping").dataTable({
			"sPaginationType" : "full_numbers",
			"bJQueryUI" : true,
			"bAutoWidth" : false,
			"bFilter" : false
		});
});
</script>
	</logic:notEmpty>
</body>
</html>