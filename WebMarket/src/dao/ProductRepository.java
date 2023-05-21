package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Product;

public class ProductRepository {	

	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> listOfProducts = new ArrayList<Product>();		
		try {			
			Connection con = ConnectionDb.getConnection();
			Statement stmt =  con.createStatement();  // 쿼리 실행
			String sql = "select * from product";
			ResultSet rs =  stmt.executeQuery(sql);				
			
			while (rs.next()) {
				Product p = setProductVo(rs);
				listOfProducts.add(p);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		
		return listOfProducts;
	}

	private Product setProductVo(ResultSet rs) throws SQLException {
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
		return p;
	}
	
	public Product getProductById(String productId) {		
		Product p = null;		
		try {
			Connection con = ConnectionDb.getConnection();
			String sql = "select * from product where productId = ?";			
			PreparedStatement pstmt =  con.prepareStatement(sql);
			pstmt.setString(1, productId);
			ResultSet rs =  pstmt.executeQuery();
			if(rs.next()) {
				p = setProductVo(rs);
			}
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		}
		return p;
		
	}
	
	public void addProduct(Product product) {
		try {
			Connection con = ConnectionDb.getConnection();
			String sql = "insert into product "
					+ "	values("
					+ "	?,?,?,?,?,?,?,?,?"
					+ "	);";
			PreparedStatement pstmt =  con.prepareStatement(sql);
			setPstmt(pstmt,product);
			pstmt.executeUpdate();			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void setPstmt(PreparedStatement pstmt,Product product) throws SQLException {		
		pstmt.setString(1, product.getProductId());
		pstmt.setString(2, product.getPname());			
		pstmt.setInt(3, product.getUnitPrice());
		pstmt.setString(4, product.getDescription());
		pstmt.setString(5, product.getManufacturer());
		pstmt.setString(6, product.getCategory());
		pstmt.setLong(7, product.getUnitsInStock());
		pstmt.setString(8, product.getCondition());
		pstmt.setString(9, product.getFilename());
	}
}
