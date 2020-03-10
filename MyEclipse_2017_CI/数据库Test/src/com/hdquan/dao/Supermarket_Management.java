package com.hdquan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hdquan.pojo.��Ա��;
import com.hdquan.pojo.������;
import com.hdquan.pojo.��Ʒ���ױ�;
import com.hdquan.pojo.��Ʒ��Ϣ��;
import com.hdquan.pojo.�˻���Ϣ��;
import com.hdquan.util.DbUtil;

public class Supermarket_Management {
	 public static List<��Ʒ��Ϣ��> SelInfo() throws Exception{
    Connection con = DbUtil.getCon();
	Statement stmt = con.createStatement();	  
    ResultSet rs = stmt.executeQuery("select ��Ʒ���,��Ʒ����,��Ʒ������,��Ʒ���,��Ʒ�ۼ�,�����,�澯�� from ��Ʒ��Ϣ��");
    
    List<��Ʒ��Ϣ��> InfoList = new ArrayList<��Ʒ��Ϣ��>();	       
    	��Ʒ��Ϣ�� Info1 = null;	     
	while (rs.next()){	           
		Info1 = new ��Ʒ��Ϣ��();	     
		Info1.set��Ʒ���(rs.getString(1));
		Info1.set��Ʒ����(rs.getString(2));	       
		Info1.set��Ʒ������(rs.getString(3));
		Info1.set��Ʒ���(rs.getString(4));
		Info1.set��Ʒ�ۼ�(rs.getString(5));
		Info1.set�����(rs.getString(6));
		Info1.set�澯��(rs.getString(7));
		InfoList.add(Info1);	  
	}
	return InfoList;	 
	 }
	 public static List<��Ʒ���ױ�> SelInfo01() throws Exception{
		    Connection con = DbUtil.getCon();
			Statement stmt = con.createStatement();	  
		    ResultSet rs = stmt.executeQuery("select ��Ʒ����,��������,���,��Ա����,������ˮ��  from ��Ʒ���ױ�");
		    
		    List<��Ʒ���ױ�> InfoList = new ArrayList<��Ʒ���ױ�>();	       
		    ��Ʒ���ױ� Info1 = null;	     
			while (rs.next()){	           
				Info1 = new ��Ʒ���ױ�();	     
				Info1.set��Ʒ����(rs.getString(1));
				Info1.set��������(rs.getString(2));	       
				Info1.set���(rs.getString(3));
				Info1.set��Ա����(rs.getString(4));
				Info1.set������ˮ��(rs.getString(5));
				InfoList.add(Info1);	  
			}
			return InfoList;	
}
	 public static List<��Ա��> SelInfo02() throws Exception{
		    Connection con = DbUtil.getCon();
			Statement stmt = con.createStatement();	  
		    ResultSet rs = stmt.executeQuery("select ��Ա����,��Ա����,��Ա����,ע������,��ֹ����  from ��Ա��");
		    
		    List<��Ա��> InfoList = new ArrayList<��Ա��>();	       
		    ��Ա�� Info1 = null;	     
			while (rs.next()){	           
				Info1 = new ��Ա��();	     
				Info1.set��Ա����(rs.getString(1));
				Info1.set��Ա����(rs.getString(2));	       
				Info1.set��Ա����(rs.getString(3));
				Info1.setע������(rs.getString(4));
				Info1.set��ֹ����(rs.getString(5));
				InfoList.add(Info1);	  
			}
			return InfoList;	
}
	 public static List<�˻���Ϣ��> SelInfo03() throws Exception{
		    Connection con = DbUtil.getCon();
			Statement stmt = con.createStatement();	  
		    ResultSet rs = stmt.executeQuery("select ������ˮ��,��Ʒ���,�˻����,�˻�����,�˻�����  from �˻���Ϣ��");
		    
		    List<�˻���Ϣ��> InfoList = new ArrayList<�˻���Ϣ��>();	       
		    �˻���Ϣ�� Info1 = null;	     
			while (rs.next()){	           
				Info1 = new �˻���Ϣ��();	     
				Info1.set������ˮ��(rs.getString(1));
				Info1.set��Ʒ���(rs.getString(2));	       
				Info1.set�˻����(rs.getString(3));
				Info1.set�˻�����(rs.getString(4));
				Info1.set�˻�����(rs.getString(5));
				InfoList.add(Info1);	  
			}
			return InfoList;	
}
	 public static List<������> SelInfo04() throws Exception{
		    Connection con = DbUtil.getCon();
			Statement stmt = con.createStatement();	  
		    ResultSet rs = stmt.executeQuery("select ���������,��Ʒ���,��Ʒ����,������,��������������  from ������");
		    
		    List<������> InfoList = new ArrayList<������>();	       
		    ������  Info1 = null;	     
			while (rs.next()){	           
				Info1 = new ������();	     
				Info1.set���������(rs.getString(1));
				Info1.set��Ʒ���(rs.getString(2));	       
				Info1.set��Ʒ����(rs.getString(3));
				Info1.set������(rs.getString(4));
				Info1.set��������������(rs.getString(5));
				InfoList.add(Info1);	  
			}
			return InfoList;	
}
	 public static void AddInfo(String ��Ʒ���,String ��Ʒ����,String ��Ʒ������,String ��Ʒ���,String ��Ʒ�ۼ�,String �����,String �澯��) throws Exception{
		 Connection con = DbUtil.getCon();
	        String sql="insert into ��Ʒ��Ϣ�� (��Ʒ���,��Ʒ����,��Ʒ������,��Ʒ���,��Ʒ�ۼ�,�����,�澯��) "
	        		+ "values(?,?,?,?,?,?,?)";
	       int  a=Integer.parseInt(��Ʒ���)+1;
//	       System.out.println(a);
	       ��Ʒ���=a+"";
		    PreparedStatement psmt = con.prepareStatement(sql);
		    psmt.setString(1, ��Ʒ���);
		    psmt.setString(2, ��Ʒ����);
		    psmt.setString(3, ��Ʒ������);
		    psmt.setString(4, ��Ʒ���);
		    psmt.setString(5, ��Ʒ�ۼ�);
		    psmt.setString(6, �����);
		    psmt.setString(7, �澯��);
		    System.out.println(��Ʒ���+��Ʒ����+��Ʒ������+��Ʒ���+��Ʒ�ۼ�+�����+�澯��);
		    psmt.execute();  
			}
	 public static void AddShop(String ������ˮ��,String ��Ʒ���,String ��Ʒ����,String ��������,String ��Ա����,String ��Ʒ���,String ��������) throws Exception{
		 Connection con = DbUtil.getCon();
	        String sql="insert into ��Ʒ���ױ� (������ˮ��,��Ʒ���,��Ʒ����,��������,��Ա����,���,��������) "
	        		+ "values(?,?,?,?,?,?,?)";
	       int  a=Integer.parseInt(��Ʒ���)+1;
	       System.out.println(a);
	       ��Ʒ���=a+"";
		    PreparedStatement psmt = con.prepareStatement(sql);
		    psmt.setString(1, ������ˮ��);
		    psmt.setString(2, ��Ʒ���);
		    psmt.setString(3, ��Ʒ����);
		    psmt.setString(4, ��������);
		    psmt.setString(5, ��Ա����);
		    psmt.setString(6, ��Ʒ���);
		    psmt.setString(7, ��������);
		    psmt.execute();  
			}
	 public static void AddBack(String ������ˮ��,String ��Ʒ���,String �˻����,String �˻�����,String �˻�����) throws Exception{
		 Connection con = DbUtil.getCon();
	        String sql="insert into �˻���Ϣ�� (������ˮ��,��Ʒ���,�˻����,�˻�����,�˻�����) "
	        		+ "values(?,?,?,?,?)";
		    PreparedStatement psmt = con.prepareStatement(sql);
		    psmt.setString(1, ������ˮ��);
		    psmt.setString(2, ��Ʒ���);
		    psmt.setString(3, �˻����);
		    psmt.setString(4, �˻�����);
		    psmt.setString(5, �˻�����);
		    psmt.execute();  
			}
	 }
