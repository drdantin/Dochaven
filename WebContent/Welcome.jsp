<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Dochaven</title>  
</head>  
<body>
 
<!-- Welcome.jsp directs to ****com.servlets package, under the Welcome_Login.java servlet****.
What is missing as of 12:47, 4-17, is the connection from this to the search functionality-->

	<form action="${pageContext.request.contextPath}/Welcome_Login" method="get">
	   		<p align="right">
	   		<button name="gotologin" type="submit" value="GoLogIn">LOGIN</button>							
   			</p>
	</form>
	
	<form action="${pageContext.request.contextPath}/Create.jsp" method="get">
	   		<p align="right">
	   		<button name="gotocreate" type="submit" value="GoCreate">CREATE</button>							
   			</p>
	</form>
	
	 <p align="center">
	   <font face="impact" color="grey" size="25">Dochaven</font> 
	   </p>
	   
	 <p align="center">
		 <img src="static/powerB.jpg" alt="" height="150" width="35%">
	 </p>
	
	<div class="search">
		<form action=" yadayada">
			<p align="center">
		    <input type="text" name="search" placeholder="Search File in DocHaven" size="25" 
   			style="font-weight: bold;" required>
			<input type="submit" value="GO">
			</p>
		</form>
	</div>
	
	 </body>  
</html> 