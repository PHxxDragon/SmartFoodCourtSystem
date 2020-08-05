package com.foodcourt.vendorowner.compile;

import java.time.LocalDate;
import java.time.temporal.*;
import java.util.List;
import java.sql.Date;

import com.foodcourt.common.dao.OrderDao;
import com.foodcourt.common.dao.VendorDao;
import com.foodcourt.common.model.Order;
import com.foodcourt.common.model.User;
import com.foodcourt.common.model.Vendor;

public class CompileReportCSV implements ICompileReport {
	private String start_date;
	private String end_date;
	private TemporalUnit time_unit;
	private User user;
	private Vendor vendor;
	
	private final static char CSV_DELIMITER = ',';
	private final static char CSV_ESCAPE_CHAR = '\"';
	private final static char CSV_ENDLINE = '\n';
	
	private final static String[] report_label = {
			"start date",
			"end date",
			"revenue"
	};
	
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
		
		for (int i = 0; i < report_label.length - 1; i++) {
			result.append(report_label[i]);
			result.append(CSV_DELIMITER);
		}
		result.append(report_label[report_label.length - 1]);
		result.append(CSV_ENDLINE);
		
		for (LocalDate start_interval = parsed_start_date; start_interval.isBefore(parsed_end_date.plusDays(1)); 
		start_interval = start_interval.plus(1, time_unit)) {
			LocalDate end_interval = start_interval.plus(1, time_unit).minusDays(1);
			List<Order> orders = OrderDao.getOrderInTimeInterval(Date.valueOf(start_interval), 
								Date.valueOf(end_interval));
			result.append(start_interval);
			result.append(CSV_DELIMITER);
			result.append(end_interval);
			result.append(CSV_DELIMITER);
			
			long totalPrice = 0;
			for (Order order : orders) {
				System.out.println(order.getOrderID());
				totalPrice += order.getPrice();
			}
			System.out.println(totalPrice);
			result.append(totalPrice);
			result.append(CSV_ENDLINE);
		}
		
		return result;
	}
}
