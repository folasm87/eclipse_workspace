<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User to System</title>
</head>
<body>

	<h2>Welcome SuperUser!. This is the page where you can add users to the system.</h2>
	<h3><html:errors/></h3>
	<html:form action="insert.do">
		<table border="3">
			<tr>
				<td>First Name:</td>
				<td><html:text property="fname"></html:text></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><html:text property="lname"></html:text></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><html:text property="username"></html:text></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><html:text property="password"></html:text></td>
			</tr>
			<tr>
				<td>Super User? (True or False)</td>
				<td><html:text property="super_user"></html:text></td>
			</tr>
			<tr>
				<td><html:submit value="Add User!"></html:submit></td>
				<td><html:reset/></td>
			</tr>
		</table>
	</html:form>
	<br/>
	<h3><a href="main.jsp">Logout?</a></h3>
	<h3><a href="loghours.jsp">Log Your Hours</a></h3>
	<h3><a href="viewtimesheet.jsp">View Timesheet</a></h3>

</body>
</html>