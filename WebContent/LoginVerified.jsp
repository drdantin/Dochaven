<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title align="center">Welcome <%=session.getAttribute("name")%></title> 
</head>
<body>
<div class="dropdown">
  <button onclick="myFunction()" class="dropbtn">Dropdown</button>
  <div id="myDropdown" class="dropdown-content">
    <a href="#">Delete</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
</div>

<h3 align="center">Login successful!!!</h3>  
    <h4 align="center">  
        Hello,  
        <%=session.getAttribute("name")%></h4>  
</body>
</html>