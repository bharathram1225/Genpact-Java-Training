package com.org.genpact.assign.day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeInformation {
	
	public Connection connect() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("Driver loading....");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/genpacttrainingofficial", "root",
					"082021");
//			System.out.println("Connection establishing");

			return con;
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("connect is not established...");
			return null;
		}
	}
	
	
	public void EmployeeDept() {
		Connection con = connect();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from emp_info where empid not in(select empid from dept)");
			rs.next();
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			
			
		} catch (Exception e) {
			
		}
	}
	
	
	public void EmployeeCount(String dname) {
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement("select count(e.empid) from dept d, emp_info e where d.empid=e.empid and d.dname=?;");
			
			ps.setString(1, dname);
			ResultSet rs = ps.executeQuery();
			rs.next();
			System.out.println("the number of employees are in "+dname+" :"+rs.getInt(1));
			
			
			
		} catch (Exception e) {
			
		}
	}
	

	public static void main(String[] args) {
		EmployeeInformation ei = new EmployeeInformation();
		System.out.println("Employee records who dont have project");
		ei.EmployeeDept();
		ei.EmployeeCount("devops");


	}

}
