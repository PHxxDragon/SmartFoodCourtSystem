<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/view_cart.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<table>
	<!--<tr>
		<td>Eta: <span id="eta">${shoppingCart.eta}"</span> </td>
		<td>Price: <span id="price">${shoppingCart.price}</span> </td>
	</tr> -->
		
	<tr>
		<td colspan=2> 
		<table>
			<c:forEach items = "${shoppingCart.orderEntries}" var="entry" varStatus="loop">
			<tr id="item${entry.meal.id }">
				<td><c:out value="Tên món ăn : ${entry.meal.name}" /> </td>
				<td><c:out value="Gia : ${entry.meal.price}" /> </td>
				<td><c:out value="So luong: ${entry.quantity}" /> </td>
				<td><Button onclick="removeFromShoppingCart(${entry.meal.id}, '${pageContext.request.contextPath}/customer/cart')" value="Remove">Remove from shopping cart</Button></td>    
			</tr>
			</c:forEach>
		</table>
		</td>
	</tr>
	</table>
	<a href="${pageContext.request.contextPath}/customer/confirmOrderController">Xác nhận đơn hàng</a>
</body>
</html>