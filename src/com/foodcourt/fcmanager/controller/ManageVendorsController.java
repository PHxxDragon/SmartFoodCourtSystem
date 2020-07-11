package com.foodcourt.fcmanager.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodcourt.common.dao.VendorDao;
import com.foodcourt.common.model.Vendor;

@WebServlet("/fcmanager/manage_vendors")
public class ManageVendorsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Vendor> vendors = VendorDao.getVendors();
		request.setAttribute("Vendors", vendors);
		RequestDispatcher rd = request.getRequestDispatcher("/fcmanager/manage_vendorsJSP");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req = request.getParameter("btn");
		switch(req) {
		case "remove":
			String[] list =  request.getParameterValues("vendorlist");
			if (list == null) {
				doGet(request, response);
				return;
			}
			ArrayList<Long> vendorID = new ArrayList<Long>();
			
			for (int i = 0; i < list.length; i++) {
				if (list[i].length() > 0) vendorID.add(Long.parseLong(list[i]));
			}
			VendorDao.removeVendor(vendorID);
			doGet(request, response);
			return;
		case "add":
			Vendor newVendor = new Vendor();
			newVendor.setId(Integer.parseInt(request.getParameter("id")));
			newVendor.setOwnerID(Integer.parseInt(request.getParameter("ownerid")));
			newVendor.setName(request.getParameter("name"));
			VendorDao.addNewVendor(newVendor);
			doGet(request, response);
			return;
		}

	}
}
