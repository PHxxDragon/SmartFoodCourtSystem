package com.foodcourt.customer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

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

/**
 * Servlet implementation class FindItemController
 */
@WebServlet("/customer/findItemController")
public class FindItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String para = request.getParameter("vendorID");
		long vendorID = 0;
		if (para == null) vendorID = 1;
		else vendorID = Long.parseLong(para);
		List<Vendor> vendors = VendorDao.getVendors();
		String stringToFind = request.getParameter("stringToFind");
		String[] stringPattern = stringToFind.trim().split("\\s+");
		List<Meal> mealListToFind = new ArrayList<Meal>();
		for (String pattern : stringPattern) {
			mealListToFind.addAll(MealDao.searchMealByNamePattern(pattern));
		}
		Set<Long> idAlreadySeen = new HashSet<>();
		mealListToFind.removeIf(meal->!idAlreadySeen.add(meal.getId()));
				
		request.setAttribute("mealList", mealListToFind);
		request.setAttribute("stringToFind", stringToFind);
		request.setAttribute("vendorList", vendors);
		RequestDispatcher rd = request.getRequestDispatcher("/customer/find_itemJSP");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
