package com.foodcourt.common.dao;

import java.util.List;

import com.foodcourt.common.database.UserData;
import com.foodcourt.common.model.Order;
import com.foodcourt.common.model.User;

public class UserDao {
	
	public static void addNewUser(User user) {
		UserData.getInstance().addNewUser(user);
	}
	public static List<User> getUsers() {
		return UserData.getInstance().getUsers();
	}
	
	public static User getUserFromUsername(String username) {
		return UserData.getInstance().getUserFromUsername(username);
	}
	public static User getUserFromUserID(long userID) {
		return UserData.getInstance().getUserFromUserID(userID);
	}
	public static void removeUser(List<Integer> userIDs) {
		for (Integer i: userIDs) {
			UserData.getInstance().removeUserFromID(i);
		}
	}
	public static void updateBalance(long balance, String username) {
		UserData.getInstance().updateBalance(balance, username);
    }
	public static void changePasswordFromUsername(String username,String newpassword) {
        UserData.getInstance().changePasswordFromUsername(username,newpassword);
	}
	public static void addMeal(long userID, long mealID) {
		UserData.getInstance().addMeal(userID, mealID);
	}
	public static void updateCart(long userID, Order shoppingCart) {
		UserData.getInstance().updateCart(userID, shoppingCart);
	}
}
