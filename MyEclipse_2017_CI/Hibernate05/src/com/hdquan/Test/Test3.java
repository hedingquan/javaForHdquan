package com.hdquan.Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.HibUtil.HibUtil;
import com.hdquan.pojo.Emp;
//hql查询为实体对象
//对于查询部分属性情况，Object数组和map都很方便，实际上也可以通过构造方法，将查出的数据直接封装到实体对象中
public class Test3 {
	public static void main(String args[])
	{
	Session session=null;
	Transaction tx=null;
	try {
		session = HibUtil.getSession();
		tx=session.beginTransaction();//开启事务

		
//	//对应的是构造器Emp(e.empno,e.ename)
//		String hql="select new Emp(e.empno,e.ename) from Emp e";
//		Query q = session.createQuery(hql);
//		List<Emp> list=q.list();
//		for(int i=0;i<list.size();i++)
//		{
//			Emp e=list.get(i);
//			System.out.println("雇员名字："+e.getEname()+"雇员编号"+e.getEmpno());
//		}
		
		
//	（1）	String hql="from Emp e where e.ename=? and e.dept.deptno=?";
		String hql="from Emp where ename=:ename";//使用参数名称动态绑定（推荐使用）
		
		Query q = session.createQuery(hql);
//	（1） q.setString(0, "Smaith");//参数索引从0开始计数，而不像jdbc一样从1开始
//		 q.setInteger(1, 20);
		q.setString("ename", "Smaith");//这里的ename是指:ename的值。名字要对应即可
	List list=q.list();
	for(int i=0;i<list.size();i++)
	{
		Emp c=(Emp)list.get(i);
		System.out.println(c.getEname());
	}
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
