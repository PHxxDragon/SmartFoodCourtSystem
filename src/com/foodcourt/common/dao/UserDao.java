package com.foodcourt.common.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.foodcourt.common.database.UserData;
import com.foodcourt.common.model.Order;
import com.foodcourt.common.model.OrderEntry;
import com.foodcourt.common.model.User;
import com.foodcourt.common.UserType;

public class UserDao {
	
	//Same as insert User
	public static void addNewUser(User user){
		//UserData.getInstance().addNewUser(user);
		insertUser(user);
	}
	
	public static List<User> getUsers() {
		return selectAllUser();
	}
	
	//Same as selectUserByUserName
	public static User getUserFromUsername(String username) {
		//return UserData.getInstance().getUserFromUsername(username);
		return selectUserByUserName(username);
	}
	
	//Same as selectUserByID
	public static User getUserFromUserID(long userID) {
		//return UserData.getInstance().getUserFromUserID(userID);
		return selectUserByID(userID);
	}
	//Same as delete user by ID
	public static void removeUser(List<Integer> userIDs) {
		for (Integer i: userIDs) {
			//UserData.getInstance().removeUserFromID(i);
			deleteUserByID(i);
		}
	}
	public static void editUser(long userID, User newUser, boolean editType) {
		//User tempUser = UserData.getInstance().getUserFromUserID(userID);
		
		
		if (newUser.getname().length()>0) {
			//tempUser.setname(newUser.getname());
			updateUserName(newUser.getname(), userID);
		}
		if (newUser.getUsername().length() > 0) {
			//tempUser.setUsername(newUser.getUsername());
			updateUserUserName(newUser.getUsername(), userID);
		}
		if (newUser.getpassword().length() > 0) {
			//tempUser.setpassword(newUser.getpassword());
			updateUserPassword(newUser.getpassword(), userID);
		}
		if (editType == true) {
			//tempUser.setUserType(newUser.getUserType());
			updateUserType(newUser.getUserType().toString(), userID);
		}
		//UserData.getInstance().removeUserFromID(userID);
		//UserData.getInstance().addNewUser(tempUser);
	}
	
	public static void updateBalance(long balance, String username) {
		//UserData.getInstance().updateBalance(balance, username);
		updateUserBalance(balance, username);
    }
	public static void changePasswordFromUsername(String username,String newpassword) {
        //UserData.getInstance().changePasswordFromUsername(username,newpassword);
		updateUserPassword(newpassword, username);
	}
	//Search for order where user id =userID and isDone=2 (if possible)
	//Add order entry through orderID
	public static void addMeal(long userID, long mealID, int quantity) {
		//UserData.getInstance().addMeal(userID, mealID, quantity);
		Order order = null;
		if (OrderDao.getOrderByUserIDisDone(userID, 2)!=null) {
			order = OrderDao.getOrderByUserIDisDone(userID, 2);
		}
		else {
			//Create a dummy order
			order = new Order();
			List<OrderEntry> list = new ArrayList<OrderEntry>();
			order.setUserID(userID);
			order.setEta(0);
			order.setPrice(0);
			order.setSaleVendorID(0);
			order.setOrderEntries(list);
			
			OrderDao.addOrder(order);
		}
		
		boolean isEntryExist=false;
		for (OrderEntry entry: order.getOrderEntries()) {
			if (entry.getMeal().getId()==mealID) {
				isEntryExist =true;
				int newQuantity = quantity;
				OrderDao.updateOrderEntryQuantity(mealID, newQuantity, order.getOrderID());
				break;
			}
		}
		if (isEntryExist == false) {
			OrderDao.insertOrderEntry(mealID, quantity, order.getOrderID());
		}
		
	}
	
	//Search for order where user id =userID and isDone=2 (if possible)
	//Delete order entry through orderID
	public static void removeMeal(long userID, long mealID) {
		//UserData.getInstance().removeMeal(userID, mealID);
		Order order = null;
		if (OrderDao.getOrderByUserIDisDone(userID, 2)!=null) {
			order = OrderDao.getOrderByUserIDisDone(userID, 2);
		}
		else {
			return;
		}
		
		OrderDao.deleteOrderEntryByMealIDOrderID(mealID, order.getOrderID());
	}
	
	//Search for order where user id =userID and isDone=2 (if possible)
	//Update order entry through orderID
	public static void updateCart(long userID, Order shoppingCart) {
		//UserData.getInstance().updateCart(userID, shoppingCart);
		//Delete the old and replace by the new one
		Order order = null;	//Order to replace
		if (OrderDao.getOrderByUserIDisDone(userID, 2)!=null) {
			order = OrderDao.getOrderByUserIDisDone(userID, 2);
		}
		else {
			return;
		}
		OrderDao.deleteOrderByOrderID(order.getOrderID());
		OrderDao.insertOrder(shoppingCart);
	}
	
	
	//The global variables to access to local database
	final private static String mysqlURL="jdbc:mysql://localhost:3306/";
	final private static String mysqlUsrName="root";
	final private static String mysqlPass="8pJ-:G&b}aPUP9*6";
	//final private static String mysqlPass="1234";
	
