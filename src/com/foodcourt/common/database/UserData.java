package com.foodcourt.common.database;
import java.util.List;
import java.util.ArrayList;
import com.foodcourt.common.model.User;
import com.foodcourt.common.UserType;


public class UserData {
	List<User> users;
	private static UserData instance;
	public static  UserData getInstance() {
		if (instance == null) instance = new UserData();
		return instance;
	}
	public List<User> getUsers() {
		return users;
	}
	private UserData() {
		users = new ArrayList<User>();
		init();
	}
	private void init() {
		users.add(new User(0, "customer user", UserType.CUSTOMER));
		users.add(new User(1, "cook user", UserType.COOK));
		users.add(new User(2, "manager user", UserType.FC_MANAGER));
		users.add(new User(3, "vendor owner user", UserType.VD_OWNER));
	}
	public void removeUserByID(Integer ID) {
			users.removeIf(n -> n.getUserID() == ID);
	}
}
