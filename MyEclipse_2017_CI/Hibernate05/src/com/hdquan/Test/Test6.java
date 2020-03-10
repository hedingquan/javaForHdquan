package com.hdquan.Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.HibUtil.HibUtil;
//hql内连接和外连接
public class Test6 {
	public static void main(String args[])
	{
	Session session=null;
	Transaction tx=null;
	try {
		session = HibUtil.getSession();
		tx=session.beginTransaction();//开启事务
	
		String hql="select e.ename,d.dname from Emp e left join e.dept d";
		Query q = session.createQuery(hql);
		
		List<Object[]> list=q.list();
		for(Object[] objects:list)
		{
			//objects[0]为e.ename，objects[1]是指d.dname
			System.out.println(objects[0]+"--"+objects[1]);
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
