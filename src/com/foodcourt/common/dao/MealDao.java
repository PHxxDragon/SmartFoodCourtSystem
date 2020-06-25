package com.foodcourt.common.dao;

import java.util.List;

import com.foodcourt.common.database.MealData;
import com.foodcourt.common.model.Meal;

public class MealDao {
	public static List<Meal> getMealList(){
		return MealData.getInstance().getMealList();
	}
	
	public static Meal getMeal(long mealID) {
		return MealData.getInstance().getMeal(mealID);
	}
}
