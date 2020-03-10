package com.hdquan;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class HandleLogin {
	 Connection con;
     PreparedStatement preSql; 
     ResultSet rs;
    public HandleLogin()
    {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e) {}
			String uri="jdbc:mysql://localhost:3306/gy1?useSSL=true&characterEncoding=utf-8";
			try {
				con=DriverManager.getConnection(uri, "root","hedingquan123");
			} catch (SQLException e1) {}
		}
    public Login queryVerify(Login login)
    {
    	int id=login.getId();
    	String pw=login.getPassword();
    	   String sqlStr ="select id,password from register where"+"id=? and password=?";
    	   int ok=0;
    	 
			try {
				preSql = con.prepareStatement(sqlStr);
				   preSql.setLong(1, id);
				   preSql.setString(2, pw);
				   rs=preSql.executeQuery();
				   ok=preSql.executeUpdate();
				   if(rs.next()==true)
				   {
					   login.setLoginSuccess(true);
					   JOptionPane.showMessageDialog(null,"登录成功","恭喜",JOptionPane.WARNING_MESSAGE);
				   }
				   else{
					   login.setLoginSuccess(false);
					   JOptionPane.showMessageDialog(null,"登录失败","重新登录",JOptionPane.WARNING_MESSAGE);
				  
				   }
				   con.close();
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   return login;
    }
}
