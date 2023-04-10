<%@page import="com.postoffice.postofficemanagement.model.SpeedPostModel"%>
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






<h1>Speed Post User List !!!</h1><br><br><br>


<form action="/speedReach" method="post">
<form action="/speedProcess" method="post">

<% HttpSession session2=request.getSession();
List<SpeedPostModel> listSpeedPostUser=(List<SpeedPostModel>) session2.getAttribute("SpeedPostUser_List");
		
		%>

	
	
	<table><caption>Speed Post</caption>
	
		<thead>
   			<tr>
   			
   			
   			    <th>trackingId</th>
    			<th>senderName</th>
   				<th>senderMobileNo</th>
   				<th>senderAddress</th>
   				
   				<th>kms</th>
   				<th>receiverName</th>
   				<th>receiverMobileNo</th>
   				<th>receiverAddress</th>
   				<th>bookingDate</th>
   				
   				<th>status</th>


			</tr>
		</thead>
		<tbody>
        <% for(SpeedPostModel speed:listSpeedPostUser){%>
        	<tr>
        	
        	<td><input type="checkbox" value="<%=speed.getTrackingId() %>" name="checkbox">
        	 <%=speed.getTrackingId() %>
        	
        	</td>
        	</form>
        	

        	
        	<td> <%=speed.getSenderName() %> </td>
        	<td> <%=speed.getSenderMobileNo() %> </td>
        	<td> <%=speed.getSenderAddress() %> </td>
        	
        	<td> <%=speed.getKms() %> </td>
        	<td> <%=speed.getReceiverName() %> </td>
        	<td> <%=speed.getReceiverMobileNo() %> </td>
        	<td> <%=speed.getReceiverAddress() %> </td>
        	<td> <%=speed.getBookingDate() %> </td>
        	 <td> <%=speed.getStatus() %> </td>
        	</tr>
        	<%} %>
        	
        

</tbody>
</table>
</form>
<button type="Processing" value="Processing">Processing<form action="/speedProcess" method="post"></button>
        	
<button type="Delivered" value="Delivered">Delivered<form action="/speedReach" method="post"></button>

</body>
</html>