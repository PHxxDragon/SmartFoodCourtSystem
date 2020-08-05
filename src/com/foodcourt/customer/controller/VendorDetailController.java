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

@WebServlet("/customer/vendorDetail")
public class VendorDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VendorDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String para = request.getParameter("vendorID");
		long vendorID = 0;
		if (para == null) vendorID = 1;
		else vendorID = Long.parseLong(para);
		List<Vendor> vendors = VendorDao.getVendors();
		Vendor vendor = null;
		for (Vendor v : vendors) {
			if (v.getId() == vendorID) {
				vendor = v;
				break;
			}
		}
		List<Meal> mealList= MealDao.getMealBySaleVendorID(vendorID);
		request.setAttribute("mealList", mealList);
		request.setAttribute("vendor", vendor);
		request.setAttribute("vendorList", vendors);
		RequestDispatcher rd = request.getRequestDispatcher("/customer/vendor_detailJSP");
		rd.forward(request, response); 	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
