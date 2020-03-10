package com.hdquan.Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Map;

import com.hdquan.HibUtil.HibUtil;
//List集合
public class Test2 {
	public static void main(String args[])
	{
	Session session=null;
	Transaction tx=null;
	try {
		session = HibUtil.getSession();
		tx=session.beginTransaction();//开启事务
//有时候，我们不需要将实体类的所有属性查找出来，只需要查找部分属性，这时，可以将返回的内容放入Object[]中，而不是实体对象中	
//c.students.name不需要做表连接
		String hql="select c.name,c.students.name from Course c";
		Query q = session.createQuery(hql);
		//一个数组Object[]对应一行记录,多个记录全部放在List容器中
		List<Object[]> list=q.list();
		for(int i=0;i<list.size();i++)
		{
			Object[] os=list.get(i);
			//os[0]是指c.name，os[1]是指c.students.name
			System.out.println("课程名字:"+os[0]+"所选课程学生名字"+os[1]);
		}
		
		
		
		
		//一般建议起别名处理查出的字段
		String hql1="select new map(c.name as cname,c.students.name as studname) from Course c";
		Query q1 = session.createQuery(hql);
	
		List<Map> list1=q1.list();
		for(int i=0;i<list1.size();i++)
		{
			Map map=list1.get(i);
//			System.out.println("课程名字:"+map.get("cname")+"所选课程学生名字"+map.get("studname");
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
