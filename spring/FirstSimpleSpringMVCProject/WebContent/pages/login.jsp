<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	Final Step! Please Login <strong>${username}</strong><br/>
	
	
	<form:form action="/FirstSimpleSpringMVCProject/loginSubmit" method="POST" commandName="login">
		Username:<form:input type="text" path="username"/> <br /> 
		Password: <form:input type="password" path="password"/> <br /> 
		<input type="submit" value="Login">
	</form:form>
</body>
</html>