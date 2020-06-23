package com.foodcourt.common.dao;

import java.util.List;

import com.foodcourt.common.database.MealData;
import com.foodcourt.common.model.Meal;

public class MealDao {
	public List<Meal> getMealList(){
		return MealData.getInstance().getMealList();
	}
}
