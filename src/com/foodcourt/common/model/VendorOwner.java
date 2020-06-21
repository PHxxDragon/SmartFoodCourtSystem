package com.foodcourt.common.model;

import com.foodcourt.common.UserType;

public class VendorOwner extends User {
	private Vendor vendor;
	public VendorOwner() {
		super();
	}
	
	public VendorOwner(long userID, String username, UserType userType) {
		super(userID, username, userType);
	}
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
}
