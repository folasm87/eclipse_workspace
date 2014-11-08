<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<title><tiles:getAsString name="title"/></title>
</head>
<body>
	<div class="container-fluid">
			
			<table border="1" width="100%" cellspacing="5">
				<div class="row">
					<tr>
						<div class="col-md-12"><td colspan="2"><tiles:insert attribute="header"/></td></td></div>
				  		
					</tr>
				</div>
				<div class="row">
					<tr>
						<div class="col-md-8"><td width="140" valign="top"><tiles:insert attribute="menu"/></td></div>
				  		<div class="col-md-4"><td valign="top" align="left" height="300"><tiles:insert attribute="body"/></td></div>
					</tr>
				</div>
				<div class="row">
					<tr>
						<div class="col-md-12"><td colspan="2"><tiles:insert attribute="footer"/></td></div>
				  		
					</tr>
				</div>

			</table>
		
	</div>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>