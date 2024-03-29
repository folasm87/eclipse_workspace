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
		$("#issues").dataTable({
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
</head>
<body id="dt_example">
	<br>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="table_header" align="center"><bean:message key="issue.page.header" />
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right"><p>
					<a href="/eHRMS/issues.do?method=add"><font color="black">
							<bean:message key="issue.add.page.header" /> </font> </a>
				</p></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<div id="container" style="width: 100%; align: left">
		<div id="demo_jui" style="width: 100%;">
			<table id="issues" class="display" width="100%" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
						<th><bean:message key="issue.table.header.column.issueid" />
						</th>
						<th><bean:message key="issue.table.header.column.issueissue" />
						</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<bean:define id="issues" name="ISSUES" scope="request" />
					<logic:iterate id="issue" name="issues">
						<tr>
							<td><a
								href="/eHRMS/issues.do?method=edit&id=<bean:write name='issue' property='id' />"><font
									color="black"><bean:write name="issue"
											property="issueId" /> </font> </a></td>
							<td><bean:write name="issue" property="issue" /></td>
							<td><a
								href="/eHRMS/issues.do?method=view&id=<bean:write name='issue' property='id' />"><font
									color="black">View</font>
							</a>
							</td>
						</tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>