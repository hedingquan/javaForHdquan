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
			tx=session.beginTransaction();//��������
			User u=new User("aa",new java.sql.Date(System.currentTimeMillis()));
			
			u.setUname("s");
			u.setUname("00000");//ִֻ����һ��sql���
			
			session.save(u);
//			session.saveOrUpdate(u);//���������ж�����һ����¼�����ݿ�û�У����Ǹ���һ����¼�����ݿ����У�
//			���ڳ־û�״̬�Ķ��󣬵�����ֵ�ĸı�ʱ��hibernate�ܼ�⵽��**�����޸����ݿ�����ݡ������save֮�󣬻�ִ������sql���
//				Ч�ʵͣ�����Գ־ö���ֵ�����޸���save֮ǰ���
			int b=2;
			u.setUname("s");
			u.setUname("00000");//��ִ������sql���
			
			tx.commit();
		} 
		catch (Exception e) {//�����쳣
			//ʡ��catch��Ͳ�ʡ��Ч��һ����
			//û��catch��Ҳ�������׳������ݿ�û���յ������ύҲ���Զ��ع�
			if(tx!=null)
			{
				tx.rollback();
			}
			throw e;//���׳��쳣��һ��Ҫ������쳣***���浽��һ��
		}	
		finally{
				if(session!=null)
				session.close(); 
			}
		}
	
	
}
