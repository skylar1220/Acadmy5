<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%> 
<%
	Connection conn = null;	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		String url="jdbc:mysql://localhost:3306/webmarketdb";
		String user="webmarket_admin";
		String password="admin1234";
				
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		
	} catch (SQLException ex) {
		out.println("데이터베이스 연결이 실패되었습니다.<br>");
		out.println("SQLException: " + ex.getMessage());
	}
		
%>