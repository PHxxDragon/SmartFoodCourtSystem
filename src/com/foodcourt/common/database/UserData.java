package com.foodcourt.common.database;

import java.util.ArrayList;
import java.util.List;

import com.foodcourt.common.UserType;
import com.foodcourt.common.model.User;
import com.foodcourt.common.model.Vendor;
import com.foodcourt.common.model.VendorOwner;

public class UserData {
	private static UserData instance;
	
	public static UserData getInstance() {
		if (instance == null) instance = new UserData();
		return instance;
	}
	
	private List<User> users;
	
	private UserData() {
		users = new ArrayList<User>();
		init();
	}
	
	public User getUserFromUsername(String username) {
		for (User u: users) {
			if (u.getUsername().equals(username)) {
				return new User(u);
			}
		}
		return null;
	}
	
	//==========================================
	
	private void init() {
		User user = new User();
		user.setUserID(1);
		user.setUsername("cook");
		user.setUserType(UserType.COOK);
		users.add(user);
		user = new User();
		user.setUserID(2);
		user.setUsername("customer");
		user.setUserType(UserType.CUSTOMER);
		users.add(user);
		user = new User();
		user.setUserID(3);
		user.setUsername("fc_manager");
		user.setUserType(UserType.FC_MANAGER);
		users.add(user);
		VendorOwner vd = new VendorOwner();
		vd.setUserID(4);
		vd.setUsername("vd_owner");
		vd.setUserType(UserType.VD_OWNER);
		vd.setVendor(new Vendor("vendor_name",1));
		users.add(vd);
		user = new User();
		user.setUserID(5);
		user.setUsername("it");
		user.setUserType(UserType.IT);
		users.add(user);
	}
	
}
