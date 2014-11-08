<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User to DB</title>

</head>
<body>

	<form method="post" action="add.do">
		<div id="container">
			<label for="first"> First Name: </label> 
			<input type="text" name="first" id="first" /> <br /> 
			
			<label for="last">Last Name: </label> 
			<input type="text" name="last" id="last" /> <br /> 
			
			<label for="username"> Username: </label> 
			<input type="text" name="username" id="username" /> <br /> 
			
			<label for="password">Password: </label> 
			<input type="password" name="password" id="password" /> <br /> 
			
			<label for="balance"> Account Balance($): </label> 
			<input type="text" name="balance" id="balance" /> <br /> 
			
			
			<br /> <input type="submit" value="Add User"> <input type="reset">
		</div>
	</form>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="ajaxtodb.js"></script>
	
</body>
</html>