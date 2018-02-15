<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearchProduct</title>
</head>
<body bgcolor=#0eace0 align="center">
<a href="./index.jsp"><h3><font color="blue">Insert Product</font></h3></a>
<h1 align="center"><font color="green">Search Form</font></h1>
<form action="./SearchServlet" >
<h3>
Product Name:- <input type=text name="t4"><br><br>
<input type=submit value="SearchProduct">



</h3>
<h3><font color="red">${err }</font></h3>
<table border="${plist.size() }" align="center">
<thead>
<td>Name</td>
<td>Price</td>
<td>Quantity</td>
<td>Photo</td><tr>
</thead>
<tbody>
<c:forEach items="${plist }" var="items">
<td><c:out value="${items.getpName() }"/></td>
<td><c:out value ="${items.getpPrice() }"/></td>
<td><c:out value ="${items.getQuan() }"/></td>
<td><a href="./ViewPhotoServlet?pid=${items.getPid() }">view photo</a></td>
<tr>

</tbody>
</c:forEach>
</table>




</form>

</body>
</html>