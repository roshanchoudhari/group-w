package com.miniproject.ecommerce;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Register {
	
	static String user ;
	static String pass;
	String add;
	String a;
	String b;
	
	public void userLogin() throws InvalidInputException, SQLException {
		PreparedStatement ps = null;
		Connection con = null ;
		Scanner scann = new Scanner(System.in);
		 boolean us=false;
		 boolean su=false;
		BuyProduct pro =new BuyProduct();
		Register reg = new Register();
		Run run = new Run();
		
			
			ConnectionTest test = new ConnectionTest();
			con=test.getConnection();
			System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("           Login\n");
			System.out.println("Please enter your username : ");
			user=scann.nextLine();
			System.out.println("Please enter your password : ");
			pass=scann.nextLine();
			ps = con.prepareStatement("select * from userdetails"); 
			ResultSet rs =ps.executeQuery();
			while (rs.next()) {
				 us =user.equals(rs.getString(2));
				su = pass.equals(rs.getString(3));
				if(us==true&&su==true) {
					 a = rs.getString(2);
					 b = rs.getString(3);
				}	
			}
			con.close();
			ps.close();
			rs.close();
		
			if((user.equals(a))&&(pass.equals(b))){
			System.out.println("\nLogin successful\n");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------\n");
			pro.buyNow();}else {
			System.err.println("\nInvalid username or password");
			
			System.out.println("\nPress 1 : To login again");
			System.out.println("Press 2 : To register new user");
			System.out.println("Press any other key to go to main menu");
			String k =scann.next();
			if(k.equals("1")) {
			reg.userLogin();
			}else if (k.equals("2")) {
				reg.enterUser();
			}else{
				run.call();
			}
			
			}
				scann.close();
			
			
		} 
		
		
	
	
	
	public void enterUser()throws InvalidInputException, SQLException {
		Scanner scann = new Scanner(System.in);
		UserInput us = new UserInput();
		Register tp = new Register();
		Run run = new Run();
		
CustomerDetails register = new CustomerDetails();
		try
		{
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------\n");
			System.out.println("\nNew user registration :");
			System.out.println("-----------------------");
			System.out.print("\nEnter firstName : ");
			String firstName = scann.nextLine();
			register.setFirstName(firstName);
			
			System.out.print("Enter userName : ");
			String userName = scann.nextLine();
			register.setUserName(userName);
			
			System.out.print("Enter password : ");
			String password = scann.nextLine();
			register.setPassword(password);
			
			System.out.print("Enter address   : ");
			String address = scann.nextLine();
			register.setAddress(address);
			
			System.out.print("Enter phoneNo : ");
			long phoneNo = scann.nextLong();
			register.setPhoneNo(phoneNo);
			
			us.insertCustomerDetails(firstName,userName,password,address,phoneNo);
			
			System.out.println("Please login to continue.");
			tp.userLogin();
			scann.close();
		}catch(Exception e) {
			System.err.println("Please provide correct input.");
			run.first();
}
	}
}