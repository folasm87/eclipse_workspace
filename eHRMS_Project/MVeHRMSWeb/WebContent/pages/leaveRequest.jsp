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
		$("#leaveRequest").dataTable({
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
<form  action="/eHRMS/leaveRequest.do?method=list"
		method="post">
	<br>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="table_header" align="center">Leave Request
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<logic:equal value="E" name="leaveRequestForm"  property="type" >
		<tr>
			<td align="right"><p>
					<a href="/eHRMS/leaveRequest.do?method=add"><font color="black">
				<bean:message key="leaverequest.table.addnewleaverquest" /></font> </a>
				</p>
			</td>
		</tr>
	</logic:equal>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	
	<logic:messagesPresent message="true">	
			<tr>
				<td colspan="5" class="msg_bg"><html:errors /> <html:messages
						id="leave_add_status" message="true">
						<bean:write name="leave_add_status" />
					</html:messages></td>
			</tr>
	</logic:messagesPresent>
		<logic:equal value="E" name="leaveRequestForm"  property="type" >
	<logic:empty name= "leaveRequest">
	<tr>
	<td>
	<bean:message key="empty.record.found" />
	</td>
	</tr>
	
	</logic:empty>
	</logic:equal>
	
	
	<logic:notEmpty name = "leaveRequest">
		<div id="container" style="width: 100%; align: left">
		<div id="demo_jui" style="width: 100%;">
			<table id="leaveRequest" class="display" width="100%" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
						<th>
						<bean:message key="employee.table.header.column.empid" />
						</th>
						<th><bean:message key="leaverequest.table.leaveType" />
						</th>
						<th><bean:message key="leaverequest.table.fromDate" />
						</th>
						<th><bean:message key="leaverequest.table.toDate" />
						</th>
						<th><bean:message key="leaverequest.table.reason" />
						</th>
						<th><bean:message key="leaverequest.table.status" />
						</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<bean:define id="leaveRequest" name="leaveRequest" scope="request" />
					<logic:iterate id="leave" name="leaveRequest">
						<tr>
							<td><a
								href="/eHRMS/leaveRequest.do?method=edit&id=<bean:write name='leave' property='id' />"><font
									color="black"><bean:write name="leave" property="employee.empId" />
								</font> </a>
							</td>
							<td><bean:write name="leave" property="leaveType" />
							</td>
							<td><bean:write name="leave" property="fromDate" />
							</td>
							<td><bean:write name="leave" property="toDate" />
							</td>
							<td><bean:write name="leave" property="reason" />
							</td>
							<td><bean:write name="leave" property="status" />
							</td>
							
							<td><a
								href="/eHRMS/leaveRequest.do?method=view&id=<bean:write name='leave' property='id' />"><font
									color="black"><bean:message key="common.view" /> </font>
							</a>&nbsp;&nbsp;
								</td>
						</tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
	</logic:notEmpty>
</form>
</body>
</html>