<%@page import="java.util.List"%>
<%@page import="com.postoffice.postofficemanagement.model.MonthlyIncomeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
tr:nth-child(even) {background-color: #f2f2f2;}
th {
  background-color: #04AA6D;
  color: white;
}
</style>
<body>
 <% HttpSession session2=request.getSession();
 List<MonthlyIncomeModel> listMonthlyIncomeDepositUser=(List<MonthlyIncomeModel>) session2.getAttribute("MonthlyIncomeDepositUser_List");
		
		%>

	
	
	<table><caption>Monthly Income</caption>
	
		<thead>
   			<tr>
   				<th>userId</th>
   				<th>userName</th>
   				<th>mobileNo</th>
   				<th>accountNo</th>
   				<th>ifscCode</th>
   				<th>principleAmount</th>
   				

			</tr>
		</thead>
		<tbody>
        <% for(MonthlyIncomeModel monthlyIncome:listMonthlyIncomeDepositUser){%>
        	<tr>
        	<td> <%=monthlyIncome.getUserId() %> </td>
        	<td> <%=monthlyIncome.getUserName() %> </td>
        	<td> <%=monthlyIncome.getMobileNo() %> </td>
        	
        	<td> <%=monthlyIncome.getAccountNo() %> </td>
        	<td> <%=monthlyIncome.getIfscCode() %> </td>
        	<td> <%=monthlyIncome.getPrincipleAmount() %> </td>
        	
        	</tr>
        	<%} %>
        	
        

</tbody>
</table>

 
</body>
</html>