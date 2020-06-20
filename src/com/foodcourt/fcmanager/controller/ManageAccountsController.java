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
import com.foodcourt.common.model.Order;
import com.foodcourt.common.model.User;

@WebServlet("/fcmanager/manage_accounts")
public class ManageAccountsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDao();
		List<User> users = userDao.getUsers();
		request.setAttribute("Users", users);
		RequestDispatcher rd = request.getRequestDispatcher("/fcmanager/manage_accountsJSP");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//supposed to remove all matching ID in array
		//here remove the user next to the button
		String value = (String) request.getParameter("remove");
		if (value.length() > 0) {
			ArrayList<Integer> userID = new ArrayList<Integer>();
			userID.add(Integer.parseInt(value));
			UserDao userDao = new UserDao();
			userDao.removeUser(userID);
		}
		doGet(request, response);
	}
}
