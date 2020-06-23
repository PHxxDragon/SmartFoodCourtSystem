package com.foodcourt.common.database;

import java.util.ArrayList;
import java.util.List;

import com.foodcourt.common.model.Meal;
import com.foodcourt.common.model.Order;
import com.foodcourt.common.model.Order.OrderEntry;

public class OrderData {
	//Each user has a list of orders
	public static class UserOrders {
		public long userID;
		List<Order> orders;
		
		public UserOrders() {
			orders = new ArrayList<Order>();
		}
		
		public UserOrders(UserOrders userOrder) {
			this.userID = userOrder.userID;
			for (Order o : userOrder.orders) {
				this.orders.add(new Order(o));
			}
		}
	}
	
	//pending orders for the cook
	List<Order> pendingOrders;
	//order history for each user
	List<UserOrders> orderTable;
	
	private static OrderData instance;
	public static OrderData getInstance() {
		if (instance == null) instance = new OrderData();
		return instance;
	}
	
	private OrderData () {
		pendingOrders = new ArrayList<Order>();
		orderTable = new ArrayList<UserOrders>();
		init();
	}
	
	public void addPendingOrder(Order order) {
		pendingOrders.add(new Order(order));
	}
	
	public void addOrder(Order order) {
		for (UserOrders u: orderTable) {
			if (order.getUserID() == u.userID) {
				u.orders.add(new Order(order));
				return;
			}
		}
		UserOrders u = new UserOrders();
		u.userID = order.getUserID();
		u.orders.add(new Order(order));
		orderTable.add(u);
	}
	
	public List<Order> getOrdersByUserID(long userID) {
		for (UserOrders u: orderTable) {
			if (u.userID == userID) {
				List<Order> orders = new ArrayList<Order>();
				for (Order o: u.orders) orders.add(new Order(o));
				return orders;
			}
		}
		System.out.println("Invalid userID");
		return null;
	}
	
	public List<Order> getPendingOrders(){
		List<Order> orders = new ArrayList<Order>();
		for (Order o: pendingOrders) {
			orders.add(new Order(o));
		}
		return orders;
	}
	
	public void confirmOrder(long orderID) {
		for (Order o: pendingOrders) {
			if (o.getOrderID() == orderID) {
				pendingOrders.remove(o);
				return;
			}
		}
	}
	
	
	//========================================
	
	private void init() {
		Order order1 = new Order();
		order1.setOrderID(1);
		order1.setUserID(1);
		order1.setSaleVendorID(1);
		List<OrderEntry> orderEntries = new ArrayList<OrderEntry>();
		orderEntries.add(new OrderEntry(new Meal(1, 100, "Banh mi", 5), 2));
		orderEntries.add(new OrderEntry(new Meal(2, 300, "Banh bao", 10), 3));
		orderEntries.add(new OrderEntry(new Meal(3, 500, "Xuc xich", 7), 1));
		order1.setOrderEntries(orderEntries);
		addPendingOrder(order1);
		addOrder(order1);
		
		order1 = new Order();
		order1.setOrderID(2);
		order1.setUserID(1);
		order1.setSaleVendorID(1);
		orderEntries = new ArrayList<OrderEntry>();
		orderEntries.add(new OrderEntry(new Meal(4, 100, "Banh mi", 5), 4));
		orderEntries.add(new OrderEntry(new Meal(5, 800, "Banh u", 10), 5));
		orderEntries.add(new OrderEntry(new Meal(6, 900, "Banh tao", 15), 6));
		order1.setOrderEntries(orderEntries);
		addPendingOrder(order1);
		addOrder(order1);
		
		order1 = new Order();
		order1.setOrderID(3);
		order1.setUserID(2);
		order1.setSaleVendorID(1);
		orderEntries = new ArrayList<OrderEntry>();
		orderEntries.add(new OrderEntry(new Meal(7, 100, "Banh mi", 5), 1));
		orderEntries.add(new OrderEntry(new Meal(8, 400, "Banh dau", 10), 2));
		orderEntries.add(new OrderEntry(new Meal(9, 200, "Banh cam", 2), 4));
		order1.setOrderEntries(orderEntries);
		addPendingOrder(order1);
		addOrder(order1);
	}
	
}
