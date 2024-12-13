package com.java.programmes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCode {
	
	public static void main(String[] args) {
		String URL="jdbc:mysql://localhost:8080/databasename";
		String name="username";
		String password="password";
		String sqlQuery="Select * from table";
		try {
			Connection connection= DriverManager.getConnection(URL, sqlQuery, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet =statement.executeQuery(sqlQuery);
			while(resultSet.next()) {
				Integer id=resultSet.getInt("Id");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
