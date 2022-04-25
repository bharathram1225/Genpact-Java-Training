package com.org.genpact.assign.day5;

import java.util.Scanner;

class salarygreaterexception extends Exception {
	public salarygreaterexception(int salary) {
		final int standard_salary = 50000; 
		if(salary >= standard_salary) {
			System.out.println("you are eligible for the 8LPA scheme");
			int installment = (int) (0.15*salary);
			System.out.println("One year installment is :"+installment);
		}
		else {
			System.out.println("you are eligible for the 3LPA scheme");
			int installment = (int) (0.15*salary);
			System.out.println("One year installment is :"+installment);
		}
	}
}



class EmployeeGenpact{
	String name;
	int salary;
	
	public EmployeeGenpact(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public void salaryvalidate(int salary) throws salarygreaterexception
	{
			if(salary > 70000)
			{
				System.out.println("The salary is > 70,000/-");
				throw new salarygreaterexception(salary);
			}
			else {
				System.out.println("The salary is < 70,000/-");
				throw new salarygreaterexception(salary);
			}
	}
}



public class EmployeeSal {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<2;i++) {
		try {
			
		System.out.println("Enter you name : ");
		String name = sc.next();
		System.out.println("Enter your salary :");
		int salary = sc.nextInt();
		EmployeeGenpact e1 = new EmployeeGenpact(name,salary);
		
		
			e1.salaryvalidate(salary);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
	}
	
}
