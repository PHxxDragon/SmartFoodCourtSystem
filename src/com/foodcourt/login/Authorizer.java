package com.foodcourt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodcourt.common.dao.UserDao;
import com.foodcourt.common.model.User;

@WebServlet("/authendication")
public class Authorizer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private boolean verify(String username, String password) {
		if (password != null && password.equals("1234")) return true;
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();
		User user = userDao.getUserFromUsername(username);
		
		if (!verify(username, password) || user == null) {
			//redirect to login
			response.sendRedirect("login");
			return;
		}
		
		
		//Create a log in session
		HttpSession session = request.getSession();
		session.setAttribute("UserType", user.getUserType());
		session.setAttribute("user", user);
		
		
		switch(user.getUserType()) {
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
