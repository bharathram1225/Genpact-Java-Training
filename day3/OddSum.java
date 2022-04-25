package com.org.genpact.assign.day3;

import java.util.Scanner;

class value{
	public static int checksum(int number) {
		int total =0;
		while(number>0) {
			int rem=number%10;
			if(rem%2!=0) {
				total=total+rem;
			}
			number=number/10;
		}
		
		if(total%2==0) 
			return 1;
		return -1;
			
	}
}

public class OddSum {
	public static void main(String[] args) {
		System.out.println("Enter the Digits");
		Scanner s = new Scanner(System.in);
		int number=s.nextInt();
		int res = value.checksum(number);
		
		
		if(res ==1) {
			System.out.println("sum of odd digits is even");}
			else {
				System.out.println("sum of odd digits is odd");
			}
		}
}
