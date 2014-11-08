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
		$("#tasks").dataTable({
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
</head>
<body id="dt_example">
	<br>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="table_header" align="center"><bean:message key="task.page.header" />
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right"><p>
					<a href="/eHRMS/tasks.do?method=add"><font color="black">
							<bean:message key="task.add.page.header" /> </font> </a>
				</p></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="container" style="width: 100%; align: left">
		<div id="demo_jui" style="width: 100%;">
			<table id="tasks" class="display" width="100%" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
						<th><bean:message key="task.table.header.column.taskid" />
						</th>
						<th><bean:message key="task.table.header.column.taskname" />
						</th>
						<th><bean:message key="task.table.header.column.estimatedHours" />
						</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<bean:define id="tasks" name="TASKS" scope="request" />
					<logic:iterate id="task" name="tasks">
						<tr>
							<td><a
								href="/eHRMS/tasks.do?method=edit&id=<bean:write name='task' property='id' />"><font
									color="black"><bean:write name="task"
											property="taskId" /> </font> </a></td>
							<td><bean:write name="task" property="name" /></td>
							<td><bean:write name="task" property="estimatedHours" /></td>
							<td><a
								href="/eHRMS/tasks.do?method=view&id=<bean:write name='task' property='id' />"><font
									color="black">View</font>
							</a>
							</td>
						</tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>