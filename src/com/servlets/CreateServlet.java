package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {
    	
    //setContentType sets the response being sent to the client, if the response has not been 
    	//been committed yet. Before sending data to client, the Servlet container informs the
    	//client browser of twhat type of data is being sent now. 
    //getWriter returns a PrintWriter object that can send character text to the client.
    	response.setContentType("text/html");    
        PrintWriter out = response.getWriter();  
        int db_isAdmin = 0;
        
    //userName and userPassword recieve the values given by login.jsp. The login.jsp is has
        //a form action which directs itself to the loginServlet class under java resources
        String userName=request.getParameter("username");    
        String userPassword=request.getParameter("userpassword");  
        String userEmail=request.getParameter("email");
     
        boolean is_Admin = false;
        if(is_Admin = request.getParameter("IsAdmin") != null){
        	db_isAdmin = 1;
        }
        
    //getSession(false) will check existence of session. If session exists, then it returns
        //the reference of that session object, if not, this method will return null. 
    //if(session!=null) is saying if there is a reference session object enter body conditional
    //setAttribute(String name, Object value) binds an object to this session, using the name
        //specified.
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        session.setAttribute("CreateUser", userName);
        
        if(Certify_Login_Create.certify(userName,userPassword,userEmail,db_isAdmin, "create")){
         	//what page to go to - calloboration unknown but will direct where one may search files
        	RequestDispatcher rd = request.getRequestDispatcher("CreateSuccessful.jsp"); 
        	response.setContentType("text/html");  
        	out.println("<script type=\"text/javascript\">");  
        	out.println("alert('Creation Successful!');");  
        	out.println("</script>");        	
        	//rd.forward(request, response);
        }
        else{
        	response.setContentType("text/html");  
        	out.println("<script type=\"text/javascript\">");  
        	out.println("alert('Creation fail!');");  
        	out.println("</script>");
        	RequestDispatcher rd=request.getRequestDispatcher("CreateUser_Upload.jsp");    
        	rd.include(request,response);   
        
        }
     }
	
}
