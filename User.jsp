<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>





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


 


</style>




 <form name="form" action="/loginUser" method="post" align="center">
 

 
 <br>
 <div class="container">
   <h1>Sign In !</h1>
    <h3>Please fill in this form </h3>
    <div class="main">
            <div class="register">

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
    <button type="submit" class="registerbtn">Login</button><br>
  </div>

  <div class="container signin">
    <p font-size="18px">Already have an account? <a href="/JspFiles1/Register.jsp">Create an Account</a>.</p><br>
    
    <a href="/JspFiles1/Admin.jsp">&nbsp;Sign Up</a>
  </div>
</form>

      
       </form>
</body>
</html>