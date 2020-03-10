package com.hdquan;

import java.sql.*;

public class GetDBConnection {
	public static Connection ConnetionDB(String DBName,String user,String password) {
		Connection con=null;
		String uri="jdbc:mysql://localhost:3306/"+
		           DBName+"?useSSL=true&characterEncoding=utf-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e) {
			
		}
		
		try {
			con=DriverManager.getConnection(uri, user, password);
		}catch(SQLException e) {
			
		}
		return con;
		
	}
}
