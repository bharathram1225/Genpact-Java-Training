package com.org.genpact.assign.day11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class OnlineQuiz {
	public final int result = 1;

	public Connection connect() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("Driver loading....");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb", "root",
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

	public void updatedata(int id) {
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement("update quiz set result=? where id=?");
			ps.setInt(1, result);
			ps.setInt(2, id);
			boolean res = ps.execute();
			if (res == false) {
				System.out.println("updated");
			} else {
				System.out.println("no updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ResultSet question() {
		Connection con = connect();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from quiz");
//			rs.next();
//			System.out.println(rs.getInt(1) + " " + rs.getString(2));
			return rs;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public void ScoreCount() {
		Connection con = connect();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select sum(result) from quiz;");
			rs.next();
			int score = rs.getInt(1);
			System.out.println("Your Score is: "+score);
			if(score >=4) {
				System.out.println("Great Job...");
			}
			else {
				System.out.println("Better Luck Next Time...");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void ResetScore() {
		Connection con = connect();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update quiz set result=0;");
			
			System.out.println("Score reset was successfull !!");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OnlineQuiz oq = new OnlineQuiz();
		ResultSet rs = oq.question();
		try {
			System.out.println("----------ONLINE QUIZ--------------");
			for(int i=1; i<=5; i++) {
				rs.next();
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
				String ans1 = sc.next();
				
				if(ans1.equals(rs.getString(3))) {
					System.out.println("you are answer is correct, it is "+rs.getString(3));
					oq.updatedata(i);
				}
				else {
					System.out.println("incorrect answer");
					
				}
			}
			System.out.println("---------------------------------- ");
			
			oq.ScoreCount();
			
			oq.ResetScore();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
