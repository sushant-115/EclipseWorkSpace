<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="http://localhost:8888/messaging/home.jsp">Back to home</a>
<h3><font color="green">${status}</font></h3>
<form action="./UploadServlet" method="POST" enctype = "multipart/form-data" >
Choose File  :-  <input type = "file" name = "t4" size = "50" required/>
         <br />
         <input type=submit value="Upload"></form>
</body>
</html>