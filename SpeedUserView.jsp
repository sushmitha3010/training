<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1 > Speed Post Tracking View !!!</h1>
	<br>
	<br>
	<br>

<%
	HttpSession session2 = request.getSession();


String status = (String) session2.getAttribute("status1_List");

%>

<table><caption>Speed</caption>

		<thead>
			<tr>



				<th>status</th>

			</tr>
		</thead>
		<tbody>
		
		
		<tr>
				<td><%=status%></td>
			</tr>
			
			</tbody>

	</table>

			

</body>
</html>