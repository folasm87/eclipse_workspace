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
		$("#resignDate").datepicker({
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
			<th class="table_header"><bean:message
					key="employee.exit.page.header" />
			</th>
		</tr>
	</table>
	<p>
		<bean:message key="employee.resign.page.info" />
	</p>
	<p>
	<form id="newemp" action="/eHRMS/saveEmployees.do?method=resign"
		method="post">
		<div style="border:solid 1px #000; padding: 5px" >
		<table width="100%" cellspacing="0" cellpadding="2" border="0">
			<tr>
				<td colspan="5" align="right"><a
					href="/eHRMS/employees.do?method=list"><bean:message
							key="go.to.main.page" /> </a></td>
			</tr>
			<tr>
				<td colspan="5"><html:messages id="employee_add_status"
						message="true">
						<bean:write name="employee_add_status" />
					</html:messages>
				</td>
			</tr>
			<tr>
				<td colspan="5">&nbsp;</td>
			</tr>
			<tr>
				<td><bean:message key="employee.table.header.column.empid" />
				</td>
				<td><bean:write name="employeeForm" property="empId" />
				</td>
				
				<td rowspan="2"><bean:message key="employee.lable.address" />
				</td>
				<td rowspan="2"><bean:write name="employeeForm"
						property="address" /></td>
			</tr>
			<tr>
				<td><bean:message key="employee.table.header.column.empname" />
				</td>
				<td><bean:write name="employeeForm" property="name" />
				</td>
			</tr>
			<tr>
				<td><bean:message key="employee.table.header.column.dob" />
				</td>
				<td><bean:write name="employeeForm" property="dob" />
				</td>
				
				<td><bean:message key="employee.table.header.column.mobile" />
				</td>
				<td><bean:write name="employeeForm" property="mobile" />
				</td>
			</tr>
			<tr>
				<td><bean:message key="employee.lable.workphone" />
				</td>
				<td><bean:write name="employeeForm" property="workphone" />
				</td>
				
				<td><bean:message key="employee.table.header.column.pemail" />
				</td>
				<td><bean:write name="employeeForm" property="personalEmailId" />
				</td>
			</tr>
			<tr>
				<td><bean:message key="employee.table.header.column.oemail" />
				</td>
				<td><bean:write name="employeeForm" property="workEmailId" />

				</td>
				
				<td><bean:message key="employee.table.header.column.jdate" />
				</td>
				<td><bean:write name="employeeForm" property="joinDate" />
				</td>
			</tr>
			<tr>
				<td><bean:message key="employee.lable.immig" />
				</td>
				<td><bean:write name="employeeForm"
						property="immigirationStatus" />
				</td>
				
				<td><bean:message key="employee.table.header.column.desig" />
				</td>
				<td><bean:write name="employeeForm" property="jobTitle" />
				</td>
			</tr>
			<tr>
				<td><bean:message key="employee.lable.benefits" />
				</td>
				<td><bean:write name="employeeForm" property="benefits" />
				</td>
				
				<td><bean:message key="employee.lable.compen" />
				</td>
				<td><bean:write name="employeeForm" property="compensation" />
				</td>
			</tr>
			<tr>
				<td><bean:message key="employee.lable.client" />
				</td>
				<td colspan="4"><bean:write name="employeeForm"
						property="clientInfo" />
				</td>
			</tr>
			<tr>
				<td><bean:message key="employee.lable.emptype" />
				</td>
				<td><bean:write name="employeeForm" property="empType" />
				</td>
				
				<td><bean:message key="employee.lable.vendor" />
				</td>
				<td><bean:write name="employeeForm" property="vendorName" />
				</td>
			</tr>
			<tr>
				<td><bean:message key="employee.lable.role" />
				</td>
				<td colspan="4"><bean:write name="employeeForm"
						property="role.name" />
				</td>
			</tr>
			
			<tr>
			<td colspan="5">
			<table width="100%" >
			<tr>
			<td colspan="5" width="100%" class="table_header1" style="width: 974px; height: 23px;" align="center">
			<bean:message key="employee.resign.details" />
			</td>
			</tr>
			</table></td></tr>
		
			<tr>
				<td><bean:message key="employee.lable.resigndate" /></td>
				<td><html:text styleClass="input_field" name="employeeForm"
						styleId="resignDate" property="resignDate" /></td>
				
				<td><bean:message key="employee.lable.resign.reason" /></td>
				<td><html:textarea styleClass="input_field" name="employeeForm"
						property="resignReason" /></td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<html:submit styleClass="button_background" value="Save" />
				</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
		</div>
	</form>
	
</html>