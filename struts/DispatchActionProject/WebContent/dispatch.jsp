<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<html:errors/>
<html:form method="POST" action="dispatcher">

 <html:text property="test"></html:text>
 <html:submit property="method" value="create"></html:submit>
  <html:submit property="method" value="delete"></html:submit>
   <html:submit property="method" value="search"></html:submit>
</html:form>

</body>
</html>