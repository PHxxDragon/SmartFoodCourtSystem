package com.foodcourt.vendorowner.model;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.text.SimpleDateFormat;

public class CompileReportCSV implements ICompileReport {
	private Date start_date;
	private Date end_date;
	private VendorOwner owner;
	
	public CompileReportCSV(VendorOwner vendor_owner, Date start, Date end) {
		this.owner = vendor_owner;
		this.start_date = start;
		this.end_date = end;
	}
	@Override
	public String compile() {
		String result = "";
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		result.concat("date,revenue,profit,\"avg review score\"\n");
		result.concat("\"" + formatter.format(date) + "\",1000,1000,4.5");
		return result;
	}
}
