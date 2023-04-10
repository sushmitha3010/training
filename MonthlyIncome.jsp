<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="/Javascript/depositValid.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<% String uName=session.getAttribute("userName").toString();
String mobNo=session.getAttribute("mobileNo").toString();

%>
</head>
<body>

<h1>Welcome To Monthly Income Scheme !!!</h1>
<style>
body{
background-color:Violet;
}


</style>



<form id="misDeposit" action="/monthlyIncome" onsubmit="mismaturity()" method="post" align="center">

   
    Enter User Name:<br><input type="text" name="UserName"  id="UserName" value=<%=uName %> placeholder="UserName"><br><br>
    Enter Mobile Number:<br><input type="number" name="MobileNumber" id="MobileNumber" value=<%=mobNo %> placeholder="MobileNumber"><br><br>
    Enter Account Number:<br><input type="number" name="AccountNumber" id="AccountNumber" placeholder="AccountNumber"><br><br>
    Enter Ifsc Code:<br><input type="text" name="IfscCode" id="IfscCode" placeholder="Ifscode"><br><br>
    Enter Principle Amount:<br><input type="number" name="PrincipleAmount" id="PrincipleAmount" placeholder="PrincipleAmount"><br><br>
      <button>Submit</button><br><br>
    
</form>
</center>

<script>
     function mismaturity() {
	
	event.preventDefault();
	
	let userName=document.querySelector("#UserName").value;
	let principleAmount = document.querySelector("#PrincipleAmount").value;
	let noOfMonths = document.querySelector("#NoOfMonths").value;
	let rateOfInterest = 5.8;
	let Interest = principleAmount * noOfMonths * (noOfMonths + 1) * rateOfInterest / 2400;

try {

	if (principleAmount < 0) {
		Interest = principleAmount * noOfMonths * (noOfMonths + 1) * rateOfInterest / 2400;

		throw new Error("The Principle Amount Could Not Less Than Zero")
	}

	else {
		alert("Welcome:" + userName);
		alert('Total Interest Amount Is:  ' + Interest);
	}

	let form = document.querySelector("#misDeposit");
	form.submit();
}

catch (err) {
	alert("Error:" + err.message);
}
}
     </script>



</body>
</html>