package com.jingle.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private String url = "jdbc:mysql://localhost:3306/jingle";
	private String username = "root";
	private String password = "root";

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
