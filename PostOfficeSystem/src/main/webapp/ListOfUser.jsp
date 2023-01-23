<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View List</title>
</head>
<body>
<h1 style="text-align:center">List Of User</h1>
    <%Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle"); 
    String query="select * from Deposit";
    PreparedStatement ps=connection.prepareStatement(query);
    ResultSet rs=ps.executeQuery();
    %>
    <table>
    <thead>
    <tr>
    <th>User Id</th>
    <th>User Name</th>
    <th>Mobile No</th>
    <th>Account No</th>
    <th>Ifsc Code</th>
    <th>Father Name</th>
    <th>Amount</th>
   
    </tr>
    </thead>
    <tbody>
    <%while(rs.next()){%>
        <tr>
        <td><%=rs.getString(1)%></td>
        <td><%=rs.getString(2) %></td>
        <td><%=rs.getString(3) %></td>
        <td><%=rs.getString(4) %></td>
        <td><%=rs.getString(5) %></td>
        <td><%=rs.getString(6) %></td>
        <td><%=rs.getString(7) %></td>
        
        </tr>
    <%}%>
    </tbody>
    </table>
</body>
</html>