<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.error{
	color:#ff0000;
}
	
</style>
</head>
<body>
	<h2>Data Saver JSP with Validation</h2>
	<form:form method="POST" commandName="employee" action="${pageContext.request.contextPath}/blah/save">
		<table>
			<tr>
				<td>Employee Id:</td>
				<td><form:input path="id"/></td>
				<td><form:errors path="id" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Employee Name:</td>
				<td><form:input path="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Employee Age:</td>
				<td><form:input path="age"/></td>
				<td><form:errors path="age" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Employee Salary:</td>
				<td><form:input path="salary"/></td>
				<td><form:errors path="salary" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>