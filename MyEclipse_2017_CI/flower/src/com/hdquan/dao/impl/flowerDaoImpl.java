package com.hdquan.dao.impl;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hdquan.dao.FlowerDao;
import com.hdquan.pojo.flower;

public class flowerDaoImpl implements FlowerDao{
	java.sql.Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public List<flower> selAll() {
		List<flower> list=new ArrayList<>();
	try {
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String user="root"; 
		String password="hedingquan123"; 
		Class.forName(driverName);
		conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=master",user,password);
		//conn.setAutoCommit(false);//将事务管理的自动提交至false
		ps=conn.prepareStatement("select * from flower");
		  rs=ps.executeQuery();
		 while(rs.next())
		 {
			 list.add(new flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
		 }
	} catch (ClassNotFoundException e) {
		System.out.println("数据库连接失败！");
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("数据库连接失败！");
		e.printStackTrace();
	}finally
	{	//conn.commit();
		try {
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {

			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}
	}
		return list;
	}
	public int insFlower(flower flower) {
		int index=0;
		java.sql.Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gy1?useUnicode=true&characterEncoding=utf8","root","hedingquan123");
			 ps=conn.prepareStatement("insert into flower values(default,?,?,?)");//default:自增
			 ps.setObject(1,flower.getName());
			 ps.setObject(2, flower.getPrice());
			 ps.setObject(3, flower.getProduction());
			 index=ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}finally
		{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {

				System.out.println("数据库连接失败！");
				e.printStackTrace();
			}
		}
			return index;
		}
	}
	
