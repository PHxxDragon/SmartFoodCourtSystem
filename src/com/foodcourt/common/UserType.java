package com.foodcourt.common;

public enum UserType {
	CUSTOMER, COOK, FC_MANAGER, IT, VD_OWNER;
	
	private String string;
	
	static {
		CUSTOMER.string = "customer";
		COOK.string = "cook";
		FC_MANAGER.string = "fc_manager";
		IT.string = "it";
		VD_OWNER.string = "vd_owner";
	}
	
	public String toString() {
		return string;
	}
}
