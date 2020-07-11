package com.foodcourt.signup;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodcourt.common.UserType;
import com.foodcourt.common.dao.UserDao;
import com.foodcourt.common.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("Register");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		User user = new User();
        user.setname(name);
        user.setEmail(email);
        user.setpassword(password);
        user.setUsername(username);
        user.setUserType(UserType.CUSTOMER);
        long maxID = 0;
        List<User> users = UserDao.getUsers();
		for (User i: users) {
			if (i.getUserID() > maxID) maxID = i.getUserID();
		}
		user.setUserID(++maxID);
		UserDao.addNewUser(user);

		response.sendRedirect("./signupsuccess");
	}

}
