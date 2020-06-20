<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form action="authendication" method="post">
		Enter Username: <input type="text" name="username"> <br>
		Enter Password: <input type="password" name="password"> <br>
		<input type="submit" value="Log in">
	</form>
	
	<% 
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
		System.out.println(msg);
		out.println(msg);
	}
	%>
</body>
</html>