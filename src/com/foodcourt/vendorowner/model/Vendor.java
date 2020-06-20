package com.foodcourt.vendorowner.model;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class Vendor {
	private UUID ID;
	private String name;
	private List<Meal> menu;
	public Vendor(String vendor_name){
		this.name = vendor_name;
		this.menu = new ArrayList<Meal>();
	}
	public UUID getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String vendor_name) {
		name = vendor_name;
	}
	public boolean addMeal(Meal new_meal) {
		menu.add(new_meal);
	}
	public Meal removeMeal(UUID mealID) {
		for (int i = 0; i < menu.size(); i++) {
			if (menu.get(i).getID() == mealID) {
				return menu.remove(i);
			}
		}
		return null;
	}
	public Meal getMeal(UUID mealID) {
		for (Meal temp_meal : menu) {
			if (temp_meal.getID() == mealID) return temp_meal;
		}
		return null;
	}
	
}
