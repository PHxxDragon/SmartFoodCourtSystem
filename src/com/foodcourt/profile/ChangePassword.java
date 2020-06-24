package com.foodcourt.profile;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodcourt.common.dao.UserDao;
import com.foodcourt.common.model.User;

@WebServlet("/changepassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private boolean verify(String username, String password, User user) {	
		System.out.println(user);
		if (user == null || !user.getpassword().equals(password)) return false;
		return true;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("abcc");
		RequestDispatcher rd = request.getRequestDispatcher("/changepasswordJSP");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		System.out.println("aaaa");
		UserDao userDao = new UserDao();
		User user = userDao.getUserFromUsername(username);
		
		if (!verify(username, oldpassword, user)) {
			//redirect to login
			response.sendRedirect("changepasswordJSP");
			return;
		}	
		userDao.changePasswordFromUsername(username,newpassword);
		response.sendRedirect("profile");
		return;
		
		
	}

}
