<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodcourt.common.UserType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add a new user</h1>
	<!-- HARDCODED PATH, CHANGE IF POSSIBLE -->
	<form action="../../fcmanager/manage_accounts" method="post">
	<table>
		<tr><td>Name:</td> <td><input type="text" name="name"></td></tr>
		<tr><td>email:</td> <td><input type="text" name="email"></td></tr>
		<tr><td>Username:</td> <td><input type="text" name="username"></td></tr>
		<tr><td>Password:</td> <td><input type="password" name="password" size = "21"></td></tr>
		<tr><td>User type:</td> <td><input type="text" name="type"></td></tr>
	</table>	
		<button type="submit" name="btn" value="add">Add</button>
	</form>	
</body>
</html>