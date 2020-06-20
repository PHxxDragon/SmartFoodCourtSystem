package com.foodcourt.common.model;

public class Meal {
	
	protected int id;
	protected int price;
	
	public Meal() {
		
	}
	
	public Meal(int id, int price) {
		this.id = id;
		this.price = price;
	}
	
	public Meal(Meal meal) {
		this.id = meal.id;
		this.price = meal.price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
