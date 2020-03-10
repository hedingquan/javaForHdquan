package com.hduqna.Hibernate;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hduqna.pojo.Emp;

public class Test1 {
	public static void main(String args[])
	{
		Session session=null;
		Transaction tx=null;
		try {
			session = HibUtil.getSession();
			tx=session.beginTransaction();//开启事务
			//查询
			String hql="from Emp";//省略了select * 
			Query q = session.createQuery(hql);
			List list =q.list();
			for(int i=0;i<list.size();i++)
			{
//				Course c=(Course) list.get(i);
//				System.out.println(c.getEname);
			}
			
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
