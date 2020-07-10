package com.foodcourt.common.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

import com.foodcourt.common.database.MealData;
import com.foodcourt.common.model.Meal;

public class MealDao {
	public static List<Meal> getMealList(){
		return MealData.getInstance().getMealList();
	}
	
	public static Meal getMeal(long mealID) {
		return MealData.getInstance().getMeal(mealID);
	}
	//The global variables to access to local database
	final private static String mysqlURL="jdbc:mysql://localhost:3306/";
	final private static String mysqlUsrName="root";
	final private static String mysqlPass="8pJ-:G&b}aPUP9*6";
	
	//The queries
	private static final String INSERT_MEAL_SQL =  "INSERT INTO meal_info (Meal_ID, Meal_Name, Sale_Vendor_ID, Price, Stock, Decription, Picture_URL, Wait_Time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_MEAL_MAX_ID = "SELECT MAX(Meal_ID) AS MaxMealID from meal_info";
		
	private static final String SELECT_MEAL_BY_ID = "SELECT * FROM meal_info WHERE Meal_ID = ?";
	private static final String SELECT_MEAL_BY_NAME = "SELECT * FROM meal_info WHERE Meal_Name = ?";
	private static final String SELECT_MEAL_BY_SALE_VENDOR_ID = "SELECT * FROM meal_info WHERE Sale_Vendor_ID = ?";
		
	private static final String DELETE_MEAL_BY_ID = "DELETE FROM meal_info WHERE Meal_ID = ?";
	private static final String DELETE_MEAL_BY_SALE_VENDOR_ID = "DELETE FROM meal_info WHERE Sale_Vendor_ID = ?";
		
	private static final String UPDATE_MEAL_NAME = "UPDATE meal_info SET Meal_Name = ? WHERE Meal_ID = ? ";
	private static final String UPDATE_MEAL_SALE_VENDOR_ID = "UPDATE meal_info SET Sale_Vendor_ID = ? WHERE Meal_ID = ? ";
	private static final String UPDATE_MEAL_PRICE = "UPDATE meal_info SET Price = ? WHERE Meal_ID = ? ";
	private static final String UPDATE_MEAL_STOCK = "UPDATE meal_info SET Stock = ? WHERE Meal_ID = ? ";
	private static final String UPDATE_MEAL_DESCRIPTION = "UPDATE meal_info SET Description = ? WHERE Meal_ID = ? ";
	private static final String UPDATE_MEAL_PRITURE_URL = "UPDATE meal_info SET Picture_URL = ? WHERE Meal_ID = ? ";
	private static final String UPDATE_MEAL_WAIT_TIME = "UPDATE meal_info SET Wait_Time = ? WHERE Meal_ID = ? ";
	
	public MealDao() {
		
	}
	
	private static String getDatabaseName() {
		String databaseName="meal_database";
		return databaseName;
	}
	
