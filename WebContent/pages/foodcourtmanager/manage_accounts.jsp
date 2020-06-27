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
<p id="prompt" style="display:none">Remove these users?</p>
<p id="add_prompt" style="display:none">Create a new user</p>
<p id="edit_prompt" style="display:none">These fields will be updated for all selected users</p>
<form action="manage_accounts" method="post">
	<table id="user_list" style="border: 1px solid black; border-collapse: collapse;">
		<tr style="border: 1px solid black; border-collapse: collapse;">
			<td style="border: 1px solid black; border-collapse: collapse;"></td>		
			<td style="border: 1px solid black; border-collapse: collapse;">User ID</td>
			<td style="border: 1px solid black; border-collapse: collapse;">Username</td>
			<td style="border: 1px solid black; border-collapse: collapse;">Type</td>
		</tr>
		<c:forEach items = "${Users}" var="user">
			<tr style="border: 1px solid black; border-collapse: collapse;">
				<td style="border: 1px solid black; border-collapse: collapse;"><input type = "checkbox" name = "userlist" value = "${user.getUserID()}"></td>		
				<td style="border: 1px solid black; border-collapse: collapse;"><c:out value="${user.getUserID()}"/> </td>
				<td style="border: 1px solid black; border-collapse: collapse;"><c:out value="${user.getUsername()}"/> </td>
				<td style="border: 1px solid black; border-collapse: collapse;"><c:out value="${user.getUserType()}"/> </td>
			</tr>
		</c:forEach>
	</table>
	<table id="add_form" style="display:none">
		<tr><td>Name:</td> <td><input type="text" name="name_add"></td></tr>
		<tr><td>email:</td> <td><input type="text" name="email_add"></td></tr>
		<tr><td>Username:</td> <td><input type="text" name="username_add"></td></tr>
		<tr><td>Password:</td> <td><input type="password" name="password_add" size = "21"></td></tr>
		<tr><td>User type:</td> <td><input type="text" name="type_add"></td></tr>
	</table>
	<table id="edit_form" style="display:none">
		<tr><td>Name:</td> <td><input type="text" name="name_edit"></td></tr>
		<tr><td>Username:</td> <td><input type="text" name="username_edit"></td></tr>
		<tr><td>Password:</td> <td><input type="password" name="password_edit" size = "21"></td></tr>
		<tr><td>User type:</td> <td><input type="text" name="type_edit"></td></tr>
	</table>	
	<button type="button" id="btn_remove" onclick="confirmationForm()">Remove</button>
	<button type="button" id="btn_edit" onclick="editForm()">Edit</button>
	<button type="button" id="btn_new" onclick="newAccountForm()">New account</button>
	<button type="submit" name="btn" id="btn_yes" value = "remove" style="display:none">Yes</button>
	<button type="button" style="display:none" onclick="confirmationForm()">No</button>
	<button type="submit" name="btn" id="btn_add" value = "add" style="display:none">Add new</button>
	<button type="submit" name="btn" id="btn_apply" value = "edit" style="display:none">Apply</button>
	<button type="button" name="btn_cancel" id="btn_canceladd" style="display:none" onclick="newAccountForm()">Cancel</button>
	<button type="button" name="btn_cancel" id="btn_canceledit" style="display:none" onclick="editForm()">Cancel</button>
</form>
<script>
function confirmationForm() {
	var table = document.getElementById("user_list")
	if (document.getElementById("prompt").style.display === "none") {
		for(var i = 1, row; row = table.rows[i]; i++) {
			if (row.cells[0].children[0].checked == false) {
				row.style.display = "none";
			}
		}
		document.getElementById("prompt").style.display = "block";
		document.getElementById("btn_remove").style.display = "none";
		document.getElementById("btn_edit").style.display = "none";
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
		document.getElementById("btn_edit").style.display = "block";
		document.getElementById("btn_new").style.display = "block";
		document.getElementById("btn_yes").style.display = "none";
		document.getElementById("btn_no").style.display = "none";
		document.getElementById("btn_add").style.display = "block";
	}
}

function newAccountForm() {
	if (document.getElementById("add_form").style.display === "none") {
		document.getElementById("add_form").style.display = "";
		document.getElementById("add_prompt").style.display = "";
		document.getElementById("user_list").style.display = "none";
		document.getElementById("btn_remove").style.display = "none";
		document.getElementById("btn_edit").style.display = "none";
		document.getElementById("btn_new").style.display = "none";
		document.getElementById("btn_add").style.display = "block";
		document.getElementById("btn_canceladd").style.display = "block";
	}
	else {
		document.getElementById("add_form").style.display = "none";
		document.getElementById("add_prompt").style.display = "none";
		document.getElementById("user_list").style.display = "";
		document.getElementById("btn_remove").style.display = "block";
		document.getElementById("btn_edit").style.display = "block";
		document.getElementById("btn_new").style.display = "block";
		document.getElementById("btn_add").style.display = "none";
		document.getElementById("btn_canceladd").style.display = "none";
	}
}

function editForm() {
	var table = document.getElementById("user_list")
	if (document.getElementById("edit_form").style.display === "none") {
		for(var i = 1, row; row = table.rows[i]; i++) {
			if (row.cells[0].children[0].checked == false) {
				row.style.display = "none";
			}
		}
		document.getElementById("edit_form").style.display = "";
		document.getElementById("edit_prompt").style.display = "";
		document.getElementById("btn_remove").style.display = "none";
		document.getElementById("btn_edit").style.display = "none";
		document.getElementById("btn_new").style.display = "none";
		document.getElementById("btn_apply").style.display = "block";
		document.getElementById("btn_canceledit").style.display = "block";
	}
	else {
		for(var i = 1, row; row = table.rows[i]; i++) {
			row.style.display = "";
		}
		document.getElementById("edit_form").style.display = "none";
		document.getElementById("edit_prompt").style.display = "none";
		document.getElementById("btn_remove").style.display = "block";
		document.getElementById("btn_edit").style.display = "block";
		document.getElementById("btn_new").style.display = "block";
		document.getElementById("btn_apply").style.display = "none";
		document.getElementById("btn_canceledit").style.display = "none";
	}
}
</script>
</body>
</html>