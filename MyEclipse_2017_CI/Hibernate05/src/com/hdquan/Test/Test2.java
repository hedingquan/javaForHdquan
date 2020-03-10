package com.hdquan.Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Map;

import com.hdquan.HibUtil.HibUtil;
//List����
public class Test2 {
	public static void main(String args[])
	{
	Session session=null;
	Transaction tx=null;
	try {
		session = HibUtil.getSession();
		tx=session.beginTransaction();//��������
//��ʱ�����ǲ���Ҫ��ʵ������������Բ��ҳ�����ֻ��Ҫ���Ҳ������ԣ���ʱ�����Խ����ص����ݷ���Object[]�У�������ʵ�������	
//c.students.name����Ҫ��������
		String hql="select c.name,c.students.name from Course c";
		Query q = session.createQuery(hql);
		//һ������Object[]��Ӧһ�м�¼,�����¼ȫ������List������
		List<Object[]> list=q.list();
		for(int i=0;i<list.size();i++)
		{
			Object[] os=list.get(i);
			//os[0]��ָc.name��os[1]��ָc.students.name
			System.out.println("�γ�����:"+os[0]+"��ѡ�γ�ѧ������"+os[1]);
		}
		
		
		
		
		//һ�㽨����������������ֶ�
		String hql1="select new map(c.name as cname,c.students.name as studname) from Course c";
		Query q1 = session.createQuery(hql);
	
		List<Map> list1=q1.list();
		for(int i=0;i<list1.size();i++)
		{
			Map map=list1.get(i);
//			System.out.println("�γ�����:"+map.get("cname")+"��ѡ�γ�ѧ������"+map.get("studname");
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
