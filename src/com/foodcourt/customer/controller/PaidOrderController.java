package com.foodcourt.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodcourt.common.dao.OrderDao;
import com.foodcourt.common.model.Order;

@WebServlet("/customer/viewOrder")
public class PaidOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaidOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao orderDao = new OrderDao();
		List<Order> paidOrders = orderDao.getOrdersByUserId(1);
		request.setAttribute("PaidOrders", paidOrders);
		RequestDispatcher rd = request.getRequestDispatcher("/customer/view_paidorderJSP");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
