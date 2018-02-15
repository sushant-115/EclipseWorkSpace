<html>
<%@page isELIgnored="false" %>
<body bgcolor=#0eace0 align="center">
<h3><font color="red">${err}</font></h3>
<h3><font color="green">${succ}</font></h3>
<h2><font color="blue">Insert Product</font></h2>
<form action="./InsertServlet"  method=post  >
<h3>
ProductName  :- <input type=text name="t1" required><br/>
ProductPrice :- <input type=text name="t2" required><br/>
Quantity     :- <input type=text name="t3" required><br/>
<blink><q><font color="yellow">First upload photo then Insert the product Details</font></q></blink><br>

                  <input type=submit value="Insert" >

</h3>

</form>
<h3><font color="green">${status}</font></h3>
<form action="./UploadServlet" method=post enctype = "multipart/form-data" >
Choose File  :-  <input type = "file" name = "t4" size = "50" required/>
         <br />
         <input type=submit value="Upload"></form>
<a href="./RetrieveServlet">View All Product</a><aside>--------------------</aside>
<a href="./searchProduct.jsp">Search Product By Name</a>

</body>
</html>
