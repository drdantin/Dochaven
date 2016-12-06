package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Direct_Login_R_Create_Servlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
									throws ServletException, IOException{
		
		
		if(request.getParameter("gotologin") != null){//does not work
			request.getRequestDispatcher("/login.jsp").forward(request, response);//works
		}
		
		else if(request.getParameter("gotocreate") != null){
			request.getRequestDispatcher("/Create.jsp").forward(request, response);
		}
		
		else if(request.getParameter("back") != null){
			request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
		}
	}
}
