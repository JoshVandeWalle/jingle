package com.jingle.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Henry Harvey
 * The Database model makes simplifies database connection
 */

public class Database {
	private String url = "jdbc:mysql://localhost:3306/jingle";
	private String username = "root";
	private String password = "root";

	public Connection getConnection() {
		Connection conn = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection success");
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		return conn;
	}

}
