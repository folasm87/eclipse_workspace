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
<link rel="stylesheet" type="text/css"
	href="styles/chosen.css" />

<script>
function saveRecord(){
var empids=document.getElementById("empIds").value;
var dates="";
if(empids=="")
{
	alert("Select atleast one employee");
}
else{
	document.getElementById("formE").submit();

}
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
			<td class="table_header"><bean:message
					key="employee.page.header" /></td>
		</tr>
		<tr>
			<td>
				<form action="/eHRMS/employeemodulemapping.do?method=save"
					method="post" id="formE">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>Module</td>
							<td><html:text property="module.name" readonly="true"  name="employeemodulemappingForm" /></td>
						</tr><html:hidden property="module.id" name="employeemodulemappingForm" />
					
										<tr>
				<td>Employee</td>
				<td>
				<html:select property="employee.id" styleClass="employee" multiple="multiple"
									name="employeemodulemappingForm" style="width: 200px;">

									<html:options collection="EMPLOYEES" property="id"
										labelProperty="name" />
								</html:select>
				</td>
				</tr>
							<tr>
							<td colspan="2" align="center"><html:button property="save" onclick="saveRecord()">Save</html:button>
							</td>
						</tr>
					</table>
				
	<html:hidden property="empIds" styleId="empIds" name="employeemodulemappingForm"/>
				</form></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	
<script type="text/javascript">
$(".employee").chosen();
$(".employee").change(function() {
var str = "";
var dates="";
$(".employee option:selected").each(function() {
			str += $(this).val()+ ",";
		
		
});
document.getElementById("empIds").value=str;
}).trigger('change');


</script>

</body>
</html>