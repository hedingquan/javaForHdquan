package com.hdquan;

import java.sql.*; 
public class Example11_5 {
   public static void main(String args[]) {
      Connection con;
      PreparedStatement preSql; 
      ResultSet rs;
      con = GetDBConnection.ConnetionDB("gy1","root","hedingquan123");
      if(con == null ) return;
      String sqlStr ="insert into student1 values(?,?,?,?)";
      try { 
          preSql = con.prepareStatement(sqlStr);
          preSql.setString(1,"7");       
          preSql.setString(2,"刘伟");       
          preSql.setString(3,"1999-9-10"); 
          preSql.setFloat(4,1.77f);       
          int ok = preSql.executeUpdate();
          sqlStr="select * from student1 where name like ? ";
          preSql = con.prepareStatement(sqlStr);
          preSql.setString(1,"张%");      
          rs = preSql.executeQuery();
          while(rs.next()) { 
             String number=rs.getString(1);
             String name=rs.getString(2);
             Date date=rs.getDate(3);
             float height=rs.getFloat(4);
             System.out.printf("%s\t",number);
             System.out.printf("%s\t",name);
             System.out.printf("%s\t",date); 
             System.out.printf("%.2f\n",height);
          }
          con.close();
      }
      catch(SQLException e) { 
         System.out.println("记录中number值不能重复"+e);
      }
  }
}

