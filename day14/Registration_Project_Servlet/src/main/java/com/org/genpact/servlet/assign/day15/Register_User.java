package com.org.genpact.servlet.assign.day15;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Register_User")
public class Register_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

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



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
		Connection con = connect();
		PreparedStatement ps = con.prepareStatement("insert into user_reg values (?,?)");
		ps.setString(1,name);
		ps.setString(2, password);
		
		int result = ps.executeUpdate();
		if(result>0) {
			out.print("<div class=\"success\" style=\"height: 50px;background: green;color: white;font-size: 25px;text-align: center;padding: 8px;\">successfully user is registered</div>");
		}
		else {
			out.print("un-successfully user is registered");
			RequestDispatcher rd = request.getRequestDispatcher("file.html");
			rd.include(request, response);
		}
		
		con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		out.close();
		
	}

}
