<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodcourt.common.model.Meal" %>
<%@ page import="com.foodcourt.common.dao.MealDao" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>This is confirm order page</h1>
	
	<table>
			<tr>
				<td><c:out value="Eta : ${shoppingCart.eta}" /> </td>
				<td><c:out value="Price : ${shoppingCart.price}" /> </td>
			</tr>
		
		<tr>
			<td colspan=2> 
			<table>
				<c:forEach items = "${shoppingCart.orderEntries}" var="entry" varStatus="loop">
				<tr>
					<td><c:out value="Tên món ăn : ${entry.meal.name}" /> </td>
					<td><c:out value="Gia : ${entry.meal.price}" /> </td>
					<td><c:out value="So luong: ${entry.quantity}" /> </td>
				</tr>
				</c:forEach>
			</table>
			</td>
		</tr>
		</table>
		<a href="${pageContext.request.contextPath}/customer/purchaseController">Thanh toán</a>
	</body>
</html>