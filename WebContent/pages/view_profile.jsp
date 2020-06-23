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
		<div id="home" class="wrapper">
			<!-- header area -->
			<header>
				<!-- secondary menu -->
				<nav class="secondary-menu">
					<div class="container">
						<!-- secondary menu left link area -->
						<div class="sm-left">
							<!-- logo area -->
							<a class="nav-brand" href="${pageContext.request.contextPath}">
								<!-- logo image -->
								<img class="img" src="${pageContext.request.contextPath}/img/logo/logo.png" alt="" />
							</a>
						</div>
						<!-- secondary menu right link area -->
						<div class="sm-right">
							<!-- social link -->
							<div class="sm-social-link">
								<a class="h-facebook" href="https://www.facebook.com"><i class="fa fa-facebook fa-lg"></i></a>
								<a class="h-twitter" href="https://www.twitter.com"><i class="fa fa-twitter fa-lg"></i></a>
								<a class="h-instagram" href="https://www.instagram.com"><i class="fa fa-instagram fa-lg"></i></a>
								<a class="h-google" href="https://www.google.com"><i class="fa fa-google fa-lg"></i></a>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</nav>
				<!-- primary menu -->
				<nav class="navbar navbar-fixed-top navbar-default">
				<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							
						</div>
						<div class="hidden-icon hide">
							<!-- logo area -->
							<a class="navbar-brand" href="${pageContext.request.contextPath}">
								<!-- logo image -->
								<img class="img-responsive" src="../img/logo/logo.png" alt="" />
							</a>
						</div>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="${pageContext.request.contextPath}">Trang chủ</a></li>
								<li><a href="${pageContext.request.contextPath}/view_paidorder">Đơn hàng đã đặt</a></li>
								<li><a href="./customer/digital_slip.html">In hóa đơn</a></li>
								<li><a href="../">Đăng xuất</a></li>
							</ul>
						</div><!-- /.navbar-collapse -->
					</div><!-- /.container-fluid -->
				</nav>
			</header>
			<!--/ header end -->
		</div>
		
		<div class="profile">
			<div class="profile-info">
				<a class="profile-img">
					<img src="${pageContext.request.contextPath}/img/user/1.jpg"></img>
				</a>				
				<span class="profile-name">
					<h1>${user.name}</h1>
				</span>
				<span class="profile-username">
					<p class="text-muted">@${user.username}</p>
				</span>
				<span class="profile-desc">
					<p>Hey, this is just a short description about myself. Don't read much into it. :)<p>
				</span>
			</div>
			<!-- block for animate navigation menu -->
			<div class="nav-animate"></div>
			<div class="profile-activity">
				<div class="activity-border">
					<div class="activity-title">
						<h2>Nhật ký hoạt động</h2>
					</div>
					<div class="activity-feed">
						<p>An activity</p>
					</div>
					<div class="activity-feed">
						<p>An activity</p>
					</div>
					<div class="activity-feed">
						<p>An activity</p>
					</div>
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