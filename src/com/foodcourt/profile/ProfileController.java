package com.foodcourt.profile;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/customer/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object attribute = session.getAttribute("userID");
		if (attribute == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		User user = UserDao.getUserFromUserID(((long) attribute));
		List<Order> paidOrders = OrderDao.getPaidOrders(user.getUserID());
		List<Vendor> vendorList = VendorDao.getVendors();
		
		request.setAttribute("user", user);
		request.setAttribute("PaidOrders", paidOrders);
		request.setAttribute("vendorList", vendorList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/customer/view_profileJSP");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

