package com.miniproject.ecommerce;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.util.Iterator;

public class UserInput {

	PreparedStatement ps = null;
	Connection con = null ;
		

	
	public void insertCustomerDetails(String firstName, String Username, String Password, String Address, long phoneNo) {
	
		try {
			
			ConnectionTest test = new ConnectionTest();
			con=test.getConnection();
			
			ps = con.prepareStatement("insert into userdetails(firstName,Username,Password,Address,phoneNo)values(?,?,?,?,?)");
			
			ps.setString(1 , firstName);
			ps.setString(2 , Username );
			ps.setString(3 ,Password);
			ps.setString(4 , Address );
			ps.setLong(5 , phoneNo);
		int i = ps.executeUpdate();	
		
		
		System.out.println("\n\nRegistration Successful");
		
		con.close();
		ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void insertBuyHistory() {
		try {
		ConnectionTest test = new ConnectionTest();
		con=test.getConnection();
		ps = con.prepareStatement("INSERT into buyhistory (username,product_id,quantity)values(?,?,?) ");
		
		Iterator<Integer> itr = BuyProduct.list4.iterator();
		 Iterator<Integer> itr2 = BuyProduct.list3.iterator();
		
		while(itr.hasNext()) {
			
			
			ps.setString(1 , Register.user);
			ps.setInt(2, itr.next());
			ps.setInt(3, itr2.next());
			ps.executeUpdate();
		}
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		}
	
}
