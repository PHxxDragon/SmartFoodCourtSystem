<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodcourt.common.model.Order,java.util.List" %>
<%@ page import="com.foodcourt.common.UserType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pending Orders</title>
</head>
<body>
	<table>
		<c:forEach items = "${PendingOrders}" var="order">
		<tr>
			<td><c:out value="Order ID : ${order.orderID}"/></td>
			<td><c:out value="User ID : ${order.userID}" /> </td>
			<td><c:out value="Vendor ID : ${order.saleVendorID}" /> </td>
			<td>
			<form action="viewOrder" method="post">
				<button type="submit" name="confirm" value="${order.orderID}">Confirm</button>
			</form> 
			</td>
		</tr>
		
		<tr>
			<td colspan=4> 
			<table>
				<c:forEach items = "${order.orderEntries}" var="entry">
				<tr>
					<td><c:out value="Meal ID: ${entry.meal.id}" /> </td>
					<td><c:out value="Meal Price: ${entry.meal.price}" /> </td>
					<td><c:out value="Meal quantity: ${entry.quantity}" /> </td>
				</tr>
				</c:forEach>
			</table>
			 </td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>