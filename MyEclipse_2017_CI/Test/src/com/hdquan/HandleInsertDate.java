package com.hdquan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class HandleInsertDate {
	 Connection con;
     PreparedStatement preSql; 
    public HandleInsertDate()
    {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e) {}
			String uri="jdbc:mysql://localhost:3306/gy1?useSSL=true&characterEncoding=utf-8";
			try {
				con=DriverManager.getConnection(uri, "root","hedingquan123");
			} catch (SQLException e1) {	}
		
    }
    public void writeRegisterModel(Register register)
    {
    	   String sqlStr ="insert into register values(?,?,?)";
    	  
    	   int ok=0;
    	   try {
			preSql = con.prepareStatement(sqlStr);
			   preSql.setLong(1, register.getId());
			   preSql.setString(2, register.getPassword());
			   preSql.setString(3, register.getBirth());
			   ok=preSql.executeUpdate();
			   con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "id不能重复","警告",JOptionPane.WARNING_MESSAGE);
			
		}if(ok!=0)
			{
				JOptionPane.showMessageDialog(null,"注册成功","恭喜",JOptionPane.WARNING_MESSAGE);
			}
		}
    }
