package com.hdquan.Test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.HibUtil.HibUtil;
//hql����ѯ�Ͷ��󵼺�
public class Test5 {
	public static void main(String args[])
	{
	Session session=null;
	Transaction tx=null;
	try {
		session = HibUtil.getSession();
		tx=session.beginTransaction();//��������
	//ֻ��Ҫ�򵥵�ʹ�����Լ���--����ѯ
		String hql="from Emp e where e.dept.deptno=?";
		Query q = session.createQuery(hql);
		q.setInteger(0, 10);
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
