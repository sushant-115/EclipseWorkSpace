<html>
<%@page isELIgnored="false" %>
<head><h2 align="center">Book Registration</h2></head>
<br/>${responseDTO.message }<br/>

<body>
<form action="./SaveBookDetails" method="post">
Isbn:<input type="text" name="isbn"/><br/>
Title :<input type="text" name="title"/><br/>
Author :<input type="text" name="author"/><br/>
Price :<input type="text" name="price"/><br/>
<input type="submit" value ="register">
</form>
</body>
</html>
