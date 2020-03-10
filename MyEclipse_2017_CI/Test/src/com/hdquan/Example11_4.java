package com.hdquan;

import java.sql.*; 
public class Example11_4 {
   public static void main(String args[]) {
      Connection con;
      Statement sql; 
      ResultSet rs;
      con = GetDBConnection.ConnetionDB("gy1", "root","hedingquan123");
      if(con == null ) return;
      String jiLu="('5','王六','2000-10-23',1.66),"+
                  "('6','李武','1989-10-23',1.76)";    //insert into 插入多条记录，此处插入2条记录
      String sqlStr ="insert into student1 values"+jiLu;
      try { 
          sql=con.createStatement(); 
          int ok = sql.executeUpdate(sqlStr);
          rs = sql.executeQuery("select * from student1");
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

