package com.foodcourt.common.database;

import java.util.ArrayList;
import java.util.List;

import com.foodcourt.common.model.Meal;
public class MealData {
	List<Meal> mealList;
	private static MealData instance;
	public static MealData getInstance() {
		if (instance == null) instance = new MealData();
		return instance;
	}

	
	public void addMeal(Meal meal) {
		mealList.add(new Meal(meal));
	}
	
	public List<Meal> getMealList(){
		return mealList;
	}
	
	public Meal getMeal(long mealID) {
		// TODO Auto-generated method stub
		for (Meal meal : mealList) {
			if (meal.getId() == mealID) return meal;
		}
		return null;
	}
	//Meal stored in the database
	private MealData() {
		mealList = new ArrayList<Meal>();
		Meal meal1 = new Meal();	//Create meal - Banh mi
		meal1.setId(1);
		meal1.setName("BANH MI");
		meal1.setPrice(100);
		meal1.setEta(5);
		addMeal(meal1);
		
		Meal meal2 = new Meal();	//Create meal - Banh bao
		meal2.setId(2);
		meal2.setName("BANH BAO");
		meal2.setPrice(300);
		meal2.setEta(10);
		addMeal(meal2);
		
		Meal meal3 = new Meal();	//Create meal - Xuc xich
		meal3.setId(3);
		meal3.setName("XUC XICH");
		meal3.setPrice(500);
		meal3.setEta(7);
		addMeal(meal3);
		
		Meal meal4 = new Meal();	//Create meal - Banh u
		meal4.setId(4);
		meal4.setName("BANH U");
		meal4.setPrice(800);
		meal4.setEta(10);
		addMeal(meal4);
		
		Meal meal5 = new Meal();	//Create meal - Banh tao
		meal5.setId(5);
		meal5.setName("BANH TAO");
		meal5.setPrice(900);
		meal5.setEta(15);
		addMeal(meal5);
		
		Meal meal6 = new Meal();	//Create meal - Banh dau
		meal6.setId(6);
		meal6.setName("BANH DAU");
		meal6.setPrice(400);
		meal6.setEta(2);
		addMeal(meal6);
		
		Meal meal7 = new Meal();	//Create meal - Banh cam
		meal7.setId(7);
		meal7.setName("BANH CAM");
		meal7.setPrice(200);
		meal7.setEta(4);
		addMeal(meal7);
		
		
	}
}
