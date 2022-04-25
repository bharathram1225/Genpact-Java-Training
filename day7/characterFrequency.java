package com.org.genpact.assign.day7;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class characterFrequency {
	public static void main(String[] args) {

		String s;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String :");
		s = sc.nextLine();
		TreeMap<Character, Integer> freq = new TreeMap<>();
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
				freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
			}
		}
		for (Map.Entry<Character, Integer> x: freq.entrySet()) {
			System.out.print(x.getKey() + ": ");
			for (int i = 0; i < x.getValue(); i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
