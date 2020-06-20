package com.foodcourt.vendorowner.model;

import com.foodcourt.common.model.User;

public class VendorOwner extends User {
	private Vendor vendor;
	public VendorOwner() {
		super();
	}
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
}
