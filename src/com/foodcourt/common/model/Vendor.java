package com.foodcourt.vendorowner.model;

import java.util.List;
import java.util.ArrayList;
import com.foodcourt.common.model.Meal;

public class Vendor {
	private int id = 0;
	private String name;
	private List<Meal> menu;
	public Vendor(String vendor_name, int id){
		this.id = id;
		this.name = vendor_name;
		this.menu = new ArrayList<Meal>();
	}
	public int getId() {
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
	public Meal removeMeal(int mealID) {
		for (int i = 0; i < menu.size(); i++) {
			if (menu.get(i).getId() == mealID) {
				return menu.remove(i);
			}
		}
		return null;
	}
	public Meal getMeal(int mealID) {
		for (Meal temp_meal : menu) {
			if (temp_meal.getId() == mealID) return temp_meal;
		}
		return null;
	}
	
}
