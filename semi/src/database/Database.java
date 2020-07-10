package database;

import java.sql.*;

public class Database {
	public static Connection CON;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			CON = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "semi", "pass");
			System.out.println("connected");
		} catch (Exception e) {
			System.out.println("connection error: " + e.toString());
		}
	}
}
