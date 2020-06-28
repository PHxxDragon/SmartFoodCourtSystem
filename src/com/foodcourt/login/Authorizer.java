package com.foodcourt.login;

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

@WebServlet("/authentication")
public class Authorizer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private boolean verify(String password, User user) {	
		if (user == null || !user.getpassword().equals(password)) return false;
		return true;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = UserDao.getUserFromUsername(username);
		
		if (!verify(password, user)) {
			//redirect to login
			request.setAttribute("error","Tên đăng nhập hoặc mật khẩu không chính xác");
			RequestDispatcher rd=request.getRequestDispatcher("/login");            
			rd.forward(request, response);
		
			return;
		}	
		
		//Create a log in session
		HttpSession session = request.getSession();
		session.setAttribute("userID", user.getUserID());
		response.sendRedirect(request.getContextPath());
	}

}
