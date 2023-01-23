<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tracking</title>
</head>
<body>
<style>
body{
background-color:Violet;
}

</style>

<h1>Tracking</h1>

<form name="form" action="TrackingServlet" method="get">

 Enter Loaction Id:<input type="text" name="LocationId" id="LocationId" placeholder="LocationId"><br><br>
 Enter Loaction Name:<input type="text" name="LocationName" id="LocationName" placeholder="LocationName"><br><br>
 Enter Status:<input type="text" name="Status" id="Status" placeholder="Status"><br><br>
 <button type="submit">submit</button>
 <input type="button" value="Go back!" onclick="history.back()">
    
</form>
</body>
</html>