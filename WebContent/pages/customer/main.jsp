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
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/main.js"></script>
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
							<li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
							<li><a href="${pageContext.request.contextPath}/customer/viewOrder">Đơn hàng đã đặt</a></li>
							<li><a href="${pageContext.request.contextPath}/customer/recharge">Nạp tiền</a></li>
							<li><a href="${pageContext.request.contextPath}/customer/viewCart">Giỏ hàng</a></li>
						</ul>
					</div><!-- /.navbar-collapse -->
				</div><!-- /.container-fluid -->
			</nav>
		</header>
		<!--/ header end -->
	</div>
	<div class="feature">
		<div class="feature-content">
			<div class="feature-title">
				<h2>Meals for today</h2>
			</div>
			<div class="feature-table">
				<table class="feature-content-table"> 
			         <tr bgcolor="00FF7F"> 
			          <th><b>Name</b></th> 
			          <th><b>ID</b></th> 
			          <th><b>Price</b></th>
			          <th><b>ETA</b></th>
			          <th class="illustration"><b>Illustration</b></th>
			          <th><b>Quantity</b></th>
			         </tr>  
			
					<c:forEach items="${mealList}" var="meal" varStatus="loop">
			            <tr> 
			                <td>${meal.name}</td> 
			                <td>${meal.id}</td> 
			                <td>${meal.price}</td> 
			                <td>${meal.eta}</td>
			                <td><img src="<c:url value='/img/food_img/${meal.name}.jpg'/>"  width="100px" height =100px/></td>
			                <td><Button onclick="addToShoppingCart(${meal.id}, '${pageContext.request.contextPath}/customer/cart', 1)" value="Add">Add to shopping cart</Button></td>    
			            </tr> 
			          </c:forEach>
			    </table> 
			    <div>
				<a href="${pageContext.request.contextPath}/customer/confirmOrderController">Xác nhận đơn hàng</a>
				</div>
			</div> 
			</div>
	  	</div> 
</body>
</html>