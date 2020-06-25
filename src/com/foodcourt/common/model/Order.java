package com.foodcourt.common.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	public static class OrderEntry {
		private Meal meal;
		private int quantity;
		
		public OrderEntry() {
			
		}
	
		public OrderEntry(OrderEntry orderEntry) {
			this.meal = new Meal(orderEntry.meal);
			this.quantity = orderEntry.quantity;
		}

		public Meal getMeal() {
			return meal;
		}

		public void setMeal(Meal meal) {
			this.meal = meal;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	}
	
	private long orderID;
	private long userID;
	private long saleVendorID;
	private List<OrderEntry> orderEntries;
	private long eta;
	private long price;
	
	public Order() {
	}
	
	public Order(Order order) {
		orderID = order.orderID;
		userID = order.userID;
		saleVendorID = order.saleVendorID;
		orderEntries = new ArrayList<OrderEntry>(); 
		for (OrderEntry o: order.orderEntries) {
			orderEntries.add(new OrderEntry(o));
		}
		eta = order.eta;
		price = order.price;
	}
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public long getSaleVendorID() {
		return saleVendorID;
	}
	public void setSaleVendorID(long saleVendorID) {
		this.saleVendorID = saleVendorID;
	}
	public List<OrderEntry> getOrderEntries() {
		return orderEntries;
	}
	public void setOrderEntries(List<OrderEntry> orderEntries) {
		this.orderEntries = orderEntries;
	}
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public long getEta() {
		return eta;
	}

	public void setEta(long eta) {
		this.eta = eta;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	
}
