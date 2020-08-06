package com.foodcourt.vendorowner.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodcourt.common.model.User;
import com.foodcourt.vendorowner.compile.CompileReportCSV;
import com.foodcourt.vendorowner.compile.ICompileReport;

/**
 * Servlet implementation class ReportWriter
 */
@WebServlet("/vdowner/ReportWriter")
public class ReportWriter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int BYTES_DOWNLOAD = 1024;
	private static final String FILENAME = "report.csv";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportWriter() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment;filename=" + "\"" + FILENAME + "\"");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Expires", "-1");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		String s1 = request.getParameter("input_start_date");
		String s2 = request.getParameter("input_end_date");
		int time_interval = Integer.valueOf(request.getParameter("time_interval"));
		
		TemporalUnit time_unit = ChronoUnit.DAYS;
		switch (time_interval) {
			case 0:
				time_unit = ChronoUnit.DAYS;
				break;
			case 1:
				time_unit = ChronoUnit.WEEKS;
				break;
			case 2:
				time_unit = ChronoUnit.MONTHS;
				break;
			default:
				break;
		}
		
		ICompileReport compiler = new CompileReportCSV(user, s1, s2, time_unit);
		String content = compiler.compile().toString();
		InputStream is = new ByteArrayInputStream(content.getBytes());
		int read = 0;
		byte[] bytes = new byte[BYTES_DOWNLOAD];
		OutputStream os = response.getOutputStream();
		while ((read = is.read(bytes)) != -1) {
			os.write(bytes, 0, read);
		}
		os.flush();
		os.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
