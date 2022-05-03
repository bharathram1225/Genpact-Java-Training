package com.org.genpact.servlet.day14;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.genpact.bean.day14.Employee_Bean;
import com.org.genpact.dao.day14.Employee_Dao;


@WebServlet("/register")
public class Employee_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee_Dao employee_Dao;
	
	public void init() {
		employee_Dao = new Employee_Dao();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int registeredEmployeeid =0;
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        
        
        Employee_Bean employee_bean = new Employee_Bean();
        employee_bean.setLastname(lastName);
        employee_bean.setFirstname(firstName);
        employee_bean.setUsername(username);
        employee_bean.setPassword(password);
        employee_bean.setPhoneno(contact);
        employee_bean.setAddress(address);
        
        try {
			registeredEmployeeid = employee_Dao.registerEmployee(employee_bean);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
        if(registeredEmployeeid >= 0) {
        	request.setAttribute("firstName",employee_bean.getFirstname());
            request.setAttribute("lastName",employee_bean.getLastname());
            request.setAttribute("username",employee_bean.getUsername());
            request.setAttribute("contact", employee_bean.getPhoneno());
            request.setAttribute("address", employee_bean.getAddress());
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("employeeDetails.jsp");
            requestDispatcher.forward(request, response);
        }
        
	}

}
