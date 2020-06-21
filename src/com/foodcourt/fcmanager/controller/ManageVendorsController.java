package com.foodcourt.fcmanager.controller;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodcourt.common.dao.OrderDao;
import com.foodcourt.common.dao.UserDao;
import com.foodcourt.common.dao.VendorDao;
import com.foodcourt.common.model.Order;
import com.foodcourt.common.model.User;
import com.foodcourt.common.model.Vendor;
import com.foodcourt.common.UserType;

@WebServlet("/fcmanager/manage_vendors")
public class ManageVendorsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VendorDao vendorDao = new VendorDao();
		List<Vendor> vendors = vendorDao.getVendors();
		request.setAttribute("Vendors", vendors);
		RequestDispatcher rd = request.getRequestDispatcher("/fcmanager/manage_vendorsJSP");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req = request.getParameter("btn");
		VendorDao vendorDao = new VendorDao();
		switch(req) {
		case "remove":
			String[] list =  request.getParameterValues("vendorlist");
			if (list == null) {
				doGet(request, response);
				return;
			}
			ArrayList<Integer> vendorID = new ArrayList<Integer>();
			
			for (int i = 0; i < list.length; i++) {
				if (list[i].length() > 0) vendorID.add(Integer.parseInt(list[i]));
			}
			vendorDao.removeVendor(vendorID);
			doGet(request, response);
			return;
		case "add":
			Vendor newVendor = new Vendor();
			newVendor.setID(Integer.parseInt(request.getParameter("id")));
			newVendor.setOwnerID(Integer.parseInt(request.getParameter("ownerid")));
			newVendor.setName(request.getParameter("name"));
			vendorDao.addNewVendor(newVendor);
			doGet(request, response);
			return;
		}

	}
}
