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
				<td><c:out value="Order ID : ${currentOrder.orderID}"/></td>
				<td><c:out value="User ID : ${currentOrder.userID}" /> </td>
				<td><c:out value="Vendor ID : ${currentOrder.saleVendorID}" /> </td>
				<td><c:out value="Eta : ${currentOrder.eta}" /> </td>
				<td><c:out value="Price : ${currentOrder.price}" /> </td>
				
				<td>
				<form action="purchaseInfoController" method="get">
					<button type="submit" name="purcharse" value="${currentOrder.orderID}">Make Payment</button>
				</form> 
				</td>
			</tr>
		
		<tr>
			<td colspan=4> 
			<table>
				<c:forEach items = "${currentOrder.orderEntries}" var="entry">
				<tr>
					<td><c:out value="Name: ${entry.meal.name}" /> </td>
					<td><c:out value="Meal ID: ${entry.meal.id}" /> </td>
					<td><c:out value="Meal Price: ${entry.meal.price}" /> </td>
					<td><c:out value="Meal quantity: ${entry.quantity}" /> </td>
				</tr>
				</c:forEach>
			</table>
			</td>
		</tr>
		</table>
	</body>
</html>