package com.hdquan.Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.HibUtil.HibUtil;
import com.hdquan.pojo.Emp;
//hql��ѯΪʵ�����
//���ڲ�ѯ�������������Object�����map���ܷ��㣬ʵ����Ҳ����ͨ�����췽���������������ֱ�ӷ�װ��ʵ�������
public class Test3 {
	public static void main(String args[])
	{
	Session session=null;
	Transaction tx=null;
	try {
		session = HibUtil.getSession();
		tx=session.beginTransaction();//��������

		
//	//��Ӧ���ǹ�����Emp(e.empno,e.ename)
//		String hql="select new Emp(e.empno,e.ename) from Emp e";
//		Query q = session.createQuery(hql);
//		List<Emp> list=q.list();
//		for(int i=0;i<list.size();i++)
//		{
//			Emp e=list.get(i);
//			System.out.println("��Ա���֣�"+e.getEname()+"��Ա���"+e.getEmpno());
//		}
		
		
//	��1��	String hql="from Emp e where e.ename=? and e.dept.deptno=?";
		String hql="from Emp where ename=:ename";//ʹ�ò������ƶ�̬�󶨣��Ƽ�ʹ�ã�
		
		Query q = session.createQuery(hql);
//	��1�� q.setString(0, "Smaith");//����������0��ʼ������������jdbcһ����1��ʼ
//		 q.setInteger(1, 20);
		q.setString("ename", "Smaith");//�����ename��ָ:ename��ֵ������Ҫ��Ӧ����
	List list=q.list();
	for(int i=0;i<list.size();i++)
	{
		Emp c=(Emp)list.get(i);
		System.out.println(c.getEname());
	}
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
