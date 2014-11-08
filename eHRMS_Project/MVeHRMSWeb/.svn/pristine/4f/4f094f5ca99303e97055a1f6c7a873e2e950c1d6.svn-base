<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="styles/ehrms_admin.css" />
<link type="text/css"
	href="styles/smoothness/jquery-ui-1.8.17.custom.css" rel="stylesheet" />

<html>
<head>
<script type="text/javascript" src="scripts/multifile_compressed.js"></script>
<script type="text/javascript" src="jquery/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="jquery/jquery-ui-1.8.17.custom.min.js"></script>
	<script type="text/javascript"
	src="jquery/jquery.validationEngine.js"></script>
	<script type="text/javascript"
	src="jquery/jquery.validationEngine-en.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/validationEngine.jquery.css" />
<script>

	$(function() {
	$("#newemp").validationEngine('attach');
		$("#dob").datepicker({
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
<form  id="newemp" action="/eHRMS/updateApplicantRegister.do?method=save"
		method="post" enctype="multipart/form-data">

<logic:empty name="appList">
		<table width="100%" cellspacing="0" cellpadding="2" border="0">
		<tr>
		<td colspan="5" class="msg_bg">
		<bean:message key="applicant.previllage" />
		</td>
		</tr>
			</table>
		
		
		</logic:empty>
	<logic:notEmpty name="appList">
<table border="0" cellpadding="0" cellspacing="0" width="100%" style="height: 670px;">
<tr style="height: 100%;">
<td align="center" valign="middle" style="height: 100%;">
			
<table border="1px;" width="95%" align="center" cellspacing="0"
			cellpadding="0">
			
			
		<tr>
							<td height="20px;" align="center">
								<html:messages id="DB_CON_FAILURE"></html:messages></td>
						</tr>
						<tr>
							<td align="center" >
									<table width="100%" cellspacing="0" cellpadding="0" border="0">
									<tr>
			<th class="table_header" align="center" colspan="2">
			
			<bean:message key="applicant.update.profile" />
			
			
			</th>
			
		</tr>
	
			
		
		<tr>
		<td>
		
		<p>
		<bean:message key="applicant.page.info" />
	</p>
	</td></tr>

			<logic:messagesPresent message="true">	
			<tr>
				<td colspan="5" class="msg_bg"><html:errors /> <html:messages
						id="applicant_add_status" message="true">
						<bean:write name="applicant_add_status" />
					</html:messages></td>
			</tr>
			</logic:messagesPresent>
			<tr>
				<td colspan="5">&nbsp;</td>
			</tr>
			
			<tr>
			<td colspan="5">
			<table width="100%" >
			<tr>
			<td colspan="5" width="100%" class="table_header1" style="width: 974px; height: 23px;">
			<bean:message key="applicant.cretae.login" />
			</td>
			</tr></table></td></tr>
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="lable.username" />
				</td>
				<td><html:text styleClass="input_field validate[required]" styleId="username" name="applicantForm" size="15"
						 property="username" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="lable.password" />
				</td>
				<td><html:password styleClass="input_field validate[required]" styleId="password" name="applicantForm" size="15"
						 property="password" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;
				<bean:message key="applicant.confirm.password" />
				
				</td>
				<td><html:password styleClass="input_field validate[required]" styleId="password" name="applicantForm" size="15"
						 property="password" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			
			
			
			<tr>
			<td colspan="5">
			<table width="100%" >
			<tr>
			<td colspan="5" width="100%" class="table_header1" style="width: 974px; height: 23px;">
			<bean:message key="applicant.contact.details" />
			</td>
			</tr>
			</table></td></tr>
			
			
			
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="employee.table.header.column.empname" />
				</td>
				<td><html:text styleClass="input_field validate[required]" size="50" styleId="name" name="applicantForm"
						 property="name" />&nbsp;<font color="red">*</font>
				</td>
				
			</tr>
	
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="employee.table.header.column.dob" />
				</td>
				<td><html:text styleClass="input_field datepicker validate[required]" size="20" styleId="dob" name="applicantForm"
						 property="dob" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="employee.table.header.column.mobile" /> 
				</td>
				<td><html:text styleClass="input_field validate[required]" styleId="mobileNo" name="applicantForm" size="15"
						 property="mobileNo" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="table.header.column.email" />
				</td>
				<td><html:text styleClass="input_field validate[required],custom[email]" styleId="email" name="applicantForm" size="30"
						 property="email" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			
				
		
			<tr>
			<td colspan="5">
			<table width="100%" >
			<tr>
			<td colspan="5" width="100%" class="table_header1" style="width: 974px; height: 23px;">
			<bean:message key="applicant.employement.details" />
			</td>
			</tr></table></td></tr>
			
		
				<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="label.experienceinmonth.degree" /> 
				</td>
				<td><html:text styleClass="input_field validate[required]" styleId="experience" size="4" name="applicantForm"
						 property="experience" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="label.jobprofile.degree" /> 
				</td>
				<td><html:textarea styleClass="input_field validate[required]" name="applicantForm" rows="2" cols="50"
 
						 property="jobProfile" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="table.header.column.skillset" />
				</td>
				<td><html:textarea styleClass="input_field validate[required]" styleId="skillSet" name="applicantForm" rows="2" cols="50"
						 property="skillSet" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;<bean:message key="table.header.column.resumeheading" />
				</td>
				<td><html:text styleClass="input_field validate[required]" name="applicantForm" size="50"
						 property="resume" />&nbsp;<font color="red">*</font>
				</td>
			</tr>
				
				
			
			
			<tr>
			<td colspan="5">
			<table width="100%" >
			<tr>
			<td colspan="5" width="100%" class="table_header1" style="width: 974px; height: 23px;">
			<bean:message key="applicant.education.background" />
			</td>
			</tr></table></td></tr>
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;
				<bean:message key="applicant.basic.education" />
				
				</td>
				<td><html:select styleClass="input_field" name="applicantForm" 
						property="basicqualification">
						<html:option value="0">Select</html:option>
						<html:option value="B.A">B.A</html:option>
						<html:option value="B.Arch">B.Arch</html:option>
						<html:option value="BCA">BCA</html:option>
						<html:option value="BBA">BBA</html:option>
						<html:option value="B.COM">B.COM</html:option>
						<html:option value="BDS">BDS</html:option>
						<html:option value="B.ED">B.ED</html:option>
						<html:option value="BHM">BHM</html:option>
						<html:option value="B.PHARM">B.PHARM</html:option>
						<html:option value="B.Sc">B.Sc</html:option>
						<html:option value="B.TECH/B.E">B.TECH/B.E</html:option>
						<html:option value="MBBS">MBBS</html:option>
						<html:option value="Diploma">Diploma</html:option>
						<html:option value="BVSC">BVSC</html:option>
						<html:option value="Others">Others</html:option>
					</html:select>
				</td>
				
			</tr>
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;
				<bean:message key="applicant.master.education" />
				</td>
				<td><html:select styleClass="input_field" name="applicantForm" 
						property="masterqualification">
						<html:option value="0">Select</html:option>
						<html:option value="CA">CA</html:option>
						<html:option value="CS">CS</html:option>
						<html:option value="ICWA">ICWA</html:option>
						<html:option value="Integrated PG">Integrated PG</html:option>
						<html:option value="LLM">LLM</html:option>
						<html:option value="M.A">M.A</html:option>
						<html:option value="M.Arch">M.Arch</html:option>
						<html:option value="M.Com">M.Com</html:option>
						<html:option value="M.Ed">M.Ed</html:option>
						<html:option value="M.Sc">M.Sc</html:option>
						<html:option value="MCA">MCA</html:option>
						<html:option value="M.Tech">M.Tech</html:option>
						<html:option value="MBA/PGDM">MBA/PGDM</html:option>
						<html:option value="PG Diploma">PG Diploma</html:option>
						<html:option value="MVSC">MVSC</html:option>
						<html:option value="MCM">MCM</html:option>
						<html:option value="Others">Others</html:option>
					</html:select>
				</td>
				
			</tr>
			
			
			
			<tr>
				<td>&nbsp;&nbsp;&nbsp;
				<bean:message key="applicant.doctorate.education" />
				</td>
				<td><html:select styleClass="input_field" name="applicantForm" 
						property="doctoratequalification">
						<html:option value="0">Select</html:option>
						<html:option value="Ph.D/Doctorate">Ph.D/Doctorate</html:option>
						<html:option value="MPHIL">MPHIL</html:option>
						<html:option value="Others">Others</html:option>
					</html:select>
				</td>
				
			</tr>
			
			<tr>
			<td colspan="5">
			<table width="100%" >
			<tr>
			<td colspan="5" width="100%" class="table_header1" style="width: 974px; height: 23px;">
			<bean:message key="applicant.upload.resume" />
					</td>
			</tr></table></td></tr>
			
			<logic:notEqual name="applicantForm" property="operation" value="S">
			<tr>
					<td class="table_style">&nbsp;&nbsp;&nbsp;
					<bean:message key="label.resume.upload" />
					</td>
					
					<td class="table_style1"><input id="my_file_element" type="file"
						name="uploads[0]" maxlength="400"> &nbsp;&nbsp;</td>
				</tr>
				<tr class="label_style">
					<td colspan="3" class="lable_style"> 
						<div id="files_list"></div>
					</td>
				</tr>
				</logic:notEqual>
				<tr>
				<td>&nbsp;</td>
				</tr>
				<tr class="label_style">
					<td colspan="3" align="center">
						<table cellpadding="0" cellspacing="0" width="70%">
							<logic:notEmpty name="attached">
								<tr>
									<td colspan="2" class="label_style">
										<bean:message key="label.attach.file" />
									</td>
								
							<logic:iterate id="att" name="attached">
								
									<td width="80%" class="table_data"><bean:write name="att" property="attachmentpath" />&nbsp;&nbsp;</td>
									<td class="table_data"><a href='/eHRMS/DownloadResume.do?method=list&path=<bean:write name="att" property="attachmentpath"/>'><img alt="Download" src="images/download.gif" /></a> &nbsp;&nbsp;
												
									</td>
								
							</logic:iterate>
							</tr>
							</logic:notEmpty>
	
			<tr>
			<td>
			&nbsp;
			</td>
			</tr>
						
							
				
			<logic:equal value="A" name="applicantForm"
						property="operation">	
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><html:submit styleClass="button_background" value="Save"
						onclick="javascript:submitMe();" />
				</td>
				<td colspan="3">&nbsp;</td>
			</tr>
			</logic:equal>
			
			
			
			<tr>
			<td>
			&nbsp;
			</td>
			</tr>
			
			<tr>
			<td>
			&nbsp;
			</td>
			</tr>

		</table>
		</table>
		</table>
		</td>
		
		</tr>
		</table>
		</logic:notEmpty>
		

</form>
</body>
</html>

