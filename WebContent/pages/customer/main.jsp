<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodcourt.common.UserType" %>
<%@ page import="com.foodcourt.common.model.Meal" %>

<%@page import="java.util.List"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>SFCS</title>
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
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/main.js"></script>
	</head>	
<body>
	<div id="home" class="wrapper">
		<!-- header area -->
		<header>
			<!-- secondary menu -->
			<nav class="secondary-menu">
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
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="${pageContext.request.contextPath}/profile">Trang cá nhân</a></li>
								<li><a href="${pageContext.request.contextPath}/customer/viewOrder">Đơn hàng đã thanh toán</a></li>
								<li><a href="${pageContext.request.contextPath}/customer/recharge">Nạp tiền</a></li>
								<li><a href="${pageContext.request.contextPath}/customer/viewCart">Giỏ hàng</a></li>
							</ul>
						</div><!-- /.navbar-collapse -->
					</div><!-- /.container-fluid -->
				</nav>
			</header>
			<!--/ header end -->
			
			<div class="pad"></div>
			<form name="ItemQuantity" id="order-cart" action="confirmOrderController">
			</form>
			<div class="content-wrapper">
				<div class="left-sidebar-wrapper"></div>
				<div class="main-content-wrapper">
					<div class="generic-title">
						<h2>Meals for today</h2>
					</div>
					<div class="generic-content">
						<div class="generic-list">
							<c:forEach items="${mealList}" var="meal" varStatus="loop">
								<div class="feature-item">
									<div class="feature-img">
										<a href="#">
											<img src="<c:url value="/img/food_img/${meal.name}.jpg"/>" alt=""></img>
										</a>
									</div>
		
									<div class="feature-main">
										<h4><span>${meal.name}</span></h4>
										<div class="order-quantity">
											<span class="quantity-title">Số lượng: </span>
											<input type="text" class="form-control quantity-input" form="order-cart" aria-describedby="input-label"  
											name="quantity<c:out value="${meal.id}"/>" id="quantity<c:out value="${meal.id}"/>"
											inputmode="numeric" maxlength="3" value="0" pattern="[0-9]"/>
										</div>
										<div class="add-cart-btn">
											<button onclick="addToShoppingCart(${meal.id}, '${pageContext.request.contextPath}/customer/cart', 1)" class="btn btn-theme">Thêm vào giỏ</button>
										</div>	
									</div>
									
									<div class="feature-info">
										<p>Đơn giá: <span class="text-muted"><c:out value="${meal.price}"/></span></p>
										<p>Thời gian làm: <span class="text-muted"><c:out value="${meal.eta}"/></span></p>
										
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					
		  		</div>
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