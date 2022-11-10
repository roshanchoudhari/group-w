package com.miniproject.ecommerce;

import java.sql.SQLException;


import java.util.Scanner;

public class Run {
	 Scanner scanner = new Scanner(System.in);
	
	
	Register re = new Register();
	public void first() throws SQLException {
		Run run = new Run();
		System.out.println(".......................................................................................................................................................................................\n");
		System.out.println("                                   •---Welcome to Annapurna eletronics---");
		System.out.println("\n.....................................................................................................................................................................................\n");
		System.out.println("\n      Main menu");
		System.out.println("     -----------");
		System.out.println("For login :    Press 1 \nFor new user : Press 2\nAdmin login :  Press 3");
		String u = scanner.next();
		Register re = new Register();
		Admin ad = new Admin();
		try {
		if(u.equals("1")) {
			re.userLogin();
		}else if (u.equals("2")) {
			 re.enterUser();
		}else if (u.equals("3")){
			ad.loginAdmin();
		}else {
			throw new InvalidInputException("Please enter a valid number.");
		}	
		}catch(InvalidInputException e) {
			System.err.println(e);
				run.first();
		}	
	}
	
	public void call() throws SQLException {
		Run run = new Run();
		run.first();
	}
	
	public void start() throws InvalidInputException, SQLException {
		
		Register reg = new Register();
		try{
			reg.userLogin();
			}catch(InvalidInputException e) {
				
				System.out.println(e);
			}
	}
	
	public static void main(String[] args) throws InvalidInputException, SQLException {
		Run run = new Run();
		run.call();	
	}

}

