package com.hdquan.HibUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibUtil {
	private static SessionFactory factory;
	private HibUtil()
	{
	}
	static
	{
		factory=new Configuration().configure().buildSessionFactory();
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
