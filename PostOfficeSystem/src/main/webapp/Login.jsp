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
background-color:brown;
}

</style>
<h1>Login Form</h1>
 <form name="form" action="LoginTestServe" method="get">
 
Enter User Id:<input type="text" name="userId" placeholder="userId"><br><br>
Enter Password:<input type="text" name="password" placeholder="password"><br><br>

<button type="submit">submit</button>
 <input type="button" value="Go back!" onclick="history.back()">
    
   </form>

</body>
</html>