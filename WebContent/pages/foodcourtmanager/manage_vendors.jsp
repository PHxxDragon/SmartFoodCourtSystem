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
<p id="prompt" style="display:none">Remove these vendors?</p>
<form action="manage_vendors" method="post">
	<table id="vendor_list" style="border: 1px solid black; border-collapse: collapse;">
		<tr style="border: 1px solid black; border-collapse: collapse;">
			<td style="border: 1px solid black; border-collapse: collapse;"></td>		
			<td style="border: 1px solid black; border-collapse: collapse;">Vendor ID</td>
			<td style="border: 1px solid black; border-collapse: collapse;">Owner ID</td>
			<td style="border: 1px solid black; border-collapse: collapse;">Name</td>
		</tr>
		<c:forEach items = "${Vendors}" var="vendor">
			<tr style="border: 1px solid black; border-collapse: collapse;">
				<td style="border: 1px solid black; border-collapse: collapse;"><input type = "checkbox" name = "vendorlist" value = "${vendor.getId()}"></td>		
				<td style="border: 1px solid black; border-collapse: collapse;"><c:out value="${vendor.getId()}"/> </td>
				<td style="border: 1px solid black; border-collapse: collapse;"><c:out value="${vendor.getOwnerID()}"/> </td>
				<td style="border: 1px solid black; border-collapse: collapse;"><c:out value="${vendor.getName()}"/> </td>
			</tr>
		</c:forEach>
	</table>
	<table id="add_form" style="display:none">
		<tr><td>Name:</td> <td><input type="text" name="name"></td></tr>
		<tr><td>ID:</td> <td><input type="text" name="id"></td></tr>
		<tr><td>Owner ID:</td> <td><input type="text" name="ownerid"></td></tr>
	</table>	
	<button type="button" id="btn_remove" onclick="confirmationForm()">Remove</button>
	<button type="submit" name="btn" id="btn_yes" value = "remove" style="display:none">Yes</button>
	<button type="button" id="btn_no" style="display:none" onclick="confirmationForm()">No</button>
	<button type="button" name="btn_new" id="btn_new" onclick="newAccountForm()">New vendor</button>
	<button type="submit" name="btn" id="btn_add" value = "add" style="display:none">Add new</button>
	<button type="button" name="btn_cancel" id="btn_add" style="display:none" onclick="newAccountForm()">Cancel</button>
</form>
<script>
function confirmationForm() {
	var table = document.getElementById("vendor_list")
	if (document.getElementById("prompt").style.display === "none") {
		for(var i = 1, row; row = table.rows[i]; i++) {
			if (row.cells[0].children[0].checked == false) {
				row.style.display = "none";
			}
		}
		document.getElementById("prompt").style.display = "block";
		document.getElementById("btn_remove").style.display = "none";
		document.getElementById("btn_new").style.display = "none";
		document.getElementById("btn_yes").style.display = "block";
		document.getElementById("btn_no").style.display = "block";
		document.getElementById("btn_add").style.display = "none";
	}
	else {
		for(var i = 1, row; row = table.rows[i]; i++) {
			row.style.display = "";
		}
		document.getElementById("prompt").style.display = "none";
		document.getElementById("btn_remove").style.display = "block";
		document.getElementById("btn_new").style.display = "block";
		document.getElementById("btn_yes").style.display = "none";
		document.getElementById("btn_no").style.display = "none";
		document.getElementById("btn_add").style.display = "block";
	}
}

function newAccountForm() {
	if (document.getElementById("add_form").style.display === "none") {
		document.getElementById("add_form").style.display = "";
		document.getElementById("vendor_list").style.display = "none";
		document.getElementById("btn_remove").style.display = "none";
		document.getElementById("btn_new").style.display = "none";
		document.getElementById("btn_add").style.display = "block";
		document.getElementById("btn_cancel").style.display = "block";
	}
	else {
		document.getElementById("add_form").style.display = "none";
		document.getElementById("vendor_list").style.display = "";
		document.getElementById("btn_remove").style.display = "block";
		document.getElementById("btn_new").style.display = "block";
		document.getElementById("btn_add").style.display = "none";
		document.getElementById("btn_cancel").style.display = "none";
	}
}
</script>
</body>
</html>