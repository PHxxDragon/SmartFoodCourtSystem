package com.foodcourt.cook.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/cook/main")
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void confirmOrder(long orderID) {
		OrderDao.confirmPendingOrder(orderID);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> pendingOrders = OrderDao.getPendingOrders();
		request.setAttribute("pendingOrders", pendingOrders);
		HttpSession session = request.getSession();
		long userID = (long) session.getAttribute("userID");
		User user = UserDao.getUserFromUserID(userID);
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/cook/mainJSP");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = (String) request.getParameter("orderID");
		String value2 = (String) request.getParameter("op");
		System.out.println(value);
		System.out.println(value2);
		if (value2 != null && value2.equals("confirm")) {
			if (value != null) {
				long confirmOrderID = Long.parseLong(value);
				confirmOrder(confirmOrderID);
			}
			return;
		}
		doGet(request, response);
	}

}
