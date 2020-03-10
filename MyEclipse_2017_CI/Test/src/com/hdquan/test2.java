
package com.hdquan;
 import java.sql.*;
public class test2 {
	 public static void main(String [] args)
	 {
	  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=gy1";
	  String userName="root";
	  String userPwd="hedingquan123";
	 
	  try
	  {
	   Class.forName(driverName);
	   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
	    System.out.println("�aa");
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   System.out.print("����ʧ��");
	  }    
	 } 
	}
