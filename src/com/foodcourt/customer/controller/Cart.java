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

import com.foodcourt.common.dao.UserDao;
import com.foodcourt.common.dao.VendorDao;
import com.foodcourt.common.model.User;
import com.foodcourt.common.model.Vendor;

@WebServlet("/customer/viewCart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Cart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long userID = (long) session.getAttribute("userID");
		User user = UserDao.getUserFromUserID(userID);
		List<Vendor> vendorList = VendorDao.getVendors();
		
		request.setAttribute("vendorList", vendorList);
		request.setAttribute("shoppingCart", user.getShoppingCart());
		RequestDispatcher rd = request.getRequestDispatcher("view_cartJSP");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
