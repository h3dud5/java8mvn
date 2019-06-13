package com.standardchartered.crm.utility;

import java.sql.Connection;
import java.sql.DriverManager;
public class Database {

	private static Connection connection;
	
	private Database() {
		
	}
	
	public static Connection getConnection() {
		if (connection == null) {
			try {
				String databaseUrl = "jdbc:mysql://localhost/standardchartered";
				String databaseConfig = "serverTimezone=UTC";
				String databaseUser = "user=root";
				String databasePassword = "";
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(databaseUrl + "?" + databaseConfig + "&" + databaseUser);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Database Error Occurred : " + e.toString());
			} 
		}
		return connection;
	}
}
