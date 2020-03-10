package com.hduqna.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibUtil {
	private static SessionFactory factory;
	private HibUtil()//私有化，外部不能new该类
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
