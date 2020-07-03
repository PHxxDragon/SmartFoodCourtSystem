package com.foodcourt.customer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.foodcourt.common.dao.MealDao;
import com.foodcourt.common.dao.UserDao;
import com.foodcourt.common.model.Order;
import com.foodcourt.common.model.OrderEntry;
import com.foodcourt.common.model.User;

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
	
	private void updateCart (long userID, String para) {
		JSONParser parser = new JSONParser();
		try {
			JSONArray array = (JSONArray) parser.parse(para);
			ArrayList<OrderEntry> orderEntries = new ArrayList<OrderEntry>();
			for (Object obj : array) {
				JSONObject jobj = (JSONObject) obj;
				OrderEntry orderEntry = new OrderEntry();
				orderEntry.setMeal(MealDao.getMeal(Long.parseLong((String) jobj.get("id"))));
				orderEntry.setQuantity(Integer.parseInt((String) jobj.get("quantity")));
				orderEntries.add(orderEntry);
			}
			User user = UserDao.getUserFromUserID(userID);
			Order shoppingCart = user.getShoppingCart();
			shoppingCart.setOrderEntries(orderEntries);
			UserDao.updateCart(userID, shoppingCart);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String para1 = request.getParameter("op");
		HttpSession session = request.getSession();
		long userID = (long) session.getAttribute("userID");
		if (para1 == null) {
			return;
		} else {
			if (para1.equals("update")) {
				String para2 = request.getParameter("data");
				updateCart(userID, para2);
			} else {
				String para2 = request.getParameter("mealID");
				String para3 = request.getParameter("quantity");
				if (para2 == null) return;
				long mealID = Long.parseLong(para2);
				if (para1.equals("add")) {
					if (para3 == null) addMeal (userID, mealID, 1);
					else addMeal(userID, mealID, Integer.parseInt(para3));
				} else if (para1.equals("remove")) {
					removeMeal(userID, mealID);
				} 
			}
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
