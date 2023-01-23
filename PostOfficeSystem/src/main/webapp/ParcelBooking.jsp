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
  background-color:Orange;

}

</style>
<h1>Parcel Booking</h1>
<form name="form" action="BookingServlet" method="get">
    
    Enter User Id:<input type="text" name="UserId" id="UserId" placeholder="UserId"><br><br>
    Enter User Name:<input type="text" name="UserName"  id="UserName" placeholder="UserName"><br><br>
    Enter Mobile No:<input type="text" name="MobileNo" id="MobileNo" placeholder="MobileNo"><br><br>
    Enter From Address:<input type="text" name="FromAddress" id="FromAddress" placeholder="FromAddress"><br><br>
    Enter To Address:<input type="text" name="ToAddress" id="ToAddress" placeholder="ToAddress"><br><br>
    Enter Parcel Id:<input type="text" name="ParcelId" id="ParcelId" placeholder="ParcelId"><br><br>
    Enter Tracking Id:<input type="text" name="TrackingId" id="TrackingId" placeholder="TrackingId"><br><br>
    <button type="submit">submit</button>
    <input type="button" value="Go back!" onclick="history.back()">
    
</form>

</body>
</html>