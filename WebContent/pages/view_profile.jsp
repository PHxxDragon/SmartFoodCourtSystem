<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <!-- Humberger Begin -->
	<div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="#"><img src="${pageContext.request.contextPath}/img/logo.png" alt=""></a>
        </div>
        <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
            </ul>
            <div class="header__cart__price">item: <span>$150.00</span></div>
        </div>
        <div class="humberger__menu__widget">
            <div class="header__top__right__auth">
                <a href="./logout"><i class="fa fa-user"></i> Đăng xuất</a>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li><a href="${pageContext.request.contextPath}/customer/main">Trang chủ</a></li>
				<li class="active"><a href="">Tài khoản</a></li>
				<li><a href="${pageContext.request.contextPath}/customer/viewCart">Giỏ hàng</a></li>
				<li><a href="${pageContext.request.contextPath}/customer/confirmOrderController">Thanh toán</a></li>
				<li><a href="./contact.html">Liên hệ</a></li>
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
                        <a href=""><img src="${pageContext.request.contextPath}/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-9">
                    <nav class="header__menu">
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/customer/main">Trang chủ</a></li>
							<li class="active"><a href="">Tài khoản</a></li>
							<li><a href="${pageContext.request.contextPath}/customer/viewCart">Giỏ hàng</a></li>
							<li><a href="${pageContext.request.contextPath}/customer/confirmOrderController">Thanh toán</a></li>
							<li><a href="./contact.html">Liên hệ</a></li>
                        </ul>
                    </nav>
                </div>
                <!--  
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span></span></a></li>
                            <li><a href="${pageContext.request.contextPath}/customer/viewCart"><i class="fa fa-shopping-bag"></i><span></span></a></li>
                        </ul>
                        <div class="header__cart__price">Giỏ hàng: <span>$150.00</span></div>
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
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->
    
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="${pageContext.request.contextPath}/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Tài khoản</h2>
                        <div class="breadcrumb__option">
                            <a href="${pageContext.request.contextPath}/customer/main">Trang chủ</a>
                            <span>Tài khoản</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->
    
    <!-- Profile Section Begin -->
	<section class="profile">
		<div class="container">
			<div class="profile__title">
				<h4>Tài khoản</h4>
			</div>
			
			<div class="row justify-content-center align-items-center">
				<div class="col-6 col-md-3 profile__name">
					<h2>${user.name}</h2>
					<p class="text-muted">@${user.username}</p>
				</div>
				<div class="col-6 col-md-3 profile__img">
					<img src="${pageContext.request.contextPath}/img/user/1.jpg">
				</div>
			</div>
		</div>
	</section>
	<!-- Profile Section End -->
	
	<!-- Profile Function Section Begin -->
    <section class="profile__featured">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="featured__controls">
                        <ul>
                            <li class="active" data-filter=".general">Thông tin chung</li>
                            <li data-filter=".paid-orders">Đơn hàng đã thanh toán</li>
                            <li data-filter=".recharge">Nạp tiền</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center profile__options__filter">
            	<!-- General info -->
               	<div class="profile__featured__general col-lg-6 mix general">
            		<ul class="list-unstyled">
            			<li>
            				<h4>Loại tài khoản</h4>
            				<span>${user.userType.toString()}</span>
            			</li>
            			<li>
            				<h4>Email</h4>
            				<span>
            					<c:choose>
		            				<c:when test="${empty user.email}">
		            					Chưa có thông tin
		            				</c:when>
		            				<c:otherwise>
		            					${user.email}
		            				</c:otherwise>
	            				</c:choose>
            				</span>
            			</li>
            			<li>
            				<h4>Số dư tài khoản</h4>
            				<span>${user.balance} &#8363;</span>
            			</li>
            		</ul>
              	</div>
              	<!-- End General info -->
              	<!-- View paid orders -->
            	<div class="profile__featured__general col-lg-6 mix paid-orders">
		            <c:forEach items = "${PaidOrders}" var="order">
			          	<div class="col-lg-12">
					        <div class="order__table">
					          	<table>
									<tr>
										<td colspan=4> 
						                    <div class="shoping__cart__table">
						                        <table>
							                            <thead>
							                                <tr>
							                                    <th class="shoping__product">Tên món ăn</th>
							                                    <th>Đơn giá</th>
							                                    <th>Số lượng</th>
							                                    <th>Tổng cộng</th>
							                                    <th></th>
							                                </tr>
							                            </thead>
						                            	<tbody>
						                            		<c:forEach items = "${order.orderEntries}" var="entry" varStatus="loop">
						                            			<tr class="shoping__cart__list">
								                                    <td class="shoping__cart__item">     
								                                        <h5 class="item-title">${entry.meal.name}</h5>
								                                    </td>
								                                    <td class="shoping__cart__price">
								                                        <span id="item-price">${entry.meal.price}</span>
								                                    </td>
								                                    <td class="shoping__cart__quantity">
							                                        	<div class="quantity">
							                                            	<span id="item-quantity">${entry.quantity}</span>
							                                        	</div>
							                                    	</td>
							                                    	<td class="shoping__cart__total">
							                                    		<span id="item-total-price">${entry.meal.price*entry.quantity }</span>&#8363;
							                                    	</td>
							                                	</tr>
						                            		</c:forEach>
						                            	</tbody>
					               	         		</table>
					                	    	</div> 
						            	   	</td>
						    		 	</tr>
						    		<tr>
										<td>
											<span id="purchase__timestamp">
												<c:out value="Thời điểm thanh toán : ${order.eta}" />
											</span>	 
										</td>
										<td>
											<span id="total__order__price">
												<c:out value="Tổng đơn hàng : ${order.price}" /> 
											</span>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</c:forEach>
         		</div>
         		<!-- End View paid orders -->
         		<!-- Recharge -->
         		<div class="profile__featured__general col-lg-6 mix recharge">
         			<div class="checkout__form">
		                <h4>Nhập thông tin thẻ nạp</h4>
		                <form action="${pageContext.request.contextPath }/customer/rechargeController">
	                        <div class="row">
	                        	<div class="col-lg-12">
	                        		<div class="checkout__input">
		                                <p>Nhà mạng<span>*</span></p>
		                                <input type="text" required>
		                            </div>
	                        	</div>
                        	</div>
                           	<div class="row"> 
                           		<div class="col-lg-12">
                           			<div class="checkout__input">
		                                <p>Số seri<span>*</span></p>
		                                <input type="text" required>
		                            </div>
                           		</div>
                            </div>
                            <div class="row">
                            	<div class="col-lg-12">
                            		<div class="rechare__submit">
			                    	    <button type="submit" class="site-btn">Nạp tiền</button>
			                        </div>
                            	</div>
	                        </div>
	                	</form>
		            </div>
       			</div>
         		<!-- End Recharge -->
        	</div>
        </div>
    </section>
    <!-- Profile Function Section End -->
    
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
