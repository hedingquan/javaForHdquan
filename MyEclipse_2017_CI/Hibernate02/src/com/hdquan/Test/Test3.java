package com.hdquan.Test;
//һ��һ����
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.pojo.Course;
import com.hdquan.pojo.Student;
import com.hduqna.Hibernate.HibUtil;

public class Test3 {
	public static void main(String arg[])
	{
		Session session=null;
		Transaction tx=null;
		
		
		try {
			session = HibUtil.getSession();
			tx=session.beginTransaction();//��������
				
		Course course1=new Course();
		Course course2=new Course();
		Course course3=new Course();
		Student student1=new Student();
		Student student2=new Student();
		Student student3=new Student();
		course1.setName("��ѧ");
		course2.setName("����");
		course3.setName("Ӣ��");
		student1.setName("Ȩ");
		student2.setName("��");
		student3.setName("��");
		student1.addCourse(course3);
		student1.addCourse(course1);
		student2.addCourse(course2);
		student3.addCourse(course3);
			session.save(student1);
			session.save(student2);
			session.save(student3);
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