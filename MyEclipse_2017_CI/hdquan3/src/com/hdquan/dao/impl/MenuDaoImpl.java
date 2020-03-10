package com.hdquan.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hdquan.dao.MenuDao;
import com.hdquan.pojo.Menu;

@Repository
public class MenuDaoImpl implements MenuDao{
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Menu> tree(Menu menu) {
	
	String hql="";
	List param =new ArrayList();
	if(menu.getId()==null||menu.getId().trim().equals(""))
	{
		hql="select * from Menu m where m.pid is null ";
	}else
	{
		hql="select * from Menu m where m.pid = ?0 ";
		param.add(menu.getId());
	}
	hql+=" order by m.seq asc";
	Session session=sessionFactory.getCurrentSession();
	Query query = session.createSQLQuery(hql).addEntity(Menu.class);
	if(param !=null&&param.size()>0)
	{
		for(int i=0;i<param.size();i++)
		{
			query.setParameter(i, param.get(i));
		}
	}
		return query.list();
	}

	@Override
	public Long countChildren(String id) {
		 String hql = "select count(*) from Menu m where m.pid = ?0";
		 Session session=sessionFactory.getCurrentSession();
		BigInteger  uniqueResult =(BigInteger) session.createSQLQuery(hql).setParameter(0, id).uniqueResult();
	    return (Long)uniqueResult.longValue();
	}
}
