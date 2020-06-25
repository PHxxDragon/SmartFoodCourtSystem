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
	</head>	
	<body>

		<div id="customer-main" class="wrapper">
			<!-- header area -->
			<header>
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
							<div class="nav navbar-nav navbar-right">
								<!-- logo area -->
								<a class="navbar-brand" href="${pageContext.request.contextPath}">
									<!-- logo image -->
									<img class="img-responsive" src="../img/logo/logo.png" alt="" />
								</a>
							</div>
							<ul class="nav navbar-nav navbar-right">
								<li><a href="${pageContext.request.contextPath}/profile">View Profile</a></li>
								<li><a href="${pageContext.request.contextPath}/viewOrder">View paid order</a></li>
								<li><a href="${pageContext.request.contextPath}/recharge">Nạp tiền</a></li>
								<li>
									<a class="h-cart">
										<button type="submit" id="confirm-order" name="confirmOrder" form="order-cart">
										<i class="fa fa-shopping-cart fa-lg" aria-hidden="true"></i></button>
									</a>
								</li>
							</ul>
						</div><!-- /.navbar-collapse -->
					</div><!-- /.container-fluid -->
				</nav>
			</header>
			<!--/ header end -->
			<div class="pad"></div>
			
			<form name="ItemQuantity" id="order-cart" action="confirmOrderController" method="get">
			</form>
			<div class="feature">
				<div class="nav-animate"></div>
				<div class="feature-content">
					<div class="feature-title">
						<h2>Meals for today</h2>
					</div>
					
					<div class="feature-list">
						<c:forEach items="${mealList}" var="meal" varStatus="loop">
							<div class="feature-item">
								<div class="feature-img">
									<a href="#">
										<img src="<c:url value="/img/food_img/${meal.name}.jpg"/>" alt=""></img>
									</a>
								</div>
								<div class="feature-info">
									<h4><span class="feature-name">${meal.name}</span></h4>
									<p>Đơn giá: <span class="text-muted"><c:out value="${meal.price}"/></span></p>
									<p>Thời gian làm: <span class="text-muted"><c:out value="${meal.eta}"/></span></p>
								</div>
								<div class="order-quantity">
									<span class="quantity-title">Số lượng: </span>
									<input type="number" class="form-control" form="order-cart" aria-describedby="input-label"  
									name="quantity<c:out value="${meal.id}"/>" id="quantity<c:out value="${meal.id}"/>"
									value="0" min="0" max="200"/>
								</div>
								<div>
									<button form="order-cart" class="btn btn-theme add-cart-btn">Thêm vào giỏ</button>
								</div>	
							</div>
						</c:forEach>
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
=======
</html>