package com.foodcourt.common;

public enum UserType {
	CUSTOMER, COOK, FC_MANAGER, IT, VD_OWNER;
	
	private String string;
	
	static {
		CUSTOMER.string = "customer";
		COOK.string = "cook";
		FC_MANAGER.string = "fcmanager";
		IT.string = "it";
		VD_OWNER.string = "vdowner";
	}
	
	public String toString() {
		return string;
	}
}
