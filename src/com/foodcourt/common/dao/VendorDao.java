package com.foodcourt.common.dao;

import java.util.List;

import com.foodcourt.common.database.UserData;
import com.foodcourt.common.database.VendorData;
import com.foodcourt.common.model.User;
import com.foodcourt.common.model.Vendor;

public class VendorDao {
	public Vendor getVendorByUserid(long userID) {
		return VendorData.getInstance().getVendorByUserid(userID);
	}
	public void addNewVendor(Vendor vendor) {
		VendorData.getInstance().addNewVendor(vendor);
	}
	public List<Vendor> getVendors() {
		return VendorData.getInstance().getVendors();
	}
	public void removeVendor(List<Integer> vendorIDs) {
		for (Integer i: vendorIDs) {
			VendorData.getInstance().removeVendorFromID(i);
		}
	}
}
