package com.hdquan.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.pojo.Address;
import com.hdquan.pojo.Company;
import com.hdquan.pojo.Department;
import com.hdquan.pojo.Employee;
import com.hduqna.Hibernate.HibUtil;
//一对一
public class Test3 {
	public static void main(String args[])
	{

		Session session=null;
		Transaction tx=null;
		
		
		try {
			session = HibUtil.getSession();
			tx=session.beginTransaction();//开启事务

			Department d=new Department();
			d.setDname("市场部");
			d.setLocation("北京市长安街");
			
			Employee e1=new Employee();
			e1.setEname("张三");
			
			Employee e2=new Employee();
			e2.setEname("李四");
			
//			由多方维护关联关系			
			e1.setDepartment(d);
			e2.setDepartment(d);			
			session.save(e1);
			session.save(e2);
			
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
