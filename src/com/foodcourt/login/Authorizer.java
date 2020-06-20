package com.foodcourt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodcourt.common.UserType;

@WebServlet("/authendication")
public class Authorizer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserType getUserType(String username, String password) {
		//TODO: write verify method
		if (username.equals("customer")){
			return UserType.CUSTOMER;
		} else if (username.equals("cook")) {
			return UserType.COOK;
		} else if (username.equals("fc_manager")) {
			return UserType.FC_MANAGER;
		} else if (username.equals("it")) {
			return UserType.IT;
		} else if (username.equals("vd_owner")) {
			return UserType.VD_OWNER;
		} else {
			return UserType.CUSTOMER;
		}
	}
	
	private boolean verify(String username, String password) {
		if (password.equals("1234")) return true;
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (!verify(username, password)) {
			//redirect to login
			response.sendRedirect("login");
			return;
		}
		
		UserType userType = getUserType(username, password);
		
		//Create a log in session
		HttpSession session = request.getSession();
		session.setAttribute("UserType", userType);
		
		switch(userType) {
		case CUSTOMER:
			response.sendRedirect("customer/main");
			break;
		case COOK:
			response.sendRedirect("cook/main");
			break;
		case IT:
			response.sendRedirect("it/main");
			break;
		case FC_MANAGER:
			response.sendRedirect("fcmanager/main");
			break;
		case VD_OWNER:
			response.sendRedirect("vdowner/main");
			break;
		}
		
	}

}
