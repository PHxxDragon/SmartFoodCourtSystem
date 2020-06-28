<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${user.name}</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Styles -->
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">	
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
								<img class="img-responsive" src="img/logo/logo.png" alt="" />
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
								<li><a href="${pageContext.request.contextPath}">Trang chủ</a></li>
								<li><a href="${pageContext.request.contextPath}/customer/viewOrder">Đơn hàng đã đặt</a></li>
								<li><a href="changepassword">Đổi mật khẩu</a></li>
								<li><a href="Logout">Đăng xuất</a></li>
							</ul>
						</div><!-- /.navbar-collapse -->
					</div><!-- /.container-fluid -->
				</nav>
			</header>
			<!--/ header end -->
			<!-- Padding for navbar -->
			<div class="pad"></div>
			
			<div class="content-wrapper">
				<!-- Left side-bar -->
				<div class="left-sidebar-wrapper"></div>
				<!-- Main content -->
				<div class="main-content-wrapper">
					<div class="profile">
						<div class="profile-head">
						
							<div class="profile-name">
								<div class="profile-fullname">
									<h1>${user.name}</h1>
								</div>
								
								<div class="profile-username">
									<span class="text-muted">@${user.username}</span>
								</div>
							</div>
							
							<div class="profile-img">
								<img src="${pageContext.request.contextPath}/img/user/1.jpg"></img>
							</div>
						</div>
						
						<div class="profile-desc">
							<span>Hey, this is just a short description about myself. Don't read much into it. :)</span>
						</div>
						
						<div class="profile-info">
							<div class="profile-email">
								<span class="text-muted">Email : </span>${user.email}
							</div>
							<div class="profile-balance">
								<span class="text-muted">Account balance : </span>${user.balance}
							</div>
						</div>
>>>>>>> 1fd67bd3026e60a790023f3d597989d90e0aef25
					</div>
					<!-- Profile past activity -->
					<div class="profile-activity">
						<div class="generic-title">
							<h2>Nhật ký hoạt động</h2>
						</div>
						<div class="generic-content">
							<div class="generic-list">
								<div class="feature-item">	
									<p>An activity</p>
								</div>
								<div class="feature-item">	
									<p>An activity</p>
								</div>
								<div class="feature-item">	
									<p>An activity</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Right side-bar -->
				<div class="right-sidebar-wrapper"></div>
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
