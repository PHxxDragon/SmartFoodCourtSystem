package com.foodcourt.common.model;

public class Meal {
	
	private String name;
	private int id;
	private int price;
	private long eta;
	private String imgSrc;
	
	public Meal() {
		
	}
	
	public Meal(Meal meal) {
		this.id = meal.id;
		this.price = meal.price;
		this.name = meal.name;
		this.eta = meal.eta;
		this.imgSrc = meal.imgSrc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getEta() {
		return eta;
	}

	public void setEta(long eta) {
		this.eta = eta;
	}

}
