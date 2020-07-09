<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodcourt.common.UserType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>User management</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Styles -->
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">	
	<!-- Animate CSS -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css" rel="stylesheet">
	<!-- Basic stylesheet -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.carousel.min.css">
	<!-- Font awesome CSS -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">		
	<!-- Custom CSS -->
	<link href="${pageContext.request.contextPath}/css/style_old.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/style-color.css" rel="stylesheet">
	
	<!-- Favicon -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo/favicon.ico">
</head>
<body>
<div id="home" class="wrapper">
<!-- header area -->
<header>
	<!-- primary menu -->
	<nav class="navbar navbar-fixed-top navbar-default">
	<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<!-- logo area -->
				<a class="navbar-brand" href="#home">
					<!-- logo image -->
					<img class="img-responsive" src="${pageContext.request.contextPath}/img/logo/logo.png" alt="" />
				</a>
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				
			</div>
			
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="manage_accounts">Manage Accounts</a></li>
					<li><a href="manage_vendors">Manage Vendors</a></li>
					<li><a href=${pageContext.request.contextPath}/Logout>Đăng xuất</a></li>
				</ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>
</header>
<!--/ header end -->

<!-- Padding for navbar -->
<div class="pad"></div>
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
		<tr><td>Name:</td> <td><input type="text" name="name_add" style="color:black"></td></tr>
		<tr><td>email:</td> <td><input type="text" name="email_add" style="color:black"></td></tr>
		<tr><td>Username:</td> <td><input type="text" name="username_add" style="color:black"></td></tr>
		<tr><td>Password:</td> <td><input type="password" name="password_add" size = "20" style="color:black"></td></tr>
		<tr><td>User type:</td>
			<td><select name="type_add" style="color:black">
					<option value="CUSTOMER" style="color:black">Customer</option>
					<option value="COOK" style="color:black">Cook</option>
					<option value="IT" style="color:black">IT</option>
					<option value="VD_OWNER" style="color:black">Vendor owner</option>
				</select>
			</td>
		</tr>
	</table>
	<table id="edit_form" style="display:none">
		<tr><td>Name:</td> <td><input type="text" name="name_edit" style="color:black"></td></tr>
		<tr><td>Username:</td> <td><input type="text" name="username_edit" style="color:black"></td></tr>
		<tr><td>Password:</td> <td><input type="password" name="password_edit" size = "20" style="color:black"></td></tr>
		<tr><td>User type:</td>
			<td><select name="type_edit" style="color:black">
					<option value="CUSTOMER" style="color:black">Customer</option>
					<option value="COOK" style="color:black">Cook</option>
					<option value="IT" style="color:black">IT</option>
					<option value="VD_OWNER" style="color:black">Vendor owner</option>
				</select>
			</td>
		</tr>
	</table>
	<table id="main_buttons">
		<tr><td><button type="button" id="btn_remove" onclick="confirmationForm()" style="color:black">Remove</button></td>
			<td><button type="button" id="btn_edit" onclick="editForm()" style="color:black">Edit</button></td>
			<td><button type="button" id="btn_new" onclick="newAccountForm()" style="color:black">New account</button></td>
		</tr>
	</table>
	<table id="remove_buttons" style="display:none">
		<tr><td><button type="submit" name="btn" id="btn_yes" value = "remove" style="color:black">Yes</button></td>
			<td><button type="button" name="btn" id="btn_no" style="color:black" onclick="confirmationForm()">No</button></td>
		</tr>
	</table>
	<table id="add_buttons" style="display:none">
		<tr><td><button type="submit" name="btn" id="btn_add" value = "add" style="color:black">Add new</button></td>
			<td><button type="button" name="btn_cancel" id="btn_canceladd" style="color:black" onclick="newAccountForm()">Cancel</button></td>
		</tr>
	</table>		
	<table id="edit_buttons" style="display:none">
	<tr><td><button type="submit" name="btn" id="btn_apply" value = "edit" style="color:black"">Apply</button></td>
		<td><button type="button" name="btn_cancel" id="btn_canceledit" style="color:black" onclick="editForm()">Cancel</button></td>
	</tr>
	</table>

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
		document.getElementById("main_buttons").style.display = "none";
		document.getElementById("remove_buttons").style.display = "";
	}
	else {
		for(var i = 1, row; row = table.rows[i]; i++) {
			row.style.display = "";
		}
		document.getElementById("prompt").style.display = "none";
		document.getElementById("main_buttons").style.display = "";
		document.getElementById("remove_buttons").style.display = "none";
	}
}

function newAccountForm() {
	if (document.getElementById("add_form").style.display === "none") {
		document.getElementById("add_form").style.display = "";
		document.getElementById("add_prompt").style.display = "";
		document.getElementById("user_list").style.display = "none";
		document.getElementById("main_buttons").style.display = "none";
		document.getElementById("add_buttons").style.display = "";
	}
	else {
		document.getElementById("add_form").style.display = "none";
		document.getElementById("add_prompt").style.display = "none";
		document.getElementById("user_list").style.display = "";
		document.getElementById("main_buttons").style.display = "";
		document.getElementById("add_buttons").style.display = "none";
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
		document.getElementById("main_buttons").style.display = "none";
		document.getElementById("edit_buttons").style.display = "";
	}
	else {
		for(var i = 1, row; row = table.rows[i]; i++) {
			row.style.display = "";
		}
		document.getElementById("edit_form").style.display = "none";
		document.getElementById("edit_prompt").style.display = "none";
		document.getElementById("main_buttons").style.display = "";
		document.getElementById("edit_buttons").style.display = "none";
	}
}
</script>
</div>
<!-- Javascript files -->
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Include js plugin -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.carousel.min.js"></script>
<!-- WayPoints JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/waypoints/2.0.3/waypoints.min.js"></script>
<!-- Custom JS -->
<script src="${pageContext.request.contextPath}/js/custom.js"></script>
</body>
</html>