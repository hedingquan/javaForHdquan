package com.hdquan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hdquan.pojo.User;
import com.hdquan.util.DbUtil;

public class UserDao {
	/*
	 * 改密码
	 */
    public void updateUser (String userPhone, String userName, String password) throws SQLException{
        Connection con=null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
        String sql="update user set userName=?,password=?,userPhone=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, userPhone);
        preparedStatement.setString(2, userName);
        preparedStatement.setString(3, password);
        preparedStatement.execute();    
    }
    
    public void AddUser(String userName, String password)
    {
    	Connection con=null;
    	try {
			con=DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String sql="insert into user (userName,password) values(?,?,)";
    	try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setLong(1,2);
			preparedStatement.setString(2,userName);
			preparedStatement.setString(3,password);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    /*
     * 查询全部用户
     */
	public static List<User> query() throws Exception{	       
		Connection con = DbUtil.getCon();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery("select Id,userName,password,sex,userPhone from user");	      
		List<User> userList = new ArrayList<User>();	       
		User user = null;	     
		while (rs.next()){	           
			user = new User();	           
			user.setUserName(rs.getString("userName"));	       
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getString("sex"));
			 user.setUserPhone(rs.getString("userPhone"));
			 user.setID(rs.getString("Id"));
			userList.add(user);	        
		}	       
		return userList;	  
	}
	/*
	 * 查询用户全部信息
	 */
	public void queryAll(String userName,String password)throws Exception 
	{
		Connection con = DbUtil.getCon();	  
		Statement stmt = con.createStatement();	  
		String sql="select Id,sex,userPhone from user where userName=? and password=?";
			 PreparedStatement psmt = con.prepareStatement(sql);
	        psmt.setString(1, userName);
	        psmt.setString(2, password);
	        
//			Statement stmt = con.createStatement();	
//	        psmt.execute();
//	        ResultSet rs = stmt.executeQuery(sql);	      
//			List<User> userList = new ArrayList<User>();	
//		User user = null;	     
//		while (rs.next()){	           
//			user = new User();	           
//			user.setUserName(userName);	       
//			user.setPassword(password);
//			user.setID(rs.getString("Id"));
//			user.setSex(rs.getString("sex"));
//			 user.setUserPhone(rs.getString("userPhone"));
//			userList.add(user);	        
//		}	      
//		return userList;
	}
    public static void main(String[] args) throws Exception {
        UserDao userDao = new UserDao();
        List<User> userList=userDao.query();
        for (User goddess : userList) {
            System.out.println(goddess.getUserName()+","+goddess.getPassword()+","+goddess.getSex()+","+goddess.getUserPhone());
        }
    }
	
}
