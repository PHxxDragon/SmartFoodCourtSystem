package com.foodcourt.common.dao;

import java.util.List;

import com.foodcourt.common.database.OrderData;
import com.foodcourt.common.model.Order;

public class OrderDao {
	public List<Order> getPendingOrders() {
		return OrderData.getInstance().getPendingOrders();
	}
	
	public List<Order> getOrdersByUserId(long userID) {
		return OrderData.getInstance().getOrdersByUserID(userID);
	}
	
	public void addOrder (Order order) {
		OrderData.getInstance().addOrder(order);
	}
	
	public void addPendingOrder(Order order) {
		OrderData.getInstance().addPendingOrder(order);
	}
	
	public void confirmPendingOrder(long orderID) {
		OrderData.getInstance().confirmOrder(orderID);
	}
}
