package com.foodcourt.common.database;

import java.util.ArrayList;
import java.util.List;

import com.foodcourt.common.model.User;
import com.foodcourt.common.model.Vendor;

public class VendorData {
	List<Vendor> vendors;
	
	private static VendorData instance;
	private VendorData() {
		vendors = new ArrayList<Vendor>();
		init();
	}
	
	public static VendorData getInstance() {
		if (VendorData.instance == null) {
			instance = new VendorData();
			return instance;
		}
		return instance;
	}
	
	public void addNewVendor(Vendor vendor) {
		vendors.add(new Vendor(vendor));
	}
	public List<Vendor> getVendors(){
		List<Vendor> vendor = new ArrayList<Vendor>();
		for (Vendor o: vendors) {
			vendor.add(new Vendor(o));
		}
		return vendor;
	}
	
	public void removeVendorFromID(Integer ID) {
		vendors.removeIf((n) -> n.getId() == ID);
	}
	
	public Vendor getVendorByUserid(long userID) {
		for (Vendor v: vendors) {
			if (v.getOwnerID() == userID) {
				return v;
			}
		}
		return null;
	}
	
	private void init() {
		Vendor vendor = new Vendor("A", 1, 1);
		vendors.add(vendor);
		vendor = new Vendor("B", 2, 2);
		vendors.add(vendor);
		vendor = new Vendor("C", 3, 3);
		vendors.add(vendor);
	}
	
}
