<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<c:forEach items = "${PaidOrders}" var="order">
		<tr>
			<td><c:out value="Order ID : ${order.orderID}"/></td>
			<td><c:out value="User ID : ${order.userID}" /> </td>
			<td><c:out value="Vendor ID : ${order.saleVendorID}" /> </td>
			<td><c:out value="Eta : ${order.eta}" /> </td>
			<td><c:out value="Price : ${order.price}" /> </td>

			<td>
			<form action="printSlip" method="get">
				<button type="submit" name="printSlip" value="${order.orderID}">Print Slip</button>
			</form> 
			</td>
		</tr>
		
		<tr>
			<td colspan=6> 
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

	<!-- 
	<c:out value="Order ID : ${order.orderID}"/>
	<c:out value="User ID : ${order.userID}" />
	<c:out value="Vendor ID : ${order.saleVendorID}"/>
	<c:out value="Eta : ${order.eta}" />
	<c:out value="Price : ${order.price}" />
	-->
</body>
</html>