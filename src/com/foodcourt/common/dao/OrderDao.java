package com.foodcourt.common.dao;

import java.util.List;

import com.foodcourt.common.database.OrderData;
import com.foodcourt.common.model.Order;

public class OrderDao {
	public static List<Order> getPendingOrders() {
		return OrderData.getInstance().getPendingOrders();
	}
	
	public static List<Order> getOrdersByUserId(long userID) {
		return OrderData.getInstance().getOrdersByUserID(userID);
	}
	
	public static void addOrder (Order order) {
		OrderData.getInstance().addOrder(order);
	}
	
	public static void addPendingOrder(Order order) {
		OrderData.getInstance().addPendingOrder(order);
	}
	
	public static void confirmPendingOrder(long orderID) {
		OrderData.getInstance().confirmOrder(orderID);
	}
	
	public static Order getOrderByUserIDAndID(long userID, long orderID) {
		List<Order> orders = OrderData.getInstance().getOrdersByUserID(userID);
		for (Order o: orders) {
			if (o.getOrderID() == orderID) {
				return o;
			}
		}
		return null;
	}
}
