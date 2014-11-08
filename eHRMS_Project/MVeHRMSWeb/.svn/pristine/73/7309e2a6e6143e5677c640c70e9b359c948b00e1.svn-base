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
<script type="text/javascript">
	$(document).ready(function() {
		$("#jobSearch").dataTable({
			"sPaginationType" : "full_numbers",
			"bJQueryUI" : true,
			"bAutoWidth" : false,
			"bFilter" : true
		});

		$('#example').dataTable({
			"aLengthMenu" : [ [ 5, 10, 25, -1 ], [ 5, 10, 25, "All" ] ]
		});
	});
</script></head>
<body>
	<br>
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<th class="table_header"><bean:message key="title.job.search" />
			</th>
		</tr>
	</table>

	<p>
	<form id="newemp" action="/eHRMS/jobSearch.do?method=search"
		method="post">
		
		<div style="border: 1px #000; padding: 5px;">
			<table width="100%" cellspacing="0" cellpadding="2" border="0">
			<logic:notEqual value="A" name="requirementForm" property="type">
			<td colspan="5" class="msg_bg">You Have No Privilege to Access Job search Menu
					</td>
			</logic:notEqual>
				<logic:equal value="A" name="requirementForm" property="type">
				<logic:messagesPresent message="true">
					<tr>
						<td colspan="5" class="msg_bg"><html:errors /> <html:messages
								id="job_apply" message="true">
								<bean:write name="job_apply" />
							</html:messages></td>
					</tr>
				</logic:messagesPresent>

				<tr>
					<td><bean:message key="label.employer" /></td>
					<td><html:text styleClass="input_field" name="requirementForm"
							property="clientName" />
					</td>
				</tr>

				<tr>
					<td><bean:message key="label.design.posi" /></td>
					<td><html:text styleClass="input_field" name="requirementForm"
							property="positionName" />
					</td>
				</tr>

				<tr>
					<td><bean:message key="label.location" /></td>
					<td><html:text styleClass="input_field" name="requirementForm"
							property="location" />
					</td>
				</tr>

				<tr>
					<td><bean:message key="job.techno.skillset" /></td>
					<td><html:text styleClass="input_field" name="requirementForm"
							property="skillset" />
					</td>
				</tr>



				<tr>
					<td>&nbsp;</td>
					<td><html:submit styleClass="button_background" value="Search"
							onclick="javascript:submitMe('search');" />
					</td>
					<td colspan="3">&nbsp;</td>
				</tr>
				</logic:equal>
				<logic:notEmpty name="reqList">
				<tr>
			<td colspan="5">
			<div id="container" style="width: 100%; align: left">
			<div id="demo_jui" style="width: 100%;">
			<table id="jobSearch" class="display" width="100%" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
						<th><bean:message key="label.requirement.id" />
										</th>
										<th><bean:message key="requirement.client.name" />
										</th>
										<th><bean:message key="requirement.client.description" />
										</th>
										<th><bean:message key="requirement.no.of.vancancy" />
										</th>
										<th><bean:message key="requirement.closeing.date" />
										</th>
										<th>&nbsp;</th>
						
					</tr>
				</thead>
				<tbody>
									<bean:define id="reqListId" name="reqList" scope="request" />
									<logic:iterate id="reqId" name="reqListId">
										<tr>

											<td align="center"><bean:write name="reqId"
													property="requirementId" />
											</td>
											<td><bean:write name="reqId" property="clientName" />
											</td>
											<td><bean:write name="reqId"
													property="clientDescription" />
											</td>
											<td align="center"><bean:write name="reqId"
													property="noOfVancancy" />
											</td>
											<td align="center"><bean:write name="reqId"
													property="endDate" />
											</td>
											<td align="center"><a
												href="/eHRMS/jobSearch.do?method=apply&reqId=<bean:write name="reqId" property="id" />">apply</a>
											</td>

										</tr>
									</logic:iterate>
								</tbody>
						
			</table>
		</div>
	</div>
	</td>
	</tr>
				</logic:notEmpty>

			</table>
		</div>
	</form>
</html>