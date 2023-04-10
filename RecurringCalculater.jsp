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



Integer principleAmount=Integer.parseInt(request.getParameter("principleAmount"));
Integer noOfMonths=Integer.parseInt(request.getParameter("numberOfMonths"));

double rateOfInterest = 5.8;

double  Interest = principleAmount * noOfMonths * (noOfMonths + 1) * rateOfInterest / 2400;


out.println("Total Interest Amount Is:  "+ Interest);

%>
</body>
</html>