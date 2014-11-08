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
		$("#endDate").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
	$(function() {
		$("#positionStatus").datepicker({
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
			<th class="table_header">
			<bean:message key="requirement.view" />
			</th>
		</tr>
	</table>
	<p>
		<bean:message key="requirement.page.info" />
	</p>
	<p>
	<form id="newemp" action="/eHRMS/requirement.do?method=list"
		method="post">
		<div style="border:solid 1px #000; padding: 5px" >
		<table width="100%" cellspacing="0" cellpadding="2" border="0">
		<tr>
				<td colspan="5" align="right"><a
					href="/eHRMS/requirement.do?method=list"><bean:message
							key="go.to.main.page" /> </a>
				</td>
			</tr>
			<logic:messagesPresent message="true">
			<tr>
				<td colspan="5" class="msg_bg"><html:errors /> <html:messages
						id="requirement_add_status" message="true">
						<bean:write name="requirement_add_status" />
					</html:messages></td>
			</tr>
			</logic:messagesPresent>
			<tr>
				<td><bean:message key="requirement.requirement.Id" />
				</td>
				<td>
				<bean:write name="requirementForm"
						 property="requirementId" />
				
				</td>
				
				<td rowspan="2"><bean:message key="requirement.client.name" />
				</td>
				<td rowspan="2">
				<bean:write name="requirementForm"
						 property="clientName" />
				</td>
			</tr>
			<tr>
				<td><bean:message key="requirement.client.description" />  
				</td>
				<td>
				<bean:write name="requirementForm"
						 property="clientDescription" />
								
				</td>
			</tr>
			<tr>
				<td><bean:message key="requirement.web.url" />
				</td>
				<td>
				<bean:write name="requirementForm"
						 property="url" />
				
				</td>
				
				<td><bean:message key="leaverequest.table.status" />
				</td>
				<td>
				<bean:write name="requirementForm"
						 property="status" />
				
				</td>
			</tr>
			
			<tr>
			<td colspan="4">
			<table width="100%" >
			<tr>
			<td colspan="4" width="100%" class="table_header1" style="width: 974px; height: 23px;" align="center">
			<bean:message key="leaverequest.requirement.details" />
			</td>
			</tr>
			</table>
			</td>
			</tr>
			
			<tr>
				<td><bean:message key="requirement.position.name" />
				</td>
				<td>
				<bean:write name="requirementForm"
						 property="positionName" />
							
				</td>
				
				<td><bean:message key="requirement.no.of.vancancy" />
				</td>
				<td>
				<bean:write name="requirementForm"
						 property="noOfVancancy" />
				
				</td>
			</tr>
			<tr>
				<td><bean:message key="requirement.current.date" />
				</td>
				<td>
				<bean:write name="requirementForm"
						 property="positionStatus" />
							
				</td>
				
				<td><bean:message key="requirement.closeing.date" />
				</td>
				<td>
				<bean:write name="requirementForm"
						 property="endDate" />
				
				</td>
				
				
			</tr>
			<tr>
				<td><bean:message key="requirement.optional" />
				</td>
				<td>
				<bean:write name="requirementForm"
						 property="optionalRequirement" />
								
				</td>
				
				<td><bean:message key="requirement.minimum.qualification" />
				</td>
				<td>
				<bean:write name="requirementForm"
						 property="minimumQualification" />
				
				
				</td>
			</tr>
			
			<tr>
				
				
				<td><bean:message key="requirement.comments" />
				</td>
				<td>
				<bean:write name="requirementForm"
						 property="comments" />
			
				</td>
				
				<td>&nbsp;
				</td>
				<td>&nbsp;
				</td>
			</tr>
		
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				<td><html:submit styleClass="button_background" value="Close"
						onclick="javascript:submitMe();" />
				</td>
				<td >&nbsp;</td>
			</tr>
		
			</table>
			</div>
	</form>
</html>