	//The queries
	private static final String INSERT_USERS_SQL = "INSERT INTO user_info_normal (User_ID, User_Name, User_Type, Password, Balance, Email) VALUES (?, ?, ?, ?, ?, ?) ";
	private static final String GET_USERS_MAX_ID = "SELECT MAX(User_ID) AS MaxUserID FROM user_info_normal";
	
	private static final String SELECT_USER_BY_ID = "SELECT * FROM user_info_normal WHERE User_ID = ? ";
	private static final String SELECT_USER_BY_USER_NAME = "SELECT * FROM user_info_normal WHERE User_Name = ? ";
	private static final String SELECT_ALL_USERS = "SELECT * FROM user_info_normal";
	
	private static final String DELETE_USER_BY_ID = "DELETE FROM user_info_normal WHERE User_ID = ? ";
	
	private static final String UPDATE_USERS_NAME = "UPDATE user_info_normal SET Name = ? where User_ID = ? ";
	private static final String UPDATE_USERS_EMAIL = "UPDATE user_info_normal SET Email = ? where User_ID = ? ";
	private static final String UPDATE_USERS_PHONE = "UPDATE user_info_normal SET Phone = ? where User_ID = ? ";
	private static final String UPDATE_USERS_TYPE = "UPDATE user_info_normal SET User_Type = ? where User_ID = ? ";
	private static final String UPDATE_USERS_USER_NAME = "UPDATE user_info_normal SET User_Name = ? where User_ID = ? ";
	
	private static final String UPDATE_USER_PASS_BY_USER_ID = "UPDATE user_info_normal SET Password = ? where User_ID = ? ";
	private static final String UPDATE_USER_PASS_BY_USER_NAME = "UPDATE user_info_normal SET Password = ? where User_Name = ? ";
	
	private static final String UPDATE_USERS_BALANCE_BY_USER_ID = "UPDATE user_info_normal SET Balance = ? where User_ID = ? ";
	private static final String UPDATE_USERS_BALANCE_BY_USER_NAME = "UPDATE user_info_normal SET Balance = ? where User_Name = ? ";
	
	
	public UserDao() {
		
	}
	
	private static String getDatabaseName() {
		String databaseName="sfcsdatabase";
		return databaseName;
	}
	//Get the database connection
	private static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(mysqlURL+getDatabaseName(),mysqlUsrName, mysqlPass);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//Insert a created user object to database (user include user_name, pass and role)
	public static void insertUser(User user) {
		Connection conn=getConnection();
		
		try {
			PreparedStatement getMaxUserID=conn.prepareStatement(GET_USERS_MAX_ID);
			ResultSet res=getMaxUserID.executeQuery();
			res.next();
			int userIDToAdd=res.getInt("MaxUserID")+1;
				
			PreparedStatement preparedStatement=conn.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setLong(1, userIDToAdd);
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getUserType().toString());
			preparedStatement.setString(4, user.getpassword());
			preparedStatement.setString(5, "0");
			preparedStatement.setString(6, user.getemail());
			preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
		
		
		
	}
	
