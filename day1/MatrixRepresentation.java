package com.org.genpact.assign.day1;

import java.util.Scanner;

public class MatrixRepresentation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the row size: ");
		int m = sc.nextInt();
		System.out.println("Enter the column size: ");
		int n = sc.nextInt();
		
		int originalMatrix[][] = new int[m][n];
		int transposeMatrix[][] = new int[n][m];
		
		int counter = 1; int sum = 0; 
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.println("Enter the element of "+counter+" :");
				originalMatrix[i][j] = sc.nextInt();
				sum +=originalMatrix[i][j];
				counter++;
			}
		}
		
		System.out.println("printing in matrix format");
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(originalMatrix[i][j]+" ");
			}
			System.out.println("");
		}
		
		
		System.out.println("printing in transpose matrix format");
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				transposeMatrix[j][i] = originalMatrix[i][j];
			}
		}
		
		System.out.println("printing in transpose matrix");
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(transposeMatrix[i][j]+" ");
			}
			System.out.println("");
		}
		
		
		System.out.println("The sum of the matrix is :"+sum);
		
		
	}
	
	
	
	

}
