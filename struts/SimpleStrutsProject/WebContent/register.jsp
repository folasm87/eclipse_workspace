<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the register page</title>
</head>
<body>
	<html:errors />
	<form action="register.do" method="POST">
		<table border="1">
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>DOB:</td>
				<td><input type="text" name="dob"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
				<td><input type="reset" name="Clear"></td>
			</tr>
		</table>
	</form>
	<!-- 
		Create a register(that is already created) that will redirect to login.jsp
		and System.out the information (4 things) entered by the user using Struts.
		
		
		Homework:
		
		Validate the register.jsp file and make all the fields required
		1. RegisterForm.java
		2. MessageResources.properties
		3. register.jsp
		4. struts-config.xml
		
		
	 -->
</body>
</html>