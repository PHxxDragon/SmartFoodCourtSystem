package com.foodcourt.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodcourt.common.dao.UserDao;
import com.foodcourt.common.model.User;


public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object object = session.getAttribute("userID");
		if (object == null) {
			response.sendRedirect("welcome");
		} else {
			long userID = (long) object;
			User user = UserDao.getUserFromUserID(userID);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
