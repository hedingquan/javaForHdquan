package com.hdquan.Test;
//一对一关联
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
			tx=session.beginTransaction();//开启事务
				
		Course course1=new Course();
		Course course2=new Course();
		Course course3=new Course();
		Student student1=new Student();
		Student student2=new Student();
		Student student3=new Student();
		course1.setName("数学");
		course2.setName("语文");
		course3.setName("英语");
		student1.setName("权");
		student2.setName("何");
		student3.setName("鼎");
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
