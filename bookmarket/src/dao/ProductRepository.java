package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Product;

public class ProductRepository {

	private ArrayList<Product> listOfProducts = new ArrayList<Product>();

	// 얘 때문에 계속 서버를 다시 시작해야 반영되었던 것 = 싱글톤이라 : 그래서 지움?
//	private static ProductRepository instance = new ProductRepository();
//	public static ProductRepository getInstance(){
//		return instance;
//	} 

	public ProductRepository() {
		try {
			Connection con = Connectiondb.getConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from product";
			ResultSet rs = stmt.executeQuery(sql);
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
				listOfProducts.add(p);
			}
		} catch (Exception e) {e.printStackTrace();}
	
	}

	public ArrayList<Product> getAllProducts() {
		return listOfProducts;
	}
	
	public Product getProductById(String productId) {
		Product productById = null;

		for (int i = 0; i < listOfProducts.size(); i++) {
			Product product = listOfProducts.get(i);
			if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
				productById = product;
				break;
			}
		}
		return productById;
	}
	
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
}
