package com.hdquan.Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.HibUtil.HibUtil;
//hql�����Ӻ�������
public class Test6 {
	public static void main(String args[])
	{
	Session session=null;
	Transaction tx=null;
	try {
		session = HibUtil.getSession();
		tx=session.beginTransaction();//��������
	
		String hql="select e.ename,d.dname from Emp e left join e.dept d";
		Query q = session.createQuery(hql);
		
		List<Object[]> list=q.list();
		for(Object[] objects:list)
		{
			//objects[0]Ϊe.ename��objects[1]��ָd.dname
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
