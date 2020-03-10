package com.hdquan.Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.HibUtil.HibUtil;
//hql查询为单个对象
public class Test {
	public static void main(String args[])
	{
	Session session=null;
	Transaction tx=null;
	try {
		session = HibUtil.getSession();
		tx=session.beginTransaction();//开启事务
	
		String hql="select count(*) from Course";
		Query q = session.createQuery(hql);
		Number n = (Number)q.uniqueResult();//唯一结果集---返回的肯定是一个对象即可用
		//count(*)可能是short、integer、long等各种类型，但是这些类型都是number的子类。
		System.out.println(n.intValue());
		
		
//		开启查询缓存
//		List list = session.createQuery("from Course").setCacheable(true).list();//使用查询缓存存数据
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
