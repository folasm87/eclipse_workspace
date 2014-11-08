<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	$(function() {
	$("#newresource").validationEngine('attach');
		$(".datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat:"yy-mm-dd"
		});
	});
	function submitMe(){
	if($("#newresource").validationEngine('validate')){
	$("#newresource").submit();
	
	}
	}

</script>
</head>
<body>
	<br>
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<th class="table_header"><bean:message
					key="resource.add.page.header" />
			</th>
		</tr>
	</table>
	<p>
		<bean:message key="resource.page.info" />
	</p>
	<p>
	
	<form id="newresource" action="/eHRMS/saveResources.do?method=save"
		method="post">
		<div style="border:solid 1px #000; padding: 5px;">
		<table width="100%" cellspacing="0" cellpadding="2" border="0">
			<tr>
				<td colspan="5" align="right"><a
					href="/eHRMS/resources.do?method=list"><bean:message
							key="go.to.main.page" /> </a></td>
			</tr>
			<logic:messagesPresent message="true">
			<tr>
				<td colspan="5" class="msg_bg"><html:errors /> <html:messages
						id="resource_add_status" message="true">
						<bean:write name="resource_add_status" />
					</html:messages>
				</td>
			</tr>
			</logic:messagesPresent>
			<tr>
				<td colspan="5">&nbsp;</td>
			</tr>
			<tr>
				<td><bean:message key="resource.table.header.column.resourceid" />
				</td>
				<td><logic:equal value="add" name="resourceForm"
						property="action">
						<html:text styleClass="input_field validate[required],custom(onlyNumber)" styleId="resourceId" name="resourceForm"
							property="resourceId" />&nbsp;<font color="red">*</font>
					</logic:equal> <logic:notEqual value="add" name="resourceForm" property="action">
						<bean:write name="resourceForm" property="resourceId" />
					</logic:notEqual></td>
				
				<td><bean:message key="resource.table.header.column.resourcename" />
				</td>
				<td><html:text styleClass="input_field validate[required]" styleId="name" name="resourceForm"
						property="name" />&nbsp;<font color="red">*</font></td>
			</tr>
			<tr>
				<td><bean:message
						key="resource.table.header.column.cost" /></td>
				<td><html:text styleClass="input_field" name="resourceForm"
						property="cost" /></td>
				
			</tr>
			<tr>
				<td><bean:message key="resource.table.header.column.project" />
				</td>
				<td><html:select styleClass="input_field" name="resourceForm"
						property="project.id">
						<html:options collection="PROJECTS" property="id"
							labelProperty="name" />
					</html:select></td>
		
			</tr>
			
		
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><html:submit property="save"  styleClass="button_background" value="Save"
						onclick="javascript:submitMe();" /></td>
				<td colspan="2">&nbsp;</td>
			</tr>
		</table>
		</div>
	</form>
</html>