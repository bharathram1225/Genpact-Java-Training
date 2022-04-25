package com.org.genpact.assign.day1;

import java.util.Scanner;

public class LetterPattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the rows:");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=n;j>i;j--) {
				System.out.print(" ");
			}
			for(int k=0;k<=i;k++) {
				if(i==4 || k==0 || k==i) {
					System.out.print(""+"**");
				}
				else {
					System.out.print(" "+" ");
				}
			}
			System.out.println();
		}

	}

}
