<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); %>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
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
<title>Insert title here</title>
</head>
<body>

	
	
        <% 
            Connection connection = DriverManager.getConnection(
               "jdbc:oracle:thin:@localhost:1521:xe", "core", "core");

            Statement statement = connection.createStatement() ;
            ResultSet resultset = 
                statement.executeQuery("select * from Recipes") ; 
        %>

	<h2>Here are the current recipes:</h2>
	<hr />
	<table border="1" width="80%">
		<tr>
			<th>Recipe Name</th>
			<th>Recipe Type</th>
			<th>Recipe Time</th>
			<th>Servings</th>
			<th>Ingredients</th>
			<th>Directions</th>
		</tr>
		<% while(resultset.next()){ %>
            <tr>
                <td> <%= resultset.getString(1) %></td>
                <td> <%= resultset.getString(2) %></td>
                <td> <%= resultset.getString(3) %></td>
                <td> <%= resultset.getString(4) %></td>
                <td> <%= resultset.getString(5) %></td>
                <td> <%= resultset.getString(6) %></td>
            </tr>
         <% } %>

	</table>

</body>
</html>