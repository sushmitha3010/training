<%@page import="java.util.List"%>
<%@page import="com.postoffice.postofficemanagement.model.RecurringDepositModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<h1>Recurring Deposit User List !!!</h1>
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
 List<RecurringDepositModel> listRecurringDepositUser=(List<RecurringDepositModel>) session2.getAttribute("RecurringDepositUser_List");
		
		%>

	
	
	<table><caption>Recurring Deposit</caption>
	
		<thead>
   			<tr>
   				<th>userId</th>
   				<th>userName</th>
   				<th>mobileNo</th>
   				<th>accountNo</th>
   				
   				<th>principleAmount</th>
   				<th>noOfMonths</th>
   				

			</tr>
		</thead>
		<tbody>
        <% for(RecurringDepositModel recurring:listRecurringDepositUser){%>
        	<tr>
        	<td> <%=recurring.getUserId() %> </td>
        	<td> <%=recurring.getUserName() %> </td>
        	<td> <%=recurring.getMobileNo() %> </td>
        	
        	<td> <%=recurring.getAccountNo() %> </td>
      
        	<td> <%=recurring.getPrincipleAmount() %> </td>
        	<td><%=recurring.getNoOfMonths() %></td>
        	
        	</tr>
        	<%} %>
        	
        

</tbody>
</table>

</body>
</html>