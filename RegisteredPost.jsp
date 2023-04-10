<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>


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
    hight:200px;
    
}
label{
    font-family: sans-serif;
    font-size: 18px;
    font-style: italic;
}
input#SenderName{
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}
input#SenderMobileNumber {
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}
input#SenderAddress {
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}
input#ParcelWeight {
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}
input#ReceiverName {
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}

input#ReceiverMobileNumber {
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}
input#ReceiverAddress {
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



	<h1>Welcome To Registered Post !!!</h1>
	<form id="parcelForm"  action="/registerPost" action="./JspFiles1/RegisteredCalculater.jsp"
		method="post" align="center">
		
		
		
		           &nbsp; &nbsp; &nbsp;  <label>SenderName:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;  <input type="text" name="SenderName" id="SenderName" value=<%=uName %> placeholder="SenderName">
                    <br><br>

                   
                    &nbsp; &nbsp; &nbsp;<label>SenderMobileNumber:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="number" name="SenderMobileNumber" id="SenderMobileNumber" placeholder="SenderMobileNumber">
                    <br><br>

                    &nbsp; &nbsp; &nbsp; <label>SenderAddress:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="text" name="SenderAddress" id="SenderAddress" placeholder="SenderAddress">
                    <br><br>
                
                    &nbsp; &nbsp; &nbsp;<label>ParcelWeight:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="number" name="ParcelWeight" id="ParcelWeight" placeholder="ParcelWeight">
                    <br><br>
    
                     &nbsp; &nbsp; &nbsp;  <label>ReceiverName:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;  <input type="text" name="ReceiverName" id="ReceiverName" placeholder="ReceiverName">
                    <br><br>

                   
                    &nbsp; &nbsp; &nbsp;<label>ReceiverMobileNumber:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="number" name="ReceiverMobileNumber" id="ReceiverMobileNumber" placeholder="ReceiverMobileNumber">
                    <br><br>

                    &nbsp; &nbsp; &nbsp; <label>ReceiverAddress:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="text" name="ReceiverAddress" id="ReceiverAddress" placeholder="ReceiverAddress">
                    <br><br>
                    
		
			
			<button type="submit" value="submit" >submit</button>
			
		 <input type="button" value="Go back!"
				onclick="history.back()">
	</form>
	</center>
</body>
</html>

