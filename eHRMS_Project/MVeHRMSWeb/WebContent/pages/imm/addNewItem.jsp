<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		
		<h4>FILL IN THE FIELDS TO ENTER IN A NEW ITEM</h4>
		<html:form action="addNewItem.do" method="post">
			ITEM NAME:<html:text property="itemName"/><br/>
			ITEM COST:<html:text property="itemCost"/><br/>
			ITEM DESCRIPTION:<html:text property="itemDescription"/><br/>
			ITEM CATEGORY:<html:text property="itemCategory"/><br/>
			<html:submit value="Add"/>
		</html:form>
	
	</center>

</body>
</html>