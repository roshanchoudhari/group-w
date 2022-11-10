package com.miniproject.ecommerce;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.miniproject.ecommerce.InvalidInputException;
public class BuyProduct {
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	Connection con = null ;
	   static	String a ;

	// Scanner scan = new Scanner(System.in);
	   static int lp,mo,pr,mn,kb,ep,sw,ch,pb,pd; 
		static int laptop,mobile,printer,moniter,keybord,earphone,smartwatch,chager,powerbank,pendrive;
	static List<Integer> list = new ArrayList<Integer>();
	static List<String> list2 = new ArrayList<>();
	static List<Integer> list3 = new ArrayList<>();
	static List<Integer> list4 = new ArrayList<>();
	
	ShowProductList show = new ShowProductList();
 
	
	
 public void buyNow() {
	 
		BuyProduct by = new BuyProduct();
		int count =1;
		try {
			ConnectionTest test = new ConnectionTest();
			con=test.getConnection();
			ps = con.prepareStatement("select * from product"); 
			ResultSet rs =ps.executeQuery();
			System.out.println("---------------------------");
			System.out.println("|   ***Product list***    |");
			System.out.println("---------------------------");
			while(rs.next()) {
				
				System.out.println("Product Id :"+rs.getString(1));
				System.out.println("Product Name :"+rs.getString(2));
				System.out.println("Description :"+rs.getString(3));
				System.out.println("Price :Rs."+rs.getString(4));
				System.out.println("To add this product to cart press : "+ count);
				count++;
				System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			}
			con.close();
			ps.close();
			rs.close();
		by.processCart();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
 
 
	public void processCart() throws SQLException {
		Scanner scan = new Scanner(System.in);

		BuyProduct buy = new BuyProduct();
		
		ConnectionTest test = new ConnectionTest();
		con=test.getConnection();
		ps3 = con.prepareStatement("update product set quantity = ? where product_id=?;"); 
		ps2 = con.prepareStatement("select * from product"); 
		ResultSet sr =ps2.executeQuery();
		try {
			while (sr.next()) {
				 if(1==sr.getInt(1)) {
				lp = sr.getInt(5);
			    }else if (2==sr.getInt(1)) {
				mo =sr.getInt(5);
			    }else if (3==sr.getInt(1)) {
				pr =sr.getInt(5);
				}else if(4==sr.getInt(1)) {
					mn =sr.getInt(5);
				}else if(5==sr.getInt(1)) {
					kb =sr.getInt(5);
				}else if(6==sr.getInt(1)) {
					ep =sr.getInt(5);
				}else if(7==sr.getInt(1)) {
					sw =sr.getInt(5);
				}else if(8==sr.getInt(1)) {
					ch =sr.getInt(5);
				}else if(9==sr.getInt(1)) {
					pb=sr.getInt(5);
				}else if(10==sr.getInt(1)) {
					pd=sr.getInt(5);
				}
				}
			System.out.println("\nPlease press a number to add product to cart 🛒:");
			a = scan.next();
			System.out.println("Please enter the quantity :");
			
		if (a.equals("1")) {
			laptop=scan.nextInt();
			if(laptop>lp || laptop<0) {
				
			throw new InvalidInputException("Please select quantity less than "+lp);
			
			}else {
				list.add(49999*laptop);
				list2.add("My laptop >> -> Qty   ");
				list3.add(laptop);
				list4.add(1);
				
			}
			}else if (a.equals("2")) {
			mobile=scan.nextInt();
			if(mobile<mo && mobile>0) {
			list.add(14999*mobile);
			list2.add("My mobile >>  -> Qty    ");
			list3.add(mobile);
			list4.add(2);
			
			}else {
			
				throw new InvalidInputException("please select quantity less than "+mo);
			}
			}else if (a.equals("3")) {
			printer=scan.nextInt();
			if(printer<pr && printer>0) {
			list.add(14000*printer);
			list2.add("printer >> -> Qty  ");
			list3.add(printer);
			list4.add(3);
			
			}else {
			
				throw new InvalidInputException("please select quantity less than "+pr);
			}
			}else if (a.equals("4")) {
			moniter=scan.nextInt();
			if(moniter<mn && moniter>0) {
			list.add(4999*moniter);
			list2.add("moniter  >> -> Qty");
			list3.add(moniter);
			list4.add(4);
		
			}else {
				
				throw new InvalidInputException("please select quantity less than "+mn);
			}
			}else if (a.equals("5")) {
			keybord=scan.nextInt();
			if(keybord<kb && keybord>0) {
			list.add(799*keybord);
			list2.add("keybord >> -> Qty");
			list3.add(keybord);
			list4.add(5);

			}else {
				
				throw new InvalidInputException("please select quantity less than "+kb);
			}
			}else if (a.equals("6")) {
			earphone=scan.nextInt();
			if(earphone<ep && earphone>0) {
			list.add(400*earphone);
			list2.add("earphone >> -> Qty");
			list3.add(earphone);
			list4.add(6);

			}else {
				
				throw new InvalidInputException("please select quantity less than "+ep);
			}
			}else if (a.equals("7")) {
			smartwatch=scan.nextInt();
			if(smartwatch<sw && smartwatch>0) {
			list.add(40000*smartwatch);
			list2.add("smartwatch >> -> Qty  ");
			list3.add(smartwatch);
			list4.add(7);
		
			}else {
				
				throw new InvalidInputException("please select quantity less than "+sw);
			}
			}else if (a.equals("8")) {
			chager=scan.nextInt();
			if(chager<ch && chager>0) {
			list.add(1000*chager);
			list2.add("chager >> -> Qty    ");
			list3.add(chager);
			list4.add(8);
		
			}else {
				
				throw new InvalidInputException("please select quantity less than "+ch);
			}
			}else if (a.equals("9")) {
			powerbank=scan.nextInt();
			if(powerbank<pb && powerbank>0) {
			list.add(1599*powerbank);
			list2.add("powerbank >> -> Qty     ");
			list3.add(powerbank);
			list4.add(9);

			}else {
				
				throw new InvalidInputException("please select quantity less than "+pb);
			}
			}else if (a.equals("10")) {
			pendrive=scan.nextInt();
			if(pendrive<pd && pendrive>0) {
			list.add(1299*pendrive);
			list2.add("pendrive  >>-> Qty      ");
			list3.add(pendrive);
			list4.add(10);

			}else {
				scan.close();
				throw new InvalidInputException("please select quantity less than "+pd);
			}
		}else {
			
			throw new InvalidInputException("Invalid option selected");
			
		}
		show.processCart();
			}catch(InvalidInputException e) {
			  System.err.println("\n\n"+e);
			  
			  System.out.println("\n\nPress 1 : To select the product again.");
				
				System.out.println("Press any other key to exit.");
				
				String k =scan.next();
				if(k.equals("1")) {
					buy.buyNow();
				}else{
					System.out.println("\n\n\n         Thank You ...\n         Visit again...");
					System.exit(0);
				}
		  }	
	}
}

