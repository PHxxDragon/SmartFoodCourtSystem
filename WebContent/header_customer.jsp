<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!-- Pre-set values -->
	<c:set var="opt_active_0" value=""/>
	<c:set var="opt_active_1" value=""/>
	<c:set var="opt_active_2" value=""/>
	<c:set var="opt_active_3" value=""/>
	<c:set var="opt_active_4" value=""/>
	
	<c:choose>
		<c:when test="${param.navbar_opt == 0}">
			<c:set var="opt_active_0" value="active"/>
		</c:when>
		<c:when test="${param.navbar_opt == 1}">
			<c:set var="opt_active_1" value="active"/>
		</c:when>
		<c:when test="${param.navbar_opt == 2}">
			<c:set var="opt_active_2" value="active"/>
		</c:when>
		<c:when test="${param.navbar_opt == 3}">
			<c:set var="opt_active_3" value="active"/>
		</c:when>
		<c:when test="${param.navbar_opt ==4}">
			<c:set var="opt_active_4" value="active"/>
		</c:when>
	</c:choose>
	
	<!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="${pageContext.request.contextPath}/customer/main"><img src="${pageContext.request.contextPath}/img/logo.png" alt=""></a>
        </div>
        <!-- 
        <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> <span></span></a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span class="cart__total__size">${cartSize }</span></a></li>
            </ul>
            <div class="header__cart__price">Giỏ hàng: <span>${shoppingCart.price}&#8363;</span></div>
        </div>
        -->
        <div class="humberger__menu__widget">
            <div class="header__top__right__auth">
                <a href="${pageContext.request.contextPath}/Logout"><i class="fa fa-user"></i> Đăng xuất</a>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="${opt_active_0}"><a href="${pageContext.request.contextPath}/customer/main">Trang chủ</a></li>
				<li class="${opt_active_1}"><a href="${pageContext.request.contextPath}/customer/profile">Tài khoản</a></li>
				<li class="${opt_active_2}"><a href="${pageContext.request.contextPath}/customer/viewCart">Giỏ hàng</a></li>
				<li class="${opt_active_3}"><a href="${pageContext.request.contextPath}/customer/confirmOrderController">Thanh toán</a></li>
				<li class="${opt_active_4}"><a href="./contact.html">Liên hệ</a></li>
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
                                <a href="${pageContext.request.contextPath}/Logout"><i class="fa fa-user"></i> Đăng xuất</a>	
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
                        <a href="${pageContext.request.contextPath}/customer/main"><img src="${pageContext.request.contextPath}/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-9">
                    <nav class="header__menu">
                        <ul>
                            <li class="${opt_active_0}"><a href="${pageContext.request.contextPath}/customer/main">Trang chủ</a></li>
							<li class="${opt_active_1}"><a href="${pageContext.request.contextPath}/customer/profile">Tài khoản</a></li>
							<li class="${opt_active_2}"><a href="${pageContext.request.contextPath}/customer/viewCart">Giỏ hàng</a></li>
							<li class="${opt_active_3}"><a href="${pageContext.request.contextPath}/customer/confirmOrderController">Thanh toán</a></li>
							<li class="${opt_active_4}"><a href="./contact.html">Liên hệ</a></li>
                        </ul>
                    </nav>
                </div>
                <!-- 
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span></span></a></li>
                            <li><a href="${pageContext.request.contextPath}/customer/viewCart"><i class="fa fa-shopping-bag"></i> <span class="cart__total__size">${cartSize}</span> </a></li>
                        </ul>
                    <div class="header__cart__price">Giỏ hàng: <span class="cart__total__price">${shoppingCart.price}</span><span>&#8363;</span></div>
                    </div>
                </div>
                -->
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->
    
    <!-- Hero Section Begin -->
    <c:choose>
	    <c:when test="${param.navbar_opt == 0}">
	    	<!-- Hero Section Main Page Begin -->
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
		                        <c:forEach items="${vendorList}" var="vendor" varStatus="loop">
		                            <li><a href="${pageContext.request.contextPath}/customer/vendorDetail?vendorID=${vendor.id}">${vendor.name}</a></li>
		                        </c:forEach>
		                        </ul>
		                    </div>
		                </div>
		                <div class="col-lg-9">
		                    <div class="hero__search">
		                        <div class="hero__search__form">
		                            <form action="findItemController">
		                                <input type="text" placeholder="Nhập từ khóa" name ="stringToFind">
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
		                            <h2>Soufflé au chocolat <br />Le chocolat, l'esprit léger</h2>
		                            <p>Miễn phí giao hàng</p>
		                            <a href="#" class="primary-btn">ĐẶT NGAY</a>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </section>
		    <!-- Hero Section Main Page End -->
	    </c:when>
		<c:otherwise>
			<!-- Hero Section Normal Pages Begin -->
			<section class="hero hero-normal">
		        <div class="container">
		            <div class="row">
		                <div class="col-lg-3">
		                    <div class="hero__categories">
		                        <div class="hero__categories__all">
		                            <i class="fa fa-bars"></i>
		                            <span>Các vendor</span>
		                        </div>
		                        <ul>
		                             <c:forEach items="${vendorList}" var="vendor" varStatus="loop">
		                           		 <li><a href="${pageContext.request.contextPath}/customer/vendorDetail?vendorID=${vendor.id}">${vendor.name }</a></li>
		                       		 </c:forEach>
		                        </ul>
		                    </div>
		                </div>
		                <div class="col-lg-9">
		                    <div class="hero__search">
		                        <div class="hero__search__form">
		                            <form action="${pageContext.request.contextPath}/customer/findItemController">
		                                <input type="text" placeholder="Nhập từ khóa" name="stringToFind">
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
		                </div>
		            </div>
		        </div>
		    </section>
		    <!-- Hero Section Normal Pages End -->
		</c:otherwise>
    </c:choose>
    <!-- Hero Section End -->