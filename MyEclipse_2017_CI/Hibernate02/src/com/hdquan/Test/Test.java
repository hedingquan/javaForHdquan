package com.hdquan.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.pojo.Department;
import com.hdquan.pojo.Employee;
import com.hduqna.Hibernate.HibUtil;

public class Test {
	public static void main(String arg[])
	{
		Session session=null;
		Transaction tx=null;
		
		
		try {
			session = HibUtil.getSession();
			tx=session.beginTransaction();//��������

			Department d=new Department();
			d.setDname("�г���");
			d.setLocation("�����г�����");
			
			Employee e1=new Employee();
			e1.setEname("����");
			
			Employee e2=new Employee();
			e2.setEname("����");
			
//			�ɶ෽ά��������ϵ			
			e1.setDepartment(d);
			e2.setDepartment(d);			
			session.save(e1);
			session.save(e2);
			
//			��һ��ά��������ϵ--��һ�ַ���
			d.getEmployees().add(e1);
			d.getEmployees().add(e2);
//			��һ��ά��������ϵ--�ڶ��ַ���
//			d.addEmployee(e1);
//			d.addEmployee(e2);
			session.save(d);
			
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
