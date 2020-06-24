package com.foodcourt.common.model;

import com.foodcourt.common.UserType;

public class User {
	private long userID;
	private String username;
	private UserType userType;
	private long balance;
	private String password;
	private String email;
	private String name;

	public User() {
		
	}
	
	public User(User user) {
		this.userID = user.userID;
		this.username = user.username;
		this.userType = user.userType;
		this.balance=user.balance;
		this.password = user.password;
		this.email = user.email;
		this.name= user.name;
	}
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getemail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
}
