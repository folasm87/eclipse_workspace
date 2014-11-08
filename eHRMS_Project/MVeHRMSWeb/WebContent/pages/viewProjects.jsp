<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<br>
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<th class="table_header"><bean:message
					key="project.view.page.header" /></th>
		</tr>
	</table>
	<p>
	<form id="newemp" action="/eHRMS/projects.do?method=list" method="post">
	<div style="border:solid 1px #000; padding: 5px;">
		<table width="100%" cellspacing="0" cellpadding="2" border="0">
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td><bean:message key="project.table.header.column.projid" />
				</td>
				<td><bean:write name="projectForm" property="projectId" />
				</td>
				
				<td><bean:message key="employee.table.header.column.empname" />
				</td>
				<td><bean:write name="projectForm" property="name" />
				</td>
			</tr>

			<tr>
				<td><bean:message key="project.table.header.column.customer" />
				</td>
				<td><bean:write name="projectForm" property="customer" /></td>
				
				<td><bean:message
						key="project.table.header.column.technologies" />
				</td>
				<td><bean:write name="projectForm" property="technologies" />
				</td>
			</tr>
			<tr>
				<td><bean:message key="project.table.header.column.projCoord" />
				</td>
				<td><bean:write name="projectForm"
						property="projectCoordinator.name" />
				</td>
				
				<td><bean:message key="project.table.header.column.projMan" />
				</td>
				<td><bean:write name="projectForm"
						property="projectManager.name" />
				</td>
				
			</tr>
			<tr>
				<td><bean:message
						key="project.table.header.column.estimatedHours" />
				</td>
				<td><bean:write name="projectForm" property="estimatedHours" />
				</td>
				
				<td><bean:message
						key="project.table.header.column.estimatedCost" />
				</td>
				<td><bean:write name="projectForm" property="estimatedCost" />
				</td>
			</tr>
			<tr>
				<td><bean:message
						key="project.table.header.column.contractRefNo" />
				</td>
				<td><bean:write name="projectForm" property="contractRefNo" />
				</td>
				
				<td><bean:message key="project.table.header.column.remarks" />
				</td>
				<td><bean:write name="projectForm" property="remarks" /></td>
			</tr>

			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><html:submit styleClass="button_background" value="Close" />
				</td>
				<td colspan="4">&nbsp;</td>
			</tr>
		</table>
		</div>
	</form>
</html>