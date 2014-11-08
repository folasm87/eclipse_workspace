<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter"%>
<%@ page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter"%>
<%@ page import="org.springframework.security.core.AuthenticationException"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link type="text/css" href="styles/menu.css" rel="stylesheet" />
    <script type="text/javascript" src="jquery/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="jquery/menu.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<style type="text/css">
* { margin:0;
    padding:0;
}
#menu {
    margin:0 auto;
    width:80%;
}

</style>



<script type="text/javascript">
$(document).ready(function(){
$("body div:last").remove();
});
    function validate()
    {
        var UserName = document.f.j_username.value;
        var password =document.f.j_password.value;
        if(document.f.j_username.value=="" || document.f.j_username.value==null)
        {
            alert('Please Enter UserName');
            document.f.j_username.focus();
            return false;
        }else if (UserName !="")
        {
        	var strArr = new Array();
        	strArr = UserName.split(" ");
        	if(strArr.length>1)
        	{
        		 alert('Please Enter valid UserName');
                 document.f.j_username.focus();
                 return false;
        	}
        }
        if(document.f.j_password.value == "" || document.f.j_password.value ==null)
        {
            alert('Please Enter Password');
            document.f.j_password.focus();
            return false;
        }else if (password !="")
        {
        	var strArr = new Array();
        	strArr = password.split(" ");
        	if(strArr.length>1)
        	{
        		 alert('Please Enter valid Password');
                 document.f.j_password.focus();
                 return false;
        	}
        }
     
        	document.forms[0].action = "j_spring_security_check";
        	document.forms[0].submit();
    }


    function resetForm()
    {
    	document.f.j_username.value= "";
    	document.f.j_password.value = "";
    	return false;
    }
    function setLoginType(el,type){
    if(type=="admin"){
    document.getElementById("newReg").style.display="none";
    
    	document.getElementById("loginType").value="Admin";
    }
    else if(type=="employee"){
    document.getElementById("newReg").style.display="none";
    	document.getElementById("loginType").value="Employee";
    }
    else if(type=="applicant"){
    document.getElementById("newReg").style.display="block";
    	document.getElementById("loginType").value="Applicant";
    }
    
    }
    function reloadPage() {
    	document.URL="/eHRMS";
    }
    </script>
<link rel="stylesheet" type="text/css" href="styles/ehrms_admin.css" />
</head>
<body onload="document.f.j_username.focus();" style="valign: middle; margin: 0px;" >
<table border="0" cellpadding="0" cellspacing="0" width="100%" style="height: 670px;">
<tr style="height: 30px">
<td class="login_table_header1">
<table width="100%" ><tr>
<td width="70%"><img
								src="images/multivision-logo.png" height="60"/></td>
								<td class="headerMenu">
<div id="menu">
    <ul class="menu">
       <li><a href="#" onclick="setLoginType(this,'admin')"><span>Admin</span></a></li>
      <li><a href="#" onclick="setLoginType(this,'employee')"><span>Employee</span></a></li>
        <li class="last"><a href="#" onclick="setLoginType(this,'applicant')"><span>Applicant</span></a></li>
    </ul>
</div>


</td>
</tr></table>
</td>
</tr>
<tr style="height: 100%;">
<td align="center" valign="middle" style="height: 100%;">

<%!String userName = "";%>
	<form name="f" action="<c:url value='j_spring_security_check'/>?userType=test"
		method="post">
		<input type="hidden"  id="loginType"   />
		<table border="1px;" width="28%" align="center" cellspacing="0"
			cellpadding="0"
			style="border-bottom: 1px; border-bottom-color: #993300; border-left: 1px; border-left-color: #993300; border-right: 1px; border-right-color: #993300; border-top: 1px; border-top-color: #993300;">
			<tr>
				<td bgcolor="#FFCC99">
					<table width="100%" cellspacing="0" cellpadding="0" border="0"
						align="center" valign="middle">
						<tr>
							<td class="login_table_header" align="left"><img
								src="images/multivision-logo-small.png" /></td>
						</tr>
						<tr>
							<td height="20px;" align="center">
								<%
									if (request.getParameter("login_error") != null) {
										userName = session
												.getAttribute("SPRING_SECURITY_LAST_USERNAME")
												.toString();
											userName = userName;	
									
									
								%> <img src="images/warning.png" />&nbsp;<font color="red"><bean:message
										key="authentication.failed" /> </font> <%
 	}
 %> <html:messages id="DB_CON_FAILURE"></html:messages></td>
						</tr>
						<tr>
							<td align="center">
								<table width="75%" cellspacing="0" cellpadding="0" border="0">
									<tr>
										<td><bean:message key="lable.username" />:</td>
										<td align="left"><input type="text" name='j_username'
											value='<%=userName%>' class="text_field" />
										</td>
									</tr>
									<tr> <td colspan="2">&nbsp;</td> </tr>
									<tr>  
										<td><bean:message key="lable.password" />:</td>
										<td align="left"><input type='password' name='j_password'
											class="text_field" />
										</td>
									</tr>
									<tr>
										<td height="10px;" colspan="2">&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td align="left"><input type="button"
											onclick="return validate();" class="button_background"
											value="Login" />&nbsp;&nbsp;<input type="reset"
											class="button_background" value="Reset"
											onclick="return reloadPage();" /></td>
									</tr>
									<tr>
									<td colspan="2" align="right"><div id="newReg" style="display: none;"><a href="applicant.do?method=list">Register</a> </div> </td>
									</tr>
								</table></td>
						</tr>
						<tr>
							<td height="20px;">&nbsp;</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>

</td>
</tr>
<tr style="height: 25px;">
<td class="login_table_header1" align="right" style="padding-right: 5px;">
Copyright @ Multivision
</td>
</tr>
</table>
</body>
</html>
