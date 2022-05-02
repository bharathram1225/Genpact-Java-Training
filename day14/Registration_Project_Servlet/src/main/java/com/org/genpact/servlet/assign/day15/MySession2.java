package com.org.genpact.servlet.assign.day15;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MySession2")
public class MySession2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession(false);
			String uname = (String) session.getAttribute("uname");
			String lname = (String) session.getAttribute("lname");
			String profession = (String) session.getAttribute("profession");
			out.print("Welcome " + uname + " " + lname + " " + "Appricate your working as " + profession);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
