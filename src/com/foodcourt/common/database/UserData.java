package com.foodcourt.common.database;

import java.util.ArrayList;
import java.util.List;

import com.foodcourt.common.UserType;
import com.foodcourt.common.model.User;
public class UserData {
	List<User> users;
	private static UserData instance;
	public static UserData getInstance() {
		if (instance == null) instance = new UserData();
		return instance;
	}
	private UserData () {
		users = new ArrayList<User>();
		init();
	}
	public void addNewUser(User user) {
		users.add(new User(user));
	}
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		for (User o: users) {
			users.add(new User(o));
		}
		return users;
	}
	private void init() {
		User cook = new User();
		cook.setname("cook");
        cook.setpassword("1234");
        cook.setUsername("cook");
        cook.setUserType(UserType.COOK);
		addNewUser(cook);
		
		User manager = new User();
		manager.setname("FC_MANAGER");
        manager.setpassword("1234");
        manager.setUsername("FC_MANAGER");
        manager.setUserType(UserType.FC_MANAGER);
		addNewUser(manager);
		
		User it = new User();
		it.setname("IT");
        it.setpassword("1234");
        it.setUsername("IT");
        it.setUserType(UserType.IT);
		addNewUser(it);
		
		User owner = new User();
		owner.setname("VD_OWNER");
		owner.setpassword("1234");
		owner.setUsername("owner");
		owner.setUserType(UserType.VD_OWNER);
		addNewUser(owner);
		
		User customer = new User();
		customer.setname("customer");
		customer.setpassword("1234");
		customer.setUsername("customer");
		customer.setUserType(UserType.CUSTOMER);
		addNewUser(customer);
}
}
	
