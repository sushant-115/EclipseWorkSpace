<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<h2><font color="blue">${status }</font></h2>
</head>
<h2></h2>
<body>
<form action="./UpdatePassword" method="POST">
<h2>
New Password:<input type="password" name="newp">
Re-type Password:<input type="password" name="renewp">
<input type="submit" value="Change Password">

</h2>


</form>
</body>
</html>