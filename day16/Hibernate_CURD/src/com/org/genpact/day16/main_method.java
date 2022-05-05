package com.org.genpact.day16;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class main_method {
	
	StandardServiceRegistry ssr;
	Metadata meta;
	SessionFactory sessionfactory;
	Session session;
	Transaction transaction;
	static Scanner sc = new Scanner(System.in);
	
	
	public void connect() {
		ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		meta = new MetadataSources(ssr).getMetadataBuilder().build();
		sessionfactory = meta.getSessionFactoryBuilder().build();
		session = sessionfactory.openSession();
		transaction = session.beginTransaction();
	}
	
	public void insert(int rollno, String name, String address) {
		connect();
		Student_Bean bean = new Student_Bean();
		bean.setId(rollno);
		bean.setName(name);
		bean.setAddress(address);
		session.save(bean);
		transaction.commit();
		System.out.println("Inserted Successfully !!");
	}

	public static void main(String[] args) {
		main_method s = new main_method();
		
		System.out.println("Enter the rollno");
		int rollno = sc.nextInt();
		System.out.println("Enter the name");
		String name = sc.next();
		System.out.println("Enter the address");
		String address = sc.next();
		s.insert(rollno, name, address);
		System.out.println("inserted successfully!!");
		

	}

}
