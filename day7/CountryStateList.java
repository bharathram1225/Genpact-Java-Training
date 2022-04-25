package com.org.genpact.assign.day7;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountryStateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter the number of entities");
		int size = sc.nextInt();
		
		
		TreeMap<String, TreeSet<String>> listmain = new TreeMap<>();
		for(int i=0;i<size;i++) {
			System.out.println("Enter the country name "+i+" :");
			String country = sc.next();
			
			System.out.println("Enter the state name "+i+" :");
			String state = sc.next();
			
			TreeSet<String> statelist = listmain.getOrDefault(country, new TreeSet<String>());
			statelist.add(state);
			listmain.put(country, statelist);
			
		}
		
		
		for(Map.Entry<String, TreeSet<String>> list: listmain.entrySet()) {
			System.out.print(list.getKey()+"\n");
			for(String state: list.getValue()) {
				System.out.println("---"+state);
			}
		}
	}

}
