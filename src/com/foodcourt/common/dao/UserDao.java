package com.foodcourt.common.dao;

import java.util.List;

import com.foodcourt.common.database.UserData;
import com.foodcourt.common.model.User;

public class UserDao {
	
	public void addNewUser(User user) {
		UserData.getInstance().addNewUser(user);
	}
	public List<User> getUsers() {
		return UserData.getInstance().getUsers();
	}
	
	public User getUserFromUsername(String username) {
		return UserData.getInstance().getUserFromUsername(username);
	}
}