	//Select user by id
	public static User selectUserByID(long id) {
		User user=new User();
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setLong(1, id);
			//System.out.println(SELECT_USER_BY_ID);	//This line is for debug purpose only
			ResultSet res=preparedStatement.executeQuery();
			
			while (res.next()) {
				String userName=res.getString("User_Name");
				String name=res.getString("Name");
				String userType=res.getString("User_Type");
				String password=res.getString("Password");
				long balance=Long.parseLong(res.getString("Balance"));
				String email=res.getString("Email");
				String phone=res.getString("Phone");
				
				//Convert String to UserType object
				for (UserType iterator: UserType.values()) {
					//System.out.println(iterator.toString());	//This line is for debug purpose only
					//System.out.println("US "+userType);	//This line is for debug purpose only
					if (iterator.toString().equals(userType)) {
						user.setUserType(iterator);
						break;
					}
				}
				user.setUserID(id);
				user.setname(name);
				user.setUsername(userName);
				user.setpassword(password);
				user.setBalance(balance);
				user.setEmail(email);
				user.setPhone(phone);
				
				//Dude, you have to get order which isDone column == 2, later then 
				Order shoppingCart = OrderDao.getOrderByUserIDisDone(id, 2);
				if (shoppingCart == null) shoppingCart = new Order();
				user.setShoppingCart(shoppingCart);
				
			}
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	//Select user by name 
	public static User selectUserByUserName(String userName) {
		User user= null;
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(SELECT_USER_BY_USER_NAME);
			preparedStatement.setString(1, userName);
			ResultSet res=preparedStatement.executeQuery();
			
			while (res.next()) {
				user = new User();
				long id = res.getLong("User_ID");
				//String userName=res.getString("User_Name");
				String name=res.getString("Name");
				String userType=res.getString("User_Type");
				String password=res.getString("Password");
				long balance=Long.parseLong(res.getString("Balance"));
				String email=res.getString("Email");
				String phone=res.getString("Phone");
				
				//Convert String to UserType object
				for (UserType iterator: UserType.values()) {
					if (iterator.toString().equals(userType)) {
						user.setUserType(iterator);
						break;
					}
				}
				user.setUserID(id);
				user.setname(name);
				user.setUsername(userName);
				user.setpassword(password);
				user.setBalance(balance);
				user.setEmail(email);
				user.setPhone(phone);
				
				//Dude, you have to get order which isDone colummn == 2, later then 
				Order shoppingCart = OrderDao.getOrderByUserIDisDone(id, 2);
				user.setShoppingCart(shoppingCart);
			}
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	//Select all user
	public static List<User> selectAllUser() {
		List<User> userList=new ArrayList<User>();
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(SELECT_ALL_USERS);
			ResultSet res=preparedStatement.executeQuery();
			
			while (res.next()) {
				User user = new User();
				long userID = res.getLong("User_ID");
				String userName=res.getString("User_Name");
				String name=res.getString("Name");
				String userType=res.getString("User_Type");
				String password=res.getString("Password");
				long balance=Long.parseLong(res.getString("Balance"));
				String email=res.getString("Email");
				String phone=res.getString("Phone");
				
				//Convert String to UserType object
				for (UserType iterator: UserType.values()) {
					if (iterator.toString().equals(userType)) {
						user.setUserType(iterator);
						break;
					}
				}
				user.setUserID(userID);
				user.setname(name);
				user.setUsername(userName);
				user.setpassword(password);
				user.setBalance(balance);
				user.setEmail(email);
				user.setPhone(phone);
				
				
				//Dude, you have to get order which isDone column == 2, later then 
				Order shoppingCart = OrderDao.getOrderByUserIDisDone(userID, 2);
				user.setShoppingCart(shoppingCart);
				
				userList.add(user);
			}
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
	}
	
	//Delete user by id
	public static boolean deleteUserByID(long userID) {
		boolean isDeleted = false;
		Connection connection = getConnection(); 
	    PreparedStatement statement;
		try {
			statement = connection.prepareStatement(DELETE_USER_BY_ID);
			statement.setLong(1, userID);
		    isDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
	    return isDeleted;
	}
	
	//Update user password through user name
	public static boolean updateUserPassword(String newPassword, String userName) {
		boolean isUpdated = false;
		//Simple handle exception
		if (newPassword =="") return isUpdated;
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_USER_PASS_BY_USER_NAME);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, userName);
				
			isUpdated=preparedStatement.executeUpdate()>0;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}
	
	//Update user password through user id
	public static boolean updateUserPassword(String newPassword, long userID) {
		boolean isUpdated = false;
		//Simple handle exception
		if (newPassword =="") return isUpdated;
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_USER_PASS_BY_USER_ID);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setLong(2,  userID);
					
			isUpdated=preparedStatement.executeUpdate()>0;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}
	
	//Update user balance through user id
	public static boolean updateUserBalance(long value, long userID) {
		boolean isUpdated = false;
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_USERS_BALANCE_BY_USER_ID);
			preparedStatement.setString(1, String.valueOf(value));
			preparedStatement.setLong(2,  userID);
			
			isUpdated=preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}
	//Update user balance through user id
	public static boolean updateUserBalance(long value, String userName) {
		boolean isUpdated = false;
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_USERS_BALANCE_BY_USER_NAME);
			preparedStatement.setString(1, String.valueOf(value));
			preparedStatement.setString(2, userName);
			
			isUpdated=preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}
	//Update user name
	public static boolean updateUserName(String name, long userID) {
		boolean isUpdated = false;
		//Simple handle exception
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_USERS_NAME);
			preparedStatement.setString(1, name);
			preparedStatement.setLong(2,  userID);
				
			isUpdated=preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}
	
	//Update user name
	public static boolean updateUserEmail(String name, long userID) {
		boolean isUpdated = false;
		//Simple handle exception
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_USERS_EMAIL);
			preparedStatement.setString(1, name);
			preparedStatement.setLong(2,  userID);
				
			isUpdated=preparedStatement.executeUpdate()>0;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}
	
	//Update user phone
	public static boolean updateUserPhone(String phoneNumber, long userID) {
		boolean isUpdated = false;
		//Simple handle exception
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_USERS_PHONE);
			preparedStatement.setString(1, phoneNumber);
			preparedStatement.setLong(2,  userID);
					
			isUpdated=preparedStatement.executeUpdate()>0;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}
	
	public static boolean updateUserType(String type, long userID) {
		boolean isUpdated = false;
		//Simple handle exception
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_USERS_TYPE);
			preparedStatement.setString(1, type);
			preparedStatement.setLong(2,  userID);
					
			isUpdated=preparedStatement.executeUpdate()>0;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}
	//Update user's username
	public static boolean updateUserUserName(String userName, long userID) {
		boolean isUpdated = false;
		//Simple handle exception
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(UPDATE_USERS_USER_NAME);
			preparedStatement.setString(1, userName);
			preparedStatement.setLong(2,  userID);
				
			isUpdated=preparedStatement.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}
}
