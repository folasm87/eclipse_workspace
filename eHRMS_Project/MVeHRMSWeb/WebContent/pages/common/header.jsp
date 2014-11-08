<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<table width="100%" cellspacing="0" cellpadding="0" border="0">
	<tr>
		<td align="left" class="page_header">
			<table width="100%" cellspacing="0" cellpadding="0">
				<tr>
					<td><img src="images/multivision-logo.png" /></td>
					<td width="65%">&nbsp;</td>
					<td><font color="#ffffff"> <bean:message
								key="welcome.title" /> <bean:write name="user" scope="session"
								property="username" />&nbsp;(<a href="/eHRMS/logout.do"><img
								src="images/logout.png" align="bottom" width="10px"
								height="10px" alt="Signout" title="Signout" /></a>)&nbsp;</font></td>
				</tr>
			</table>
		</td>
	</tr>
</table>