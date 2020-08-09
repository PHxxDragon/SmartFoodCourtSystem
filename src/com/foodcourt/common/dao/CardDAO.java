package com.foodcourt.common.dao;

import java.sql.*;

public class CardDAO {
	final private static String mysqlURL="jdbc:mysql://localhost:3306/";
	final private static String mysqlUsrName="root";
	
	//final private static String mysqlPass="8pJ-:G&b}aPUP9*6";
	final private static String mysqlPass="1234";
	
	
	private static final String SELECT_CARD_BY_SERIAL = "SELECT * FROM sfcs_card WHERE Serial = ? ";
	private static final String CHANGE_CARD_IS_USED = "UPDATE sfcs_card SET isUsed = 1 WHERE Serial = ?";
	
	public CardDAO() {
		
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
	
	public static boolean verifyCardSerial(String inputSerial) {
		boolean isExist = false;
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_CARD_BY_SERIAL);
			preparedStatement.setString(1, inputSerial);
			
			ResultSet res = preparedStatement.executeQuery();
			if (!res.next()) {
				isExist = false;
			}
			else {
				int isUsed = res.getInt("isUsed");
				if (isUsed == 1) {
					isExist = false;
				}
				else {
					isExist = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isExist;
		
	}
	
	public static long getCardValue(String inputSerial) {
		Connection conn=getConnection();
		long value =0;
		if (verifyCardSerial(inputSerial)) {
			PreparedStatement preparedStatement;
			try {
				preparedStatement = conn.prepareStatement(SELECT_CARD_BY_SERIAL);
				preparedStatement.setString(1, inputSerial);
				ResultSet res = preparedStatement.executeQuery();
				res.next();
				
				value = Long.parseLong(res.getString("Card_Value"));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			value=0;
		}
		return value;
	}
	
	public static void changeCardIsUsed(String inputSerial) {
		Connection conn=getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(CHANGE_CARD_IS_USED);
			preparedStatement.setString(1, inputSerial);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
