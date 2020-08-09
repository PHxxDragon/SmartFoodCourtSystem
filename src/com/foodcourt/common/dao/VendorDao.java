package com.foodcourt.common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.foodcourt.common.database.VendorData;
import com.foodcourt.common.model.Vendor;


import com.foodcourt.common.model.Meal;

public class VendorDao {
	public static List<Vendor> getVendorByUserid(long userID) {
		//return VendorData.getInstance().getVendorByUserid(userID);
		return selectVendorByOwnerID(userID);
	}
	public static void addNewVendor(Vendor vendor) {
		//VendorData.getInstance().addNewVendor(vendor);
		insertVendor(vendor);
	}
	public static List<Vendor> getVendors() {
		//return VendorData.getInstance().getVendors();
		return selectAllVendors();
	}
	public static void removeVendor(List<Long> vendorIDs) {
		for (Long i: vendorIDs) {
			//VendorData.getInstance().removeVendorFromID(i);
			deleteVendorByID(i);
		}
	}
	
	
	final private static String mysqlURL="jdbc:mysql://localhost:3306/";
	final private static String mysqlUsrName="root";

	// final private static String mysqlPass="soni1382000duy";
	final private static String mysqlPass="1234";
	//final private static String mysqlPass="8pJ-:G&b}aPUP9*6";
	
	private static final String INSERT_VENDOR =  "INSERT INTO vendor_info (Vendor_ID, Name, Owner_ID) VALUES (?, ?, ?)";
	private static final String GET_VENDOR_MAX_ID = "SELECT MAX(Vendor_ID) AS MaxVendorID from vendor_info";
		
	private static final String SELECT_ALL_VENDORS = "SELECT * FROM vendor_info";
	private static final String SELECT_VENDOR_BY_ID = "SELECT * FROM vendor_info WHERE Vendor_ID = ?";
	private static final String SELECT_VENDOR_BY_NAME = "SELECT * FROM vendor_info WHERE Vendro_Name = ?";
	private static final String SELECT_VENDOR_BY_OWNER_ID = "SELECT * FROM vendor_info WHERE Owner_ID = ?";
		
	private static final String DELETE_VENDOR_BY_ID = "DELETE FROM vendor_info WHERE Vendor_ID = ?";
		
	private static final String UPDATE_VENDOR_OWNER_ID = "UPDATE vendor_info SET Owner_ID = ? WHERE Vendor_ID = ? ";
	private static final String UPDATE_VENDOR_NAME = "UPDATE vendor_info SET Name = ? WHERE Vendor_ID = ? ";
	
	
	public VendorDao() {
		
	}
	
	private static String getDatabaseName() {
		String databaseName="sfcsdatabase";
		return databaseName;
	}
	
