package com.foodcourt.customer.controller;

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

@WebServlet("/customer/viewOrder")
public class PaidOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaidOrderController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long userID = (long) session.getAttribute("userID");
		User user = UserDao.getUserFromUserID(userID);
		List<Order> paidOrders = OrderDao.getOrdersByUserId(user.getUserID());
		request.setAttribute("PaidOrders", paidOrders);
		RequestDispatcher rd = request.getRequestDispatcher("/customer/view_paidorderJSP");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
