package com.foodcourt.common.model;

public class OrderEntry {
	private Meal meal;
	private int quantity;
	
	public OrderEntry() {
		
	}

	public OrderEntry(OrderEntry orderEntry) {
		this.meal = orderEntry.meal;
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