	private static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(mysqlURL+getDatabaseName(),mysqlUsrName, mysqlPass);
			//System.out.println(mysqlURL+getDatabaseName());	//This line is for debug purpose only
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void insertVendor(Vendor vendor) {
		Connection conn = getConnection();
		try {
			PreparedStatement getMaxVendorID = conn.prepareStatement(GET_VENDOR_MAX_ID);
			ResultSet res = getMaxVendorID.executeQuery();
			res.next();
			int vendorIDToAdd = res.getInt("MaxVendorID")+1;
			vendor.setId(vendorIDToAdd);
			
			
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_VENDOR);
			preparedStatement.setLong(1, vendor.getId());
			preparedStatement.setString(2, vendor.getName());
			preparedStatement.setLong(3, vendor.getOwnerID());
			preparedStatement.executeUpdate();
			
			//Update to meal database
			for (Meal meal : vendor.getMenu()) {
				MealDao.insertMeal(meal);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static List<Vendor> selectAllVendors() {
		List<Vendor> vendorList = new ArrayList<Vendor>();
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(SELECT_ALL_VENDORS);
				
			ResultSet res=preparedStatement.executeQuery();
			while (res.next()) {
				Vendor vendor = new Vendor();
				long id  =  res.getLong("Vendor_ID");
				String vendorName = res.getString("Name");
				int ownerID = res.getInt("Owner_ID");
				vendor.setId(id);
				vendor.setName(vendorName);
				vendor.setOwnerID(ownerID);
				//Get all the meals from this vendor
				List<Meal> mealList = MealDao.getMealBySaleVendorID(id);
				vendor.setMenu(mealList);
				
				vendorList.add(vendor);
			}
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vendorList;
			
	}
	
	public static Vendor selectVendorByID(long vendorID) {
		Vendor vendor = new Vendor();
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(SELECT_VENDOR_BY_ID);
			preparedStatement.setLong(1, vendorID);
			
			ResultSet res=preparedStatement.executeQuery();
			res.next();
			long id  =  res.getLong("Vendor_ID");
			String name = res.getString("Name");
			long ownerID = res.getLong("Owner_ID");
			
			vendor.setId(id);
			vendor.setName(name);
			vendor.setOwnerID(ownerID);
			
			//Get all the meals from this vendor
			List<Meal> mealList = MealDao.getMealBySaleVendorID(vendorID);
			vendor.setMenu(mealList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vendor;
		
	}
	
	public static Vendor selectVendorByName(String name) {
		Vendor vendor = new Vendor();
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(SELECT_VENDOR_BY_NAME);
			preparedStatement.setString(1, name);
				
			ResultSet res=preparedStatement.executeQuery();
			res.next();
			long id  =  res.getLong("Vendor_ID");
			String vendorName = res.getString("Name");
			long ownerID = res.getLong("Owner_ID");
				
			vendor.setId(id);
			vendor.setName(vendorName);
			vendor.setOwnerID(ownerID);
				
			//Get all the meals from this vendor
			List<Meal> mealList = MealDao.getMealBySaleVendorID(id);
			vendor.setMenu(mealList);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vendor;
			
	}
	
	public static List<Vendor> selectVendorByOwnerID(long ownerID) {
		List<Vendor> vendorList = new ArrayList<Vendor>();
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(SELECT_VENDOR_BY_OWNER_ID);
			preparedStatement.setLong(1, ownerID);
				
			ResultSet res=preparedStatement.executeQuery();
			while (res.next()) {
				Vendor vendor = new Vendor();
				long id  =  res.getLong("Vendor_ID");
				String vendorName = res.getString("Name");
				//int ownerID = res.getInt("Owner_ID");
				vendor.setId(id);
				vendor.setName(vendorName);
				vendor.setOwnerID(ownerID);
				//Get all the meals from this vendor
				List<Meal> mealList = MealDao.getMealBySaleVendorID(id);
				vendor.setMenu(mealList);
				
				vendorList.add(vendor);
			}
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vendorList;
			
	}
	
	public static void deleteVendorByID(long vendorID) {
		Connection conn = getConnection();
		try {	
			PreparedStatement preparedStatement=conn.prepareStatement(DELETE_VENDOR_BY_ID);
			preparedStatement.setLong(1, vendorID);
			preparedStatement.executeUpdate();
			
			//Delete in meal and order data base
			MealDao.deleteMealBySaleVendorID(vendorID);
			//OrderDao.deleteOrderSaleVendorID(vendorID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean updateVendorOwnerID(long ownerID, long vendorID) {
		boolean isUpdated = false;
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_VENDOR_OWNER_ID);
			preparedStatement.setLong(1, ownerID);
			preparedStatement.setLong(2, vendorID);
			
			isUpdated=preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
		
	}
	
	public static boolean updateVendorName(String name, long vendorID) {
		boolean isUpdated = false;
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_VENDOR_NAME);
			preparedStatement.setString(1, name);
			preparedStatement.setLong(2, vendorID);
			
			isUpdated=preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
		
	}
	
	//Update a meal in a vendor
	//Please refer to MealDao methods for this
	//Get the id for each meal and then call them
}
