package com.hdquan.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

	private static String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=Supermarket Management";
	private static String dbUserName="root";
	private static String dbPassword="hedingquan123";
	private static String jdbcName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public static Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	
	/**
	 * �ر����ݿ�����
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
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
