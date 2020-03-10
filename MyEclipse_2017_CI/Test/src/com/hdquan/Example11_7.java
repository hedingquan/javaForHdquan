package com.hdquan;

import java.sql.*; 
public class Example11_7{
    public static void main(String args[]){
       Connection con = null;
       Statement sql;
       ResultSet rs; 
       String sqlStr;
       con = GetDBConnection.ConnetionDB("gy1","root","hedingquan123");
       if(con == null ) return;
       try{ float n = 0.02f;
            con.setAutoCommit(false);      
            sql = con.createStatement();
            sqlStr = "select name,height from student1 where number='1'";
            rs = sql.executeQuery(sqlStr);
            rs.next();
            float h1 = rs.getFloat(2);
            System.out.println("事务之前"+rs.getString(1)+"身高:"+h1);
            sqlStr = "select name,height from student1 where number='2'"; 
            rs = sql.executeQuery(sqlStr);
            rs.next();
            float h2 = rs.getFloat(2);
            System.out.println("事务之前"+rs.getString(1)+"身高:"+h2);  
            h1 = h1-n;
            h2 = h2+n;
            sqlStr = "update student1 set height ="+h1+" where number='1'";
            sql.executeUpdate(sqlStr);
            sqlStr = "update student1 set height ="+h2+" where number='2'";
            sql.executeUpdate(sqlStr);
            con.commit(); 
            con.setAutoCommit(true); 
            String s = "select name,height from student1"+
                      " where number='1'or number='2'";
            rs = 
            sql.executeQuery(s);
            while(rs.next()){
               System.out.println("事务后"+rs.getString(1)+
                                  "身高:"+rs.getFloat(2));  
            }
            con.close();
         }
         catch(SQLException e){
            try{ con.rollback();          
            }
            catch(SQLException exp){}
         }
    }
}
