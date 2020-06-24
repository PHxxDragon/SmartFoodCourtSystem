package com.foodcourt.common.dao;

import java.util.List;

import com.foodcourt.common.database.VendorData;
import com.foodcourt.common.model.Vendor;

public class VendorDao {
	public static Vendor getVendorByUserid(long userID) {
		return VendorData.getInstance().getVendorByUserid(userID);
	}
	public static void addNewVendor(Vendor vendor) {
		VendorData.getInstance().addNewVendor(vendor);
	}
	public static List<Vendor> getVendors() {
		return VendorData.getInstance().getVendors();
	}
	public static void removeVendor(List<Integer> vendorIDs) {
		for (Integer i: vendorIDs) {
			VendorData.getInstance().removeVendorFromID(i);
		}
	}
}
