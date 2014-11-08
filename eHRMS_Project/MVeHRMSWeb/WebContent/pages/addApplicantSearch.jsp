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
		$("#applicantSearch").dataTable({
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
			<th class="table_header"><bean:message key="title.candidate.search"/></th>
		</tr>
	</table>
	
	<p>
	<form id="newemp" action="/eHRMS/applicantSearch.do?method=search"
		method="post">
		<div style="border: 1px #000; padding: 5px;">
		<table width="100%" cellspacing="0" cellpadding="2" border="0">
				
			
			<tr>
			
			<td><bean:message key="label.job.id"/></td>
					<td><html:select styleClass="input_field" name="applicantForm"
							property="name">
							<html:options collection="requirementList" property="requirementId"
								labelProperty="requirementId" />
						</html:select>
					</td>
				
			</tr>
	
				<tr>
				<td><bean:message key="label.eligibility"/>  
				</td>
				<td>
				<html:text styleClass="input_field validate[required]" styleId="qualification" name="applicantForm"
						 property="qualification" />&nbsp;
				</td>
			</tr>
			
			
			<tr>
				<td><bean:message key="label.skill.set"/>
				</td>
				<td><html:text styleClass="input_field validate[required]" styleId="skillSet" name="applicantForm"
						 property="skillSet" />&nbsp;
				</td>
			</tr>
			
				<tr>
				<td><bean:message key="label.experience.months"/>
				</td>
				<td><html:text styleClass="input_field validate[required]" styleId="experience" name="applicantForm"
						 property="experience" />&nbsp;
				</td>
			</tr>
			
	
			
			
				
			<tr>
				<td>&nbsp;</td>
				<td><html:submit styleClass="button_background" value="Search"
						onclick="javascript:submitMe();" />
				</td>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			
			<logic:messagesPresent message="true">
			<tr>
				<td colspan="5" class="msg_bg"><html:errors /> <html:messages
						id="applicant_search_status" message="true">
						<bean:write name="applicant_search_status" />
					</html:messages></td>
			</tr>
			</logic:messagesPresent>
			
			<logic:notEmpty name="appList">
			<tr>
			<td colspan="5">
			<div style="text-align: right;"><a href="/eHRMS/applicantSearch.do?method=report"><img src="images/xls.png" width="32" height="32"></a></div>	
			<div id="container" style="width: 100%; align: left">
			<div id="demo_jui" style="width: 100%;">
			<table id="applicantSearch" class="display" width="100%" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
						<th><bean:message key="candidate.app.id"/>
						</th>
						<th><bean:message key="candidate.app.name"/>
						</th>
						<th><bean:message key="label.skill.set"/>
						</th>
						<th><bean:message key="candidate.education"/>
						</th>
						<th><bean:message key="label.year.experience"/>
						</th>
						<th><bean:message key="label.view.profile"/>
						</th>
						
					</tr>
				</thead>
				<tbody>
					<bean:define id="appListid" name="appList" scope="request" />
					<logic:iterate id="appListId" name="appList">
						<tr>
							
							<td align="center">
							<a
								href="/eHRMS/applicantView.do?method=edit&id=<bean:write name='appListId' property='id' />"><font
									color="blue">
							<bean:write name="appListId" property="id" /></font></a>
							</td>
							<td align="center"><bean:write name="appListId" property="name" />
							</td>
							<td align="center"><bean:write name="appListId" property="skillSet" />
							</td>
							<td align="center"><bean:write name="appListId" property="basicqualification" />
							</td>
							<td align="center"><bean:write name="appListId" property="experience" />
							</td>
							<bean:define id="attId" name="appListId" property="applicantList"></bean:define>
							<logic:iterate id="att" name="attId">
									
									<td class="table_data" align="center"><a href='/eHRMS/DownloadResume.do?method=list&path=<bean:write name="att" property="attachmentpath"/>'><img alt="Download" src="images/download.gif" /></a> &nbsp;&nbsp;
												
									</td>
								
							</logic:iterate>
							
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