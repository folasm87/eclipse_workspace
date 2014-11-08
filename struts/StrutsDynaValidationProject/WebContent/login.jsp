<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Log In here:</h1>
	<h3><html:errors/></h3>
	<html:form action="login.do">
		<table border="3">
			<tr>
				<td>Username:</td>
				<td><html:text property="username"></html:text></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><html:password property="password"></html:password></td>
			</tr>
			<tr>
				<td><html:submit value="Log In!"></html:submit></td>
				<td><html:reset/></td>
			</tr>
		</table>
	</html:form>

</body>
</html>