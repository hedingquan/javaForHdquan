package com.hdquan.Test;
//一对一关联
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hdquan.pojo.Address;
import com.hdquan.pojo.Company;
import com.hduqna.Hibernate.HibUtil;

public class Test2 {
	public static void main(String arg[])
	{
		Session session=null;
		Transaction tx=null;
		
		
		try {
			session = HibUtil.getSession();
			tx=session.beginTransaction();//开启事务
				
			Company company=new Company();
			Address address=new Address();
			
			
			company.setName("北京市长安街");
			address.setCity("北京");
			company.setAddress(address);
			
			session.save(company);
			
			
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
