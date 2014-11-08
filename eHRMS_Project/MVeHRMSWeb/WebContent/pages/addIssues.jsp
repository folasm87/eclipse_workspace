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
	$("#newissue").validationEngine('attach');
		$(".datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat:"yy-mm-dd"
		});
	});
	function submitMe(){
	if($("#newissue").validationEngine('validate')){
	$("#newissue").submit();
	
	}
	}

</script>
</head>
<body>
	<br>
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<th class="table_header"><bean:message
					key="issue.add.page.header" />
			</th>
		</tr>
	</table>
	<p>
		<bean:message key="issue.page.info" />
	</p>
	<p>
	
	<form id="newissue" action="/eHRMS/saveIssues.do?method=save"
		method="post">
		<div style="border:solid 1px #000; padding: 5px;">
		<table width="100%" cellspacing="0" cellpadding="2" border="0">
			<tr>
				<td colspan="5" align="right"><a
					href="/eHRMS/issues.do?method=list"><bean:message
							key="go.to.main.page" /> </a></td>
			</tr>
			<logic:messagesPresent message="true">
			<tr>
				<td colspan="5" class="msg_bg"><html:errors /> <html:messages
						id="issue_add_status" message="true">
						<bean:write name="issue_add_status" />
					</html:messages>
				</td>
			</tr>
			</logic:messagesPresent>
			<tr>
				<td colspan="5">&nbsp;</td>
			</tr>
			<tr>
				<td><bean:message key="issue.table.header.column.issueid" />
				</td>
				<td><logic:equal value="add" name="issueForm"
						property="action">
						<html:text styleClass="input_field validate[required],custom(onlyNumber)" styleId="issueId" name="issueForm"
							property="issueId" />&nbsp;<font color="red">*</font>
					</logic:equal> <logic:notEqual value="add" name="issueForm" property="action">
						<bean:write name="issueForm" property="issueId" />
					</logic:notEqual></td>
				
				<td><bean:message key="issue.table.header.column.issueissue" />
				</td>
				<td><html:text styleClass="input_field validate[required]" styleId="issue" name="issueForm"
						property="name" />&nbsp;<font color="red">*</font></td>
			</tr>
			<tr>
				<td><bean:message key="issue.table.header.column.project" />
				</td>
				<td><html:select styleClass="input_field" name="issueForm"
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