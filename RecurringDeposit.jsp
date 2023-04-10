<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

<script type="/Javascript/RecurringDepositCalculation.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%

String uName=session.getAttribute("userName").toString();

%>
</head>
<body>
<style>
body{
background-color:Lavender;
}
 {
    margin: 0%;
    padding: 0%;
}
body{
    background: url(/Image/regi.jpg);
    background-size: 400px;
    background-repeat: no-repeat;
    background-size: cover;
    
    

}

div.main{
    width: 300px;
    margin: 100px auto 0px auto;
    padding-left: 100px;
}

h2{
    text-align: center;
    padding: 20px;
    font-family: sans-serif;
}
div.register{
    background-color: rgba(0,0 , 0, 0.5);
    width: 450px;
    font-size: 17px;
    margin-left:-100px;
    margin-right:10px;
    padding-top:20px;
    padding-bottom:20px;
    align-items: center;
    border-radius: 120px;
    border: 1px solid rgba(255,255,255,0.3);
    box-shadow: 2px 2px 15px rgba(0,0 , 0, 0.3);
    color: #fff;
    
}
form#register{
    
    align-items: center;
    
}
label{
    font-family: sans-serif;
    font-size: 18px;
    font-style: italic;
}
input#UserName{
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}
input#MobileNumber {
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}
input#AccountNumber {
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}
input#PrincipleAmount {
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}
input#NumberOfMonths {
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}

</style>

<div class="main">
            <div class="register">


<h1> Welcome To Recurring Deposit!!!</h1>
<form id=recurringDeposit action="/recurringDeposit" onsubmit="rdmaturity()" method="post" align="center">



<br><br>
     &nbsp; &nbsp; &nbsp;  <label>UserName:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;  <input type="text" name="UserName" id="UserName" value=<%=uName %> placeholder="UserName">
                    <br><br>

                   
                    &nbsp; &nbsp; &nbsp;<label>MobileNumber:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="number" name="MobileNumber" id="MobileNumber"  placeholder="MobileNumber">
                    <br><br>

                    &nbsp; &nbsp; &nbsp; <label>AccountNumber:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="number" name="AccountNumber" id="AccountNumber" placeholder="AccountNumber">
                    <br><br>

                  
                    &nbsp; &nbsp; &nbsp;<label>PrincipleAmount:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="number" name="PrincipleAmount" id="PrincipleAmount" placeholder="PrincipleAmount">
                    <br><br>

                    &nbsp; &nbsp; &nbsp; <label>NumberOfMonths:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp; <input type="number" name="NumberOfMonths" id="NumberOfMonths" placeholder="NumberOfMonths">
                    <br><br>

                  <button type="submit">submit</button>

     <input type="submit" value="Go back!" onclick="history.back()">
    
    
    
    
    
    
     <script>
     function rdmaturity() {
	
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

	let form = document.querySelector("#recurringDeposit");
	form.submit();
}

catch (err) {
	alert("Error:" + err.message);
}
}
     </script>
     
    
</form>
</center>


</body>
</html>