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
		Connection con = ConnectionDb.getConnection();
		Statement stmt =  con.createStatement();  // 쿼리 실행
		String sql = "select * from product";
		ResultSet rs =  stmt.executeQuery(sql);		
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
