package com.foodcourt.common.dao;

import com.foodcourt.common.database.VendorData;
import com.foodcourt.common.model.Vendor;

public class VendorDao {
	public Vendor getVendorByUserid(long userID) {
		return VendorData.getInstance().getVendorByUserid(userID);
	}
}
