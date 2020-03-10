package com.hdquan.Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.HibUtil.HibUtil;
import com.hdquan.pojo.Emp;
//hql��ҳ��ѯ
public class Test4 {
	public static void main(String args[])
	{
	Session session=null;
	Transaction tx=null;
	try {
		session = HibUtil.getSession();
		tx=session.beginTransaction();//��������
	
		String hql="from Course";
		Query q = session.createQuery(hql);
	//limit 20,10
		q.setFirstResult(10);//�ӵڼ�����ʼȡ����//�ڶ�ҳ��ʼȡ
	q.setMaxResults(5);//����ÿҳ�����ʾ��¼�ĸ���//ÿҳ5��
	List list=q.list();
	for(int i=0;i<list.size();i++)
	{
		Emp c=(Emp) list.get(i);
		System.out.println(c.getEname());
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
