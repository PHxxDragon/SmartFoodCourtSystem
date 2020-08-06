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
		RequestDispatcher rd = request.getRequestDispatcher("/changepasswordJSP");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long userID = (long) session.getAttribute("userID");
		User user = UserDao.getUserFromUserID(userID);
		String req = request.getParameter("btn");
		switch(req) {
		case "xacnhan":
			String oldpassword = request.getParameter("oldpassword");
			String newpassword = request.getParameter("newpassword");
			
			if (!verify(user.getUsername(), oldpassword, user)) {
				request.setAttribute("error", 1);
				RequestDispatcher rd=request.getRequestDispatcher("/changepasswordJSP");            
				rd.forward(request, response);
				return;
			}
			else if (oldpassword.equals(newpassword)) {
				request.setAttribute("error", 2);
				RequestDispatcher rd=request.getRequestDispatcher("/changepasswordJSP");            
				rd.forward(request, response);
				return;
			}
			
			UserDao.changePasswordFromUsername(user.getUsername(),newpassword);
			response.sendRedirect(request.getContextPath() +"/" + user.getUserType().toString() + "/main");
			return;
		case "huybo":
			response.sendRedirect("/SmartFoodCourtSystem/" + user.getUserType().toString() + "/main");
			return;
		}
		
		
	}

}
