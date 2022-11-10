package com.miniproject.ecommerce;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Admin {
	

		PreparedStatement ps = null;
		Connection con = null ;
		Scanner scanner = new Scanner(System.in);
		String user2;
		String pass2;
		String name;

		public void loginAdmin() throws SQLException, InvalidInputException
		{
			String user;
			
			String pass;
			boolean us=false;
			 boolean su=false;
			Admin ad  = new Admin(); 
			Run run = new Run ();
			try {	
				ConnectionTest test = new ConnectionTest();
				con=test.getConnection();
				ps = con.prepareStatement("select * from admin_details"); 
				ResultSet rs =ps.executeQuery();
				System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("         Admin Login\n");
				System.out.println("Please enter your username : ");
				user=scanner.nextLine();
				System.out.println("Please enter your password : ");
				pass=scanner.nextLine();
				while (rs.next()) {
					 us =user.equals(rs.getString(3));
					su = pass.equals(rs.getString(4));	
					if(us==true) {
						name=rs.getString(2);
						user2=rs.getString(3);
						pass2=rs.getString(4);
					}
				}
				if(user.equals(user2)&&pass.equals(pass2)) {
					System.out.println("\nLogin successful\n");
					System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("\nWelcome! "+name+",Please select an option :\n");
					System.out.println("Press 1 : for checking customer details\nPress 2 : for checking product quantity remaining\nPress 3 : for checking the user buy history\nPress any other key to exit");
				String qq= scanner.nextLine();
				if(qq.equals("1")) {
					ad.fetchCustomerDetails();
				}else if (qq.equals("2")){
					ad.productQuantity();
				}else if (qq.equals("3")){
				     ad.getBuyHistory();
				}else {
					System.out.println("\n\n\n         Thank You ...");
					System.exit(0);
				}
				}else {
					throw new InvalidInputException("Invalid username or password");	
				}
			} catch (InvalidInputException e) {
				System.out.println(e);
				
				System.out.println("Press 1 : To login again");
				System.out.println("Press any other key to exit");
				
				String k =scanner.nextLine();
				if(k.equals("1")) {
					ad.loginAdmin();
				}else{
					run.first();
				}
			}	
			}
			
		
		public void fetchCustomerDetails() {
			Admin ad  = new Admin();
			Run run = new Run ();
		int	count = 1; 
			try {
				ConnectionTest test = new ConnectionTest();
			con=test.getConnection();
			ps = con.prepareStatement("select * from userdetails"); 
			ResultSet rs =ps.executeQuery();
			System.out.println("\n\n\nUser List : ");
			System.out.println("----------\n");
			while (rs.next()) {
				
				System.out.println(count+".");
				System.out.println("Name : "+rs.getString(1));
				System.out.println("UserName :"+rs.getString(2));
				System.out.println("MobileNumber :"+rs.getLong(5));
				System.out.println("Address :"+rs.getString(4));
				count++;
				System.out.println("--------------------------");
			}
			
			System.out.println("\n\n\nPress 1 : To check product quantity.");
			System.out.println("Press 2 : To check product buy history. ");
			System.out.println("Press 3 : To go to Home page. ");
			System.out.println("Press any other key to exit.");
			
			String k =scanner.nextLine();
			if(k.equals("1")) {
				ad.productQuantity();
			}else if (k.equals("2")) {
			ad.getBuyHistory();
			
			}else if (k.equals("3")) {
				run.first();
			}else{
				System.out.println("\n\n\n         Thank You ...");
				System.exit(0);
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		public void productQuantity() {
			Admin ad  = new Admin();
			Run run = new Run ();
			try {
				ConnectionTest test = new ConnectionTest();
				con=test.getConnection();
				ps = con.prepareStatement("select * from product"); 
				ResultSet rs =ps.executeQuery();
				System.out.println("\n\n\nProduct quantity remaining : ");
				System.out.println("----------------------------\n");
				
				while(rs.next()) {
					
					System.out.println("Name :"+rs.getString(2));
					System.out.println("Quantity :"+rs.getInt(5));
					System.out.println("--------------------------");
				}
				System.out.println("\n\n\nPress 1 : To check cutomer details.");
				System.out.println("Press 2 : To check product buy history. ");
				System.out.println("Press 3 : To go to Home page. ");
				System.out.println("Press any other key to exit.");
				
				String k =scanner.nextLine();
				if(k.equals("1")) {
					ad.fetchCustomerDetails();
				}else if (k.equals("2")) {
				ad.getBuyHistory();
				
				}else if (k.equals("3")) {
					run.first();
				}else{
					System.out.println("\n\n\n         Thank You ...");
					System.exit(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		public void getBuyHistory() {
			Admin ad  = new Admin();
			Run run = new Run ();
			try {
				ConnectionTest test = new ConnectionTest();
				con=test.getConnection();
				ps = con.prepareStatement("select * from buyhistory"); 
				ResultSet rs =ps.executeQuery();
				System.out.println("\n\\n\nBuy history : ");
				System.out.println("-------------\n");
				while(rs.next()) {
					
					System.out.println("ProductId :"+rs.getInt(3));
					System.out.println("Quantity :"+rs.getInt(4));
					System.out.println("Username :"+rs.getString(2));
					System.out.println("--------------------------");
				}
				
				System.out.println("\n\n\nPress 1 : To check cutomer details.");
				System.out.println("Press 2 : To check product quantity. ");
				System.out.println("Press 3 : To go to Home page. ");
				System.out.println("Press any other key to exit.");
				
				String k =scanner.nextLine();
				if(k.equals("1")) {
					ad.fetchCustomerDetails();
				}else if (k.equals("2")) {
				ad.productQuantity();
				
				}else if (k.equals("3")) {
					run.first();
				}else{
					System.out.println("\n\n\n         Thank You ...");
					System.exit(0);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	

}
