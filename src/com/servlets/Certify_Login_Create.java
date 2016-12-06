package com.servlets;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public class Certify_Login_Create {
	public static boolean certify(String name, String pass, String email, int isAdmin, String action) {
		boolean isCertified = false;
		//A connection(session)with a specific database. SQL statements are executed and results are returned
		//within the context of a connection.
		Connection conn = null; 
		
		//PreparedStatement is an Object that represents a precompiled SQL statement.A SQL statement is precompiled
		//and stored in a PreparedStatement object. This object can then be used to efficiently execute this
		//statement multiple times.
		PreparedStatement prepared_stat = null;
		
		
		//ResultSet is a table of data representing a database result set, which is usually generated executing a 
		//statement that queries the database.A ResultSet object maintains a cursor pointing to its current row of 
		//data. Initially the cursor is positioned before the first row. The next method moves the cursor to the next
		//row, and because it returns false when there are no more rows in the ResultSet object, it can be used in a 
		//while loop to iterate through the result set.
		ResultSet resultSet = null;
		
		
		String url = "jdbc:mysql://localhost/";
		String dbName = "RAD";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String userPassword = "password";
		try {
			//Class.forName allows to use the Driver class.
			Class.forName(driver).newInstance();
			
			//getConnection is a method in DriverManger api which holds url parameter, a user parameter(the database
			//user on whose behalf the connection is being made, and password(user password). Returns a connection
			//to the URL. Has only 3 parameters, yet it is necessary to locate the database by name,dbName
			// and also have the table info regarding the userName and password. ??
			conn = DriverManager.getConnection(url + dbName, userName, userPassword);
			
			if (action.equalsIgnoreCase("login")) {
				prepared_stat = conn.prepareStatement("select * from tblUser where UserName=? and Password=?");
				prepared_stat.setString(1, name);
				prepared_stat.setString(2, pass);

				resultSet = prepared_stat.executeQuery();
				//A ResultSet cursor is initially positioned before the first row
				//When a call to the next method returns false, the cursor is positioned after the last row
				//If true redirect to CreateUser_Upload
				isCertified = resultSet.next();
				
			}
			else if (action.equalsIgnoreCase("create")) {
				prepared_stat = conn.prepareStatement("insert into tblUser (UserName,Password,email,isAdmin) values (?,?,?,?)");
				prepared_stat.setString(1, name);
				prepared_stat.setString(2, pass);
				prepared_stat.setString(3, email );
				prepared_stat.setInt(4, isAdmin);

				prepared_stat.executeUpdate();
				isCertified = true;
				
							}
		}catch (Exception e) {
				System.out.println(e);
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (prepared_stat != null) {
					try {
						prepared_stat.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return isCertified;
		}
	//This method is used in LoginServlet to get the IsAdmin field, to see if it is an admin or not.This
	// method returns a boolean. If true, it is a Admin.
	public static boolean getAdmin(String userName){
		
		System.out.println("Use Name:"+userName);
	Connection conn = null;
		
		boolean isAdmin=false;
		PreparedStatement prepared_stat = null;
	
		ResultSet resultSet = null;
		
		String url = "jdbc:mysql://localhost/";
		String dbName = "RAD";
		String driver = "com.mysql.jdbc.Driver";
		String userName2 = "root";
		String userPassword = "password";
		
		String drive = "com.mysql.jdbc.Driver";
		Connection conn2 = null;
		PreparedStatement prepared_stat2 = null;
		ResultSet resultSet2 = null;
		try{
		Class.forName(drive).newInstance();
		conn2 = DriverManager.getConnection(url + dbName, userName2, userPassword);
		
		prepared_stat2 = conn2.prepareStatement("select IsAdmin from tblUser where UserName=?");
		prepared_stat2.setString(1, userName);

		resultSet2 = prepared_stat2.executeQuery();
		
		resultSet2.next();
		
		int adminValue=resultSet2.getInt(1);
		
		if(adminValue==1)
		{
			isAdmin=true;
		}
		
		}catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn2 != null) {
				try {
					conn2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (prepared_stat2 != null) {
				try {
					prepared_stat2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (resultSet2 != null) {
				try {
					resultSet2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}	
		return isAdmin;
	
	}	
}

