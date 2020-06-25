package com.foodcourt.common.database;

import java.util.ArrayList;
import java.util.List;

import com.foodcourt.common.UserType;
import com.foodcourt.common.dao.MealDao;
import com.foodcourt.common.model.Meal;
import com.foodcourt.common.model.Order;
import com.foodcourt.common.model.OrderEntry;
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
	public void removeUserFromID(Integer ID) {
		users.removeIf((n) -> n.getUserID() == ID);
	}
	public List<User> getUsers(){
		List<User> user = new ArrayList<User>();
		for (User o: users) {
			user.add(new User(o));
		}
		return user;
	}
	
	public User getUserFromUsername(String username) {
		for (User u: users) {
			if (u.getUsername().equals(username)) {
				return new User(u);
			}
		}
		return null;
	}
	public void changePasswordFromUsername(String username,String newpassword) {
		for (User u: users) {
			if (u.getUsername().equals(username)) {
				u.setpassword(newpassword);
				return;
			}
		}
		return;
	}
	
	public User getUserFromUserID(long userID) {
		for (User u: users) {
			if (u.getUserID() == userID) {
				return new User(u);
			}
		}
		return null;
	}
	
	public void updateBalance(long balance, String username) {
		for (User u: users) {
			if (u.getUsername().equals(username)) {
				u.setBalance(balance);
			}
		}
	}
	
	public void addMeal(long userID, long mealID) {
		for (User u: users) {
			if (u.getUserID() == userID) {
				Order shoppingCart = u.getShoppingCart();
				for (OrderEntry orderEntry: shoppingCart.getOrderEntries()) {
					if (orderEntry.getMeal().getId() == mealID) {
						orderEntry.setQuantity(orderEntry.getQuantity() + 1);
						return;
					}
				}
				OrderEntry orderEntry = new OrderEntry();
				Meal meal = MealDao.getMeal(mealID);
				orderEntry.setMeal(MealDao.getMeal(mealID));
				orderEntry.setQuantity(1);
				shoppingCart.getOrderEntries().add(orderEntry);
				shoppingCart.setPrice(shoppingCart.getPrice() + meal.getPrice());
				shoppingCart.setEta(shoppingCart.getEta() + meal.getEta());
				return;
			}
		}
	}
	
	private void init() {
		User cook = new User();
		cook.setname("cook");
        cook.setpassword("1234");
        cook.setUsername("cook");
        cook.setUserID(1);
        cook.setUserType(UserType.COOK);
		addNewUser(cook);
		
		User manager = new User();
		manager.setname("fc_manager");
        manager.setpassword("1234");
        manager.setUsername("FC_MANAGER");
        manager.setUserID(2);
        manager.setUserType(UserType.FC_MANAGER);
		addNewUser(manager);
		
		User it = new User();
		it.setname("it");
        it.setpassword("1234");
        it.setUsername("IT");
        it.setUserID(4);
        it.setUserType(UserType.IT);
		addNewUser(it);
		
		User owner = new User();
		owner.setname("vd_owner");
		owner.setpassword("1234");
		owner.setUserID(3);
		owner.setUsername("owner");
		owner.setUserType(UserType.VD_OWNER);
		addNewUser(owner);
		
		User customer = new User();
		customer.setname("customer");
		customer.setpassword("1234");
		customer.setUsername("customer");
		customer.setUserID(5);
		customer.setUserType(UserType.CUSTOMER);
		addNewUser(customer);
	}

	public void updateCart(long userID, Order shoppingCart) {
		for (User u: users) {
			if (u.getUserID() == userID) {
				u.setShoppingCart(shoppingCart);
			}
		}
		
	}
}
	
