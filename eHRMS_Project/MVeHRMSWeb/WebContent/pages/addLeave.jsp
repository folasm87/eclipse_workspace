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
function difference(){
  var ONE_DAY = 1000 * 60 * 60 * 24;
  var first =new Array(); 
  var second = new Array();
  var fromDate=document.getElementById("fromDate").value;
  var toDate=document.getElementById("toDate").value;
  
  first=fromDate.split('/');
  second=toDate.split('/');
  
	var firstDate = new Date(first[2],first[0],first[1]);
	var secondDate = new Date(second[2],second[0],second[1]);
	
    // Convert both dates to milliseconds
    var date1_ms = firstDate.getTime();
    var date2_ms = secondDate.getTime();

    // Calculate the difference in milliseconds
    var difference_ms = Math.abs(date1_ms - date2_ms);

    // Convert back to days and return
    var diff= Math.round(difference_ms/ONE_DAY);
    
   document.getElementById("noOfDays").value=diff;

}


	$(function() {
	$("#newemp").validationEngine('attach');
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
	function submitMe(){
	if($("#newemp").validationEngine('validate')){
	$("#newemp").submit();
	}
	}
</script>
<style type="text/css">



</style>
</head>
<body>
	<br>
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<th class="table_header">
			<bean:message key="leaverequest.page.header" />
			</th>
		</tr>
	</table>
	<p>
	<bean:message key="leaverequest.page.info" />
		
	</p>
	<p>
	<form id="newemp" action="/eHRMS/saveLeaveRequest.do?method=save"
		method="post">
		<div style="border:solid 1px #000; padding: 5px">
		<table width="100%" cellspacing="0" cellpadding="2" border="0">
			<tr>
				<td colspan="5" align="right"><a
					href="/eHRMS/leaveRequest.do?method=list"><bean:message
							key="go.to.main.page" /> </a>
				</td>
			</tr>
			<logic:messagesPresent message="true">
			<tr>
				<td colspan="5" class="msg_bg"><html:errors /> <html:messages
						id="leave_add_status" message="true">
						<bean:write name="leave_add_status" />
					</html:messages></td>
			</tr>
			</logic:messagesPresent>
			<tr>
				<td colspan="5">&nbsp;</td>
			</tr>
			
		
			<tr>
				<td>
				<bean:message key="leaverequest.table.leaveType" />
				</td>
				<td><html:select styleClass="input_field validate[required]" styleId="leaveType" name="leaveRequestForm" 
						property="leaveType">&nbsp;<font color="red">*</font>
						<html:option value="Casual">Casual Leave</html:option>
						<html:option value="Paid">Paid Leave</html:option>
						<html:option value="Medical">Medical Leave</html:option>
					</html:select>
				</td>
				
			</tr>
	
			<tr>
				<td>
				<bean:message key="leaverequest.table.fromDate" />
				</td>
				<td><html:text styleClass="input_field validate[required]"  name="leaveRequestForm"
						styleId="fromDate" styleId="fromDate" property="fromDate" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
				<tr>
				<td>
				<bean:message key="leaverequest.table.toDate" />
				</td>
				<td>
				<html:text styleClass="input_field validate[required]" name="leaveRequestForm"
						styleId="toDate" styleId="toDate" property="toDate"  onchange="difference();"/>&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			<tr>
				<td>
				<bean:message key="leaverequest.table.noofdays" />
				</td>
				<td>
				<html:text styleClass="input_field validate[required]" name="leaveRequestForm"
						styleId="noOfDays" styleId="noOfDays" property="noOfDays" readonly="readonly" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
				<tr>
				<td>
				<bean:message key="leaverequest.table.reason" />
				
				</td>
				<td><html:textarea styleClass="input_field" styleId="reason" name="leaveRequestForm"
						property="reason" />
				</td>
			</tr>
			
			
			
			<tr>
				<td>&nbsp;</td>
				<td><html:submit styleClass="button_background" value="Save"
							onclick="javascript:submitMe();" /></td>
				<td colspan="3">&nbsp;</td>
			</tr>
		</table>
		</div>
	</form>
</html>