package com.foodcourt.customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodcourt.common.dao.MealDao;
import com.foodcourt.common.dao.VendorDao;
import com.foodcourt.common.model.Meal;
import com.foodcourt.common.model.Vendor;


@WebServlet("/customer/itemDetail")
public class ItemDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String para = request.getParameter("mealID");
		long mealID = 0;
		if (para == null) mealID = 1;
		else mealID = Long.parseLong(para);
		
		List<Meal> mealList= MealDao.getMealList();
		Meal meal = MealDao.getMeal(mealID);
		String stockValue;
		int stock = meal.getStock();
		if (stock == 0) stockValue = "Hết hàng";
		else stockValue = "Còn hàng ("+String.valueOf(stock)+" đơn vị)";
		List<Vendor> vendorList = VendorDao.getVendors();
		
		request.setAttribute("stockValue", stockValue);
		request.setAttribute("mealList", mealList);
		request.setAttribute("meal", meal);
		request.setAttribute("vendorList", vendorList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/customer/item_detailJSP");
		rd.forward(request, response); 	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
