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
	<%
		if (session.getAttribute("UserType") == null){
			response.sendRedirect(request.getContextPath() + "/login");
		} else if (((UserType) session.getAttribute("UserType")) != UserType.VD_OWNER) {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	%>
	<h1>This is the main page for the vendor owner</h1>
</body>
</html>