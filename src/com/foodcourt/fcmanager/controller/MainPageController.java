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
import javax.servlet.http.HttpSession;

import com.foodcourt.common.UserType;
import com.foodcourt.common.dao.UserDao;
import com.foodcourt.common.dao.VendorDao;
import com.foodcourt.common.model.User;
import com.foodcourt.common.model.Vendor;

@WebServlet("/fcmanager/main")
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = UserDao.getUsers();
		request.setAttribute("Users", users);
		List<Vendor> vendors = VendorDao.getVendors();
		request.setAttribute("Vendors", vendors);
		HttpSession session = request.getSession();
		long userID = (long) session.getAttribute("userID");
		User user = UserDao.getUserFromUserID(userID);
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/fcmanager/mainJSP");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req = request.getParameter("btn");
		switch(req) {
		case "account_remove":
			String[] list =  request.getParameterValues("userlist");
			if (list == null) {
				doGet(request, response);
				return;
			}
			ArrayList<Integer> userID = new ArrayList<Integer>();
			
			for (int i = 0; i < list.length; i++) {
				if (list[i].length() > 0) userID.add(Integer.parseInt(list[i]));
			}
			UserDao.removeUser(userID);
			doGet(request, response);
			return;
		case "account_add":
			User newUser = new User();
			UserType type = UserType.CUSTOMER;
			switch (request.getParameter("account_type_add").toUpperCase()) {
			case "COOK":
				type = UserType.COOK;
				break;
			case "IT":
				type = UserType.IT;
				break;
			case "FC_MANAGER":
				doGet(request, response);
				return;
			case "VD_OWNER":
				type = UserType.VD_OWNER;
				break;
			case "CUSTOMER":
				break;
			}
			newUser.setEmail(request.getParameter("account_email_add"));
			newUser.setname(request.getParameter("account_name_add"));
			newUser.setUsername(request.getParameter("account_username_add"));
			newUser.setUserType(type);
			newUser.setpassword(request.getParameter("account_password_add"));
			List<User> users = UserDao.getUsers();
			long maxID = 0;
			for (User i: users) {
				if (i.getUserID() > maxID) maxID = i.getUserID();
			}
			newUser.setUserID(++maxID);
			UserDao.addNewUser(newUser);
			doGet(request, response);
			return;
		case "account_edit":
			User editUser = new User();
			boolean edit = true;
			UserType editType = UserType.CUSTOMER;
			switch (request.getParameter("account_type_edit").toUpperCase()) {
			case "NO_CHANGE":
				edit = false;
				break;
			case "COOK":
				editType = UserType.COOK;
				break;
			case "IT":
				editType = UserType.IT;
				break;
			case "FC_MANAGER":
				edit = false;
				break;
			case "VD_OWNER":
				editType = UserType.VD_OWNER;
				break;
			case "CUSTOMER":
				editType = UserType.CUSTOMER;
				break;
			}
			System.out.println(request.getParameter("account_id_edit"));
			editUser.setUserID(Integer.parseInt(request.getParameter("account_id_edit")));
			editUser.setEmail(request.getParameter("account_email_edit"));
			editUser.setname(request.getParameter("account_name_edit"));
			editUser.setUsername(request.getParameter("account_username_edit"));
			editUser.setpassword(request.getParameter("account_password_edit"));
			if (edit) editUser.setUserType(editType);
			UserDao.editUser(editUser.getUserID(), editUser, edit);
			doGet(request, response);
			return;
		case "vendor_remove":
			String[] listVendor =  request.getParameterValues("vendorlist");
			if (listVendor == null) {
				doGet(request, response);
				return;
			}
			ArrayList<Long> vendorID = new ArrayList<Long>();
			
			for (int i = 0; i < listVendor.length; i++) {
				if (listVendor[i].length() > 0) vendorID.add(Long.parseLong(listVendor[i]));
			}
			VendorDao.removeVendor(vendorID);
			doGet(request, response);
			return;
		case "vendor_add":
			Vendor newVendor = new Vendor();
			newVendor.setOwnerID(Integer.parseInt(request.getParameter("vendor_ownerid_add")));
			newVendor.setName(request.getParameter("vendor_name_add"));
			List<Vendor> vendors = VendorDao.getVendors();
			long maxVendorID = 0;
			for (Vendor i: vendors) {
				if (i.getId() > maxVendorID) maxVendorID = i.getId();
			}
			newVendor.setId(++maxVendorID);
			VendorDao.addNewVendor(newVendor);
			doGet(request, response);
			return;
		default:
			break;
		}
	}
}
