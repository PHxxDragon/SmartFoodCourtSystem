package com.foodcourt.vendorowner.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodcourt.common.UserType;
import com.foodcourt.common.model.Vendor;
import com.foodcourt.common.model.VendorOwner;
import com.foodcourt.vendorowner.compile.CompileReportCSV;
import com.foodcourt.vendorowner.compile.ICompileReport;

/**
 * Servlet implementation class ReportWriter
 */
@WebServlet("/vdowner/ReportWriter")
public class ReportWriter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int BYTES_DOWNLOAD = 1024;
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
		response.setHeader("Content-Disposition", "attachment;filename=\"downloadname.csv\"");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Expires", "-1");
		
		VendorOwner owner = new VendorOwner(1,"vendorowner",UserType.VD_OWNER);
		Vendor vendor = new Vendor("vendor_name",1);
		owner.setVendor(vendor);
		
		ICompileReport compiler = new CompileReportCSV(owner, new Date(), new Date());
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
