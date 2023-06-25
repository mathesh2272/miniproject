package com.kce.sport.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static Connection DataConnection() {
		Connection connect = null;
		try {
			String URL = "jdbc:mysql://localhost:3306/mini_project";
			String userName = "root";
			String password = "math2272";
			connect = DriverManager.getConnection(URL, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connect;
	}
}
