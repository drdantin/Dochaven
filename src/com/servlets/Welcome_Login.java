package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Welcome_Login extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
									throws ServletException, IOException{
		
		// This getParameter is getting the parameter from Welcome.jsp. The getParameter
		// "gotologin is the name of the login button communicated from Welcome.jsp.
		// From here we go to the login.jsp
		if(request.getParameter("gotologin") != null){
			request.getRequestDispatcher("/login.jsp").forward(request, response);//was /login.jsp
		}
	}
}
