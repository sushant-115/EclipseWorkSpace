<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Form</title>
<style>
body{
background-color:#C0C0C0;

}
div.header{
border-radius:10px;
background-color:#1b1ebb;
color:Black;
padding:30px;

}
#register{
width:20px;
height:10px;
color:#12e2d2;
margin-left:64px;
}
div.signup{
	border-radius:15px;
	width:250px;
	height:350px;
	background-color:#12ac36;
	box-shadow:10px 10px #88888f;
	background:linear-gradient(#12ac36,yellow)

}
div.photo{
margin-top:-300px;
margin-left:400px;
position:relative;


}
</style>
</head>
<h2><font color="blue">${status }</font></h2>
<body>
<div class="header">
<h1 align="center">Registration Form</h1></div>
<form action="http://localhost:8888/messaging/SignupServlet" method="POST">
<div class="signup">
<h2 align="center">
UserName:<input type="text" name="un" required><br>
Email-Id:<input type="text" name="email" required><br>
Mobile No:<input type="text" name="mn" required><br>
Date of Birth:<input type="text" name="dob" required placeholder="DD/MM/YYYY"><br>
Password :<input type="password" name="password" required><br>
Re-enter Password:<input type="password" name="repass" required><br>

<h5 align="center"><input type="checkbox" name="checkbox" value="term" required>Accept Terms&Conditions </h5><br></h2></div>
<a><br></a>
<h2 id="register"><input type="submit" value="Register"></h2><br>






</form>
<div class="photo">
<img alt height="400" width="737" src="photo.png">
</div>
<h2>Already have an account?<a href="http://localhost:8888/messaging/signin.jsp">Signin</a></h2>
</body>
</html>