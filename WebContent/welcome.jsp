<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Smart Food Court System</title>
		<!-- Description, Keywords and Author -->
		<meta name="description" content="Your description">
		<meta name="keywords" content="Your,Keywords">
		<meta name="author" content="HimanshuGupta">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Styles -->
		<!-- Bootstrap CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">	
		<!-- Animate CSS -->
		<link href="css/animate.min.css" rel="stylesheet">
		<!-- Basic stylesheet -->
		<link rel="stylesheet" href="css/owl.carousel.css">
		<!-- Font awesome CSS -->
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">		
		<!-- Custom CSS -->
		<link href="css/style.css" rel="stylesheet">
		<link href="css/style-color.css" rel="stylesheet">
		
		<!-- Favicon -->
		<link rel="shortcut icon" href="img/logo/favicon.ico">
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
							<a class="sm-brand" href="#home">
								<!-- logo image -->
								<img class="img" src="img/logo/logo.png" alt="" />
							</a>
						</div>
						<!-- secondary menu right link area -->
						<div class="sm-right">
							<!-- social link -->
							<div class="sm-social-link">
								<a class="h-facebook" href="https://www.facebook.com"><i class="fa fa-facebook"></i></a>
								<a class="h-twitter" href="https://www.twitter.com"><i class="fa fa-twitter"></i></a>
								<a class="h-instagram" href="https://www.instagram.com"><i class="fa fa-instagram"></i></a>
								<a class="h-google" href="https://www.google.com"><i class="fa fa-google"></i></a>
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

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="./login">Đăng nhập</a></li>
								<li><a href="./signup">Đăng ký</a></li>
							</ul>
						</div><!-- /.navbar-collapse -->
					</div><!-- /.container-fluid -->
				</nav>
			</header>
			<!--/ header end -->
		
		
			<!-- banner area -->
			<div class="banner">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="img/banner/b1.jpg" alt="...">
							<div class="container">
								<!-- banner caption -->
								<div class="carousel-caption slide-one">
									<!-- heading -->
									<h2 class="animated fadeInLeftBig"><i class="fa fa-cutlery"></i> Khuyến mãi lớn...</h2>
									<!-- paragraph -->
									<h3 class="animated fadeInRightBig">Đừng bỏ lỡ cơ hội này!</h3>
									<!-- button -->
									<a href="#" class="animated fadeIn btn btn-theme">Đặt món ngay</a>
								</div>
							</div>
						</div>
						<div class="item">
							<img src="img/banner/b2.jpg" alt="...">
							<div class="container">
								<!-- banner caption -->
								<div class="carousel-caption slide-two">
									<!-- heading -->
									<h2 class="animated fadeInLeftBig"><i class="fa fa-cutlery"></i>Khuyến mãi lớn...</h2>
									<!-- paragraph -->
									<h3 class="animated fadeInRightBig">Đừng bỏ lỡ cơ hội này!</h3>
									<!-- button -->
									<a href="#" class="animated fadeIn btn btn-theme">Đặt món ngay</a>
								</div>
							</div>
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="fa fa-arrow-left" aria-hidden="true"></span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="fa fa-arrow-right" aria-hidden="true"></span>
					</a>
				</div>
			</div>
			<!--/ banner end -->
		</div>
		<!-- Javascript files -->
		<!-- jQuery -->
		<script src="js/jquery.js"></script>
		<!-- Bootstrap JS -->
		<script src="js/bootstrap.min.js"></script>
		<!-- Include js plugin -->
		<script src="js/owl.carousel.min.js"></script>
	</body>
</html>