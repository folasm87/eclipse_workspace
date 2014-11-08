<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	
<%@page import="java.util.*"%><html>
<head>
<%int i =0;
				int j=0;
				int k=0;%>
<script type="text/javascript"><!--

function saveRecord(){
	<%List parentList = (List)session.getAttribute("parentMenuList");
	List subList = (List)session.getAttribute("subMenuList");
	%>
	
	var pread = "pread";
	var pwrite = "pwrite";
	var sread = "sread";
	var swrite = "swrite";
	var parentr ="";
	var parentw ="";
	var subr = "";
	var subw ="";
	var i = <%=parentList.size()%>;
	var j = <%=subList.size()%>;
	var k=0;
	
	
	 for(var z=0;z<i;z++){
		
		var parRead='';
		var parWrite='';
		if(document.getElementById('pwrite'+z).checked==true){
			k++;
			parWrite = 'True';
		}else{
			parWrite = 'False';
		}
		parentr=parentr+parRead+"==";
		parentw=parentw+parWrite+"==";

		
	}
	
	 for(var y=0;y<j;y++){
		
		var subRead='';
		var subWrite='';
		if(document.getElementById('swrite'+y).checked==true){
			k++;
			subWrite = 'True';
		}else{
			subWrite = 'False';
		}
		subr=subr+subRead+"==";
		subw=subw+subWrite+"==";
	}
	
	
	if(k>0){	

	 document.roleAccessForm.parentWrite.value=parentw;	
	 document.roleAccessForm.subWrite.value=subw;
	
     document.roleAccessForm.action = "/eHRMS/menuAccessSave.do?method=save";
	 document.roleAccessForm.method = "post";
	 document.roleAccessForm.submit(); 
	
	if (window.opener && !window.opener.closed) {
		 window.opener.location.href="/eHRMS/RoleAccessAdd.do?access=access";
		}
	}else{
		alert("Please give access to atleast one menu");
	}
		
	
}
function checkr(obj){
    
    var obj1 = obj.replace("read", "write");
    if(document.getElementById(obj).checked==true){
    	document.getElementById(obj1).checked = false ;
    }
    
}
function checkw(obj){
    var obj1 = obj.replace("write", "read");
    if(document.getElementById(obj).checked==true){
    }
    
}
function selectAllw(){
	
	var i = <%=parentList.size()%>;
	var j = <%=subList.size()%>;
	var k=i+j;
	var pw = "pwrite";
	var sw = "swrite";
	var ssw = "sswrite";
	var pr = "pread";
	var sr = "sread";
	var ssr = "ssread";
	
	 if(document.getElementById("writeMark").checked==true){
	for(var z=0;z<i;z++){
		 var pwt = pw+z;
		 document.getElementById(pwt).checked = true;
		 
	 }
	for(var y=0;y<j;y++){
		 var swt = sw+y;
		 document.getElementById(swt).checked = true; 
		 
	 }
	
	 }else{
	 
	 for(var z=0;z<i;z++){
		 var pwt = pw+z;
		 document.getElementById(pwt).checked = false;
		 
	 }
	for(var y=0;y<j;y++){
		 var swt = sw+y;
		 document.getElementById(swt).checked = false; 
		 
	 }
	 }
}

	</script>
	<style type="text/css">
	.chart_file {
		margin: 0px;
		padding: 0px 0px 0px 0px;
		width: 100%;
		background-color: #993300;
		text-align: center;
		color: #000;
		border: #666666 1px solid;
		font-size: 11px; 
		font-family: verdana;
	}
	.row_title {
		border-bottom: #ccc 1px solid; 
		border-right: #ccc solid 1px; 
		font-size: 10px; 
		color: #fff;
		font-family: Arial, Helvetica, sans-serif;
		height: 30px;
		width: 20%;
		}
	.odd_info {
		border-right: #ccc solid 1px; 
		border-bottom: #fff 1px solid; 
		color:#000000;
		background-color: #FFFFFF; 
		height: 25px;
		padding-left: 10px;
		border-bottom: #cccccc 1px solid;
		text-align: left;
		width: 20.2%;
	}
	.even_info {
		border-right: #ccc solid 1px; 
		border-bottom: #fff 1px solid; 
		color:#000000;
		background-color: #EBEAE9;
		border-bottom: #cccccc 1px solid; 
		height: 25px;
		padding-left: 10px;
		text-align: left;
		width: 20.2%;
	}
	
		
</style>
</head>

<body id="dt_example">
<html:form action="/menuAccess.do">

