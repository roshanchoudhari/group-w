package com.miniproject.ecommerce;

import java.sql.Connection;

import java.sql.DriverManager;

public class ConnectionTest {
       Connection con = null;
       
       public Connection getConnection() {
    	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}  
    	   return con;
       }
}
