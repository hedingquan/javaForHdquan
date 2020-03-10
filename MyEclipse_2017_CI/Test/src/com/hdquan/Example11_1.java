package com.hdquan;

import java.sql.*;
public class Example11_1 {

	public static void main(String[] args) {
		Connection con=null;
		Statement sql;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(Exception e) {}
		
		String url="jdbc:mysql://localhost:3306/gy1?useSSL=true";
		String user="root";
		String password="hedingquan123";
		try {
			con=DriverManager.getConnection(url, user, password);
			System.out.println(con);
		}catch(SQLException e) {}
		
		try {
			sql=con.createStatement();
			rs=sql.executeQuery("SELECT * FROM student1");
			while(rs.next()) {
				String number=rs.getString(1);
				String name=rs.getString(2);
				Date date=rs.getDate(3);
				float height=rs.getFloat(4);
				System.out.println(number+"  "+name+"  "+date+"  "+height);
			}
			con.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}

