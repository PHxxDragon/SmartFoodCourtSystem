package com.foodcourt.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodcourt.common.dao.OrderDao;
import com.foodcourt.common.model.Order;
import com.foodcourt.common.model.Order.OrderEntry;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderDao orderDao = new OrderDao();
		PrintWriter out = response.getWriter();
		
		List<Order> orders = orderDao.getPendingOrders();
		for (Order o : orders) {
			out.println("saleid : " + o.getSaleVendorID());
			out.println("userid : " + o.getUserID());
			for (OrderEntry oe: o.getOrderEntries()) {
				out.println("mealid : " + oe.getMeal().getId());
				out.println("mealprice : " + oe.getMeal().getPrice());
				out.println("quantity : "+ oe.getQuantity());
				out.println();
			}
			out.println();
		}
		
		out.println("user 2 : ");
		orders = orderDao.getOrdersByUserId(2);
		for (Order o : orders) {
			out.println("saleid : " + o.getSaleVendorID());
			out.println("userid : " + o.getUserID());
			for (OrderEntry oe: o.getOrderEntries()) {
				out.println("mealid : " + oe.getMeal().getId());
				out.println("mealprice : " + oe.getMeal().getPrice());
				out.println("quantity : "+ oe.getQuantity());
				out.println();
			}
			out.println();
		}
		
		out.println("user 1 :");
		orders = orderDao.getOrdersByUserId(1);
		for (Order o : orders) {
			out.println("saleid : " + o.getSaleVendorID());
			out.println("userid : " + o.getUserID());
			for (OrderEntry oe: o.getOrderEntries()) {
				out.println("mealid : " + oe.getMeal().getId());
				out.println("mealprice : " + oe.getMeal().getPrice());
				out.println("quantity : "+ oe.getQuantity());
				out.println();
			}
			out.println();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
