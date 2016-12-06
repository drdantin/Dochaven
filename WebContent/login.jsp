<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Login Application</title>  
</head>  
<body>  

<!-- Welcome_Login.java servlet directs itself to this login.jsp. From here ****LoginServlet**** is directed too,
 by which it connects to the Database to certify the user and password. -->

		<p align="center">
	   <font face="impact" color="grey" size="10">Login</font> 
	   </p>
		<form action="LoginServlet" method="post">
            <table align="center">  
                <tr>  
                    <td><b>User ID</b></td>  
                    <td><input type="text" name="username" required="required" /></td>  
                </tr>  
                <tr>  
                    <td><b>Password</b></td>  
                    <td><input type="password" name="userpassword" required="required" /></td>  
                </tr>  
                
              	<tr>
              		<td><button name="login" type="submit" value="LogIn"><b>LOGIN</b></button></td>  	
                </tr>   
                
            </table>  
           </form>
           
            <form action="${pageContext.request.contextPath}/Welcome.jsp" method="get">
	   		<p align="justify">
	   			<button name="back" type="submit" value="Back"><b>BACK</b></button>
   			</p>
	  		 </form>
            
            	
</body>  
</html> 