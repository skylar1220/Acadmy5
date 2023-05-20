package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Product;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = Connectiondb.getConnection();
		Statement stmt = con.createStatement();
		String sql = "select * from product";
		ResultSet rs = stmt.executeQuery(sql);
		List<Product> productLists = new ArrayList<>();
		while (rs.next()) {
			Product p = new Product(
					rs.getString("productId"), 
					rs.getString("pname"), 
					rs.getInt("unitPrice"),
					rs.getString("descriptions"),
					rs.getString("manufacturer"), 
					rs.getString("category"), 
					rs.getLong("unitsInStock"),
					rs.getString("conditions"), 
					rs.getString("filename")
					);
			productLists.add(p);
		}
		System.out.println(productLists);
	}

}

//System.out.println(
//		rs.getString("productId") + " " +  rs.getString("pname") + " " + 
//		rs.getInt("unitPrice") + " " + rs.getString("descriptions") + " " + 
//		rs.getString("manufacturer") + " " + rs.getString("category") + " " + 
//		rs.getLong("unitsInStock") + " " + rs.getString("conditions") + " " + 
//		rs.getString("filename") 
//);

//public void db() {
//	try {
//		Connection conn = Connectiondb.getConnection();
//		Statement stmt = conn.createStatement();
//		String str = " update product set  unitPrice = 123 where productId = 'P1236'";
//		ResultSet rs = null;
//		int result =  stmt.executeUpdate(str);
//		if (result > 0 ) {
//			System.out.println("데이터 삽입 성공");
//		} else {
//			System.out.println("데이터 삽입 실패");
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//}