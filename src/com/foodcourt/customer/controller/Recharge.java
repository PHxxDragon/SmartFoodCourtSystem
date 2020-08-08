package com.foodcourt.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodcourt.common.dao.CardDAO;
import com.foodcourt.common.dao.UserDao;
import com.foodcourt.common.model.User;

@WebServlet("/customer/rechargeController")
public class Recharge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Recharge() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long userID = (long) session.getAttribute("userID");
		String serialNumber = request.getParameter("serialNumber");
		boolean isValidCard = CardDAO.verifyCardSerial(serialNumber);
		if (isValidCard) {
			long cardPrice = CardDAO.getCardValue(serialNumber);
			User user = UserDao.getUserFromUserID(userID);
			UserDao.updateBalance(user.getBalance() + cardPrice, user.getUsername());
			CardDAO.changeCardIsUsed(serialNumber);
			request.setAttribute("rechargeStatus", true);
		}
		else {
			request.setAttribute("rechargeStatus", false);
		}
		
		response.sendRedirect(request.getContextPath()+ "/customer/profile");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
