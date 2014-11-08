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
	$(document).ready(function() {
		$("#reqList").dataTable({
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
			<td class="table_header" align="center">
			<bean:message key="requirement.title" />
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right"><p>
					<a href="/eHRMS/requirement.do?method=add"><font color="black">
							<bean:message key="requirement.add.new" /></font> </a>
				</p>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<logic:notEmpty name="reqList">
	<div id="container" style="width: 100%; align: left">
		<div id="demo_jui" style="width: 100%;">
			<table id="reqList" class="display" width="100%" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
						<th><bean:message key="requirement.requirement.Id" />
						</th>
						<th><bean:message key="requirement.client.name" />
						</th>
						<th><bean:message key="requirement.client.description" />  
						</th>
						<th><bean:message key="requirement.no.of.vancancy" />
						</th>
						<th><bean:message key="requirement.requirement.Id" />
						</th>
					
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<bean:define id="reqListId" name="reqList" scope="request" />
					<logic:iterate id="reqId" name="reqListId">
						<tr>
							<td><a
								href="/eHRMS/requirement.do?method=edit&id=<bean:write name='reqId' property='id' />"><font
									color="black"><bean:write name="reqId" property="requirementId" />
								</font> </a>
							</td>
							
							<td><bean:write name="reqId" property="clientName" />
							</td>
							<td><bean:write name="reqId" property="clientDescription" />
							</td>
							<td><bean:write name="reqId" property="noOfVancancy" />
							</td>
							<td><bean:write name="reqId" property="endDate" />
							</td>
							
							<td><a
								href="/eHRMS/requirement.do?method=view&id=<bean:write name='reqId' property='id' />"><font
									color="black"><bean:message key="common.view" /></font>
							</a>&nbsp;&nbsp;
								</td>
						</tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
</logic:notEmpty>
<logic:empty name="reqList">
<tr>
<td>
<bean:message key="empty.record.found" />
</td>
</tr>
</logic:empty>
</body>
</html>