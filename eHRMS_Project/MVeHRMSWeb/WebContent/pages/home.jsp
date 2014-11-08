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

<script type="text/javascript">
	$(function() {
		$( "#dialog" ).dialog(
		{ 
			width:500,
			height: 400,
			top:200 ,
			modal: true
		
		}
		);
		
	});
</script>
<div id="dialog" title="<bean:message
					key="employee.page.header" />">
					<form action="/eHRMS/home.do?method=getList"
		method="post">
	<table>
	<logic:notEmpty name="EMPLOYEES">
					<bean:define id="employees" name="EMPLOYEES" scope="request" />
					<logic:iterate id="emp" name="employees">
						<tr>
							<td>
							<input type="radio" name="empId" value="<bean:write name="emp" property="empId"/>">
							<bean:write name="emp" property="name"/>
							</td>
						
						</tr>
					</logic:iterate>
					<tr><td>
					
					<html:button styleClass="button_background" onclick="javascript:saveRecord();" property="save">
					<bean:message key="employee.get.details" />
					
					</html:button>
					</td></tr>
					</logic:notEmpty>
					<logic:empty name="EMPLOYEES">
					<tr>
					<td>
					<bean:message key="employee.anniversary.Record" />
					</td>
					</tr>
								
					</logic:empty>
</table>
</form>
</div>




</body>
