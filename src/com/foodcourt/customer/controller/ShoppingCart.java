package com.foodcourt.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodcourt.common.dao.UserDao;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/customer/addCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void addMeal (long userID, long mealID) {
		UserDao.addMeal(userID, mealID);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String para = request.getParameter("mealID");
		if (para == null) {
			return;
		} else {
			long mealID = Long.parseLong(para);
			HttpSession session = request.getSession();
			long userID = (long) session.getAttribute("userID");
			addMeal (userID, mealID);
			System.out.println("added to shopping cart");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
