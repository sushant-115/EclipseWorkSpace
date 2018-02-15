<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Products</title>
</head>
<h2 align ="center"> ALL PRODUCTS DETAILS</h2>
<h3 align ="center"><a href="./index.jsp" align="center"><font color="blue">Insert Record</font></a><br></h3>
<h3 align ="center"><a href="./searchProduct.jsp" align="center"><font color="blue">Search Product By Name</font></a><br></h3>

<body bgcolor=#0eace0 align="center">
<c:set var="start" value="${start }"></c:set>
<c:set var="pageRequired" value="${pageRequired }"/>
<c:set var="currentPage" value="${currentPage }"/>

<table border="${pDto.size() }" align="center">

<thead>
<td>Name</td>
<td>Price</td>
<td>Quantity</td>
<td>Photo</td>
</thead>
<c:forEach items="${pDto}" var="item">
<td><c:out value="${item.getpName() }">---   </c:out></td>
<td><c:out value="${item.getpPrice()}">---    </c:out></td>
<td><c:out value="${item.getQuan()}">---   </c:out></td>
<td><a href="./ViewPhotoServlet?pid=${item.getPid() }">view photo</a></td>
<tr>
</c:forEach>
<tr>
<td><br/></td>
<td colspan="${pDto.size() }"><br/></td>
</table>
<c:if test="${start gt 1}">
		<a href="RetrieveServlet?pageNo=${start-1}">Previous</a>
	</c:if>

	<c:forEach begin="1" end="${pageRequired }" var="i">
		<c:set value="${i}" var="no" />
		<c:choose>
			<c:when test="${currentPage ne no}">
				<a href="./RetrieveServlet?pageNo=${i}">${i}</a>
			</c:when>
			<c:otherwise>
					${i}
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${start ne pageRequired}">
		<a href="RetrieveServlet?pageNo=${start+1}">Next</a>
	</c:if>
</body>
</html>