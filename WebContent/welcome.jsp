<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodcourt.common.UserType" %>
<%@ page import="com.foodcourt.common.model.Meal" %>

<%@page import="java.util.List"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="MealDao" prefix="md" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Smart Food Court System</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/customer/main.js"></script>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
    
    <c:set value="${md:getMealList()}" var="mealList"/>
    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="#"><img src="${pageContext.request.contextPath}/img/logo.png" alt=""></a>
        </div>
        <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> <span></span></a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span class="cart__total__size">0</span></a></li>
            </ul>
            <!--  <div class="header__cart__price">Giỏ hàng: <span>${shoppingCart.price}&#8363;</span></div> -->
        </div>
        <div class="humberger__menu__widget">
            <div class="header__top__right__auth">
                <a href="./login"><i class="fa fa-user"></i> Đăng nhập</a>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="">Trang chủ</a></li>
				<li><a href="${pageContext.request.contextPath}/login">Tài khoản</a></li>
				<li><a href="${pageContext.request.contextPath}/login">Giỏ hàng</a></li>
				<li><a href="${pageContext.request.contextPath}/login">Thanh toán</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
        	<a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-pinterest-p"></i></a>  
        </div>
        <div class="humberger__menu__contact">
            <ul>
                <li><i class="fa fa-envelope"></i> support@sfcs.com</li>
            </ul>
        </div>
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> support@sfcs.com</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                             <div class="header__top__right__social">
                               <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-pinterest-p"></i></a> 
                            </div>
							<div class="header__top__right__auth">
                                <a href="${pageContext.request.contextPath}/login"><i class="fa fa-user"></i> Đăng nhập</a>	
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href=""><img src="${pageContext.request.contextPath}/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-9">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="">Trang chủ</a></li>
							<li><a href="${pageContext.request.contextPath}/login">Tài khoản</a></li>
							<li><a href="${pageContext.request.contextPath}/login">Giỏ hàng</a></li>
							<li><a href="${pageContext.request.contextPath}/login">Thanh toán</a></li>
							<li><a href="./contact.html">Liên hệ</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span></span></a></li>
                            <li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-shopping-bag"></i> <span class="cart__total__size">0</span> </a></li>
                        </ul>
                       <!--  <div class="header__cart__price">Giỏ hàng: <span class="cart__total__price">${shoppingCart.price}</span><span>&#8363;</span></div>  -->
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>Các vendor</span>
                        </div>
                        <ul>
                            <li><a href="#">Fresh Meat</a></li>
                            <li><a href="#">Vegetables</a></li>
                            <li><a href="#">Fruit & Nut Gifts</a></li>
                            <li><a href="#">Fresh Berries</a></li>
                            <li><a href="#">Ocean Foods</a></li>
                            <li><a href="#">Butter & Eggs</a></li>
                            <li><a href="#">Fastfood</a></li>
                            <li><a href="#">Fresh Onion</a></li>
                            <li><a href="#">Papayaya & Crisps</a></li>
                            <li><a href="#">Oatmeal</a></li>
                            <li><a href="#">Fresh Bananas</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <div class="hero__search__categories">
                                    Các vendor
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="Nhập từ khóa">
                                <button type="submit" class="site-btn">TÌM KIẾM</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>Hỗ trợ 24/7</span>
                            </div>
                        </div>
                    </div>
                    <div class="hero__item set-bg" data-setbg="${pageContext.request.contextPath}/img/hero/banner.jpg">
                        <div class="hero__text">
                            <span>MÓN MỚI</span>
                            <h2>Vegetable <br />100% Organic</h2>
                            <p>Miễn phí giao hàng</p>
                            <a href="${pageContext.request.contextPath}/login" class="primary-btn">ĐẶT NGAY</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Categories Section Begin -->
    <section class="categories">
        <div class="container">
            <div class="row">
                <div class="categories__slider owl-carousel">
					<c:forEach items="${mealList}" var="meal" varStatus="loop">
						<div class="col-lg-3">
							<div class="categories__item set-bg" data-setbg=
							"${pageContext.request.contextPath}/img/product/food_img/product-${meal.id}.jpg">
								<h5><a href="${pageContext.request.contextPath}/login">Thêm vào giỏ</a></h5>
							</div>
						</div>
					</c:forEach>
                </div>
            </div>
        </div>
    </section>
    <!-- Categories Section End -->

    <!-- Featured Section Begin -->
    <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>Các món nổi bật</h2>
                    </div>
                    <div class="featured__controls">
                        <ul>
                            <li class="active" data-filter="*">Tất cả</li>
                            <li data-filter="*">Bữa sáng</li>
                            <li data-filter="*">Bữa trưa</li>
                            <li data-filter="*">Bữa tối</li>
                            <li data-filter="*">Nước uống</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row featured__filter">
            	<c:forEach items="${mealList}" var="meal" varStatus="loop">
                	<div class="col-lg-3 col-md-4 col-sm-6 mix breakfast fresh-meat">
	                    <div class="featured__item">
	                        <div class="featured__item__pic set-bg" data-setbg=
	                        "${pageContext.request.contextPath}/img/product/food_img/product-${meal.id}.jpg">
	                            <ul class="featured__item__pic__hover">
	                                <li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-shopping-cart"></i></a></li>
	                            </ul>
	                        </div>
							<div class="featured__item__text">
								<h6><a href="#">${meal.name}</a></h6>
								<h5>${meal.price} &#8363;</h5>
							</div>	
	                    </div>
               	 	</div>
                 </c:forEach>
            </div>
        </div>
    </section>
    <!-- Featured Section End -->

    <!-- Banner Begin -->
    <div class="banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="${pageContext.request.contextPath}/img/banner/banner-1.jpg" alt="">
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="${pageContext.request.contextPath}/img/banner/banner-2.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
   <!-- Banner End -->

    <!-- Latest Product Section Begin -->
    <section class="latest-product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>Mới nhất</h4>
                        <div class="latest-product__slider owl-carousel">
                        	<c:forEach var="idx" varStatus="" begin="0" end="1">
                        		<c:set var="begin_loop_idx" value="${idx * 3}"/>
                        		<c:set var="end_loop_idx" value="${idx * 3 + 2}"/>
	                            <div class="latest-prdouct__slider__item">
	                            	<c:forEach items="${mealList}" var="meal" varStatus="loop" begin="${begin_loop_idx}" end="${end_loop_idx}">
		                                <a href="${pageContext.request.contextPath}/customer/itemDetail?mealID=${meal.id}" class="latest-product__item">
		                                    <div class="latest-product__item__pic">
		                                        <img src="${pageContext.request.contextPath}/img/product/food_img/product-${meal.id}.jpg"
		                                        alt="">
		                                    </div>
		                                    <div class="latest-product__item__text">
		                                        <h6>${meal.name}</h6>
		                                        <span>${meal.price}&#8363;</span>
		                                    </div>
		                                </a>
	                                </c:forEach>
	                            </div>		
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>Đánh giá cao nhất</h4>
                        <div class="latest-product__slider owl-carousel">
                        	<c:forEach var="idx" varStatus="" begin="0" end="2">
                        		<c:set var="begin_loop_idx" value="${idx * 3}"/>
                        		<c:set var="end_loop_idx" value="${idx * 3 + 2}"/>
	                            <div class="latest-prdouct__slider__item">
	                            	<c:forEach items="${mealList}" var="meal" varStatus="loop" begin="${begin_loop_idx}" end="${end_loop_idx}">
		                                <a href="${pageContext.request.contextPath}/customer/itemDetail?mealID=${meal.id}" class="latest-product__item">
		                                    <div class="latest-product__item__pic">
		                                        <img src="${pageContext.request.contextPath}/img/product/food_img/product-${meal.id}.jpg"
		                                        alt="">
		                                    </div>
		                                    <div class="latest-product__item__text">
		                                        <h6>${meal.name}</h6>
		                                        <span>${meal.price} &#8363;</span>
		                                    </div>
		                                </a>
	                                </c:forEach>
	                            </div>		
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>Được đề cử</h4>
                        <div class="latest-product__slider owl-carousel">
                        	<c:forEach var="idx" varStatus="" begin="1" end="2">
                        		<c:set var="begin_loop_idx" value="${idx * 3}"/>
                        		<c:set var="end_loop_idx" value="${idx * 3 + 2}"/>
	                            <div class="latest-prdouct__slider__item">
	                            	<c:forEach items="${mealList}" var="meal" varStatus="loop" begin="${begin_loop_idx}" end="${end_loop_idx}">
		                                <a href="${pageContext.request.contextPath}/customer/itemDetail?mealID=${meal.id}" class="latest-product__item">
		                                    <div class="latest-product__item__pic">
		                                        <img src="${pageContext.request.contextPath}/img/product/food_img/product-${meal.id}.jpg"
		                                        alt="">
		                                    </div>
		                                    <div class="latest-product__item__text">
		                                        <h6>${meal.name}</h6>
		                                        <span>${meal.price} &#8363;</span>
		                                    </div>
		                                </a>
	                                </c:forEach>
	                            </div>		
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Latest Product Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./index.html"><img src="${pageContext.request.contextPath}/img/logo.png" alt=""></a>
                        </div>
                        <ul>
                            <li>Địa chỉ: 60-49 Road 11378 New York</li>
                            <li>Điện thoại: +65 11.188.888</li>
                            <li>Email: support@sfcs.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">
                        <h6>Các thông tin khác</h6>
                        <ul>
                            <li><a href="#">Về chúng tôi</a></li>
                            <li><a href="#">Về trang web</a></li>
                            <li><a href="#">Mua sắm bảo mật</a></li>
                            <li><a href="#">Thông tin giao hàng</a></li>
                            <li><a href="#">Chính sách bảo mật</a></li>
                        </ul>
                        <ul>
                            <li><a href="#">Chúng tôi là ai</a></li>
                            <li><a href="#">Dịch vụ của chúng tôi</a></li>
                            <li><a href="#">Các dự án khác</a></li>
                            <li><a href="#">Thông tin liên lạc</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Theo dõi bảng tin của chúng tôi</h6>
                        <p>Cập nhật các ting tức mới nhất về các gian hàng và thông tin giảm giá mới nhất.</p>
                        <form action="#">
                            <input type="text" placeholder="Email của bạn">
                            <button type="submit" class="site-btn">Đăng ký</button>
                        </form>
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.nice-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.slicknav.js"></script>
    <script src="${pageContext.request.contextPath}/js/mixitup.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>

</html>