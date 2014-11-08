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

$(function() {
	$(".DatePicker").datepicker({
		changeMonth : true,
		changeYear : true
	});
});
	function saveRecord() {
		var empids = document.getElementById("empIds").value;
		var dates = "";
		if (empids == "") {
			alert("Select atleast one employee");
		} else {
			var tmp = empids.split(',');
			for ( var i = 0; i < tmp.length - 1; i++) {

				var startDate = document.getElementById(tmp[i] + "startdate").value;
				var endDate = document.getElementById(tmp[i] + "enddate").value;
				if (startDate == "") {
					alert("select start date");
					return false;
				} else if (endDate == "") {
					alert("select end date");
					return false;
				} else {
					if (i != (tmp.length - 2)) {
						dates += startDate + "," + endDate + "~";
					}
					if (i == (tmp.length - 2)) {
						dates += startDate + "," + endDate;
					}

				}
			}
			document.getElementById("dates").value = dates;
			document.getElementById("formE").submit();

		}
	}
	
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
			<td width="100%" style="border: 1px solid black" align="center">
				<form action="/eHRMS/employeeprojectmapping.do?method=save"
					method="post" id="formE">
					<table width="80%" border="0" style="padding: 20px;"
						cellpadding="0" cellspacing="0">
						<tr>
							<td colspan="2" align="right"><a
								href="/eHRMS/employeeprojectmapping.do?method=getProjects"><bean:message
										key="go.to.main.page" /> </a>
							</td>
						</tr>
						<tr>
							<td height="50px" width="50%"><bean:message
									key="project.page.header" /></td>
							<td><html:text property="project.name" readonly="true"  styleClass="input_field"
									name="employeeprojectmappingForm" />
							</td>
						</tr>
						<html:hidden property="project.id"
							name="employeeprojectmappingForm" />
						<tr>
							<td height="50px"><bean:message
									key="project.table.header.column.startdate" />
							</td>
							<td><html:text property="project.startDate" readonly="true" styleClass="input_field"
									name="employeeprojectmappingForm" /></td>
						</tr>
						<tr>
							<td height="50px"><bean:message
									key="project.table.header.column.enddate" />
							</td>
							<td><html:text property="project.endDate" readonly="true"  styleClass="input_field"
									name="employeeprojectmappingForm" /></td>
						</tr>

						<tr>
							<td height="50px"><bean:message key="employee.page.header" />
							</td>
							<td><bean:define id="employeeProject"
									name="EMPLOYEEPROJECTMAPING" /> <bean:define id="employee"
									name="EMPLOYEES" /> <select class="employee"
								multiple="multiple" style="width: 200px;">
									<logic:iterate id="emp" name="employeeProject">
										<option
											value="<bean:write name="emp" property="employee.id"/>"
											selected="selected">
											<bean:write name="emp" property="employee.name" />
										</option>

									</logic:iterate>
									<logic:iterate id="employeeId" name="employee">
										<option value="<bean:write name="employeeId" property="id"/>">
											<bean:write name="employeeId" property="name" />
										</option>
									</logic:iterate>

							</select></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2" align="center" width="100%"><bean:define
									id="employees" name="EMPLOYEES" />

								<div style="overflow: auto; width: 100%; display: none;"
									id="main">
									<table border="1" style="border-style: solid;" cellpadding="0"
										cellspacing="0" width="98%">
										<tr style="background-color: #993300; color: white;">
											<th height="35px" width="30%"><bean:message
													key="employee.name" />
											</th>
											<th width="35%"><bean:message
													key="project.table.header.column.startdate" />
											</th>
											<th width="35%"><bean:message
													key="project.table.header.column.enddate" />
											</th>
										</tr>
										<tr>
											<td colspan="3"><logic:iterate id="empProject"
													name="employeeProject">
													<div
														id="<bean:write name="empProject" property="employee.id" />div"
														style="width: 100%; display: none;">
														<table border="0" style="border-style: solid"
															cellpadding="0" cellspacing="0" width="100%">
															<tr>
																<td width="30%" height="35px"><bean:write
																		name="empProject" property="employee.name" />
																</td>
																<td width="35%" height="35px" align="center"><input
																	type="text"  class="input_field" 
																	id="<bean:write name="empProject" property="employee.id" />startdate"
																	class="DatePicker"
																	value="<bean:write name="empProject" property="startDate" />">
																</td>
																<td width="35%" height="35px" align="center"><input
																	type="text" class="input_field" 
																	id="<bean:write name="empProject" property="employee.id" />enddate"
																	class="DatePicker"
																	value="<bean:write name="empProject" property="endDate" />">
																</td>
															</tr>
															<tr>
															</tr>
														</table>


													</div>
												</logic:iterate> <logic:iterate id="emp" name="employees">
													<div id="<bean:write name="emp" property="id" />div"
														style="width: 100%; display: none;">
														<table border="0" style="border-style: solid"
															cellpadding="0" cellspacing="0" width="100%">
															<tr>
																<td width="30%" height="35px"><bean:write
																		name="emp" property="name" />
																</td>
																<td width="35%" height="35px" align="center"><input
																	type="text"
																	id="<bean:write name="emp" property="id" />startdate"
																	class="DatePicker">
																</td>
																<td width="35%" height="35px" align="center"><input
																	type="text" 
																	id="<bean:write name="emp" property="id" />enddate"
																	class="DatePicker">
																</td>
															</tr>
															<tr>
															</tr>
														</table>


													</div>
												</logic:iterate></td>
										</tr>

									</table>
								</div></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><br /> <html:button
									styleClass="button_background" property="save"
									onclick="saveRecord()">Save</html:button></td>
						</tr>
					</table>
					<html:hidden property="dates" styleId="dates"
						name="employeeprojectmappingForm" />
					<html:hidden property="empIds" styleId="empIds"
						name="employeeprojectmappingForm" />
				</form>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>

	<script type="text/javascript">
		$(".employee").chosen();
		$(".employee")
				.change(
						function() {
							var str = "";
							var dates = "";
							$(".employee option:selected")
									.each(
											function() {
												str += $(this).val() + ",";

												document.getElementById($(this)
														.val()
														+ "div").style.display = "block";
											});
							$(".employee option:not(:selected)")
									.each(
											function() {
												document.getElementById($(this)
														.val()
														+ "div").style.display = "none";
											});
							if (str == "") {
								document.getElementById("main").style.display = "none";
							} else {
								document.getElementById("main").style.display = "block";
							}
							document.getElementById("empIds").value = str;
						}).trigger('change');
	</script>

</body>
</html>