package com.foodcourt.common.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private long orderID;
	private long userID;
	private long saleVendorID;
	private List<OrderEntry> orderEntries;
	private int eta;
	private long price;
	private int isDone = 2;
	
	public Order() {
		orderEntries = new ArrayList<OrderEntry>();
		price = 0;
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
		isDone = order.isDone;
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

	public int getEta() {
		int eta = 0;
		for (OrderEntry o: orderEntries) {
			eta += o.getMeal().getEta() * o.getQuantity();
		}
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public long getPrice() {
		long price = 0;
		for (OrderEntry o: orderEntries) {
			price += o.getMeal().getPrice() * o.getQuantity();
		}
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public int getIsDone() {
		return isDone;
	}

	public void setIsDone(int isDone) {
		this.isDone = isDone;
	}
	
}
