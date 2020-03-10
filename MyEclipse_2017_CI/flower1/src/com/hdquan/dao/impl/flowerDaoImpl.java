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
	public List<flower> selAll() {
		List<flower> list=new ArrayList<>();
	try {
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String user="root"; 
		String password="hedingquan123"; 
		Class.forName(driverName);
		conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=gy1",user,password);
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
		System.out.print("dafgda");
		java.sql.Connection conn=null;
		PreparedStatement ps=null;
		try {
			String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String user="root"; 
			String password="hedingquan123"; 
			Class.forName(driverName);
			conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=gy1",user,password);
			 ps=conn.prepareStatement("insert into flower (name,price,production) values(?,?,?)");//default:自增
			 ps.setObject(1,flower.getname());
			 ps.setObject(2, flower.getprice());
			 ps.setObject(3, flower.getproduction());
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
	
