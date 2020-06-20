package com.foodcourt.common.dao;
import java.util.List;
import java.util.ArrayList;
import com.foodcourt.common.model.User;
import com.foodcourt.common.UserType;
import com.foodcourt.common.database.UserData;

public class UserDao {
	public List<User> getUsers() {
		return UserData.getInstance().getUsers();
	}
	public void removeUser(ArrayList<Integer> userID) {
		for (Integer i: userID) {
			System.out.println(i);
			UserData.getInstance().removeUserByID(i);
		}	
	}
}
