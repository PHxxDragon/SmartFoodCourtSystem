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

import com.foodcourt.common.UserType;
import com.foodcourt.common.dao.UserDao;
import com.foodcourt.common.model.User;

@WebServlet("/fcmanager/manage_accounts")
public class ManageAccountsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = UserDao.getUsers();
		request.setAttribute("Users", users);
		RequestDispatcher rd = request.getRequestDispatcher("/fcmanager/manage_accountsJSP");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req = request.getParameter("btn");
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
			UserDao.removeUser(userID);
			doGet(request, response);
			return;
		case "add":
			User newUser = new User();
			UserType type = UserType.CUSTOMER;
			switch (request.getParameter("type_add").toUpperCase()) {
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
			newUser.setEmail(request.getParameter("email_add"));
			newUser.setname(request.getParameter("name_add"));
			newUser.setUsername(request.getParameter("username_add"));
			newUser.setUserType(type);
			newUser.setpassword(request.getParameter("password_add"));
			List<User> users = UserDao.getUsers();
			long maxID = 0;
			for (User i: users) {
				if (i.getUserID() > maxID) maxID = i.getUserID();
			}
			newUser.setUserID(++maxID);
			UserDao.addNewUser(newUser);
			doGet(request, response);
			return;
		case "edit":
			User tempUser = new User();
			tempUser.setname(request.getParameter("name_edit"));
			tempUser.setUsername(request.getParameter("username_edit"));
			tempUser.setpassword(request.getParameter("password_edit"));
			UserType editType = UserType.CUSTOMER;
			boolean edit = false;
			if (request.getParameter("type_edit").length() > 0) {
				edit = true;
				switch (request.getParameter("type_edit").toUpperCase()) {
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
					break;
				}
			}
			tempUser.setUserType(editType);
			String[] editList =  request.getParameterValues("userlist");
			if (editList == null) {
				doGet(request, response);
				return;
			}
			ArrayList<Integer> IDs = new ArrayList<Integer>();
			
			for (int i = 0; i < editList.length; i++) {
				if (editList[i].length() > 0) IDs.add(Integer.parseInt(editList[i]));
			}
			for (int i = 0; i < IDs.size(); i++) {
				//UserDao.editUser(tempUser, edit);
			}
			doGet(request, response);
			return;
		}

	}
}
