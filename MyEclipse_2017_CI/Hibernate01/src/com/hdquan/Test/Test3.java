package com.hdquan.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.pojo.Address;
import com.hdquan.pojo.Person;
import com.hduqna.Hibernate.HibUtil;

public class Test3 {
	public static void main(String arg[])
	{
		Session session=null;
		Transaction tx=null;
		try {
			session = HibUtil.getSession();
			tx=session.beginTransaction();//开启事务
			
		Address a=new Address();
		a.setCity("北京");
		a.setStreet("长安街");
		Person p=new Person();
		p.setName("权");
		p.setAddress(a);
		
		session.save(p);
		
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
