<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Đăng nhập vào SCFS</title>
		
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
					<h1>Tạo tài khoản SFCS của bạn</h1>
				</div>
				<form action="Register" id="signup_form" method="post">
					<!-- form field-->
					<div class="form-group">
						<label class="control-label" for="name">Họ và tên</label>
						<input class="form-control" type="text" name="name" id="name" required>
					</div>
					<div class="form-group">
						<label class="control-label" for="email">Email</label>
						<input class="form-control" type="text" name="email" id="email" required>
					</div>
					<div class="form-group">
						<label class="control-label" for="username">Tên đăng nhập</label>
						<input class="form-control" type="text" name="username" id="username" required>
					</div>

					<div class="form-group">
						<label class="control-label" for="password">Mật khẩu</label>
						<input class="form-control" type="password" name="password" id="password" minlength="4" maxlength="20" required>
						<small id="passwordHelpInline" class="form-text text-muted">
						Mật khẩu của bạn phải dài từ 4-20 kí tự.
						</small>
					</div>
					<div class="form-group text-center">
						<button type="submit" class="btn btn-theme btn-lg">Tạo tài khoản</button>
					</div>
				</form>
				<div class="other-opts">
					<a id="sign-up" href="./login">
						<span>Đã có tài khoản? Đăng nhập</span>
					</a>
				</div>
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