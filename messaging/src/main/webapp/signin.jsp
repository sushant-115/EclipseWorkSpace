<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<h2><font color="red">${status }</font></h2>
<h1><font color="red">${b }</font></h1>
<style>
body{
background-color:#C0C0C0;

}
div.header{
border-radius:10px;
background-color:#1b1ebb;
color:white;
padding:30px;

}
div.login{
	border-radius:15px;
	width:250px;
	height:300px;
	background-color:#12ac36;
	box-shadow:10px 10px #88888f

}
div.photo{
margin-top:-250px;
margin-left:400px;
position:relative;


}
</style>
<body>

<div class="header">
<h1 align="center" border="5px"><font color="#fff">Welcome to MyApplication</font></h1></div>
<hr>
<hr>
<div align="center" class="login" >
<form action="./SigninServlet" method="POST">
<h2 >
Username:<input type="text" name="un" required><br>
Password:<input type="password" name="password" required><br>
<img src="http://localhost:8888/messaging/CaptchaServlet">
<input type="text" name="captcha" required>
<h3 align= "center"><input type="checkbox" name="rm" value="r">Remember me</h3>
<h2 align="center"><input type="submit" value="Login"></h2>
<h2><a href="http://localhost:8888/messaging/ForgotPassword">forgot password?</a></h2>
</h2>
</form></div>
<div class="photo">
<img alt height="400" width="737" src="photo.png">
</div>
<h2 >New User?<a href="http://localhost:8888/messaging/Signup.jsp"><font>SignUp</font></a></h2>
</body>
</html>