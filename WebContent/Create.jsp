<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  

<title>Create User</title>  
</head> 
 <style>
 	#ErrorName{color: transparent;}
 	#ErrorPass{color: transparent;}
 	#ErrorEmail{color: transparent;}
 </style>
 
 
  
<body>  
	<p align="center">
	   <font face="impact" color="grey" size="10">Create A New User</font> 
	   </p>
   <%-- <span id="ErrorEmail">Email not Valid</span>	--%>
    	<form action="CreateServlet" method="post" onsubmit="return theErrors()"> 
            <table align="center">  
                <tr>  
                    <td>User Name</td>  
                     <td><input id ="usernameCheck" value="" type="text" name="username" class="rows" required="required" />
                     <span id="ErrorName">Must be at least 6 characters</span></td>
                </tr>  
                	
                <tr>  
                    <td>Password</td>  
                    <td><input id="passwordCheck" type="password" name="userpassword" class="rows" required="required" />
                    <span id="ErrorPass">More than 6 character,1 number, 1 capital</span></td>  
                </tr> 
                 <tr>  
                    <td>email</td>  
                    <td><input id ="emailCheck"  type="text" name="email" class="rows" required="required" />
                    <span id="ErrorEmail">Email Failed</span></td>  
                </tr>     
                
                 <tr>  
                    <td>IsAdmin</td>  
                    <td><input type="checkbox" name="IsAdmin" value="check" class="rows" required="required" /></td>  
                </tr>     
     			<tr>
     												
     					<td><button id="theButton" name="create" type="submit" value="Create"><b>CREATE</b></button></td>
                </tr> 
                 
            </table> 
             
            </form>
            
             <form action="${pageContext.request.contextPath}/Welcome.jsp" method="get">
	   		<p>
	   				<button name="back" type="submit" value="Back"><b>BACK</b></button>
	   		
   			</p>
	  		 </form>
	  		 
	  		<script>
	  	
	  		 function theErrors(){
  				
  				var sendSubmition = "true";
  				var name = document.getElementById("usernameCheck").value;
  				var pass = document.getElementById("passwordCheck").value;
            	var email = document.getElementById("emailCheck").value;
            	
  				if(name.length < 6){
  					document.getElementById("ErrorName").style.color="red";
  					sendSubmition = "false";
  
  				}
  				if(checkPassword(pass) == "false" ){
  					document.getElementById("ErrorPass").style.color="red";
  					sendSubmition = "false";
  				}
  				if(checkEmail(email) == "false"){
  					document.getElementById("ErrorEmail").style.color="red";
  					sendSubmition = "false";
  				}
  				
  				if(sendSubmition == "false"){
  					location.reload();
  					return false;
  					
  					
  				}
  				
  			}
	  		
  			function checkPassword(checkpass){
  				var sendSubmition = "true";
        		if (checkpass.length < 6) {
        			sendSubmition = "false";
					}
        		if (checkpass.search(/\d/) == -1) {
        	    	sendSubmition = "false";
        	       
        	    }
        		if (checkpass.search(/[A-Z]/) == -1) {
        	    	sendSubmition = "false";
        	        
        	    }
        		return sendSubmition;
        	}
  			
  			
        	function checkEmail(checkemail){
        		var sendSubmition = "true";
        		var check =  /\S*.+@\S*.+.[com]|[net]|[org]/;
				var x = check.test(checkemail);
				if(x == false){
					sendSubmition = "false";
					}
        		return sendSubmition;
        	}
        	
             </script>
            
</body>  

</html> 

