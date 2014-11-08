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
<title>TimeSheet</title>
</head>
<body>

	<%-- 	<sql:setDataSource var="snapshot" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="hibernate" password="hibernate" />

	<sql:query dataSource="${snapshot}" var="result">

		SELECT * from TIMESHEET order by <%= session.getAttribute("user_id") %>

	</sql:query> --%>

	<%@ page import="net.mv.dao.Timesheet"%>
	<%@ page import="net.mv.dao.T_User"%>
	<%@ page import="java.util.Calendar" %>
	<%@ page import="java.text.SimpleDateFormat" %>
	<%@ page import="java.util.concurrent.TimeUnit" %>



	<h1>Here is your Time Sheet</h1>
	<hr />
	<table border="1" width="80%">
		<tr>
			<th>User</th>
			<th>Month/Day/Year</th>
			<th>Start Hour : Minute</th>
			<th>End Hour : Minute</th>
			
		</tr>
		<%
	
			Set <Timesheet> tsheets = (Set)session.getAttribute("user_tsheet"); 
			
			Iterator t = tsheets.iterator();
			
			
			
			while(t.hasNext()){
			
				Timesheet current = (Timesheet)t.next();
				
				int day = current.getDAY();
				int month = current.getMONTH();
				int year = current.getYEAR();
				
				int start_hour = current.getSTART_HOUR();
				int start_min = current.getSTART_MIN();
				
				int end_hour = current.getEND_HOUR();
				int end_min = current.getEND_MIN();
				
		/* 		Calendar start_cal = Calendar.getInstance();
				Calendar end_cal = Calendar.getInstance();
				start_cal.set(year,month,day,start_hour, start_min);//2009,4,22);
				end_cal.set(year,month,day,end_hour, end_min);
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				sdf.format(start_cal); */
				
				/*
				I almost finished this just needed to get the above code into a calendar format 
				to calculate the hours. 
				
				*/
				
				String name = current.getUser().getFNAME() + " " + current.getUser().getLNAME();
				String date = month + "/" + day + "/" + year;
				String start = start_hour+ " : " + start_min;
				String end = end_hour + " : " + end_min;
		
		 %>
		
				<tr>
					<td><c:out value="<%= name %>"/></td>
					<td><c:out value="<%= date %>" /></td>
					<td><c:out value="<%= start %>" /></td>
					<td><c:out value="<%= end %>" /></td>
					
				</tr>
		
		
		<%
			}
		 %>

	</table>
</body>
</html>