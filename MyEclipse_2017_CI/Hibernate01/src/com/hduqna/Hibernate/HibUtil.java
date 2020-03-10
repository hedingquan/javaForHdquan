package com.hduqna.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibUtil {
	private static SessionFactory factory;
	private HibUtil()//˽�л����ⲿ����new����
	{
	}
	static
	{
		Configuration configuration=new Configuration();
		configuration.configure();
//		configuration.configure("hibernate22.cfg.xml");
		factory=configuration.buildSessionFactory();
		
	}
	public static SessionFactory getFactory()
	{
		return factory;
	}
	public static Session getSession()
	{
		return factory.openSession();
	}
}
