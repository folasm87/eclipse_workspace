<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping App</title>
</head>
<body>
	<h3>Your Shopping Cart</h3>
	<%@ page import="java.util.List" %>
	
	<ul>
		<% 
			List<String> items = (List<String>)session.getAttribute("cartList");
			if (items != null){
				for (int i = 0; i < items.size(); i++){
		 %>
				
					<li><%=items.get(i) %></li>
				
		<%
				}
			}
		 %>
	</ul>
	
	<a href="add.jsp">Add Item</a>
	


	
	

</body>
</html>