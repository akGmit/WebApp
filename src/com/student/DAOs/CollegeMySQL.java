package com.student.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.student.Models.Course;

import java.sql.ResultSet;

public class CollegeMySQL {
	
	private Connection conn = null;
	private Statement statement;
	private ResultSet result;

	public CollegeMySQL(String dbURL, String user, String password) {
		
		MysqlDataSource mysqlDS = new MysqlDataSource();
		
		mysqlDS.setURL(dbURL);
		mysqlDS.setUser(user);
		mysqlDS.setPassword(password);

		try {
			conn = mysqlDS.getConnection();
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String query){
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void executeUpdate(String update) {
		try {
			statement.executeUpdate(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}