<table width="100%" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<th class="table_header"><bean:message
					key="sysrole.table.header.column.menuaccess" /></th>
		</tr>
	</table>
		<table width="100%" cellspacing="0" cellpadding="0" border="0">
		<tr>
				<td colspan="5" align="right"><a
					href="/eHRMS/systemRoles.do?method=list"><bean:message
							key="go.to.main.page" /> </a>
				</td>
			</tr>
	<tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
	<logic:messagesPresent message="true">
	<tr>
				<td colspan="5" class="msg_bg"><html:errors /> <html:messages
						id="employee_add_status" message="true">
						<bean:write name="employee_add_status" />
					</html:messages></td>
			</tr>
			</logic:messagesPresent>
		</table>
		
		<table width="100%" cellspacing="0" cellpadding="0" border="0">
	<tr>
				<td colspan="5">&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</table>
	<p>
                  
		<table width="100%"  border="0"  cellpadding="0" cellspacing="0" class="chart_file">
				<tr>
			<td class="row_title" style="border-left: 1px solid #fff; border-top: 1px solid #fff; ">
			<bean:message key="role.menu.module" />
			</td>
			<td class="row_title" style="border-top: 1px solid #fff; ">
			<bean:message key="role.menu.screenName" />
			</td>
			<td class="row_title" style="border-top: 1px solid #fff; ">
			<bean:message key="role.menu.isaccess" />
			<input type="checkbox" name="writeMark" id="writeMark"  onclick="selectAllw();"/></td>
		</tr>
		<%int rowCount=0;%>
				
				<logic:iterate id="parent" name="parentMenuList">
				<bean:define id="id" name="parent" property="id"></bean:define>
				<% String parentId  = id.toString();
				int pid = Integer.parseInt(parentId);%>
				<%String fn="pread"+i;%>
				<%String rn="pwrite"+i;
				i++;%>
				<tr>
				<%if(rowCount%2==0){ %>
				<td class="odd_info"  style="border-left: 1px solid #fff; ">
				<%}else{ %>
				<td class="even_info"  style="border-left: 1px solid #fff; ">
				<%} %>
				<bean:write name="parent" property="name"/>
				</td>
				<%if(rowCount%2==0){ %>
				<td class="odd_info">
				<%}else{ %>
				<td class="even_info">
				<%} %>&nbsp;</td>
				<%if(rowCount%2==0){ %>
				<td class="odd_info">
				<%}else{ %>
				<td class="even_info">
				<%} %>
				<input type="checkbox" name=<%=rn%> id=<%=rn%> onclick="checkw(this.id);"/>
				</td>
				<%rowCount++;  %>
				</tr>
				<logic:iterate id="sub" name="subMenuList">
				<bean:define id="parentid" name="sub" property="parentid.id"></bean:define>
				<bean:define id="subid" name="sub" property="id"></bean:define>
				<%String parentIds  = parentid.toString(); 
				String subId = subid.toString();
				int sids = Integer.parseInt(subId);%>
				<%if(parentId.equals(parentIds)){ %>
				
				<%fn="sread"+j;%>
				<%rn="swrite"+j;
				j++;%>
				<tr>
				<%if(rowCount%2==0){ %>
				<td class="odd_info"  style="border-left: 1px solid #fff; ">
				<%}else{ %>
				<td class="even_info"  style="border-left: 1px solid #fff; ">
				<%} %>&nbsp;</td>
				<%if(rowCount%2==0){ %>
				<td class="odd_info">
				<%}else{ %>
				<td class="even_info">
				<%} %>
				<bean:write name="sub" property="name"/>
				</td>
				<%if(rowCount%2==0){ %>
				<td class="odd_info">
				<%}else{ %>
				<td class="even_info">
				<%} %>
				<input type="checkbox" name=<%=rn%> id=<%=rn%> onclick="checkw(this.id);"/>
				</td>
				<%rowCount++;  %>
				</tr>
				
				<%} %>
				</logic:iterate>
				</logic:iterate>
			</table>
			<br></br>
			<tr>
			<td align="center">
			<html:button property="save" onclick="saveRecord();"
										styleClass="submit-button">
									<bean:message key="button.save" />	
									</html:button>
									
									</td>
									</tr>
		
			<html:hidden name="roleAccessForm"
						property="parentRead"></html:hidden>
			<html:hidden name="roleAccessForm"
						property="parentWrite"></html:hidden>
			<html:hidden name="roleAccessForm"
						property="subRead"></html:hidden>
			<html:hidden name="roleAccessForm"
						property="subWrite"></html:hidden>

	</html:form>
</body>
