<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="/Javascript/depositValid.js"></script>
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
    width: 500px;
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
input#Periods {
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



<h1>Welcome To Time Deposit !!!</h1>
<form id="timeDeposit" action="/timeDeposit" onsubmit="tdmaturity()" method="post" align="center">


<br><br>
    
    
     &nbsp; &nbsp; &nbsp;  <label>UserName:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;  <input type="text" name="UserName" id="UserName" value=<%=uName %> placeholder="UserName">
                    <br><br>

                   
                    &nbsp; &nbsp; &nbsp;<label>MobileNumber:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="number" name="MobileNumber" id="MobileNumber" placeholder="MobileNumber">
                    <br><br>

                    &nbsp; &nbsp; &nbsp; <label>AccountNumber:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="number" name="AccountNumber" id="AccountNumber" placeholder="AccountNumber">
                    <br><br>

                  
                    &nbsp; &nbsp; &nbsp;<label>PrincipleAmount:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="number" name="PrincipleAmount" id="PrincipleAmount" placeholder="PrincipleAmount">
                    <br><br>
    
    
       &nbsp; &nbsp; &nbsp; <div><label>
    EnterPeriods:</label>
    
    <select name="Periods" id="Periods" placeholder="Periods">
          <option value=1>1</option>
          <option value=2>2</option>
          <option value=3>3</option>
         
          <option value=5>5</option>
          
      </select>
      </div><br><br>
          
          
          
          
    <button type="submit">submit</button>
     <input type="button" value="Go back!" onclick="history.back()">
    
</form>



<script >
     function tdmaturity() {
	
	  event.preventDefault();
	
	let userName=document.querySelector("#UserName").value;
	let principleAmount = document.querySelector("#PrincipleAmount").value;
	let periods = document.querySelector("#Periods").value;
	
	let rate1=7.10;
	let simpleInterest=(principleAmount*rate1*periods)/100;
	let totalAmountperYear=principleAmount*1*12;
	
	let rateOfInterest=7.20;
	let simpleInterest1=(principleAmount*rateOfInterest*periods)/100;
	let totalAmountperYear1=principleAmount*2*12;
	
	let rateOfInterest1=7.40;
	let simpleInterest2=(principleAmount*rateOfInterest1*periods)/100;
	let totalAmountperYear2=principleAmount*2*12;
	
	let rateOfInterest2=7.90;
	let simpleInterest3=(principleAmount*rateOfInterest2*periods)/100;
	let totalAmountperYear3=principleAmount*2*12;

try {

	if(periods==1){
		
		alert('Welcome:' + userName);
		alert('Your Maturity Interest for 1 year is:'+simpleInterest);
		alert('Your Total Maturity Amount Is: '+totalAmountperYear);
	}
	
	else if(periods==2){
		
		alert('Welcome:' + userName);
		alert('Your Maturity Interest for 2 year is:'+simpleInterest1);
		alert('Your Total Maturity Amount Is: '+totalAmountperYear1);
//alert('Total Maturity Amount Is: '+Interest);
	}
	
	else if(periods==3){
		
		alert('Welcome:' + userName);
		alert('Your Maturity Interest for 3 year is:'+simpleInterest2);
		alert('Your Total Maturity Amount Is: '+totalAmountperYear2);
	}
   
	else if(periods==5){
		
		alert('Welcome:' + userName);
		alert('Your Maturity Interest for 5 year is:'+simpleInterest3);
		alert('Your Total Maturity Amount Is: '+totalAmountperYear3);
	}
	
	else {
		alert('Welcome:' + userName);
		alert('Total Interest Amount Is:  ' + +Interest);
	}

	let form = document.querySelector("#timeDeposit");
	form.submit();
}

catch (err) {
	alert("Error:" + err.message);
}
}
     </script>





</body>
</html>