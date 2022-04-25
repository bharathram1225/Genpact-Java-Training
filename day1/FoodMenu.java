package com.org.genpact.assign.day1;

import java.util.Scanner;

public class FoodMenu {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("WELCOME TO BHARATIYATASTEBUDES.COM");
			System.out.println("1. South Indian \n2. North Indian\n3. Rajasthani\n4. Bengali\n5. Desserts\n6. exit");
			System.out.println("Enter the choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: 
				System.out.println("------------------------------");
				System.out.println("Welcome to South Indian Food"); 
				System.out.println("you get ....\n 1. Masala Dosa 2 pieces\n 2. Idle vada 1 pieces\n 3. Hyderabadi Biryani 2 pieces\n 4. Paal Payasam 3 pieces");
				System.out.println("------------------------------");
				break;
				
			case 2:
				System.out.println("------------------------------");
				System.out.println("Welcome to Rajasthani Food"); 
				System.out.println("you get ....\n 1. Dal Bati Churma 2 pieces\n 2. Mohan Thaal 1 pieces\n 3. Laal Maas 2 pieces\n 4. Mawa Kachori 2 pieces");
				System.out.println("------------------------------");
				break;
				
			case 3:
				System.out.println("------------------------------");
				System.out.println("Welcome to North Indian Food"); 
				System.out.println("you get ....\n 1. Malpua 2 pieces\n 2. Aloo chat 1 pieces\n 3. Kadai Paneer 2 pieces\n 4. Aloo Gobi 2 pieces");
				System.out.println("------------------------------");
				break;
				
			case 4:
				System.out.println("------------------------------");
				System.out.println("Welcome to North Gujrati Food"); 
				System.out.println("you get ....\n 1. Gujarati Samosa 2 pieces\n 2. Gujarati Kadhi 1 pieces\n 3. Dhokla 2 pieces\n 4. Dal Dhokli 2 pieces");
				System.out.println("------------------------------");
				break;
			
			case 5:
				System.out.println("------------------------------");
				System.out.println("Welcome to Desserts Factory");  
				System.out.println("you get ....\n 1. Lemon Tart 2 pieces\n 2. Pistachio Phirni 1 pieces\n 3. Coconut Kheer 2 pieces\n 4. Chocolate Coffee Truffle 2 pieces");
				System.out.println("------------------------------");
				break;
				
			case 6:
				System.out.println("Exit");
				System.exit(0);
				
			default:
				System.out.println("no dishes avaiable..........");
				
			}
		}
	}

}
