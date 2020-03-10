package com.hdquan.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

	private static String dbUrl="jdbc:mysql://localhost:3306/library?useSSL=false";
	private static String dbUserName="root";
	private static String dbPassword="hedingquan";
	private static String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			DbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
