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



function saveRecord(){
	var radioButtons = document.getElementsByName("empId");
     for (var x = 0; x < radioButtons.length; x ++) {
       if (radioButtons[x].checked) {
         var value = radioButtons[x].value;
       }
     }
     document.forms[0].action = "/eHRMS/home.do?method=getList&id="+value;
	 document.forms[0].method = "post";
	 document.forms[0].submit(); 
    
}








	$(document).ready(function() {
		$("#employees").dataTable({
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

<script type="text/javascript">
	function closeWindow() {
		document.getElementById("inlineContent").style.display = "none";
	}
</script>
</head>
<body id="dt_example">

<script type="text/javascript">
	$(function() {
		$( "#dialog" ).dialog(
		{ 
			width:800,
			height: 450,
			top:300 ,
			modal: false
		
		}
		);
		
	});
</script>
<div id="dialog" title="Applicant Profile">
					<form action="/eHRMS/applicantSearch.do?method=search"
		method="post">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" style="height: 670px;">
<tr style="height: 100%;">
<td align="center" valign="middle" style="height: 100%;">
			
<table border="1px;" width="95%" align="center" cellspacing="0"
			cellpadding="0">
			
			
	
						<tr>
							<td align="center" >
									<table width="100%" cellspacing="0" cellpadding="0" border="0">
									<tr>
			<th class="table_header" align="center" colspan="2">
			
			<bean:message key="update.profile" />
			
			
			</th>
			
		</tr>
	
			
		
		<tr>
		<td>
		
		&nbsp;
	</td></tr>

			
			<tr>
				<td colspan="5">&nbsp;</td>
			</tr>
			
			
			<tr>
			<td colspan="5">
			<table width="100%" >
			<tr>
			<td colspan="5" width="100%" class="table_header1" style="width: 974px; height: 23px;">
			<bean:message key="contact.details" />
			</td>
			</tr>
			</table></td></tr>
			
			<tr>
			<td>&nbsp;</td>
			</tr>
			
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="employee.table.header.column.empname" />
				</td>
				<td><bean:write name="applicantForm"
						 property="name" />&nbsp;
				</td>
				
			</tr>
	
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="employee.table.header.column.dob" />
				</td>
				<td><bean:write name="applicantForm"
						 property="dob" />&nbsp;
				</td>
			</tr>
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="employee.table.header.column.mobile" /> 
				</td>
				<td><bean:write  name="applicantForm" 
						 property="mobileNo" />&nbsp;
				</td>
			</tr>
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="table.header.column.email" />
				</td>
				<td><bean:write  name="applicantForm" 
						 property="email" />&nbsp;
				</td>
			</tr>
			
			<tr>
			<td>&nbsp;</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			</tr>
				
		
			<tr>
			<td colspan="5">
			<table width="100%" >
			<tr>
			<td colspan="5" width="100%" class="table_header1" style="width: 974px; height: 23px;">
			<bean:message key="employement.details" />
			</td>
			</tr></table></td></tr>
			<tr>
			<td>&nbsp;</td>
			</tr>
		
				<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="label.experienceinmonth.degree" /> 
				</td>
				<td><bean:write  name="applicantForm"
						 property="experience" />&nbsp;
				</td>
			</tr>
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="label.jobprofile.degree" /> 
				</td>
				<td><bean:write  name="applicantForm" 
 
						 property="jobProfile" />&nbsp;
				</td>
			</tr>
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="table.header.column.skillset" />
				</td>
				<td><bean:write  name="applicantForm" 
						 property="skillSet" />&nbsp;
				</td>
			</tr>
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="table.header.column.resumeheading" />
				</td>
				<td><bean:write  name="applicantForm" 
						 property="resume" />&nbsp;
				</td>
			</tr>
				
			<tr>
			<td>&nbsp;</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			</tr>	
			
			
			<tr>
			<td colspan="5">
			<table width="100%" >
			<tr>
			<td colspan="5" width="100%" class="table_header1" style="width: 974px; height: 23px;">
			<bean:message key="education.background" />
			</td>
			</tr></table></td></tr>
			<tr>
			<td>&nbsp;</td>
			</tr>
			<logic:notEqual value="0" name="applicantForm" property="basicqualification">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;
				<bean:message key="applicant.basic.education" />
				
				</td>
				<td><bean:write  name="applicantForm" 
						property="basicqualification" />
						
				</td>
				
			</tr>
			</logic:notEqual>
			<logic:notEqual value="0" name="applicantForm" property="masterqualification">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;
				<bean:message key="applicant.master.education" />
				</td>
				<td><bean:write name="applicantForm" 
						property="masterqualification"/>
						
				</td>
				
			</tr>
			</logic:notEqual>
			
			<logic:notEqual value="0" name="applicantForm" property="doctoratequalification">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;
				<bean:message key="applicant.doctorate.education" />
				</td>
				<td><bean:write  name="applicantForm" 
						property="doctoratequalification" />
						
				</td>
				
			</tr>
			</logic:notEqual>
			<tr>
			<td>&nbsp;</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			</tr>
			
			<tr>
					
					<td align="center">
					&nbsp;&nbsp;&nbsp;
					<html:submit property="save"
							styleClass="button_background" value="Close" /></td>
					<td colspan="3">&nbsp;</td>
				</tr>
				<tr>
			<td>&nbsp;</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			</tr>

		</table>
		</table>
		</table>
	
</form>
</div>




</body>
