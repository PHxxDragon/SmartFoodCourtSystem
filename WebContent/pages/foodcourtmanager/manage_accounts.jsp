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
<table>
		<c:forEach items = "${Users}" var="user">
		<tr>
			<td><c:out value="User ID : ${user.getUserID()}"/></td>
			<td><c:out value="Username : ${user.getUsername()}" /> </td>
			<td><c:out value="Type : ${user.getUserType()}" /> </td>
			<td>
			<form action="manage_accounts" method="post">
				<button type="submit" name="remove" value="${user.userID}">Remove</button>
			</form> 
			</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>