package com.hdquan.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.pojo.Student;
import com.hdquan.pojo.StudentId;
import com.hduqna.Hibernate.HibUtil;

public class Test2 {
	public static void main(String arg[])
	{
		Session session=null;
		Transaction tx=null;
		try {
			session = HibUtil.getSession();
			tx=session.beginTransaction();//��������
			
			StudentId sid=new StudentId();
			
			sid.setFirstname("ʿ��");
			sid.setLastname("��");
		
			Student student=new Student(sid,"aa");
		
			student.setMajor("bb");
			session.save(student);
			
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
