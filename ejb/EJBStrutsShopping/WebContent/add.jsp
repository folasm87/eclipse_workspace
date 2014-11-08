<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add an Item to your Shopping Cart</title>
</head>
<body>
	<h3>Please Add an Item</h3>
	<html:form action="additem" method="post">
		<html:text property="item"/>
		<html:submit value="Add Item"/>
		
	</html:form>
</body>
</html>