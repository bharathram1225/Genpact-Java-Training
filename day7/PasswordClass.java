package com.org.genpact.assign.day7;

import java.util.Scanner;

public class PasswordClass {
	public static final int PASSWORD_LENGTH = 8;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("1. A password minimun eight characters.\n"
				+ "2. A password with 1 uppercase, 1 lowercase, 1 special and 1 digit atleast\n"
				+ "Input a password: ");
		String s = input.nextLine();

		if (is_Valid_Password(s)) {
			System.out.println("Password is valid: " + s);
		} else {
			System.out.println("Not a valid password: " + s);
		}

	}

	public static boolean is_Valid_Password(String password) {

		if (password.length() < PASSWORD_LENGTH)
			return false;

		int charCount = 0, upcnt = 0, specialCnt = 0;
		int numCount = 0;
		for (int i = 0; i < password.length(); i++) {

			char ch = password.charAt(i);

			if (is_Numeric(ch))
				numCount++;
			else if (is_Letter(ch))
				charCount++;
			else if (is_Letter_upper(ch))
				upcnt++;
			else if (is_Special(ch))
				specialCnt++;
			else
				return false;
		}

		return (charCount >= 1 && numCount >= 1 && specialCnt >= 1 && upcnt >= 1);
	}

	public static boolean is_Letter(char ch) {
		return (ch >= 'a' && ch <= 'z');
	}

	public static boolean is_Letter_upper(char ch) {
		ch = Character.toUpperCase(ch);
		return (ch >= 'A' && ch <= 'Z');
	}

	public static boolean is_Special(char ch) {
		String a = "@#$%^&*(";
		for (int i = 0; i < a.length(); i++) {
			if (ch == a.charAt(i))
				return true;
		}
		return false;
	}

	public static boolean is_Numeric(char ch) {

		return (ch >= '0' && ch <= '9');
	}

}
