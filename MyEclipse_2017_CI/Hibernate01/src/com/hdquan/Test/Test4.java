package com.hdquan.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.pojo.User2;
import com.hduqna.Hibernate.HibUtil;

public class Test4 {
	public static void main(String arg[]) throws Exception
	{
		Session session=null;
		Transaction tx=null;
		try {
			session = HibUtil.getSession();
			tx=session.beginTransaction();//¿ªÆôÊÂÎñ
		
//			InputStream is=new FileInputStream(new File("C:/Users/Administrator/Desktop.hibernate.txt"));
//			Blob createBlob = LobHelper.createBlob(is, 4);
//			Blob b=Hibernate.createBlob(is);
//			Clob c=Hibernate.createClob(is);
			
			User2 user2=new User2();
			user2.setName("aa");
			
			session.save(user2);
		
			tx.commit();
		} 
		catch (Exception e) {
			if(tx!=null)
			{
				tx.rollback();
			}
			throw e;
		}	
		finally{
				if(session!=null)
				session.close(); 
			}
		}
	
	
}
