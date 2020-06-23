<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Recharge Page</h1>
	<form action="rechargeController" method="post">
		Current money in account : ${user.balance}
		Enter Money Value: <input type="text" name="money"> <br>
		<input type="submit" value="Recharge">
	</form>
</body>
</html>