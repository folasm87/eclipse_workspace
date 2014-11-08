<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="ajaxtodb.css">
</head>
<body>

	<form method="post" action="submit.do">
		<div id="container">
			<label for="name"> Name </label> 
			<input type="text" name="name" id="name" />
			 <br /> 
			 <label for="email">Email</label> 
			 <input type="text" name="email" id="email" /> 
			 <br /> 
			 <label for="comment">
				Comments 
			</label>
			<textarea rows="5" cols="35" id="comment" name="comment"></textarea>
			<br /> <input type="submit" value="Comment"> <input
				type="reset">
		</div>
	</form>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="ajaxtodb.js"></script>
</body>
</html>