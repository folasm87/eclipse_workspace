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

<title>Please Login</title>

</head>
<body>
<h2>User Info</h2>

		<table border='3'>
		<tr>
		<td>Customer First Name</td>
		<td>Customer Last Name</td>
		<td>Customer Account Balance</td>
		<tr>
		<td>"+ map.get("first") + "</td>
		<td>"+ map.get("last") + "</td>
		<td>"+ map.get("balance") + "</td>
		<tr>
		</table>
        <a href='home.jsp'>Go back</a>
        <form action='deposit.do' method='post' id='deposit'><label for='desposit'> <input type='hidden' id='balance' value='" + map.get("balance")+ "'></input>Deposit: </label><input type='text' name='deposit' id='amount' /> <input type='submit' value='Deposit' id='deposit'></form> 
        <form action='withdraw.do' method='post' id='withdraw'><label for='withdraw'><input type='hidden' id='balance' value='" + map.get("balance")+ "'></input> Withdraw: </label><input type='text' name='withdraw' id='amount' /> <input type='submit' value='Withdraw' id='withdraw'></form> 


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="ajaxtodb.js"></script>

</body>
</html>