<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Enter Recipe Information here:</h1>
	<h3><html:errors/></h3>
	<html:form action="insert.do">
		<table border="3">
			<tr>
				<td>Name:</td>
				<td><html:text property="name"></html:text></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><html:text property="type"></html:text></td>
			</tr>
			<tr>
				<td>Time:</td>
				<td><html:text property="time"></html:text></td>
			</tr>
			<tr>
				<td>Servings:</td>
				<td><html:text property="servings"></html:text></td>
			</tr>
			<tr>
				<td>Ingredients:</td>
				<td><html:text property="ingredients"></html:text></td>
			</tr>
			<tr>
				<td>Directions:</td>
				<td><html:text property="directions"></html:text></td>
			</tr>
			<tr>
				<td><html:submit value="Push Me!"></html:submit></td>
				<td><html:reset/></td>
			</tr>
		</table>
	</html:form>
</body>
</html>