package com.hdquan.Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.HibUtil.HibUtil;
import com.hdquan.pojo.Emp;
//hql分页查询
public class Test4 {
	public static void main(String args[])
	{
	Session session=null;
	Transaction tx=null;
	try {
		session = HibUtil.getSession();
		tx=session.beginTransaction();//开启事务
	
		String hql="from Course";
		Query q = session.createQuery(hql);
	//limit 20,10
		q.setFirstResult(10);//从第几条开始取数据//第二页开始取
	q.setMaxResults(5);//设置每页最多显示记录的个数//每页5个
	List list=q.list();
	for(int i=0;i<list.size();i++)
	{
		Emp c=(Emp) list.get(i);
		System.out.println(c.getEname());
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
