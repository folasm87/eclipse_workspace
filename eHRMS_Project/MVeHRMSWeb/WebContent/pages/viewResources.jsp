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
					key="resource.view.page.header" /></th>
		</tr>
	</table>
	<p>
	<form id="newresource" action="/eHRMS/resources.do?method=list" method="post">
	<div style="border:solid 1px #000; padding: 5px;">
		<table width="100%" cellspacing="0" cellpadding="2" border="0">
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td><bean:message key="resource.table.header.column.resourceid" />
				</td>
				<td><bean:write name="resourceForm" property="resourceId" />
				</td>
				
				<td><bean:message key="resource.table.header.column.resourcename" />
				</td>
				<td><bean:write name="resourceForm" property="name" />
				</td>
			</tr>

			<tr>
				<td><bean:message key="resource.table.header.column.cost" />
				</td>
				<td><bean:write name="resourceForm" property="cost" /></td>
				
			</tr>
			<tr>
				<td><bean:message key="resource.table.header.column.project" />
				</td>
				<td><bean:write name="resourceForm"
						property="project.name" />
				</td>
				
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