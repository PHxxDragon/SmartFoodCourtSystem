<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <!-- 
        <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
            </ul>
            <div class="header__cart__price">item: <span>$150.00</span></div>
        </div>
        -->
        <div class="humberger__menu__widget">
            <div class="header__top__right__auth">
                <a href="./logout"><i class="fa fa-user"></i> Đăng xuất</a>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
				<li class="active"><a href="">Trang chủ</a></li>
				<li><a href="${pageContext.request.contextPath}/fcmanager/manage_accounts" class="primary-btn">Quản lý tài khoản</a></li>
				<li><a href="${pageContext.request.contextPath}/changepassword" class="primary-btn">Đổi mật khẩu</a></li>
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
                            <li class="active"><a href="">Trang chủ</a></li>
                            <li><a href="${pageContext.request.contextPath}/fcmanager/manage_accounts">Quản lý tài khoản</a></li>
							<li><a href="${pageContext.request.contextPath}/changepassword">Đổi mật khẩu</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->
    
     <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="${pageContext.request.contextPath}/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Trang chủ</h2>
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
                            <li data-filter=".manage-accounts">Quản lý người dùng</li>
                            <li data-filter=".manage-vendors">Quản lý các quầy hàng</li>
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
            			<li><a href="${pageContext.request.contextPath}/changepassword" class="primary-btn">Đổi mật khẩu</a></li>
            		</ul>
              	</div>
              	<!-- End General info -->
              	
              	<!-- View users -->
            	<div class="profile__featured__general col-lg-12 mix manage-accounts">
            		<div class="col-lg-12">
            			<p id="account_prompt" style="display:none">Remove these users?</p>
		                <p id="account_add_prompt" style="display:none">Create a new user</p>
		                <p id="account_edit_prompt" style="display:none">Edit this user</p>
		                <form action="main" method="post">
		                	<div class="shoping__cart__table">
				                <table id="user_list">
				                     <thead>
				                         <tr>
				                             <th></th>
				                             <th>ID</th>
				                             <th>Username</th>
				                             <th class="hidden_column">Loại tài khoản</th>
				                             <th></th>
				                         </tr>
				                     </thead>
				                    <tbody>
					                    <c:forEach items="${Users}" var="entry" varStatus="loop">
				                            <tr>
					                            <td>
						                            <input type="checkbox" name="userlist" value="${entry.getUserID()}">
					                            </td>
					                            <td>
						                            <c:out value="${entry.getUserID()}"/>
					                            </td>
					                            <td>
						                            <c:out value="${entry.getUsername()}"/>
					                            </td>
					                            <td class="hidden_column">
						                            <c:out value="${entry.getUserType()}"/>
					                            </td>
					                            <td>
						                            <button type="button" id="btn_edit" onclick="accountEditForm(this.value)" class="site-btn" value = "${entry.getUserID()}">Sửa</button>
					                            </td>
				                            </tr>
					                    </c:forEach>
				                    </tbody>
				      	         </table>
				      	     </div>
			                 <table id="account_add_form" style="display:none">
				                <tr><td>Name:</td> <td><input type="text" name="account_name_add" style="color:black"></td></tr>
				                <tr><td>email:</td> <td><input type="text" name="account_email_add" style="color:black"></td></tr>
				                <tr><td>Username:</td> <td><input type="text" name="account_username_add" style="color:black"></td></tr>
				                <tr><td>Password:</td> <td><input type="password" name="account_password_add" size = "20" style="color:black"></td></tr>
				                <tr>
					                <td>User type:</td>
					                <td>
						                <select name="account_type_add" style="color:black">
							                <option value="CUSTOMER" style="color:black">Customer</option>
							                <option value="COOK" style="color:black">Cook</option>
							                <option value="IT" style="color:black">IT</option>
							                <option value="VD_OWNER" style="color:black">Vendor owner</option>
						                </select>
					                </td>
				                </tr>
			                </table>
							<table id="account_edit_form" style="display:none">
								<tr><td><input type="hidden" name="account_id_edit" id ="account_id_edit" style="color:black"></input></td></tr>
								<tr><td>Name:</td> <td><input type="text" name="account_name_edit" style="color:black"></td></tr>
								<tr><td>Username:</td> <td><input type="text" name="account_username_edit" style="color:black"></td></tr>
								<tr><td>Email:</td> <td><input type="text" name="account_email_edit" style="color:black"></td></tr>
								<tr><td>Password:</td> <td><input type="password" name="account_password_edit" size = "20" style="color:black"></td></tr>
								<tr><td>User type:</td>
									<td><select name="account_type_edit" style="color:black">
											<option value="NO_CHANGE" style="color:black">No change</option>
											<option value="CUSTOMER" style="color:black">Customer</option>
											<option value="COOK" style="color:black">Cook</option>
											<option value="IT" style="color:black">IT</option>
											<option value="VD_OWNER" style="color:black">Vendor owner</option>
										</select>
									</td>
								</tr>
							</table>
							<div id="account_main_buttons" class="account__management__btns">
								<button type="button" id="account_btn_remove" onclick="accountConfirmationForm()" class="site-btn">Xóa</button>
								<button type="button" id="account_btn_new" onclick="newAccountForm()" class="site-btn">Tài khoản mới</button>
							</div>
							<table id="account_remove_buttons" style="display:none">
								<tr><td><button type="submit" name="btn" id="account_btn_yes" value = "account_remove" style="color:black">Yes</button></td>
									<td><button type="button" name="btn" id="account_btn_no" style="color:black" onclick="accountConfirmationForm()">No</button></td>
								</tr>
							</table>
							<table id="account_add_buttons" style="display:none">
								<tr><td><button type="submit" name="btn" id="btn_add" value = "account_add" style="color:black">Add new</button></td>
									<td><button type="button" name="btn_cancel" id="btn_canceladd" style="color:black" onclick="newAccountForm()">Cancel</button></td>
								</tr>
							</table>		
							<table id="account_edit_buttons" style="display:none">
								<tr><td><button type="submit" name="btn" id="btn_apply" value = "account_edit" style="color:black">Apply</button></td>
									<td><button type="button" name="btn_cancel" id="btn_canceledit" style="color:black" onclick="accountEditForm()">Cancel</button></td>
								</tr>
							</table>
						</form>
            		</div>
	                
         		</div>
         		<!-- End View users -->
         		
              	<!-- View vendors -->
            	<div class="profile__featured__general col-lg-6 mix manage-vendors">
            	<div class="col-lg-12">
	                <p id="vendor_prompt" style="display:none">Remove these vendors?</p>
	                <p id="vendor_add_prompt" style="display:none">Add a new vendor</p>
	                <form action="main" method="post">
	                <div class="shoping__cart__table">
		                <table id="vendor_list">
		                    <thead>
		                         <tr>
		                             <th></th>
		                             <th>Vendor ID</th>
		                             <th>Owner ID</th>
		                             <th>Name</th>
		                         </tr>
		                    </thead>
		                    <tbody>
			                    <c:forEach items = "${Vendors}" var="entry" varStatus="loop">
		                            <tr>
			                            <td>
				                            <input type = "checkbox" name = "vendorlist" value = "${entry.getId()}">
			                            </td>
			                            <td>
				                            <c:out value="${entry.getId()}"/>
			                            </td>
			                            <td>
				                            <c:out value="${entry.getOwnerID()}"/>
			                            </td>
			                            <td>
				                            <c:out value="${entry.getName()}"/>
			                            </td>
		                            </tr>
			                    </c:forEach>
		                    </tbody>
		      	         </table>
		                 <table id="vendor_add_form" style="display:none">
			                <tr><td>Name:</td> <td><input type="text" name="vendor_name_add" style="color:black"></td></tr>
			                <tr><td>Owner ID:</td> <td><input type="text" name="vendor_ownerid_add" style="color:black"></td></tr>
		                </table>
						<table id="vendor_main_buttons">
							<tr><td><button type="button" id="vendor_btn_remove" onclick="vendorConfirmationForm()" style="color:black">Xóa</button></td>
								<td><button type="button" id="vendor_btn_new" onclick="newVendorForm()" style="color:black">Tạo mới</button></td>
							</tr>
						</table>
						<table id="vendor_remove_buttons" style="display:none">
							<tr><td><button type="submit" name="btn" id="vendor_btn_yes" value = "vendor_remove" style="color:black">Yes</button></td>
								<td><button type="button" name="btn" id="vendor_btn_no" style="color:black" onclick="vendorConfirmationForm()">No</button></td>
							</tr>
						</table>
						<table id="vendor_add_buttons" style="display:none">
							<tr><td><button type="submit" name="btn" id="btn_add" value = "vendor_add" style="color:black">Add new</button></td>
								<td><button type="button" name="btn_cancel" id="btn_canceladd" style="color:black" onclick="newVendorForm()">Cancel</button></td>
							</tr>
						</table>
					</div>
					</form>
				</div>
         		</div>
         		<!-- End View vendors -->
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
                        <p>Cập nhật các tin tức mới nhất về các gian hàng và thông tin giảm giá mới nhất.</p>
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
    <script src="${pageContext.request.contextPath}/js/foodcourtmanager/main.js"></script>
</body>
</html>
