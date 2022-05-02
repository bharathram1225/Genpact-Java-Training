package com.org.genpact.filter.day14;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/Authentication_Filter")
public class Authentication_Filter extends HttpFilter implements Filter {


	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("------------------------------------");
		out.println("Authenticating The Client...!!!");
		out.println("------------------------------------");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(!(username.equalsIgnoreCase("ram") && password.equalsIgnoreCase("ram"))) {
			out.println("You are Not-Authorized user.....");
			out.println("Your Credentials did not match....");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		else {
			out.println("You are Authorized user.....");
			out.println("Your Credentials matched....");
			chain.doFilter(request, response);
		}
		
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
