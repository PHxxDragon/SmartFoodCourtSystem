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
<form action="manage_vendors" method="post">
	<table>
		<c:forEach items = "${Vendors}" var="vendor">
			<tr>
				<td><input type = "checkbox" name = "vendorlist" value = "${vendor.getID()}"></td>		
				<td><c:out value="| Vendor ID : ${vendor.getID()} "/> </td>
				<td><c:out value="| Owner ID : ${vendor.getOwnerID()} " /> </td>
				<td><c:out value="| Name : ${vendor.getName()} |" /> </td>
			</tr>
		</c:forEach>
	</table>
	<button type="submit" name="btn" value = "remove">Remove</button>
	 <!-- <button type="submit" name="btn" value = "add">Add new</button> -->
</form>
<!-- HARDCODED PATH, CHANGE IF POSSIBLE -->
<a href="../pages/foodcourtmanager/add_vendor_form.jsp"><button>Add new</button></a>
</body>
</html>