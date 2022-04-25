package com.org.genpact.assign.day2;

import java.util.ArrayList;
import java.util.List;

class Sbi{
	
	int accountno;
	String bankname;
	int balance;
	
	public Sbi(int accountno, String bankname, int balance) {
		
		this.accountno = accountno;
		this.bankname = bankname;
		this.balance = balance;
	}	
	
	public void display() {
		System.out.println("accountno "+accountno+" bank name"+bankname+" balance "+balance);
	}
	
}


class Axis{
	
	int accountno;
	String bankname;
	int balance;
	
	
	public Axis(int accountno, String bankname, int balance) {
		super();
		this.accountno = accountno;
		this.bankname = bankname;
		this.balance = balance;
	}
	
	public void display1() {
		System.out.println("accountno "+accountno+" bank name"+bankname+" balance "+balance);
	}
		
}

class Person{
	
	String name, address; 
	Sbi sbi;
	Axis axis;
	public Person(String name, String address, Sbi sbi, Axis axis) {
		super();
		this.name = name;
		this.address = address;
		this.sbi = sbi;
		this.axis = axis;
	}
	
	public void display() {
		System.out.println("Name: "+name+"\nAddress: "+address+"\nSBI\nAccount number: "+sbi.accountno+"\nbank name: "+sbi.bankname+"Balance: "+sbi.balance+"\nAxis\naccount no"+axis.accountno+"\nbank name: "+axis.bankname+"\nbalance: "+axis.balance);
	}	
}



public class BankAssociation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sbi sb = new Sbi(10001, "sbi", 1000);
		Axis ax = new Axis(1200, "axis", 9999);
		
		Person p1 = new Person("Bharath", "Bharathinagar", sb, ax);
		p1.display();

		
		
		

	}

}