	//Get the database connection
	private static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(mysqlURL+getDatabaseName(),mysqlUsrName, mysqlPass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void insertMeal(Meal meal) {
		System.out.println(INSERT_MEAL_SQL);
		Connection conn = getConnection();
		PreparedStatement getMaxMealID;
		try {
			getMaxMealID = conn.prepareStatement(GET_MEAL_MAX_ID);
			ResultSet res = getMaxMealID.executeQuery();
			res.next();
			int mealIDToAdd = res.getInt("MaxMealID")+1;
			meal.setId(mealIDToAdd);
			
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_MEAL_SQL);
			preparedStatement.setLong(1, meal.getId());
			preparedStatement.setString(2, meal.getName());
			preparedStatement.setLong(3, meal.getSaleVendorID());
			preparedStatement.setString(4, String.valueOf(meal.getPrice()));
			preparedStatement.setInt(5, meal.getStock());
			preparedStatement.setString(6, meal.getDecription());
			preparedStatement.setString(7, meal.getImgSrc());
			preparedStatement.setInt(8, meal.getEta());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Meal selectMeal(long id) {
		Meal meal = new Meal();
		Connection conn= getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_MEAL_BY_ID);
			preparedStatement.setLong(1, id);
			ResultSet res = preparedStatement.executeQuery();
			
			while (res.next()) {
				//int id = res.getInt("Meal_ID");
				String name = res.getString("Meal_name");
				long saleVendorID = res.getLong("Sale_Vendor_ID");
				long price = Long.parseLong(res.getString("Price"));
				int stock = res.getInt("Stock");
				String des = res.getString("Description");
				String pic_url = res.getString("Picture_URL");
				int waitTime = res.getInt("Wait_Time");
				
				meal.setId(id);
				meal.setName(name);
				meal.setSaleVendorID(saleVendorID);
				meal.setPrice(price);
				meal.setStock(stock);
				meal.setDecription(des);
				meal.setImgSrc(pic_url);
				meal.setEta(waitTime);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meal;
	}
	
	public static Meal selectMeal(String name) {
		Meal meal = new Meal();
		Connection conn= getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_MEAL_BY_NAME);
			preparedStatement.setString(1, name);
			ResultSet res = preparedStatement.executeQuery();
			
			while (res.next()) {
				long id = res.getLong("Meal_ID");
				//String name = res.getString("Meal_name");
				int saleVendorID = res.getInt("Sale_Vendor_ID");
				long price = Long.parseLong(res.getNString("Price"));
				int stock = res.getInt("Stock");
				String des = res.getString("Description");
				String pic_url = res.getString("Picture_URL");
				int waitTime = res.getInt("Wait_Time");
				
				meal.setId(id);
				meal.setName(name);
				meal.setSaleVendorID(saleVendorID);
				meal.setPrice(price);
				meal.setStock(stock);
				meal.setDecription(des);
				meal.setImgSrc(pic_url);
				meal.setEta(waitTime);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meal;
	}
	
	//Select meal by sale vendor ID
	public static List<Meal> getMealBySaleVendorID(long saleVendorID){
		List<Meal> mealList = new ArrayList<Meal>();
		Connection conn= getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_MEAL_BY_SALE_VENDOR_ID);
			preparedStatement.setLong(1, saleVendorID);
			ResultSet res = preparedStatement.executeQuery();
			
			while (res.next()) {
				Meal meal = new Meal();	
				long id = res.getInt("Meal_ID");
				String name = res.getString("Meal_name");
				//int saleVendorID = res.getInt("Sale_Vendor_ID");
				long price = Long.parseLong(res.getNString("Price"));
				int stock = res.getInt("Stock");
				String des = res.getString("Description");
				String pic_url = res.getString("Picture_URL");
				int waitTime = res.getInt("Wait_Time");
				
				meal.setId(id);
				meal.setName(name);
				meal.setSaleVendorID(saleVendorID);
				meal.setPrice(price);
				meal.setStock(stock);
				meal.setDecription(des);
				meal.setImgSrc(pic_url);
				meal.setEta(waitTime);
				
				mealList.add(meal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mealList;
	}
	
	//Delete meal by id
	public static boolean deleteMealByID(long id) {
		boolean isDeleted= false;
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(DELETE_MEAL_BY_ID);
			preparedStatement.setLong(1, id);
			isDeleted = preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isDeleted;
	}
	
	public static boolean deleteMealBySaleVendorID(long saleVendorID) {
		boolean isDeleted= false;
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(DELETE_MEAL_BY_SALE_VENDOR_ID);
			preparedStatement.setLong(1, saleVendorID);
			isDeleted = preparedStatement.executeUpdate()>0;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return isDeleted;
	}
	
	public static boolean updateMealName(String name, long mealID) {
		boolean isUpdated = false;
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_MEAL_NAME);
			preparedStatement.setString(1,name);
			preparedStatement.setLong(2, mealID);
			
			isUpdated=preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
		
	}
	
	public static boolean updateMealSaleVendorID(long saleVendorID, long mealID) {
		boolean isUpdated = false;
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_MEAL_SALE_VENDOR_ID);
			preparedStatement.setLong(1,saleVendorID);
			preparedStatement.setLong(2, mealID);
			
			isUpdated=preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
		
	}
	
	public static boolean updateMealPrice(long price, long mealID) {
		boolean isUpdated = false;
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_MEAL_PRICE);
			preparedStatement.setString(1, String.valueOf(price));
			preparedStatement.setLong(2, mealID);
			
			isUpdated=preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
		
	}
	
	public static boolean updateMealStock(int stock, long mealID) {
		boolean isUpdated = false;
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_MEAL_STOCK);
			preparedStatement.setInt(1, stock);
			preparedStatement.setLong(2, mealID);
			
			isUpdated=preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
		
	}
	
	public static boolean updateMealDescription(String description, long mealID) {
		boolean isUpdated = false;
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_MEAL_DESCRIPTION);
			preparedStatement.setString(1, description);
			preparedStatement.setLong(2, mealID);
			
			isUpdated=preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
		
	}
	
	public static boolean updateMealPictureURL(String url, long mealID) {
		boolean isUpdated = false;
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_MEAL_PRITURE_URL);
			preparedStatement.setString(1, url);
			preparedStatement.setLong(2, mealID);
			
			isUpdated=preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
		
	}
	
	public static boolean updateMealWaitTime(int waitTime, long mealID) {
		boolean isUpdated = false;
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_MEAL_WAIT_TIME);
			preparedStatement.setInt(1, waitTime);
			preparedStatement.setLong(2, mealID);
			
			isUpdated=preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
		
	}
}
