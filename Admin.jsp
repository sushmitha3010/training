<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Admin Login</title>

</head>
<body>
<style>


{
    margin: 0%;
    padding: 0%;
}
body{
    background-image: url(/Image/1.jpg);
    background-size: 600px;
    
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
    padding-top:20px;
    padding-bottom:20px;
    align-items: center;
    margin-left:-100px;
    border-radius: 120px;
    border: 1px solid rgba(255,255,255,0.3);
    box-shadow: 2px 2px 15px rgba(0,0 , 0, 0.3);
    color: #fff;
    
}
form#register{
    margin: 30px;
    align-items: center;
}
label{
    font-family: sans-serif;
    font-size: 18px;
    font-style: italic;
}
input#MailId{
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


</style>


 <div class="main">
            <div class="register">

<h1>Sign Up Here !!!</h1>
<form name="form" action="/loginAdmin" method="post" align="center">
 
 <br><br>


                    &nbsp; &nbsp; &nbsp;  <label>MailId:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;  <input type="text" name="MailId" id="MailId" placeholder="MailId">
                    <br><br>

                    &nbsp; &nbsp; &nbsp; <label>Password:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="Password" name="Password" id="Password" placeholder="Password">
                    <br><br>


<button type="submit">submit</button>
 
  <input type="submit" value="Go back!" onclick="history.back()">
    
 
</form>
</center>



</body>
</html>