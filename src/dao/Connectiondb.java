package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectiondb {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/webmarketdb";
		String user = "webmarket_admin";
		String psw = "admin1234";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn =  DriverManager.getConnection(url, user, psw);
		return conn;
	}
}
