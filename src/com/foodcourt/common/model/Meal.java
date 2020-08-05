package com.foodcourt.common.model;

import java.util.List;

public class Meal {
	
	String name;
	long id;
	long price;
	int eta;
	int stock;
	String decription;
	String imgSrc;
	long saleVendorID;
	List<String> tag;
	
	public long getSaleVendorID() {
		return saleVendorID;
	}

	public void setSaleVendorID(long saleVendorID) {
		this.saleVendorID = saleVendorID;
	}

	public Meal() {
		
	}
	
	public Meal(Meal meal) {
		this.id = meal.id;
		this.price = meal.price;
		this.name = meal.name;
		this.eta = meal.eta;
		this.price = meal.price;
		this.eta = meal.eta;
		this.decription = meal.decription;
		this.imgSrc = meal.imgSrc;
		this.tag = meal.tag;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getEta() {
		return eta;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

}
