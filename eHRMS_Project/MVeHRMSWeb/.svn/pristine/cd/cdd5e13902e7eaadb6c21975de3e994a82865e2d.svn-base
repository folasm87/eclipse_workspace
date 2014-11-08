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
	$("#newemp").validationEngine('attach');
	
		$("#date").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
	
	
	function submitMe(){
	if($("#newemp").validationEngine('validate')){
	$("#newemp").submit();
	
	}
	}
</script>
</head>
<body>
	<br>
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<th class="table_header"> <bean:message key="title.add.emp.shift.update"/></th>
		</tr>
	</table>
	<p>
		<bean:message key="employeeshift.page.info" />
	</p>
	<p>
	<form id="newemp" action="/eHRMS/saveEmployeeShift.do?method=save"
		method="post">
		<div style="border:solid 1px #000; padding: 5px" >
		<table width="100%" cellspacing="0" cellpadding="2" border="0">
			<tr>
				<td colspan="4" align="right"><a
					href="/eHRMS/employeesShift.do?method=list"><bean:message
							key="go.to.main.page" /> </a>
				</td>
			</tr>
			
			<logic:messagesPresent message="true">
			<tr>
				<td colspan="5" class="msg_bg"><html:errors /> <html:messages
						id="employee_shift_add_status" message="true">
						<bean:write name="employee_shift_add_status" />
					</html:messages></td>
			</tr>
			</logic:messagesPresent>
			
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			
				<tr>
				<td>
				<bean:message key="employee.table.header.column.empid" />
				</td>
				<td><html:select styleClass="input_field validate[required]" styleId="empShift"
						name="employeeShiftTime" property="employee.id">
						<html:options collection="EmployeeList" property="id"
							labelProperty="name" />
					</html:select></td>
			</tr>
		
			<tr>
				<td><bean:message key="project.page.header" />
				</td>
				<td><html:select styleClass="input_field"
						name="employeeShiftTime" property="project.id">
						<html:options collection="ProjectList" property="id"
							labelProperty="name" />
					</html:select></td>
			</tr>
			
			<tr>
				<td><bean:message key="label.date"/>
				</td>
				<td><html:text styleClass="input_field validate[required]" styleId="date" name="employeeShiftTime" size="15"
						 property="date" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			<tr>
				<td><bean:message key="label.hours"/>
				</td>
				<td><html:text styleClass="input_field validate[required]" styleId="hours" name="employeeShiftTime" size="5"
						 property="hours" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			<tr>
				<td><bean:message key="label.jobdone"/>
				</td>
				<td><html:textarea styleClass="input_field validate[required]" styleId="jobDone" name="employeeShiftTime"
						 property="jobDone" rows="3" cols="30"/>&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			<tr>
				<td><bean:message key="label.remarks"/>
				</td>
				<td><html:textarea styleClass="input_field" name="employeeShiftTime"
						 property="remarks" />
				</td>
			</tr>
		
		
		
		
			
				<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>
			
				<html:button property="save" styleClass="button_background" value="Save"
						onclick="javascript:submitMe();" />
				</td>
				<td colspan="3">&nbsp;</td>
			</tr>
		</table>
		</div>
	</form>
</html>