<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.foodcourt.common.model.Meal" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Payment Info</title>
</head>
<body>
<h1>Enter your payment info</h1>
<form action="validify" name="enter payment method" id="form2">
		Current money in account : ${user.balance}
		<h2>Enter your credit information </h2>
		Name: <input type="text" name="name"><br/>
		Bank's name: <input type="text" name="bankName"><br/>
		Bank's account number/Card number: <input type="text" name="cardNumber"><br/>
		Password: <input type="password" id="password" name="cardPassword" required>
		<input type="submit" value="confirm" />		
		
</form>
</body>
</html>