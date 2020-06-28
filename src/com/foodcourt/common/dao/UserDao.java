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
	public static void editUser(int userID, User newUser, boolean editType) {
		User tempUser = UserData.getInstance().getUserFromUserID(userID);
		if (newUser.getname().length() > 0) tempUser.setname(newUser.getname());
		if (newUser.getUsername().length() > 0) tempUser.setUsername(newUser.getUsername());
		if (newUser.getpassword().length() > 0) tempUser.setpassword(newUser.getpassword());
		if (editType == true) tempUser.setUserType(newUser.getUserType());
		UserData.getInstance().removeUserFromID(userID);
		UserData.getInstance().addNewUser(tempUser);
	}
	public static void updateBalance(long balance, String username) {
		UserData.getInstance().updateBalance(balance, username);
    }
	public static void changePasswordFromUsername(String username,String newpassword) {
        UserData.getInstance().changePasswordFromUsername(username,newpassword);
	}
	public static void addMeal(long userID, long mealID, int quantity) {
		UserData.getInstance().addMeal(userID, mealID, quantity);
	}
	public static void removeMeal(long userID, long mealID) {
		UserData.getInstance().removeMeal(userID, mealID);
	}
	public static void updateCart(long userID, Order shoppingCart) {
		UserData.getInstance().updateCart(userID, shoppingCart);
	}
}
