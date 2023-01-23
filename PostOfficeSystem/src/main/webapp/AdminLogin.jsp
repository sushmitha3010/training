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
background-color:LightGreen;


}


</style>
<form name="form" action="AdminLogTestServe" method="get">
 
Enter Mail Id:<input type="text" name="mailId" placeholder="mailId"><br><br>
Enter Password:<input type="text" name="password" placeholder="password"><br><br>

<button type="submit">submit</button>
 <input type="button" value="Go back!" onclick="history.back()">
    

</form>
</body>
</html>