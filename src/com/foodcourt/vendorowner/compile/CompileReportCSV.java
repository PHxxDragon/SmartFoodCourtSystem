package com.foodcourt.vendorowner.compile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;

import com.foodcourt.common.dao.OrderDao;
import com.foodcourt.common.dao.VendorDao;
import com.foodcourt.common.model.User;
import com.foodcourt.common.model.Vendor;

public class CompileReportCSV implements ICompileReport {
	private String start_date;
	private String end_date;
	private User user;
	private Vendor vendor;
	
	private static char CSV_DELIMITER = ',';
	private static char CSV_PURE_TEXT_START = '\"';
	private static char CSV_PURE_TEXT_END = '\"';
	
	public CompileReportCSV(User user, String startDate, String endDate) {
		this.user = user;
		this.start_date = startDate;
		this.end_date = endDate;
		// this.vendor = VendorDao.getVendorByUserid(user.getUserID()).get(0);
		this.vendor = null;
	}
	@Override
	public StringBuffer compile() {
		StringBuffer result = new StringBuffer();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date parsed_start_date = formatter.parse(start_date);
		Date parsed_end_date = formatter.parse(end_date);
		
		for (LocalDate date = parsed_start_date; date.isBefore(parsed_end_date) {
			
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
