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
	<button type="submit" name="btn" value = "remove">Remove</button>
	 <!-- <button type="submit" name="btn" value = "add">Add new</button> -->
</form>
<!-- HARDCODED PATH, CHANGE IF POSSIBLE -->
<a href="../pages/foodcourtmanager/add_user_form.jsp"><button>Add new</button></a>
</body>
</html>