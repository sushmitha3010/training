<%@page import="java.util.List"%>
<%@page import="com.postoffice.postofficemanagement.model.RegisteredPostModel"%>
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
input#TrackingId {
    width: 300px;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: 0%;
    padding: 7px;
    background-color: #fff;
    box-shadow: inset 1px 1px 5px rgba(0,0 , 0, 0.3);

}


</style>

<body>
<div class="main">
            <div class="register">



<h1 >Tracking!!!</h1>
<form name="form" action="/view" method="post" align="center">


                    &nbsp; &nbsp; &nbsp;  <label>UserName:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;  <input type="text" name="UserName" id="UserName" value=<%=uName %> placeholder="UserName">
                    <br><br>

                    &nbsp; &nbsp; &nbsp; <label>TrackingId:</label>
                    <br>
                    &nbsp; &nbsp; &nbsp;<input type="number" name="search" id="TrackingId" placeholder="TrackingId">
                    <br><br>


   <button type="submit">submit</button>
 <input type="button" value="Go back!" onclick="history.back()">
</body>
</html>