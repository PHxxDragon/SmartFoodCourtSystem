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
<form action="manage_accounts" method="post">
	<table>
		<c:forEach items = "${Users}" var="user">
			<tr>
				<td><input type = "checkbox" name = "userlist" value = "${user.getUserID()}"></td>		
				<td><c:out value="| User ID : ${user.getUserID()} "/> </td>
				<td><c:out value="| Username : ${user.getUsername()} " /> </td>
				<td><c:out value="| Type : ${user.getUserType()} |" /> </td>
			</tr>
		</c:forEach>
	</table>
	<button type="submit" name="remove">Remove</button>
</form> 	
</body>
</html>