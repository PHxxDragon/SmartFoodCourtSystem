package com.foodcourt.common.model;

import java.util.List;
import java.util.ArrayList;

public class Vendor {
	private long id = 0;
	private long ownerID;
	private String name;
	private List<Meal> menu;

	public Vendor(){
		this.id = 0;
		this.name = "";
		this.menu = new ArrayList<Meal>();
		this.ownerID = 0;
	}
	
	public Vendor(Vendor vendor) {
		this.id = vendor.id;
		this.ownerID = vendor.ownerID;
		this.name = vendor.name;
		this.menu =  new ArrayList<Meal>(vendor.menu);
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String vendor_name) {
		name = vendor_name;
	}
	public void addMeal(Meal new_meal) {
		menu.add(new_meal);
	}
	public Meal removeMeal(long mealID) {
		for (int i = 0; i < menu.size(); i++) {
			if (menu.get(i).getId() == mealID) {
				return menu.remove(i);
			}
		}
		return null;
	}
	public Meal getMeal(long mealID) {
		for (Meal temp_meal : menu) {
			if (temp_meal.getId() == mealID) return temp_meal;
		}
		return null;
	}
	public long getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(long ownerID) {
		this.ownerID = ownerID;
	}
	public List<Meal> getMenu() {
		return menu;
	}
	public void setMenu(List<Meal> menu) {
		this.menu = menu;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
