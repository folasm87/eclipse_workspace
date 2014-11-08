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
<script src="jquery/chosen.jquery.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="styles/chosen.css" />

<script>
	function saveRecord() {
		document.getElementById("formE").submit();

	}
	$(function() {
		$(".DatePicker").datepicker({
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
			<td class="table_header" align="center"><bean:message
					key="employeemapping.page.header" />
			</td>
		</tr>
		<tr>
			<td>
				<form action="/eHRMS/employeeprojectmapping.do?method=update"
					method="post" id="formE">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td colspan="2" align="right"><a
								href="/eHRMS/employeeprojectmapping.do?method=getProjects"><bean:message
										key="go.to.main.page" /> </a>
							</td>
						</tr>

						<tr>
							<td>Employee Name</td>
							<td><html:text property="employee.name" readonly="true"
									name="employeeprojectmappingForm" styleClass="input_field" />
							</td>
						</tr>
						<html:hidden property="id" name="employeeprojectmappingForm" />
						<tr>
							<td>Start Date</td>
							<td><html:text property="startDate" styleClass="DatePicker"
									name="employeeprojectmappingForm" styleClass="input_field" /></td>
						</tr>
						<tr>
							<td>End Date</td>
							<td><html:text property="endDate" styleClass="DatePicker"
									name="employeeprojectmappingForm" styleClass="input_field" /></td>
						</tr>
						<tr>
							<td align="center"><html:button property="save"
									styleClass="button_background" onclick="saveRecord()">Save</html:button>
							</td>
							<td>&nbsp;</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>


</body>
</html>