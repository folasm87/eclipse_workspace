<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Multivison HRMS Application</title>
<link type="text/css"
	href="styles/smoothness/jquery-ui-1.8.17.custom.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="styles/ehrms_admin.css" />
<script type="text/javascript" src="jquery/jquery-1.7.1.js"></script>
<script type="text/javascript"
	src="jquery/jquery-ui-1.8.17.custom.min.js"></script>
	<script type="text/javascript"
	src="jquery/jquery.validationEngine.js"></script>
	<script type="text/javascript"
	src="jquery/jquery.validationEngine-en.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/validationEngine.jquery.css" />
</head>
<body>
	<table bgcolor="#ffffff" width="100%" style="height: 500px;"
		 border="0" cellspacing="0" cellpadding="0" valign="top">
		<tr>
			<td colspan="2" style="height: 10px;"><tiles:insert
					attribute="header" />
			</td>
		</tr>
		<tr valign="top">
			<td width="20%" class="leftMenu"><tiles:insert attribute="menu" />
			</td>
			<td valign="top">
				<table width="100%" cellspacing="2" cellpadding="5">
					<tr>
						<td><tiles:insert attribute="body" />
						</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td colspan="2" class="footer"><tiles:insert attribute="footer" />
			</td>
		</tr>
	</table>

</body>
</html>
