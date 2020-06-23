package com.foodcourt.vendorowner.compile;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.foodcourt.common.dao.VendorDao;
import com.foodcourt.common.model.User;
import com.foodcourt.common.model.Vendor;

public class CompileReportCSV implements ICompileReport {
	private String start_date;
	private String end_date;
	private User user;
	private Vendor vendor;
	
	public CompileReportCSV(User user, String startDate, String endDate) {
		this.user = user;
		this.start_date = startDate;
		this.end_date = endDate;
		
		VendorDao vendorDao = new VendorDao();
		this.vendor = vendorDao.getVendorByUserid(user.getUserID());
		
	}
	@Override
	public StringBuffer compile() {
		StringBuffer result = new StringBuffer();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		result.append("date,revenue,profit,\"avg review score\"\n");
		result.append("\"" + start_date +"-" +  end_date + "\",1000,1000,4.5");
		return result;
	}
}
