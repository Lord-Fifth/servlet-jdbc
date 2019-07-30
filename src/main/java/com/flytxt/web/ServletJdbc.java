package com.flytxt.web;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.*;

// Import Database Connection Class file 
import com.flytxt.web.DatabaseConnection; 

// Servlet Name 
@WebServlet("/InsertData") 
public class ServletJdbc extends HttpServlet { 
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		try { 

			// Initialize the database 
			Connection con = DatabaseConnection.initializeDatabase(); 

			// Create a SQL query to insert data into demo table demo table consists of two columns, so two '?' is used 
			PreparedStatement st = con.prepareStatement("INSERT INTO employees VALUES(?, ?, ?, ?, ?, ?)"); 

			// For the parameter, get the data using request object
			st.setInt(1, Integer.valueOf(request.getParameter("no"))); 
			st.setString(2, request.getParameter("bdate")); 
			st.setString(3, request.getParameter("fname")); 
			st.setString(4, request.getParameter("lname")); 
			st.setString(5, request.getParameter("gen")); 
			st.setString(6, request.getParameter("hdate")); 
			
			// Execute the insert command using executeUpdate() to make changes in database 
			st.executeUpdate(); 

			// Close all the connections 
			st.close(); 
			con.close(); 

			// Get a writer pointer to display the successful result 
			PrintWriter out = response.getWriter(); 
			out.println("<html><body><h2>Successfully Inserted</h2></body></html>"); 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
} 
