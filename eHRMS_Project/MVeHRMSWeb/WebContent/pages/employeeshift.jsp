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
		$("#employeesShift").dataTable({
			"sPaginationType" : "full_numbers",
			"bJQueryUI" : true,
			"bAutoWidth" : false,
			"bFilter" : false
		});

		$('#example').dataTable({
			"aLengthMenu" : [ [ 5, 10, 25, -1 ], [ 5, 10, 25, "All" ] ]
		});
	});
</script>
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
</script>
</head>
<body id="dt_example">
	<br>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="table_header" align="center">Employee Shift Timing Update </td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right"><p>
					<a href="/eHRMS/employeesShift.do?method=add"><font color="black">
							<bean:message key="title.add.emp.shift.update" /></font> </a>
				</p>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<logic:empty name="EmloyeeShift">
		<tr>
			<td><bean:message key="empty.record.found" /></td>
		</tr>
	</logic:empty>
	<logic:notEmpty name="EmloyeeShift">
	<div id="container" style="width: 100%; align: left">
		<div id="demo_jui" style="width: 100%;">
			<table id="employeesShift" class="display" width="100%" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
						<th><bean:message key="employee.table.header.column.empid" />
						</th>
						<th><bean:message key="project.page.header" />
						</th>
						<th><bean:message key="label.date"/>
						</th>
						<th><bean:message key="label.hours"/>
						</th>
						<th><bean:message key="label.jobdone"/>
						</th>
						<th><bean:message key="label.remarks"/>
						</th>
						<th>&nbsp;
						</th>
					</tr>
				</thead>
				<tbody>
					<bean:define id="EmloyeeShiftid" name="EmloyeeShift" scope="request" />
					<logic:iterate id="EmloyeeShiftId" name="EmloyeeShift">
						<tr>
							<td><a
								href="/eHRMS/employeesShift.do?method=edit&id=<bean:write name='EmloyeeShiftId' property='id' />"><font
									color="black"><bean:write name="EmloyeeShiftId" property="employee.empId" />
								</font> </a>
							</td>
							<td><bean:write name="EmloyeeShiftId" property="project.name" /></td>
							<td><bean:write name="EmloyeeShiftId" property="date" />
							</td>
							<td><bean:write name="EmloyeeShiftId" property="hours" />
							</td>
							<td><bean:write name="EmloyeeShiftId" property="jobDone" />
							</td>
							<td><bean:write name="EmloyeeShiftId" property="remarks" />
							</td>
							<td><a
								href="/eHRMS/employeesShift.do?method=view&id=<bean:write name='EmloyeeShiftId' property='id' />"><font
									color="black"><bean:message key="common.view"/></font>
							</a></td>
						</tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
	</logic:notEmpty>
</body>
</html>