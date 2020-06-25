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
	<h1>This is the main page for the cook</h1>
	<form action="<%=request.getContextPath()%>/profile" method="post">
		<button type="submit" value="viewProfile" name="viewProfile">View Profile</button>
	</form>
	<form action="viewOrder" method="post">
		<button type="submit" value="viewOrder" name="viewOrder">View Order</button>
	</form>
	<form action="<%=request.getContextPath()%>/Logout" method="get">
		<button type="submit" value="Logout" name="Logout">Đăng xuất</button>
	</form>
</body>
</html>