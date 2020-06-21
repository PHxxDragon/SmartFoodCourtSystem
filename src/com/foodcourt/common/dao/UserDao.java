package com.foodcourt.common.dao;

import com.foodcourt.common.database.UserData;
import com.foodcourt.common.model.User;

public class UserDao {
	public User getUserFromUsername(String username) {
		return UserData.getInstance().getUserFromUsername(username);
	}
}
