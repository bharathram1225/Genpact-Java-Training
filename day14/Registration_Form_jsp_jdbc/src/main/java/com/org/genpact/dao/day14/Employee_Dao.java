package com.org.genpact.dao.day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.org.genpact.bean.day14.Employee_Bean;

public class Employee_Dao {
	public Connection connect() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loading....");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationdb", "root",
					"082021");
			System.out.println("Connection establishing");

			return con;
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("connect is not established...");
			return null;
		}
	}
	
	
	public int registerEmployee(Employee_Bean employee_bean) throws ClassNotFoundException{
		
		Connection con = connect();
		int result =0;
		String INSERT_USERS_SQL = "INSERT INTO Employee" +"  (first_name, last_name, username, password, address, contact) VALUES " +" (?, ?, ?, ?,?,?);";
		try {
		PreparedStatement preparedStatement =  con.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, employee_bean.getFirstname());
			preparedStatement.setString(2, employee_bean.getLastname());
			preparedStatement.setString(3, employee_bean.getUsername());
			preparedStatement.setString(4, employee_bean.getPassword());
			preparedStatement.setString(5, employee_bean.getAddress());
			preparedStatement.setString(6, employee_bean.getPhoneno());
			
			result = preparedStatement.executeUpdate();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
		
	}
	
	
}
