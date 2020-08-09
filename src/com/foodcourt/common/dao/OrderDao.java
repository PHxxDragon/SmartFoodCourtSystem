package com.foodcourt.common.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.foodcourt.common.model.Meal;
import com.foodcourt.common.model.Order;
import com.foodcourt.common.model.OrderEntry;

public class OrderDao {
	
	//Get order with isDone value== 1
	public static List<Order> getPendingOrders() {
		//return OrderData.getInstance().getPendingOrders();
		return getOrderByIsDone(1);
	}
	//Get order with user id and isDone value== 0
	public static List<Order> getPaidOrders(long userID) {
		//return OrderData.getInstance().getPendingOrders();
		List<Order> orders = getOrderByUserIDisDone(userID, 1);
		orders.addAll(getOrderByUserIDisDone(userID,0));
		return orders;
	}
	
	
	//Get order with User_ID == userID
	public static List<Order> getOrdersByUserId(long userID) {
		//return OrderData.getInstance().getOrdersByUserID(userID);
		return getOrdersByUserId(userID);
	}
	
	//Add order initial
	public static void addOrder (Order order) {
		//OrderData.getInstance().addOrder(order);
		insertOrder(order);
	}
	
	//Move order which isDone from 2 to 1
	public static void addPendingOrder(Order order) {
		//OrderData.getInstance().addPendingOrder(order);
		updateOrderStatus(1, order.getOrderID());
		//Update order stock
		
	}
	
	//Move order which isDone from 1 to 0
	public static void confirmPendingOrder(long orderID) {
		//OrderData.getInstance().confirmOrder(orderID);
		updateOrderStatus(0, orderID);
	}
	
	//Get specific
	public static Order getOrderByUserIDAndID(long userID, long orderID) {
		//List<Order> orders = OrderData.getInstance().getOrdersByUserID(userID);
		//for (Order o: orders) {
		//	if (o.getOrderID() == orderID) {
		//		return o;
		//	}
		//}
		//return null;
		return getOrderByUserIDOrderID(userID, orderID);
	}
	
	public static Order getShoppingCart(long userID) {
		List<Order> orders = OrderDao.getOrderByUserIDisDone(userID, 2);
		if (orders.size() >= 1) return orders.get(0);
		return new Order();
	}
	
	
	
	//The global variables to access to local database
	final private static String mysqlURL="jdbc:mysql://localhost:3306/";
	final private static String mysqlUsrName="root";
	
	//final private static String mysqlPass="soni1382000duy";
	//final private static String mysqlPass="8pJ-:G&b}aPUP9*6";
	final private static String mysqlPass="1234";
	
	//The queries
	private static final String INSERT_ORDER_SQL =  "INSERT INTO order_info (Order_ID, Price, Wait_Time, User_ID, isDone, Date_Complete) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ORDER_MAX_ID = "SELECT MAX(Order_ID) AS MaxOrderID FROM order_info";
	private static final String INSERT_ORDER_ENTRY = "INSERT INTO order_entry_info (Order_Entry_ID, Meal_ID, Quantity, Total_Price, Order_ID, Total_Wait_Time) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ORDER_ENTRY_MAX_ID = "SELECT MAX(Order_Entry_ID) AS MaxOrderEntryID FROM order_entry_info";
	
	private static final String SELECT_ORDER_BY_ID = "SELECT * FROM order_info WHERE Order_ID = ?";
	private static final String SELECT_ORDER_ENTRY_BY_ORDER_ID = "SELECT * FROM order_entry_info WHERE Order_ID = ?";
	
	private static final String SELECT_ORDER_BY_USER_ID = "SELECT * FROM order_info WHERE User_ID = ?";
	private static final String SELECT_ORDER_BY_USER_ID_ORDER_ID = "SELECT * FROM order_info WHERE User_ID = ? AND Order_ID = ?";
	private static final String SELECT_ORDER_BY_USER_ID_ISDONE = "SELECT * FROM order_info WHERE User_ID = ? AND isDone = ?";
	
