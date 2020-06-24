package com.foodcourt.common.dao;

import java.util.List;

import com.foodcourt.common.database.UserData;
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
	public void changePasswordFromUsername(String username,String newpassword) {
        UserData.getInstance().changePasswordFromUsername(username,newpassword);
	}
}
