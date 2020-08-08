package com.foodcourt.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodcourt.common.dao.OrderDao;
import com.foodcourt.common.dao.UserDao;
import com.foodcourt.common.model.Order;
import com.foodcourt.common.model.User;

@WebServlet("/customer/validify")
public class PaymentMethodCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaymentMethodCheck() {
        super();
    }
    
    
    private boolean validify(String password, User user, Order order) {	
    	if (!password.equals(user.getpassword())) return false;
    	if (order.getOrderEntries().size() == 0) return false;
    	if (user.getBalance() < order.getPrice()) return false;
		return true;
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		long userID = (long) session.getAttribute("userID");
		// String bankName = request.getParameter("bankName");
		// String cardNumber = request.getParameter("cardNumber");
		String password = request.getParameter("password");
		
		User user = UserDao.getUserFromUserID(userID);
		Order order = user.getShoppingCart();
		
		boolean isValid = validify(password,user, order);
		if (isValid) {
			UserDao.updateBalance(user.getBalance() - order.getPrice(), user.getUsername());
			order.setOrderID(10);
			order.setSaleVendorID(1);
			order.setUserID(userID);
			OrderDao.addOrder(order);
			OrderDao.addPendingOrder(order);
			
			//Order new order
			Order newOrder = new Order();
			newOrder.setUserID(userID);
			UserDao.updateCart(userID, newOrder);
			request.setAttribute("paidStatus", true);
		} else {
			request.setAttribute("paidStatus", false);
		}
		RequestDispatcher rd = request.getRequestDispatcher("confirmOrderController");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
