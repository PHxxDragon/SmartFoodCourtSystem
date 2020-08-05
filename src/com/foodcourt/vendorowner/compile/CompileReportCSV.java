package com.foodcourt.vendorowner.compile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.*;

import com.foodcourt.common.dao.OrderDao;
import com.foodcourt.common.dao.VendorDao;
import com.foodcourt.common.model.User;
import com.foodcourt.common.model.Vendor;

public class CompileReportCSV implements ICompileReport {
	private String start_date;
	private String end_date;
	private TemporalUnit time_unit;
	private User user;
	private Vendor vendor;
	
	private static char CSV_DELIMITER = ',';
	private static char CSV_PURE_TEXT_START = '\"';
	private static char CSV_PURE_TEXT_END = '\"';
	
	public CompileReportCSV(User user, String startDate, String endDate, TemporalUnit timeUnit) {
		this.user = user;
		this.start_date = startDate;
		this.end_date = endDate;
		// this.vendor = VendorDao.getVendorByUserid(user.getUserID()).get(0);
		this.vendor = null;
		this.time_unit = timeUnit;
	}
	@Override
	public StringBuffer compile() {
		StringBuffer result = new StringBuffer();
		LocalDate parsed_start_date = LocalDate.parse(start_date);
		LocalDate parsed_end_date = LocalDate.parse(end_date);
		
		for (LocalDate date = parsed_start_date; date.isBefore(parsed_end_date); date = date.plus(1, time_unit)) {
			
		}
		List<Order> daily_orders = OrderDao.getOrderInTimeInterval(startDate, endDate)
		while () {
			
		}
		
		while () {
			
		}
		
		result.append("date,revenue,profit,\"avg review score\"\n");
		result.append("\"" + start_date +"-" +  end_date + "\",1000,1000,4.5");
		
		return result;
	}
}
