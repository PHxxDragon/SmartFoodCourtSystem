package com.foodcourt.vendorowner.model;


public class VendorOwner extends User {
	private Vendor vendor;

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
}
