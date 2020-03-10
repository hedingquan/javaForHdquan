package com.hdquan.Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.HibUtil.HibUtil;
//hql��ѯΪ��������
public class Test {
	public static void main(String args[])
	{
	Session session=null;
	Transaction tx=null;
	try {
		session = HibUtil.getSession();
		tx=session.beginTransaction();//��������
	
		String hql="select count(*) from Course";
		Query q = session.createQuery(hql);
		Number n = (Number)q.uniqueResult();//Ψһ�����---���صĿ϶���һ�����󼴿���
		//count(*)������short��integer��long�ȸ������ͣ�������Щ���Ͷ���number�����ࡣ
		System.out.println(n.intValue());
		
		
//		������ѯ����
//		List list = session.createQuery("from Course").setCacheable(true).list();//ʹ�ò�ѯ���������
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
