<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Please Login</title>

</head>
<body>
<h2>Provide your username and Password to Access your account</h2>
	<form action="login.do" method="post">
		<div id="container">
			<label for="username"> Username: </label> 
			<input type="text" name="username" id="username" /> <br /> 
			
			<label for="password">Password: </label> 
			<input type="password" name="password" id="password" /> <br /> 
			
			<input type="submit" value="Login" id="login"> <input type="reset">
		</div>

	</form>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="ajaxtodb.js"></script>

</body>
</html>