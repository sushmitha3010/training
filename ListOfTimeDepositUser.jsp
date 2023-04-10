<%@page import="java.util.List"%>
<%@page import="com.postoffice.postofficemanagement.model.TimeDepositModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<h1 >Time Deposit User List !!!</h1>
</head>
<style>
body{
background-color:lightGreen;
}
tr {
background-color:silver; 
}
th {
  background-color: #04AA6D;
  color: black;
}
</style>
<body>
<% HttpSession session2=request.getSession();
 List<TimeDepositModel> listTimeDepositUser=(List<TimeDepositModel>) session2.getAttribute("TimeDepositUser_List");
		
		%>

	
	
	<table><caption>Time Deposit</caption>
	
		<thead>
   			<tr>
   				<th>userId</th>
   				<th>userName</th>
   				<th>mobileNo</th>
   				<th>accountNo</th>
   				
   				<th>principleAmount</th>
   				

			</tr>
		</thead>
		<tbody>
        <% for(TimeDepositModel time:listTimeDepositUser){%>
        	<tr>
        	<td> <%=time.getUserId() %> </td>
        	<td> <%=time.getUserName() %> </td>
        	<td> <%=time.getMobileNo() %> </td>
        	
        	<td> <%=time.getAccountNo() %> </td>
        	
        	<td> <%=time.getPrincipleAmount() %> </td>
        	
        	</tr>
        	<%} %>
        	
        

</tbody>
</table>


</body>
</html>