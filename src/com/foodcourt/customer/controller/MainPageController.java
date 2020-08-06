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

import com.foodcourt.common.dao.MealDao;
import com.foodcourt.common.dao.UserDao;
import com.foodcourt.common.dao.VendorDao;
import com.foodcourt.common.model.Meal;
import com.foodcourt.common.model.Order;
import com.foodcourt.common.model.OrderEntry;
import com.foodcourt.common.model.User;
import com.foodcourt.common.model.Vendor;

@WebServlet("/customer/main")
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MainPageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Meal> mealList= MealDao.getMealList();
		List<Vendor> vendorList = VendorDao.getVendors();
		HttpSession session = request.getSession();
		long userID = (long) session.getAttribute("userID");
		User user = UserDao.getUserFromUserID(userID);
		Order shoppingCart = user.getShoppingCart();
		
		request.setAttribute("mealList", mealList);
		request.setAttribute("shoppingCart", shoppingCart);
		request.setAttribute("vendorList", vendorList);
		int cartSize = 0;
		for (OrderEntry o: shoppingCart.getOrderEntries()) {
			cartSize += o.getQuantity();
		}
		request.setAttribute("cartSize", cartSize);
		RequestDispatcher rd = request.getRequestDispatcher("/customer/mainJSP");
		rd.forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
//urlPatterns= {"/customer/meals", "/customer/viewMealDetails", "/customer/addToOrder", "/customer/viewCart"}
}
