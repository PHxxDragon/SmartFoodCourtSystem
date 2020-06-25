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
@WebServlet("/customer/cart")
public class ShoppingCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void addMeal (long userID, long mealID, int quantity) {
		UserDao.addMeal(userID, mealID, quantity);
	}
	
	private void removeMeal (long userID, long mealID) {
		UserDao.removeMeal(userID, mealID);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String para1 = request.getParameter("op");
		String para2 = request.getParameter("mealID");
		String para3 = request.getParameter("quantity");
		if (para1 == null || para2 == null) {
			return;
		} else {
			long mealID = Long.parseLong(para2);
			HttpSession session = request.getSession();
			long userID = (long) session.getAttribute("userID");
			if (para1.equals("add")) {
				if (para3 == null) addMeal (userID, mealID, 1);
				else addMeal(userID, mealID, Integer.parseInt(para3));
			} else if (para1.equals("remove")) {
				removeMeal(userID, mealID);
			}
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
