package com.hdquan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hdquan.pojo.会员表;
import com.hdquan.pojo.供货表;
import com.hdquan.pojo.商品交易表;
import com.hdquan.pojo.商品信息表;
import com.hdquan.pojo.退货信息表;
import com.hdquan.util.DbUtil;

public class Supermarket_Management {
	 public static List<商品信息表> SelInfo() throws Exception{
    Connection con = DbUtil.getCon();
	Statement stmt = con.createStatement();	  
    ResultSet rs = stmt.executeQuery("select 商品编号,商品名称,商品条形码,商品类别,商品售价,库存量,告警量 from 商品信息表");
    
    List<商品信息表> InfoList = new ArrayList<商品信息表>();	       
    	商品信息表 Info1 = null;	     
	while (rs.next()){	           
		Info1 = new 商品信息表();	     
		Info1.set商品编号(rs.getString(1));
		Info1.set商品名称(rs.getString(2));	       
		Info1.set商品条形码(rs.getString(3));
		Info1.set商品类别(rs.getString(4));
		Info1.set商品售价(rs.getString(5));
		Info1.set库存量(rs.getString(6));
		Info1.set告警量(rs.getString(7));
		InfoList.add(Info1);	  
	}
	return InfoList;	 
	 }
	 public static List<商品交易表> SelInfo01() throws Exception{
		    Connection con = DbUtil.getCon();
			Statement stmt = con.createStatement();	  
		    ResultSet rs = stmt.executeQuery("select 商品名称,交易数量,金额,会员卡号,交易流水号  from 商品交易表");
		    
		    List<商品交易表> InfoList = new ArrayList<商品交易表>();	       
		    商品交易表 Info1 = null;	     
			while (rs.next()){	           
				Info1 = new 商品交易表();	     
				Info1.set商品名称(rs.getString(1));
				Info1.set交易数量(rs.getString(2));	       
				Info1.set金额(rs.getString(3));
				Info1.set会员卡号(rs.getString(4));
				Info1.set交易流水号(rs.getString(5));
				InfoList.add(Info1);	  
			}
			return InfoList;	
}
	 public static List<会员表> SelInfo02() throws Exception{
		    Connection con = DbUtil.getCon();
			Statement stmt = con.createStatement();	  
		    ResultSet rs = stmt.executeQuery("select 会员卡号,会员姓名,会员密码,注册日期,截止日期  from 会员表");
		    
		    List<会员表> InfoList = new ArrayList<会员表>();	       
		    会员表 Info1 = null;	     
			while (rs.next()){	           
				Info1 = new 会员表();	     
				Info1.set会员卡号(rs.getString(1));
				Info1.set会员姓名(rs.getString(2));	       
				Info1.set会员密码(rs.getString(3));
				Info1.set注册日期(rs.getString(4));
				Info1.set截止日期(rs.getString(5));
				InfoList.add(Info1);	  
			}
			return InfoList;	
}
	 public static List<退货信息表> SelInfo03() throws Exception{
		    Connection con = DbUtil.getCon();
			Statement stmt = con.createStatement();	  
		    ResultSet rs = stmt.executeQuery("select 交易流水号,商品编号,退货金额,退货数量,退货日期  from 退货信息表");
		    
		    List<退货信息表> InfoList = new ArrayList<退货信息表>();	       
		    退货信息表 Info1 = null;	     
			while (rs.next()){	           
				Info1 = new 退货信息表();	     
				Info1.set交易流水号(rs.getString(1));
				Info1.set商品编号(rs.getString(2));	       
				Info1.set退货金额(rs.getString(3));
				Info1.set退货数量(rs.getString(4));
				Info1.set退货日期(rs.getString(5));
				InfoList.add(Info1);	  
			}
			return InfoList;	
}
	 public static List<供货表> SelInfo04() throws Exception{
		    Connection con = DbUtil.getCon();
			Statement stmt = con.createStatement();	  
		    ResultSet rs = stmt.executeQuery("select 供货单编号,商品编号,商品名称,供货量,供货单生成日期  from 供货表");
		    
		    List<供货表> InfoList = new ArrayList<供货表>();	       
		    供货表  Info1 = null;	     
			while (rs.next()){	           
				Info1 = new 供货表();	     
				Info1.set供货单编号(rs.getString(1));
				Info1.set商品编号(rs.getString(2));	       
				Info1.set商品名称(rs.getString(3));
				Info1.set供货量(rs.getString(4));
				Info1.set供货单生成日期(rs.getString(5));
				InfoList.add(Info1);	  
			}
			return InfoList;	
}
	 public static void AddInfo(String 商品编号,String 商品名称,String 商品条形码,String 商品类别,String 商品售价,String 库存量,String 告警量) throws Exception{
		 Connection con = DbUtil.getCon();
	        String sql="insert into 商品信息表 (商品编号,商品名称,商品条形码,商品类别,商品售价,库存量,告警量) "
	        		+ "values(?,?,?,?,?,?,?)";
	       int  a=Integer.parseInt(商品编号)+1;
//	       System.out.println(a);
	       商品编号=a+"";
		    PreparedStatement psmt = con.prepareStatement(sql);
		    psmt.setString(1, 商品编号);
		    psmt.setString(2, 商品名称);
		    psmt.setString(3, 商品条形码);
		    psmt.setString(4, 商品类别);
		    psmt.setString(5, 商品售价);
		    psmt.setString(6, 库存量);
		    psmt.setString(7, 告警量);
		    System.out.println(商品编号+商品名称+商品条形码+商品类别+商品售价+库存量+告警量);
		    psmt.execute();  
			}
	 public static void AddShop(String 交易流水号,String 商品编号,String 商品名称,String 交易数量,String 会员卡号,String 商品金额,String 交易日期) throws Exception{
		 Connection con = DbUtil.getCon();
	        String sql="insert into 商品交易表 (交易流水号,商品编号,商品名称,交易数量,会员卡号,金额,交易日期) "
	        		+ "values(?,?,?,?,?,?,?)";
	       int  a=Integer.parseInt(商品编号)+1;
	       System.out.println(a);
	       商品编号=a+"";
		    PreparedStatement psmt = con.prepareStatement(sql);
		    psmt.setString(1, 交易流水号);
		    psmt.setString(2, 商品编号);
		    psmt.setString(3, 商品名称);
		    psmt.setString(4, 交易数量);
		    psmt.setString(5, 会员卡号);
		    psmt.setString(6, 商品金额);
		    psmt.setString(7, 交易日期);
		    psmt.execute();  
			}
	 public static void AddBack(String 交易流水号,String 商品编号,String 退货金额,String 退货数量,String 退货日期) throws Exception{
		 Connection con = DbUtil.getCon();
	        String sql="insert into 退货信息表 (交易流水号,商品编号,退货金额,退货数量,退货日期) "
	        		+ "values(?,?,?,?,?)";
		    PreparedStatement psmt = con.prepareStatement(sql);
		    psmt.setString(1, 交易流水号);
		    psmt.setString(2, 商品编号);
		    psmt.setString(3, 退货金额);
		    psmt.setString(4, 退货数量);
		    psmt.setString(5, 退货日期);
		    psmt.execute();  
			}
	 }
