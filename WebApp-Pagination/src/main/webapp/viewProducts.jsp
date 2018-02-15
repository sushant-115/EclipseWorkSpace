<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:set var="pageNumber" value="${currPageNo}" />
	<c:set var="totalpgs" value="${totalPages}" />
	<a href="index.jsp">Add New Product</a>
	<table>
		<thead>
			<tr>
				<td>S.No</td>
				<td>Product Name</td>
				<td>Product Price</td>
				<td>Product Quantity</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="p" varStatus="counter">
				<tr>
					<td><c:out value="${counter.index+1}" /></td>
					<td><c:out value="${p.pname}" /></td>
					<td><c:out value="${p.price}" /></td>
					<td><c:out value="${p.quantity}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:if test="${pageNumber gt 1}">
		<a href="viewProducts?pageNo=${pageNumber-1}">Previous</a>
	</c:if>

	<c:forEach begin="1" end="${totalPages}" var="i">
		<c:set value="${i}" var="no" />
		<c:choose>
			<c:when test="${pageNumber!=no}">
				<a href="viewProducts?pageNo=${i}">${i}</a>
			</c:when>
			<c:otherwise>
					${i}
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${pageNumber!=totalpgs}">
		<a href="viewProducts?pageNo=${pageNumber+1}">Next</a>
	</c:if>

</body>
</html>