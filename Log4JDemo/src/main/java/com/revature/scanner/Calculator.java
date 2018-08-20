package com.revature.scanner;

import java.util.Scanner;

import org.apache.log4j.Logger;


public class Calculator {
	
	
	private static Scanner sc = new Scanner(System.in);
	
	
	private static Logger log = Logger.getRootLogger();
	
	public void calculate() {
		log.info("Please enter the operation that you would like to perform");
//		System.out.println("Please enter the operation that you would like to perform");
		String operation = sc.nextLine();
		
		int[] numbs = getNumbs();
		
		switch (operation) {
		case "addition": //get and add
			System.out.println(numbs[0] + " + " + numbs[1] + " = " + (numbs[0] + numbs[1]));
			break;
		case "subtraction":
			System.out.println(numbs[0] + " - " + numbs[1] + " = " + (numbs[0] - numbs[1]));
			break;
		case "multiplication": 
			System.out.println(numbs[0] + " * " + numbs[1] + " = " + (numbs[0] * numbs[1]));
			break;
		case "division":
			if (numbs[1] == 0) {
				System.out.println("Cannot divide by 0");
			}
			else {
				System.out.println(numbs[0] + " / " + numbs[1] + " = " + (numbs[0] / numbs[1]));
			}
			break;
		default: 
			System.out.println("Not valid operation");
		}
		
	} // end of calculate
	
	private int[] getNumbs() {
		int[] numbs = new int[2];
		log.fatal("Enter First Number!!!");
		System.out.println("Please Enter First Number");
		numbs[0] = getNumb();
		System.out.println("Please Enter Second Number");
		numbs[1] = getNumb();
		return numbs;
	}
	
	
	private int getNumb() {
		int returnVal = 0;
		
		boolean goodValue = false;
		// The string that holds the input
//		String intputString = "";
		
		// Throws a number format exception
		while (!goodValue) {
			try {
				returnVal = Integer.parseInt(sc.nextLine());
				goodValue = true;
			} catch (NumberFormatException e) {
				System.err.println("Invalid innput");
			}
		}
			
		return returnVal;
	}
	
	
}
