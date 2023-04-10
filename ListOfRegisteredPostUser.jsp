<%@page import="com.postoffice.postofficemanagement.model.RegisteredPostModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

<form action="/registerCheck" method="post">

<h1>Register Post User List !!!</h1><br><br><br>

<%

 HttpSession session2=request.getSession();
List<RegisteredPostModel> listRegisterPostUser=(List<RegisteredPostModel>) session2.getAttribute("RegisterPostUser_List");
%>

	
	
	<table><caption>Register Post</caption>
	
		<thead>
   			<tr>	
   				<th>trackingId</th>
   				<th>senderName</th>
   				<th>senderMobileNo</th>
   				<th>senderAddress</th>
   				<th>parcelWeight</th>
   				<th>receiverName</th>
   				<th>receiverMobileNo</th>
   				<th>receiverAddress</th>
   				<th>bookingDate</th>

   				<th>status</th>


			</tr>
		</thead>
		<tbody>
        <%
        
         for(RegisteredPostModel register:listRegisterPostUser)
         { %>
        	<tr>
        	
        	<td><input type="checkbox" value="<%=register.getTrackingId() %>" name="checkbox1">
        	<button type="Submit"> <%=register.getTrackingId() %></button>
        	
        	</td>
        	</form>
        
        	
        		
        	<td> <%=register.getSenderName() %> </td>
        	<td> <%=register.getSenderMobileNo() %> </td>
        	<td> <%=register.getSenderAddress() %> </td>
        	<td> <%=register.getParcelWeight() %> </td>
        	<td> <%=register.getReceiverName() %> </td>
        	<td> <%=register.getReceiverMobileNo() %> </td>
        	<td> <%=register.getReceiverAddress() %> </td>
        	<td> <%=register.getBookingDate() %>
	
        	<td><%=register.getStatus() %></td>
        	</tr>
        	<%} %>
        	
        

</tbody>
</table>
</form>
<button type="Processing" value="Processing">Processing<form action="/registerProcess" method="post"> </button>
<button type="Delivered" value="Delivered">Delivered<form action="/registerCheck" method="post"></button>

</body>
</html>