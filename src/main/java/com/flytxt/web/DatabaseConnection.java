package com.flytxt.web;

import java.sql.*;

// This class can be used to initialize the database connection 
public class DatabaseConnection { 
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException 
	{ 
		// Initialize all the information regarding Database Connection 
		String dbDriver = "com.mysql.cj.jdbc.Driver"; 
		String dbURL = "jdbc:mysql://localhost/demodb"; 
		// Database name to access 
		String dbUsername = "aditya"; 
		String dbPassword = "root123"; 

		Class.forName(dbDriver); 
		Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword); 
		return con; 
	} 
} 
