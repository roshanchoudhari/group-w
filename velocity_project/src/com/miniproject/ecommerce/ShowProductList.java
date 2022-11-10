package com.miniproject.ecommerce;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

public class ShowProductList {
	PreparedStatement ps = null;
	Connection con = null ;
	ConnectionTest test = new ConnectionTest();
	// Scanner scan1 = new Scanner(System.in);
	static int sum=0;
	
	public void processCart() throws SQLException {
		//Run run = new Run();
		Scanner scan1 = new Scanner(System.in);
		UserInput use = new UserInput();
		BuyProduct buy =new BuyProduct();
		ShowProductList show = new ShowProductList();
	try {
		System.out.println("Product added to the cartðŸ›’.\n");
		System.out.println("\nDo you want to continue shopping ?\n \nTo continue shopping ðŸ›�ï¸�: Press Y\nTo go to payment page ðŸ’°: Press any other key ");
	
	String  b= scan1.nextLine();;

	  if(b.equals("y")) {
		  buy.buyNow();  
	  }else {
		   for(int s : BuyProduct.list) {
			   sum= sum+s;
			   }
		  
		 Iterator<String> itr = BuyProduct.list2.iterator();
		 Iterator<Integer> itr2 = BuyProduct.list3.iterator();
		 Iterator<Integer> itr3 = BuyProduct.list.iterator();
		 
		  while(itr.hasNext()) {
			 System.out.println("\n"+itr.next()+""+itr2.next()+"\t= "+itr3.next());
			  }
		 System.out.println("----------------------------------------------------------------------------------------------------------------------");
		 System.out.println("-------------------------------------");
		 System.out.println("| Total payable amount is : Rs. "+sum +" |");
		 System.out.println("-------------------------------------");
		 String stringCheck = Register.user;
			String newAddress;
			boolean check = false;
			
			ConnectionTest test2 = new ConnectionTest();
			con=test2.getConnection();
			ps = con.prepareStatement("select * from userdetails"); 
			ResultSet rs =ps.executeQuery();
		
			
			while (rs.next()) {
				 check =stringCheck.equals(rs.getString(2));
				
				if(check==true) {
				System.out.println("\nYour registered address is : "+rs.getString(4));
				}
			}
			
		con.close();
		ps.close();
		rs.close();
			System.out.println("\n\nIf you want to continue with same address ðŸ�  : Press 1\nIf you want to add new Address ðŸ� : Press 2");
	
			String j = scan1.nextLine();
		
				if (j.equals("1")) {
					
					System.out.println("-----------------------------------------------------------------------------------------------\n");
					System.out.println("-------------------------------------");
					System.out.println("| Total payable amount is : Rs. "+ sum+" |");
					System.out.println("| Payment method : Cash on Delivery |");
					System.out.println("-------------------------------------");
					System.out.println("\nTo confirm your order : Press 1\nTo cancel your order and exit : Press any other key");
					String h=scan1.nextLine();
					if(h.equals("1")) {
						System.out.println("Your order is confirmed. âœ”ï¸�\nOrder will be delivered within 4-5 business days. ðŸšš\n\n\nThank You for shooping ðŸ˜€.");
						System.out.println(" Visit again ðŸ™‚...");
						show.quantitySubstraction();
						use.insertBuyHistory();
					}else {
						System.err.println("\nOrder cancelled");
						System.out.println("\n\n         Thank You ðŸ™�ðŸ�»");
						System.out.println("         Visit again ðŸ™‚...");
						System.exit(0);;
					}
					
				}else if (j.equals("2")) {
					System.out.println("Please enter new address");
					newAddress= scan1.nextLine();
					System.out.println("-----------------------------------------------------------------------------------------------");
					System.out.println("Total payable amount is : Rs. "+sum);
					
					System.out.println("Delivery address ðŸ� : "+newAddress);
					System.out.println("Payment method : Cash on Delivery\n\n");
					System.out.println("\nTo confirm your order : Press 1\nTo cancel your order and exit : Press any other key");
					
					String hp=scan1.nextLine();
					if(hp.equals("1")) {
						System.out.println("Your order is confirmed.\nOrder will be delivered within 4-5 business days.\n\n\n\nThank You for shooping ðŸ˜€.");
						System.out.println(" Visit again ðŸ™‚...");
						show.quantitySubstraction();
						use.insertBuyHistory();
					}else {
						System.err.println("Order cancelled");
						System.out.println("\n\n       Thank You ðŸ™�ðŸ�»");
						System.out.println("       Visit again ðŸ™‚...");
						System.exit(0);;
					}
				}else {
					throw new InvalidInputException("Invalid option selected.");	
				}		 
	  }
	  ;	
	  scan1.close();
	  }catch(InvalidInputException e) {
		  System.out.println(e);
		  System.out.println("Please select the products again.");
		  show.processCart();
	  }
		}

	public void quantitySubstraction( ) throws SQLException {
		
		
		int laptop,mobile,printer,moniter,keybord,earphone,smartwatch,chager,powerbank,pendrive;
		
		PreparedStatement p =null;
		
		try {
				con=test.getConnection();
				ps = con.prepareStatement("Select * from product"); 
				p=con.prepareStatement("update product set quantity = ? where product_id=?;");
			
				laptop=BuyProduct.lp-BuyProduct.laptop;
			 p.setInt(1,laptop);
				p.setInt(2,1);
				p.executeUpdate();
	        	   
				mobile = BuyProduct.mo-BuyProduct.mobile;
				p.setInt(1,mobile);
				p.setInt(2,2);
				p.executeUpdate();
				
				printer = BuyProduct.pr-BuyProduct.printer;
				p.setInt(1,printer);
				p.setInt(2,3);
				p.executeUpdate();
				
				moniter = BuyProduct.mn-BuyProduct.moniter;
				p.setInt(1,moniter);
				p.setInt(2,4);
				p.executeUpdate();
				
				keybord = BuyProduct.kb-BuyProduct.keybord;
				p.setInt(1,keybord);
				p.setInt(2,5);
				p.executeUpdate();
				
				earphone = BuyProduct.ep-BuyProduct.earphone;
				p.setInt(1,earphone);
				p.setInt(2,6);
				p.executeUpdate();
				
				smartwatch = BuyProduct.sw-BuyProduct.smartwatch;
				p.setInt(1,smartwatch);
				p.setInt(2,7);
				p.executeUpdate();
				
				chager = BuyProduct.ch-BuyProduct.chager;
				p.setInt(1,chager);
				p.setInt(2,8);
				p.executeUpdate();
				
				powerbank = BuyProduct.pb-BuyProduct.powerbank;
				p.setInt(1,powerbank);
				p.setInt(2,9);
				p.executeUpdate();
				
				pendrive = BuyProduct.pd-BuyProduct.pendrive;
				p.setInt(1,pendrive);
				p.setInt(2,10);
				p.executeUpdate();
				con.close();
				ps.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
