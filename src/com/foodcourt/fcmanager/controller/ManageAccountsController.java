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
import com.foodcourt.common.UserType;

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
		String req = request.getParameter("btn");
		UserDao userDao = new UserDao();
		switch(req) {
		case "remove":
			String[] list =  request.getParameterValues("userlist");
			if (list == null) {
				doGet(request, response);
				return;
			}
			ArrayList<Integer> userID = new ArrayList<Integer>();
			
			for (int i = 0; i < list.length; i++) {
				if (list[i].length() > 0) userID.add(Integer.parseInt(list[i]));
			}
			userDao.removeUser(userID);
			doGet(request, response);
			return;
		case "add":
			User newUser = new User();
			UserType type = UserType.CUSTOMER;
			switch (request.getParameter("type").toUpperCase()) {
			case "COOK":
				type = UserType.COOK;
				break;
			case "IT":
				type = UserType.IT;
				break;
			case "FC_MANAGER":
				type = UserType.FC_MANAGER;
				break;
			case "VD_OWNER":
				type = UserType.VD_OWNER;
				break;
			case "CUSTOMER":
				break;
			}
			newUser.setEmail(request.getParameter("email"));
			newUser.setname(request.getParameter("name"));
			newUser.setUsername(request.getParameter("username"));
			newUser.setUserType(type);
			newUser.setpassword(request.getParameter("password"));
			List<User> users = userDao.getUsers();
			long maxID = 0;
			for (User i: users) {
				if (i.getUserID() > maxID) maxID = i.getUserID();
			}
			newUser.setUserID(++maxID);
			userDao.addNewUser(newUser);
			doGet(request, response);
			return;
		}

	}
}