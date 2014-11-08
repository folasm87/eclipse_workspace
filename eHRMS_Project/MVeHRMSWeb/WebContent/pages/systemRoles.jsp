<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="jquery/jquery.dataTables.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="jquery/jquery.dataTables.css" />
<script type="text/javascript">
	$(document).ready(function() {
		$("#systemRoles").dataTable({
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
			<td class="table_header" align="center"><bean:message key="sysrole.page.header" />
			</td>
		</tr>
	</table>
	<br>
	<div id="container" style="width: 100%; align: left">
		<div id="demo_jui" style="width: 100%;">
			<table id="systemRoles" class="display" width="100%" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
						<th><bean:message key="sysrole.table.header.column.role" />
						</th>
						<th><bean:message key="sysrole.table.header.column.desc" />
						</th>
						<th><bean:message key="sysrole.table.header.column.menuaccess" />
						</th>
					</tr>
				</thead>
				<tbody>
					<bean:define id="sysRoles" name="SYSTEM_ROLES" scope="request" />
					<logic:iterate id="role" name="sysRoles">
						<tr>
							<td><bean:write name="role" property="name" /></td>
							<td><bean:write name="role" property="description" /></td>
							<td><a
								href="/eHRMS/menuAccess.do?method=list&id=<bean:write name='role' property='id' />"><font
									color="black">
									<bean:message key="sysrole.table.header.column.access" />
									</font>
							</a>&nbsp;&nbsp;
								</td>
						</tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>