package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;  
	  
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {
    	
    //setContentType sets the response being sent to the client, if the response has not been 
    	//been committed yet. Before sending data to client, the Servlet container informs the
    	//client browser of twhat type of data is being sent now. 
    //getWriter returns a PrintWriter object that can send character text to the client.
    	response.setContentType("text/html");    
        PrintWriter out = response.getWriter();  
        
    //userName and userPassword recieve the values given by login.jsp. The login.jsp is has
        //a form action which directs itself to the loginServlet class under java resources
        String userName=request.getParameter("username");    
        String userPassword=request.getParameter("userpassword");  
        
        //getSession(false) will check existence of session. If session exists, then it returns
        //the reference of that session object, if not, this method will return null. 
    //if(session!=null) is saying if there is a reference session object enter body conditional
    //setAttribute(String name, Object value) binds an object to this session, using the name
        //specified.
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        session.setAttribute("nameLogin", userName);  
        
    //Certify_Login_Create.certify is a class and method which certifies login user and returns
        //true if login certification was successful or false if not
        //If successful we are directed to Createuser_Upload.jsp
        if(Certify_Login_Create.certify(userName, userPassword, null, 0, "login")){ 
        	//********* cannot do pop up
        	session.setAttribute("isAdmin", Certify_Login_Create.getAdmin(userName));
        	//isAdmin has true or false depending on whether it is an Admin or not
        	boolean isAdmin=(boolean) session.getAttribute("isAdmin");
        	if(isAdmin == true){
        		
        		RequestDispatcher requestDispatch = request.getRequestDispatcher("CreateAdminUser_Upload.jsp");     
        		requestDispatch.forward(request,response);    
        	}
        	else{
        		
        		RequestDispatcher requestDispatch = request.getRequestDispatcher("NormalUser_UpLoad.jsp");     
        		requestDispatch.forward(request,response);    
        	}
        
        }
        else{    
            out.print("<p style=\"color:red\">Sorry username or password error</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");   
            rd.include(request,response);    
        } 
    }
}