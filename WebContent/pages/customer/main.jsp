<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodcourt.common.UserType" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is the main page for the customer</h1>
	<form action="<%=request.getContextPath()%>/viewProfile" method="post">
		<button type="submit" value="viewProfile" name="viewProfile">View Profile</button>
	</form>
	<form action="viewOrder" method="post">
		<button type="submit" value="viewOrder" name="viewOrder">View Paid Order</button>
	</form>
	<form action="recharge" method="post">
		<button type="submit" value="recharge" name="recharge">Notify out of stock</button>
	</form>
</body>
</html>