<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comment</title>
</head>
<body>

<html:form action="comment.do" method="post">
<table>
	<tr>
	<td>
		Your Name:
	</td>
	<td>
		<html:text property="name"></html:text>	
	</td>
	 
	</tr>
	
	<tr>
		<td>
			Subject:
		</td>
		<td>
			<html:text property="subject"></html:text>
		</td>
	 
	</tr>
	
	<tr>
		<td>
			Comment:
		</td>
		<td>
			<html:textarea property="comment"></html:textarea>
		</td>
		
	</tr>
	
	<tr>
		<td>
		<html:submit>Comment</html:submit>
		</td>
		<td>
			<a href="view.jsp">View All Comments</a>
		</td>
	</tr>
	
</table>
	
	 
	 
	
	
</html:form>

</body>
</html>