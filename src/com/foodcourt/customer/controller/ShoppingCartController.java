package com.foodcourt.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodcourt.common.dao.UserDao;
import com.foodcourt.common.dao.MealDao;
import com.foodcourt.common.model.Meal;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/customer/addCart")
public class ShoppingCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void addMeal (long userID, long mealID) {
		UserDao.addMeal(userID, mealID);
	}
	private void updateCart (long userID, Meal meal) {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long mealID;
		int quantity;
		String tempMealID, tempQuantity, para;
		int count = 0;
		while (true) {
			tempMealID = request.getParameter("mealID" + Integer.toString(count));
			tempQuantity = request.getParameter("getQuantity" + Integer.toString(count));
			if (tempMealID == null || !tempMealID.isEmpty() || tempQuantity == null || !tempQuantity.isEmpty())
				break;
			mealID = Long.parseLong(tempMealID);
			quantity = Integer.parseInt(tempQuantity);
		}
		para = request.getParameter("mealID");
		if (para == null) {
			return;
		} else {
			mealID = Long.parseLong(para);
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