package com.foodcourt.customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodcourt.common.dao.OrderDao;
import com.foodcourt.common.model.Order;

/**
 * Servlet implementation class PrintSlipController
 */
@WebServlet("/customer/printSlip")
public class PrintSlipController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String para = request.getParameter("printSlip");
		if (para != null) {
			long orderID = Long.parseLong(para);
			OrderDao orderDao = new OrderDao();
			Order order = orderDao.getOrderByUserIDAndID(1, orderID);
			request.setAttribute("order", order);
			RequestDispatcher rd = request.getRequestDispatcher("/customer/digitalSlip");
			rd.forward(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/customer/main");
		rd.forward(request, response);
	}

}