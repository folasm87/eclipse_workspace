<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title"/></title>
</head>
<body>
	<table border="1" width="100%" cellspacing="5">
		<tr>
			<td colspan="2"><tiles:insert attribute="header"/></td>
		</tr>
		<tr>
			<td width="140" valign="top"><tiles:insert attribute="menu"/></td>
			<td valign="top" align="left"><tiles:insert attribute="body"/></td>
		</tr>
		<tr>
			<td colspan="2"><tiles:insert attribute="footer"/></td>
		</tr>
	</table>
</body>
</html>