package com.hdquan.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.pojo.Address;
import com.hdquan.pojo.Company;
import com.hduqna.Hibernate.HibUtil;
//一对一
public class Test2 {
	public static void main(String args[])
	{
	Session session=null;
	Transaction tx=null;
	try {
		session = HibUtil.getSession();
		tx=session.beginTransaction();//开启事务
		
		Address a=new Address();
		a.setCity("北京");
		
		Company c=new Company();
		c.setName("北京");
		c.setAddress2(a);
		
		session.save(c);
		session.save(a);
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
