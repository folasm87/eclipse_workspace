<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log Hours</title>
</head>
<body>

	<h2>Log Your Hours</h2>
	<h3><html:errors/></h3>
	<html:form action="log.do">
		<table border="3">
			<tr>
				<td>Month - (1 - 12):</td>
				<td><html:text property="month"></html:text></td>
				<td>Day - (1 - 31):</td>
				<td><html:text property="day"></html:text></td>
				<td>Year:</td>
				<td><html:text property="year"></html:text></td>
			</tr>
			<tr>
				<td>Start Hour - (7 PM = 19):</td>
				<td><html:text property="start_hour"></html:text></td>
				<td>Start Minute:</td>
				<td><html:text property="start_min"></html:text></td>
			</tr>
			<tr>
				<td>End Hour - (7 PM = 19):</td>
				<td><html:text property="end_hour"></html:text></td>
				<td>End Minute:</td>
				<td><html:text property="end_min"></html:text></td>
			</tr>
			<tr>
				<td><html:submit value="Log Time"></html:submit></td>
				<td><html:reset/></td>
			</tr>
		</table>
	</html:form>

</body>
</html>