	//Later
	//private static final String SELECT_ORDER_BY_SALE_VENDOR_ID = "SELECT * FROM order_info WHERE Sale_Vendor_ID = ? ";
	
	
	private static final String SELECT_ORDER_BY_ISDONE = "SELECT * FROM order_info WHERE isDone = ? ";
	private static final String SELECT_ORDER_IN_TIME_INTERVAL = "SELECT * FROM order_info WHERE (DATE(Date_Complete) BETWEEN ? AND ?) AND isDone <> 2";
	
	//private static final String SELECT_ORDER_ID_BY_SALE_VENDOR_ID = "SELECT Order_ID FROM order_info WHERE Sale_Vendo_ID = ?";
		
	
	private static final String DELETE_ORDER_BY_ID = "DELETE FROM order_info WHERE Order_ID = ?";
	//private static final String DELETE_ORDER_BY_SALE_VENDOR_ID = "DELETE FROM order_innfo WHERE Sale_Vendor_ID = ?";
	private static final String DELETE_ORDER_ENTRY_BY_ORDER_ID = "DELETE FROM order_entry_info WHERE Order_ID = ?";
	private static final String DELETE_ORDER_ENTRY_BY_MEAL_ID_ORDER_ID = "DELETE FROM order_entry_info WHERE Meal_ID = ? AND Order_ID = ?";
	
	private static final String UPDATE_ORDER_STATUS = "UPDATE order_info SET isDone = ?, Date_Complete = ? WHERE Order_ID = ? ";
	private static final String UPDATE_ORDER_ENTRY_QUANTITY = "UPDATE order_entry_info SET Quantity = ?, Total_Price = ?, Total_Wait_Time = ? WHERE Order_ID = ? AND Meal_ID = ? ";
	private static final String UPDATE_ORDER_PRICE_WAITTIME = "UPDATE order_info SET Price = ?, Wait_Time = ? WHERE Order_ID = ? ";
	
