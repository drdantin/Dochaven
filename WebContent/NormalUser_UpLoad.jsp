<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.button {
    background-color: #FFFFFF; 
    border: none;
    color: black;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-blocker;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    
}
.button1 {font-size: 16px; border: 2px solid #C0C0C0;}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Normal User Upload</title>
</head>
<body>
	<!-- LoginServlet directs us to this point. If its a normal user than that normal user
	does not have the ability to create a user only upload files. From here, if one presses 
	upload, one is directed ****UpLoad.jsp**** page -->

	<p align="center">
			<a href="UpLoad.jsp"><button class="button button1"><b>UpLoad File</b></button></a>
	</p>
	
	<form action="${pageContext.request.contextPath}/login.jsp" method="get">
	   		<p align="justify">
	   			<button name="back" type="submit" value="Back"><b>BACK</b></button>
   			</p>
	</form>
</body>
</html>


