<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<font color='green'>${succMsg}</font>
		<font color='red'>${errMsg}</font>
		<form action="insert" method="post">
			Product Name : <input type="text" name="pname"/></br/>
			Product Price : <input type="text" name="price"/></br>
			Product Quantity:	<input type="text" name="quantity"/></br>
			<input type="submit" value="Submit"/>
		</form>
		
			<a href="viewProducts">View All Products</a>
</body>
</html>