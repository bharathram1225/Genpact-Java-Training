package com.org.genpact.filter.day14;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/LogFilter")
public class LogFilter extends HttpFilter implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("------------------------------------");
		out.println("Capturing Log of Client Machine... !!!!");
		out.println("------------------------------------");
		String ipaddress = request.getRemoteAddr();
		String hostname = request.getRemoteHost();
		String protocol = request.getProtocol();
		
		out.println("The IP Address of Client Machine: "+ipaddress);
		out.println("The hostname of Client Machine: "+hostname);
		out.println("The protocol used by Client Machine: "+protocol);
		out.println("====================================");
		out.println("Data is Successfully Logged");
		out.println("====================================");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
