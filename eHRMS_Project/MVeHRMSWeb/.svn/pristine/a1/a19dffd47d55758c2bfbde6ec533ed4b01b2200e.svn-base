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
			<th class="table_header">
			<bean:message key="leaveapproval.title" />
		</th>
		</tr>
	</table>
	<p>
		<bean:message key="leaveapproval.page.info" />
	</p>
	<p>
	<form id="newemp" action="/eHRMS/saveLeaveRequestApproval.do?method=save"
		method="post">
		<div style="border:solid 1px #000; padding: 5px">
		<table width="100%" cellspacing="0" cellpadding="2" border="0">
			<tr>
				<td colspan="5" align="right"><a
					href="/eHRMS/leaveApproval.do?method=list"><bean:message
							key="go.to.main.page" /> </a>
				</td>
			</tr>
			<logic:messagesPresent message="true">
			<tr>
				<td colspan="5" class="msg_bg"><html:errors /> <html:messages
						id="employee_add_status" message="true">
						<bean:write name="employee_add_status" />
					</html:messages></td>
			</tr>
			</logic:messagesPresent>
			<tr>
				<td colspan="5">&nbsp;</td>
			</tr>
			
			<tr>
				<td>
				<bean:message key="employee.table.header.column.empid" />
				</td>
				<td colspan="4"><html:select styleClass="input_field validate[required]" styleId="empShift"
						name="leaveRequestForm" property="employee.id">
						<html:options collection="EmployeeList" property="id"
							labelProperty="name" />
					</html:select></td>
			</tr>
			
			<tr>
				<td><bean:message key="leaverequest.table.leaveType" />
				</td>
				<td><html:select styleClass="input_field" name="leaveRequestForm" disabled="true"
						property="leaveType">
						<html:option value="Casual">Casual Leave</html:option>
						<html:option value="Paid">Paid Leave</html:option>
						<html:option value="Medical">Medical Leave</html:option>
					</html:select>
				</td>
				
			</tr>
	
			<tr>
				<td><bean:message key="leaverequest.table.fromDate" />
				</td>
				<td><html:text styleClass="input_field" name="leaveRequestForm" readonly="true"
						 property="fromDate" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
				<tr>
				<td><bean:message key="leaverequest.table.toDate" />
				</td>
				<td>
				<html:text styleClass="input_field" name="leaveRequestForm" readonly="true"
						 property="toDate" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			
			<tr>
				<td><bean:message key="leaverequest.table.noofdays" />
				</td>
				<td>
				<html:text styleClass="input_field" name="leaveRequestForm" readonly="true"
						 property="noOfDays" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
				<tr>
				<td><bean:message key="leaverequest.table.reason" />
				</td>
				<td><html:textarea styleClass="input_field" name="leaveRequestForm" readonly="true"
						property="reason" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			
			<tr>
				<td>
				<bean:message key="leaverequest.table.status" />
				</td>
				<td><html:select styleClass="input_field" name="leaveRequestForm"
						property="status">
						<html:option value="PENDING">PENDING</html:option>
						<html:option value="APPROVED">APPROVED</html:option>
						<html:option value="REJECTED">REJECTED</html:option>
					</html:select>
				</td>
				
			</tr>
			
			
			
			<tr>
				<td>&nbsp;</td>
				<td><html:submit styleClass="button_background" value="Save"
						onclick="javascript:submitMe('save');" />
				</td>
				<td colspan="3">&nbsp;</td>
			</tr>
		</table>
		</div>
	</form>
</html>