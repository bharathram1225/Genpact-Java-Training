package com.org.genpact.assign.day3;

import java.util.Scanner;

public class PatternCheck {
	 public static void main(String[] args) {
		  System.out.println("Enter the digits:");
	    Scanner sc = new Scanner(System.in);
	     String s1 = sc.nextLine();
	    
	    if(s1.matches("[0-9]{3}[-]{1}[0-9]{3}[-]{1}[0-9]{4}")){
	      System.out.println("Valid number format");
	    }else{
	      System.out.println("Worng number format");
	    }
	  }
}
