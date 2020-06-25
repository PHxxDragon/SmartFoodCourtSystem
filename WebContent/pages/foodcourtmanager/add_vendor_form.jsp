<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodcourt.common.UserType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
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
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/style-color.css" rel="stylesheet">
		
		<!-- Favicon -->
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/logo/favicon.ico">
	</head>
	<body>
		
		
		<div class="form-window">
			<!-- form content -->
			<div class="form-content animated fadeInUp">
				<!-- form title -->
				<div class="form-title">
					<h1>Add a new vendor</h1>
				</div>
				<form action="../../fcmanager/manage_vendors" id="addnewvendor_form" method="post">
					<!-- form field-->
					<div class="form-group">
						<label class="control-label" for="name">Name</label>
						<input class="form-control" type="text" name="name" id="name" required>
					</div>
					<div class="form-group">
						<label class="control-label" for="id">ID</label>
						<input class="form-control" type="text" name="id" id="id" required>
					</div>
					<div class="form-group">
						<label class="control-label" for="ownerid">Owner ID</label>
						<input class="form-control" type="text" name="ownerid" id="ownerid" required>
					</div>

					<div class="form-group text-center">
						<button  type="submit" name="btn" value="add" class="btn btn-theme btn-lg">Add</button>
					</div>
				</form>
				
			</div>
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

