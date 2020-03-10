package com.hdquan.Test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.HibUtil.HibUtil;
import com.hdquan.pojo.Emp;
//sql原生查询--hql不能满足我们的要求，需要使用原始的sql完成
public class Test7 {
	public static void main(String args[])
	{
	Session session=null;
	Transaction tx=null;
	try {
		session = HibUtil.getSession();
		tx=session.beginTransaction();//开启事务
	
//		String hql="select ename from emp where empno=:id";
////		注意是SQLQuery
//		SQLQuery q = session.createSQLQuery(hql);
//		q.setInteger("id", 7369);
//		List list=q.list();//返回的结果为List<Object[]>
//		for(int i=0;i<list.size();i++)
//		{
//			Object[] c=(Object[]) list.get(i);
//			System.out.println(c[0]+"-"+c[1]);
//		}
		
		
		
		String hql="select * from emp where empno=:id";
		SQLQuery q = session.createSQLQuery(hql);
		q.setInteger("id", 7369);
		q.addEntity(Emp.class);//**
		List<Emp> list=q.list();
		for(int i=0;i<list.size();i++)
		{
			Emp c=list.get(i);
			System.out.println(c.getEname()+"-"+c.getEmpno());
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
