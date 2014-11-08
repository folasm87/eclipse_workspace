<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	$(function() {
		$("#fromDate").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
	$(function() {
		$("#toDate").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
</script>
</head>
<body>
	<br>
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<th class="table_header"><bean:message key="leaverequest.page.header" /></th>
		</tr>
	</table>
	<p>
	<form id="newemp" action="/eHRMS/leaveRequest.do?method=list"
		method="post">
		<div style="border:solid 1px #000; padding: 5px">
		<table width="100%" cellspacing="0" cellpadding="2" border="0">
			<tr>
				<td colspan="5" align="right"><a
					href="/eHRMS/leaveRequest.do?method=list"><bean:message
							key="go.to.main.page" /> </a>
				</td>
			</tr>
			
			
			<tr>
				<td>
				<bean:message key="employee.table.header.column.empid" />
				</td>
				<td colspan="4">
				<bean:write name="leaveRequestForm"
						property="employee.id" />
				</td>
			</tr>
			
			<tr>
				<td><bean:message key="leaverequest.table.leaveType" />
				</td>
				<td>
				<bean:write name="leaveRequestForm"
						property="leaveType" />
								
				</td>
				
			</tr>
	
			<tr>
				<td><bean:message key="leaverequest.table.fromDate" />
				</td>
				<td>
				<bean:write name="leaveRequestForm"
						property="fromDate" />
				&nbsp;
				</td>
			</tr>
				<tr>
				<td><bean:message key="leaverequest.table.toDate" />
				</td>
				<td>
				<bean:write name="leaveRequestForm"
						property="toDate" />
				&nbsp;
				</td>
			</tr>
			
			<tr>
				<td><bean:message key="leaverequest.table.noofdays" />
				</td>
				<td>
				<bean:write name="leaveRequestForm"
						property="noOfDays" />
				&nbsp;
				</td>
			</tr>
			
				<tr>
				<td>
				<bean:message key="leaverequest.table.reason" />
				</td>
				<td>
				<bean:write name="leaveRequestForm"
						property="reason" />
				</td>
			</tr>
			
			
			
			<tr>
				<td>&nbsp;</td>
				<td><html:submit styleClass="button_background" value="Close" />
				</td>
				<td colspan="3">&nbsp;</td>
			</tr>
		</table>
		</div>
	</form>
</html>