package com.foodcourt.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

/**
 * Servlet implementation class PaymentMethodCheck
 */
@WebServlet("/customer/validify")
public class PaymentMethodCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentMethodCheck() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    private boolean validify(String bankName, String bankNumber, String password, User user) {	
		//TODO Process some real check here
    	if (!password.equals(user.getpassword())) return false;
		return true;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("name");
		String bankName = request.getParameter("bankName");
		String cardNumber = request.getParameter("cardNumber");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		OrderDao orderDao = new OrderDao();
		User user = userDao.getUserFromUsername(username);
		
		HttpSession session = request.getSession();
		
		Order order = (Order) session.getAttribute("currentOrder");
		
		boolean isValid= validify(bankName,cardNumber,password,user); 
		if (isValid) {
			userDao.updateBalance(user.getBalance() - order.getPrice(), username);
			session.setAttribute("user", userDao.getUserFromUsername(username));
			orderDao.addOrder(order);
		} else {
			PrintWriter out = response.getWriter();
			out.println("wrong information !");
			return;
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Finish ordering";
		String docType= "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
		out.println(docType +
	                "<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "</body></html>");
		out.println("<a type='submit' href='./viewItemController' value='return'>Return</a>");
		request.setAttribute("user", user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
