package com.qa.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;



public class db  {

	private static final String URL =
            "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres123";


	 public static Connection getConnection() {
	        try {
	            return DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (SQLException e) {
	            throw new RuntimeException("DB Connection Failed");
	        }
	    }
	
	 public static Map<String, String> getLoginUser() {

	        Map<String, String> credentials = new HashMap<>();

	        String query =
	          "select * from loginCredential where id = 1;";

	        try (Connection con = getConnection();
	             Statement stmt = con.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {

	            if (rs.next()) {
	                credentials.put("username", rs.getString("username"));
	                credentials.put("password", rs.getString("password"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return credentials;
	 }
//	public static void main(String args[])throws SQLException {
//		
//		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres123");
//				
//				//("jdbc:mysql://" + "localhost" + ":"+ "5432" + "/myserver", "postgres", "postgres123");
//		Statement s = con.createStatement();
//		ResultSet rs = s.executeQuery("select * from loginCredential where id = 1;");
//		while(rs.next()){
//		System.out.println(rs.getString("username"));
//		System.out.println(rs.getString("password"));
//	}
//	}
}
