package com.hdquan.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hdquan.pojo.User;
import com.hduqna.Hibernate.HibUtil;

public class Test {
	public static void main(String arg[])
	{
		Session session=null;
		Transaction tx=null;
//		Configuration conf=new Configuration();
//		conf.configure();
//		SessionFactory Factory = conf.buildSessionFactory();
//		Session session = Factory.openSession();
		
		try {
			session = HibUtil.getSession();
			tx=session.beginTransaction();//开启事务
			User u=new User("aa",new java.sql.Date(System.currentTimeMillis()));
			
			u.setUname("s");
			u.setUname("00000");//只执行这一条sql语句
			
			session.save(u);
//			session.saveOrUpdate(u);//根据主键判断是增一条记录（数据库没有）还是更新一条记录（数据库中有）
//			处于持久化状态的对象，当发生值的改变时，hibernate能检测到，**立刻修改数据库的数据。如果在save之后，会执行两条sql语句
//				效率低，建议对持久对象值进行修改在save之前最好
			int b=2;
			u.setUname("s");
			u.setUname("00000");//会执行两条sql语句
			
			tx.commit();
		} 
		catch (Exception e) {//捕获到异常
			//省掉catch块和不省的效果一样的
			//没有catch他也会向外抛出。数据库没有收到正常提交也会自动回滚
			if(tx!=null)
			{
				tx.rollback();
			}
			throw e;//，抛出异常，一定要把这个异常***报告到上一层
		}	
		finally{
				if(session!=null)
				session.close(); 
			}
		}
	
	
}
