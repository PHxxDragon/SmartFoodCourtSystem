package com.foodcourt.vendorowner.compile;

import java.util.Date;

import com.foodcourt.common.model.VendorOwner;

import java.text.SimpleDateFormat;
import java.lang.StringBuffer;

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
	public StringBuffer compile() {
		StringBuffer result = new StringBuffer();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		result.append("date,revenue,profit,\"avg review score\"\n");
		result.append("\"" + formatter.format(date) + "\",1000,1000,4.5");
		return result;
	}
}
