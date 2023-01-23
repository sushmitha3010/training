<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<style>
body{
background-color:orange;
}

</style>


<h1>Register Form</h1>
    <form name="form" action="RegTestServlet" method="get">
    
    Enter User Id:<input type="text" name="UserId" id="UserId" placeholder="UserId"><br><br>
    Enter User Name:<input type="text" name="UserName"  id="UserName" placeholder="UserName"><br><br>
    Enter Password:<input type="text" name="Password" id="Password" placeholder="Password"><br><br>
    Enter Mobile No:<input type="number" name="MobileNo" id="MobileNo" placeholder="MobileNo"><br><br>
    Enter Aadhar No:<input type="number" name="AadharNo" id="AadharNo" placeholder="AadharNo"><br><br>
    Enter Address:<input type="text" name="Address" id="Address" placeholder="Address"><br><br>
    <button type="submit">submit</button>
     <input type="button" value="Go back!" onclick="history.back()">
    
</form>
<script>

function validateForm() {
    event.preventDefault();
    let UserId=document.querySelector("#UserId").value;
    let UserName=document.querySelector("#UserName").value;
    let Password=document.querySelector("#Password").value;
    let MobileNo=document.querySelector("#MobileNo").value;
    let AadharNo=document.querySelector("#AadharNo").value;
    let Address=document.querySelector("#Address").value;


try {
        if(UserId.length<=4){
            throw new Error("User Id Must Contain Greater than or Equal to 4 numbers ");
        }
        else if(UserName == null || UserName.trim() ==""){
            throw new Error("User Name Cannot be Empty");
        }
        else if(UserName.length<=4) {
            throw new Error("User Name Must Contain Greater than 4");
        }
       else if(Password.length<=8){
            throw new Error("Password Must Contain Greater than 8")
        }
      else if(MobileNo.length>=10){
            throw new Error("Mobile No Must Contain Less than or Equal to 10 Numbers ")
        }
      else if(AadharNo.length>=12){
            throw new Error("Aadhar No Must Contain Less than or Equal to 12 Numbers ");
        }
        else{
        alert("Welcome" +name);
     }
     let form=document.querySelector("Register Form");
     form.submit();
}
    
        catch(err){
            console.Error(err);
            console.log("Validation FAiled:" + err.message);
                    alert("Error:"+ err.message);
                }
            }

 </script>
</body>
</html>