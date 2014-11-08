<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!-- include java classs -->
<%@ page import="java.io.*, java.util.*, java.sql.*"%>
<%@ page import="javax.servlet.http.*, javax.servlet.*"%>

<!-- get our tag libraries -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Employees</title>
</head>
<body>

	<sql:setDataSource var="snapshot" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="core" password="core" />

	<sql:update dataSource="${snapshot}" var="result0">
		INSERT INTO Employeez VALUES (104, 'Homer', 'Simpson', 37)
		</sql:update>

	
	<sql:query dataSource="${snapshot}" var="result">

		SELECT * from EMPLOYEEZ order by e_id

	</sql:query>

	
	<h1>Here are the current employees:</h1>
	<hr />
	<table border="1" width="80%">
		<tr>
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.e_id}" /></td>
				<td><c:out value="${row.e_first}" /></td>
				<td><c:out value="${row.e_last}" /></td>
				<td><c:out value="${row.e_age}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>