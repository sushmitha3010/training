<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="/CSS/Register.css">
<script src="/Javascript/validation.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>



</head>
<body align="center">
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
input#Password {
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
input#AadharNumber {
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}
input#MailId {
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}
input#Address {
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}


</style>

 <div class="main">
            <div class="register">
<h1> Welcome To Register !!!</h1>
    <form id="registerForm" action="/register" onsubmit="validateForm()"  method="post" align="center">
    
   <br><br>
     &nbsp; &nbsp; &nbsp;  <label>UserName:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;  <input type="text" name="UserName" id="UserName"  placeholder="UserName">
                    <br><br>

                    &nbsp; &nbsp; &nbsp; <label>Password:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="Password" name="Password" id="Password" placeholder="Password">
                    <br><br>

                    &nbsp; &nbsp; &nbsp;<label>MobileNumber:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="number" name="MobileNumber" id="MobileNumber" placeholder="MobileNumber">
                    <br><br>

                    &nbsp; &nbsp; &nbsp; <label>AadharNumber:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="number" name="AadharNumber" id="AadharNumber" placeholder="AadharNumber">
                    <br><br>

                  
                    &nbsp; &nbsp; &nbsp;<label>MailId:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="text" name="MailId" id="MailId" placeholder="MailId">
                    <br><br>

                    &nbsp; &nbsp; &nbsp; <label>Address:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp; <input type="text" name="Address" id="Address" placeholder="Address">
                    <br><br>

     <button>Register</button>
      <input type="submit" value="Go back!" onclick="history.back()">

    
   </center>
    
</form>
</div>
</div>


</body>
</html>