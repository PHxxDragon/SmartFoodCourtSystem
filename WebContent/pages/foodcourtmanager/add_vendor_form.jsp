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
	<form action="../../fcmanager/manage_vendors" method="post">
	<table>
		<tr><td>Name:</td> <td><input type="text" name="name"></td></tr>
		<tr><td>ID:</td> <td><input type="text" name="id"></td></tr>
		<tr><td>Owner ID:</td> <td><input type="text" name="ownerid"></td></tr>
	</table>	
		<button type="submit" name="btn" value="add">Add</button>
	</form>	
</body>
</html>