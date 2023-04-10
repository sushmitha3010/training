<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
    Integer parcelWeight=Integer.parseInt(request.getParameter("ParcelWeight"));
    
    Integer parcelCharge=parcelWeight*15;
	
	
     out.println("Total Parcel Charge Is:"+parcelCharge);
	
	%>
</body>
</html>