	public OrderDao() {
		
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
	
	public static void insertOrder(Order order) {
		Connection conn = getConnection();
		try {
			PreparedStatement getMaxOrderID = conn.prepareStatement(GET_ORDER_MAX_ID);
			ResultSet res = getMaxOrderID.executeQuery();
			res.next();
			int orderIDToAdd = res.getInt("MaxOrderID")+1;
			order.setOrderID(orderIDToAdd);
			
			//First, create a new row in order_database
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_ORDER_SQL);
			preparedStatement.setLong(1, order.getOrderID());
			preparedStatement.setString(2, String.valueOf(order.getPrice()));
			preparedStatement.setInt(3, order.getEta());
			preparedStatement.setLong(4, order.getUserID());
			preparedStatement.setInt(5, 2); //Order is buying
			preparedStatement.setDate(6, Date.valueOf(LocalDate.now()));
			
			preparedStatement.executeUpdate();
			
			//Update to order_entry_info
			
			List<OrderEntry> orderEntries = order.getOrderEntries();
			for (int i = 0; i < orderEntries.size(); i++) {
				OrderEntry entry = orderEntries.get(i);
				PreparedStatement getMaxOrderEntryID = conn.prepareStatement(GET_ORDER_ENTRY_MAX_ID);
				ResultSet result = getMaxOrderEntryID.executeQuery();
				result.next();
				int orderEntryIDToAdd=result.getInt("MaxOrderEntryID")+1;
				
				
				//Get total price for this meal
				//Meal meal =MealDao.selectMeal(entry.getMeal().getId());
				//long totalPrice = meal.getPrice()*entry.getQuantity();
				//Don't know which is better
				long totalPrice = entry.getMeal().getPrice()*entry.getQuantity();
				PreparedStatement addOrderEntry = conn.prepareStatement(INSERT_ORDER_ENTRY);
				addOrderEntry.setLong(1, orderEntryIDToAdd);
				addOrderEntry.setLong(2, entry.getMeal().getId());
				addOrderEntry.setInt(3, entry.getQuantity());
				addOrderEntry.setString(4, String.valueOf(totalPrice));
				addOrderEntry.setLong(5, order.getOrderID());
				addOrderEntry.setInt(6, entry.getMeal().getEta());
				
				addOrderEntry.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void insertOrderEntry(long mealID, int quantity, long orderID) {
		Connection conn = getConnection();
		try {
			PreparedStatement getMaxOrderEntryID = conn.prepareStatement(GET_ORDER_ENTRY_MAX_ID);
			ResultSet result = getMaxOrderEntryID.executeQuery();
			result.next();
			int orderEntryIDToAdd=result.getInt("MaxOrderEntryID")+1;
				
				
			//Get total price for this meal
			Meal meal = MealDao.getMeal(mealID);
			OrderEntry newOrderEntry = new OrderEntry();
			newOrderEntry.setMeal(meal);
			newOrderEntry.setQuantity(quantity);
			//long totalPrice = meal.getPrice()*entry.getQuantity();
			//Don't know which is better
			long totalPrice = meal.getPrice()*quantity;
			int totalWaitTime = meal.getEta()*quantity;
				
			PreparedStatement addOrderEntry = conn.prepareStatement(INSERT_ORDER_ENTRY);
			addOrderEntry.setLong(1, orderEntryIDToAdd);
			addOrderEntry.setLong(2, mealID);
			addOrderEntry.setInt(3, quantity);
			addOrderEntry.setString(4, String.valueOf(totalPrice));
			addOrderEntry.setLong(5, orderID);
			addOrderEntry.setInt(6, totalWaitTime);
			
			addOrderEntry.executeUpdate();
			
			Order orderToUpdate = OrderDao.selectOrder(orderID);
			orderToUpdate.getOrderEntries().add(newOrderEntry);
			orderToUpdate.setPrice(orderToUpdate.getPrice()+totalPrice);
			orderToUpdate.setEta(orderToUpdate.getEta()+totalWaitTime);
			
			updateOrderPriceETA(orderToUpdate.getPrice(),orderToUpdate.getEta(), orderID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Update oder isDone (2:buying, 1: pending, 0: complete)
	//Update time when this order is completed
	//This method should be called once the order is completed
	public static void updateOrderStatus(int status, long orderID) {
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_ORDER_STATUS);
			preparedStatement.setInt(1, status);
			preparedStatement.setDate(2, Date.valueOf(LocalDate.now()));
			preparedStatement.setLong(3, orderID);
			
			preparedStatement.executeUpdate();
			
			//Update meal stock if from 2 to 1
			if (status == 1) {
				Order order = OrderDao.selectOrder(orderID);
				for (OrderEntry entry: order.getOrderEntries()) {
					int newStock = entry.getMeal().getStock()-entry.getQuantity();
					//Update new stock in class
					//Feedback if this line is necessary or not
					entry.getMeal().setStock(newStock);
					//Update in the meal_database
					MealDao.updateMealStock(newStock, entry.getMeal().getId());
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateOrderEntryQuantity(long mealID, int newQuantity, long orderID) {
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_ORDER_ENTRY_QUANTITY);
			Meal  mealToUpdate = MealDao.getMeal(mealID);
			long newPrice = mealToUpdate.getPrice()*newQuantity;
			int newWaitTime = mealToUpdate.getEta()*newQuantity;
			preparedStatement.setLong(1, newQuantity);
			preparedStatement.setString(2, String.valueOf(newPrice));
			preparedStatement.setInt(3, newWaitTime);
			preparedStatement.setLong(4, orderID);
			preparedStatement.setLong(5, mealID);
			
			preparedStatement.executeUpdate();
			
			//Update order price and wait time accordingly
			Order orderToUpdate = selectOrder(orderID);
			long newTotalPrice = 0;
			int newTotalETA = 0;
			for (OrderEntry entry : orderToUpdate.getOrderEntries()) {
				if (entry.getMeal().getId()!=mealID) {
					newTotalPrice+=entry.getMeal().getPrice()*entry.getQuantity();
					newTotalETA += entry.getMeal().getEta()*entry.getQuantity();
				}
			}
			newTotalPrice += newPrice;
			newTotalETA += newWaitTime;
			
			updateOrderPriceETA(newTotalPrice, newTotalETA, orderID);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateOrderPriceETA(long newPrice, int newETA, long orderID) {
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_ORDER_PRICE_WAITTIME);
			
			preparedStatement.setString(1, String.valueOf(newPrice));
			preparedStatement.setInt(2, newETA);
			preparedStatement.setLong(3, orderID);
			
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Order selectOrder(long id) {
		Order order = new Order();
		Connection conn = getConnection();
		try {
			//First get the order info
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ORDER_BY_ID);
			preparedStatement.setLong(1, id);
			ResultSet res = preparedStatement.executeQuery();
			res.next();
			long orderID = res.getLong("Order_ID");
			long price  = Long.valueOf(res.getString("Price"));
			int eta = res.getInt("Wait_Time");
			long userID = res.getLong("User_ID");
			int isDone = res.getInt("isDone");
			
			order.setOrderID(orderID);
			order.setPrice(price);
			order.setEta(eta);
			order.setUserID(userID);
			order.setIsDone(isDone);
			
			//Then get meal info of this order
			List<OrderEntry> mealList = new ArrayList<OrderEntry>();
			PreparedStatement getMealsWithOrderID = conn.prepareStatement(SELECT_ORDER_ENTRY_BY_ORDER_ID);
			getMealsWithOrderID.setLong(1, order.getOrderID());
			ResultSet resultList = getMealsWithOrderID.executeQuery();
			while (resultList.next()) {
				int mealID = resultList.getInt("Meal_ID");
				int quantity = resultList.getInt("Quantity");
				
				//Get all info of the meal from meal database
				Meal meal = MealDao.selectMeal(mealID);
				OrderEntry newEntry = new OrderEntry();
				newEntry.setMeal(meal);
				newEntry.setQuantity(quantity);
				mealList.add(newEntry);
			}
			order.setOrderEntries(mealList);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}
	
	public static List<Order> getOrderByUserID(long userID){
		List<Order> userOrder = new ArrayList<Order>();
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ORDER_BY_USER_ID);
			preparedStatement.setLong(1, userID);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				int orderID = result.getInt("Order_ID");
				//This is not optimal
				Order order = OrderDao.selectOrder(orderID);
				userOrder.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userOrder;
	}
	
	public static Order getOrderByUserIDOrderID(long userID, long orderID){
		Order order = new Order();
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ORDER_BY_USER_ID_ORDER_ID);
			preparedStatement.setLong(1, userID);
			preparedStatement.setLong(2, orderID);
			ResultSet result = preparedStatement.executeQuery();
			
			result.next();
			long price  = Long.valueOf(result.getString("Price"));
			int eta = result.getInt("Wait_Time");
			int isDone = result.getInt("isDone");
			
			order.setOrderID(orderID);
			order.setPrice(price);
			order.setEta(eta);
			order.setUserID(userID);
			order.setIsDone(isDone);
			
			//Get mealList of this order
			List<OrderEntry> mealList = new ArrayList<OrderEntry>();
			PreparedStatement getMealsWithOrderID = conn.prepareStatement(SELECT_ORDER_ENTRY_BY_ORDER_ID);
			ResultSet resultList = getMealsWithOrderID.executeQuery();
			while (resultList.next()) {
				int mealID = resultList.getInt("Meal_ID");
				int quantity = resultList.getInt("Quantity");
				
				//Get all info of the meal from meal database
				Meal meal = MealDao.selectMeal(mealID);
				OrderEntry newEntry = new OrderEntry();
				newEntry.setMeal(meal);
				newEntry.setQuantity(quantity);
				mealList.add(newEntry);
			}
			order.setOrderEntries(mealList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}
	
	public static List<Order> getOrderByUserIDisDone(long userID, int isDone){
		List<Order> orders = new ArrayList<Order>();
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ORDER_BY_USER_ID_ISDONE);
			preparedStatement.setLong(1, userID);
			preparedStatement.setInt(2, isDone);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				Order order = new Order();
				long orderID = result.getLong("Order_ID");
				long price  = Long.valueOf(result.getString("Price"));
				int eta = result.getInt("Wait_Time");
				
				order.setOrderID(orderID);
				order.setPrice(price);
				order.setEta(eta);
				order.setUserID(userID);
				order.setIsDone(isDone);
				
				//Get mealList of this order
				List<OrderEntry> mealList = new ArrayList<OrderEntry>();
				PreparedStatement getMealsWithOrderID = conn.prepareStatement(SELECT_ORDER_ENTRY_BY_ORDER_ID);
				getMealsWithOrderID.setLong(1, order.getOrderID());
				ResultSet resultList = getMealsWithOrderID.executeQuery();
				while (resultList.next()) {
					int mealID = resultList.getInt("Meal_ID");
					int quantity = resultList.getInt("Quantity");
					
					//Get all info of the meal from meal database
					Meal meal = MealDao.selectMeal(mealID);
					OrderEntry newEntry = new OrderEntry();
					newEntry.setMeal(meal);
					newEntry.setQuantity(quantity);
					mealList.add(newEntry);
				}
				order.setOrderEntries(mealList);
				orders.add(order);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}
	
	public static List<Order> getOrderByIsDone(int isDone){
		List<Order> userOrder = new ArrayList<Order>();
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ORDER_BY_ISDONE);
			preparedStatement.setInt(1, isDone);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				int orderID = result.getInt("Order_ID");
				//This is not optimal
				Order order = OrderDao.selectOrder(orderID);
				System.out.println(order.getPrice());
				userOrder.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userOrder;
	}
	
	public static List<Order> getOrderInTimeInterval(Date startDate, Date endDate){
		List<Order> userOrder = new ArrayList<Order>();
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ORDER_IN_TIME_INTERVAL);
			preparedStatement.setDate(1, startDate);
			preparedStatement.setDate(2, endDate);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				int orderID = result.getInt("Order_ID");
				//This is not optimal
				Order order = OrderDao.selectOrder(orderID);
				userOrder.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userOrder;
	}
	
	public static void deleteOrderByOrderID(long orderID) {
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(DELETE_ORDER_BY_ID);
			preparedStatement.setLong(1, orderID);
			preparedStatement.executeUpdate();
			
			//The delete all rows that have this orderID from database
			PreparedStatement deleteStatement = conn.prepareStatement(DELETE_ORDER_ENTRY_BY_ORDER_ID);
			deleteStatement.setLong(1, orderID);
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void deleteOrderEntryByMealIDOrderID(long mealID, long orderID) {
		Connection conn = getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(DELETE_ORDER_ENTRY_BY_MEAL_ID_ORDER_ID);
			preparedStatement.setLong(1, mealID);
			preparedStatement.setLong(2, orderID);
			preparedStatement.executeUpdate();
			
			//Update order
			Order orderToUpdate = selectOrder(orderID);
			long newTotalPrice = 0;
			int newTotalETA = 0;
			
			for (OrderEntry entry : orderToUpdate.getOrderEntries()) {
				if (entry.getMeal().getId()!=mealID) {
					newTotalPrice+=entry.getMeal().getPrice()*entry.getQuantity();
					newTotalETA += entry.getMeal().getEta()*entry.getQuantity();
				}
			}	
			
			updateOrderPriceETA(newTotalPrice, newTotalETA, orderID);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
