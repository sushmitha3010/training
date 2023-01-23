<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
body{
background-color:pink;
}

</style>
<h1>Deposit</h1>
<form name="form" action="DepositServlet" method="get">
    
    Enter User Id:<input type="text" name="UserId" id="UserId" placeholder="UserId"><br><br>
    Enter User Name:<input type="text" name="UserName"  id="UserName" placeholder="UserName"><br><br>
    Enter Mobile No:<input type="number" name="MobileNo" id="MobileNo" placeholder="MobileNo"><br><br>
    Enter Account No:<input type="number" name="AccountNo" id="AccountNo" placeholder="AccountNo"><br><br>
    Enter Ifsc Code:<input type="text" name="IfscCode" id="IfscCode" placeholder="Ifscode"><br><br>
    Enter Amount:<input type="text" name="Amount" id="Amount" placeholder="Amount"><br><br>
    <button type="submit">submit</button>
     <input type="button" value="Go back!" onclick="history.back()">
    
</form>

</body>
</html>