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
		$("#dob").datepicker({
			changeMonth : true,
			changeYear : true
		});
		$("#doj").datepicker({
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
					key="employee.add.page.header" />
			</th>
		</tr>
	</table>
	<p>
		<bean:message key="employee.page.info" />
	</p>
	<p>
	<form id="newemp" action="/eHRMS/saveEmployees.do?method=save"
		method="post">
		<div style="border: solid 1px #000; padding: 5px">
			<table width="100%" cellspacing="0" cellpadding="2" border="0">
				<tr>
					<td colspan="5" align="right"><a
						href="/eHRMS/employees.do?method=list"><bean:message
								key="go.to.main.page" /> </a></td>
				</tr>
				<tr>
					<td colspan="5" class="msg_bg"><html:errors /> <html:messages
							id="employee_add_status" message="true">
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
					<td><logic:equal value="add" name="employeeForm"
							property="action">
							<html:text styleClass="mandatory_input_field" styleId="empId"
								name="employeeForm" property="empId" />&nbsp;<font color="red">*</font>
						</logic:equal> <logic:notEqual value="add" name="employeeForm" property="action">
							<bean:write name="employeeForm" property="empId" />
						</logic:notEqual></td>
					<td width="120px;">&nbsp;</td>
					<td><bean:message key="employee.table.header.column.jdate" />
					</td>
					<td><html:text styleClass="mandatory_input_field"
							name="employeeForm" styleId="doj" property="joinDate"
							style="width:60px;" />&nbsp;<font color="red">*</font></td>
				</tr>
				<tr>
					<td><bean:message key="employee.table.header.column.empname" />
					</td>
					<td><html:text styleClass="mandatory_input_field"
							styleId="name" name="employeeForm" style="width:200px;"
							property="name" />&nbsp;<font color="red">*</font></td>
					<td>&nbsp;</td>
					<td><bean:message key="employee.table.header.column.desig" />
					</td>
					<td><html:text styleClass="input_field" name="employeeForm"
							style="width:200px;" property="jobTitle" />
					</td>
				</tr>
				<tr>
					<td><bean:message key="employee.table.header.column.dob" /></td>
					<td><html:text styleClass="mandatory_input_field"
							styleId="dob" name="employeeForm" styleId="dob" styleId="dob"
							style="width:60px;" property="dob" />&nbsp;<font color="red">*</font>
					</td>
					<td>&nbsp;</td>
					<td><bean:message key="employee.lable.workphone" /></td>
					<td><html:text styleClass="input_field" name="employeeForm"
							property="workphone" /></td>
				</tr>
				<tr>
					<td><bean:message key="employee.table.header.column.mobile" />
					</td>
					<td><html:text styleClass="input_field" name="employeeForm"
							property="mobile" />
					</td>
					<td>&nbsp;</td>

					<td><bean:message key="employee.table.header.column.oemail" />
					</td>
					<td><html:text styleClass="input_field" name="employeeForm"
							property="workEmailId" style="width:200px;" /></td>
				</tr>
				<tr>
					<td><bean:message key="employee.table.header.column.pemail" />
					</td>
					<td><html:text styleClass="input_field" name="employeeForm"
							property="personalEmailId" style="width:200px;" /></td>
					<td>&nbsp;</td>
					<td><bean:message key="employee.lable.emptype" /></td>
					<td><html:select styleClass="input_field" name="employeeForm"
							property="empType">
							<html:option value="P">Permanent</html:option>
							<html:option value="C">Contract</html:option>
						</html:select></td>
				</tr>
				<tr>
					<td><bean:message key="employee.lable.immig" /></td>
					<td><html:text styleClass="input_field" name="employeeForm"
							property="immigirationStatus" style="width:200px;" /></td>
					<td>&nbsp;</td>
					<td><bean:message key="employee.lable.vendor" /></td>
					<td><html:text name="employeeForm" styleClass="input_field"
							property="vendorName" style="width:200px;" />
					</td>
				</tr>
				<tr>
					<td><bean:message key="employee.lable.address" />
					</td>
					<td><html:textarea styleClass="text_area" name="employeeForm"
							property="address" />
					</td>
					<td>&nbsp;</td>
					<td><bean:message key="employee.lable.role" /></td>
					<td><html:select styleClass="input_field" name="employeeForm"
							property="role.id">
							<html:options collection="SYSTEM_ROLES" property="id"
								labelProperty="name" />
						</html:select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td><bean:message key="employee.lable.compen" /></td>
					<td><html:textarea styleClass="text_area" name="employeeForm"
							property="compensation" />
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td><bean:message key="employee.lable.benefits" /></td>
					<td><html:textarea styleClass="text_area" name="employeeForm"
							property="benefits" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td><bean:message key="employee.lable.client" /></td>
					<td colspan="4"><html:textarea styleClass="text_area"
							name="employeeForm" property="clientInfo" />
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><html:submit property="save"
							styleClass="button_background" value="Save" /></td>
					<td colspan="3">&nbsp;</td>
				</tr>
			</table>
		</div>
	</form>
</html>