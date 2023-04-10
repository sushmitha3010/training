<%@page import="java.util.List"%>
<%@page import="com.postoffice.postofficemanagement.model.SeniorCitizenModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<h1>Senior Citizen Deposit User List !!!</h1>
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
 List<SeniorCitizenModel> listSeniorCitizenDepositUser=(List<SeniorCitizenModel>) session2.getAttribute("SeniorCitizenDepositUser_List");
		
		%>

	
	
	<table><caption>Senior Citizen</caption>
	
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
        <% for(SeniorCitizenModel seniorCitizen:listSeniorCitizenDepositUser){%>
        	<tr>
        	<td> <%=seniorCitizen.getUserId() %> </td>
        	<td> <%=seniorCitizen.getUserName() %> </td>
        	<td> <%=seniorCitizen.getMobileNo() %> </td>
        	
        	<td> <%=seniorCitizen.getAccountNo() %> </td>
        
        	<td> <%=seniorCitizen.getPrincipleAmount() %> </td>
        	
        	</tr>
        	<%} %>
        	
        

</tbody>
</table>

 

</body>
</html>