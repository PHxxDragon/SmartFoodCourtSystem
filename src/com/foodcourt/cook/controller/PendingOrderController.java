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

import com.foodcourt.common.UserType;
import com.foodcourt.common.dao.OrderDao;
import com.foodcourt.common.model.Order;

@WebServlet("/cook/viewOrder")
public class PendingOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void confirmOrder(long orderID) {
		OrderDao orderDao = new OrderDao();
		orderDao.confirmPendingOrder(orderID);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao orderDao = new OrderDao();
		List<Order> pendingOrders = orderDao.getPendingOrders();
		request.setAttribute("PendingOrders", pendingOrders);
		RequestDispatcher rd = request.getRequestDispatcher("/cook/view_orderJSP");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = (String) request.getParameter("confirm");
		if (value != null) {
			long confirmOrderID = Long.parseLong(value);
			confirmOrder(confirmOrderID);
		}
		doGet(request, response);
	}

}
