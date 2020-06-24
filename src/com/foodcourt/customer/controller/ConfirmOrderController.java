package com.foodcourt.customer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodcourt.common.dao.MealDao;
import com.foodcourt.common.model.Meal;
import com.foodcourt.common.model.Order;
import com.foodcourt.common.model.Order.OrderEntry;
import com.foodcourt.common.model.User;

/**
 * Servlet implementation class ConfirmOrderController
 */
@WebServlet("/customer/confirmOrderController")
public class ConfirmOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
    public ConfirmOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Meal> mealList = MealDao.getMealList();
		List<OrderEntry> orderEntries = new ArrayList<OrderEntry>();
		int[] quantity = new int[mealList.size()];
		int [] price =new int[mealList.size()];
		int [] eta =new int[mealList.size()];
		int totalPrice=0;
		int ETA=0;
		for (int i = 0; i < mealList.size(); i++) {
			quantity[i] = Integer.parseInt((request.getParameter("quantity"+mealList.get(i).getId())));
			if (quantity[i]!=0){
				OrderEntry orderEntry = new OrderEntry();
				orderEntry.setMeal(mealList.get(i));
				orderEntry.setQuantity(quantity[i]);
				orderEntries.add(orderEntry);
				eta[i]=((int)mealList.get(i).getEta())*quantity[i];
				price[i]=(mealList.get(i).getPrice())*quantity[i];
				totalPrice+=price[i];
				ETA+=eta[i];
			}
		}
		Order order = new Order();
		order.setEta(ETA);
		order.setPrice(totalPrice);
		order.setSaleVendorID(1);
		order.setUserID(user.getUserID());
		order.setOrderID(10);
		order.setOrderEntries(orderEntries);
		session.setAttribute("currentOrder", order);
		RequestDispatcher rd = request.getRequestDispatcher("confirmOrder");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
