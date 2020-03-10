package com.hdquan.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hdquan.dao.AdressDao;
import com.hdquan.dao.UserGroupDao;
import com.hdquan.pojo.Adress;
import com.hdquan.pojo.User;
import com.hdquan.pojo.UserGroup;

@Repository
public class AdressDaoImpl implements AdressDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public int insertAdress(Adress adress)
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(adress);
		return adress.getId();
	}

	public Adress deleteAdress(String ids) {
		Session session = sessionFactory.getCurrentSession();
		for(String id:ids.split(","))
		{
			Adress adress =(Adress)session.get(Adress.class,Integer.valueOf(id));
			session.delete(adress);
		}
		return null;
	}

	public List<Adress> getAdress(Adress adress,User k) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Adress as a where 1=1 ";
		String hql1 = addWhere(hql,adress);
		if(k!=null)
		{
//			hql1+=" and "
		}
		Query query = session.createQuery(hql1);
		List list = query.list();
		return list;
	}

	public Long getTotal() {
		Session session = sessionFactory.getCurrentSession();
		String hql="select count(*) from Adress";
		Query q = session.createQuery(hql);
		Long n =(Long)q.uniqueResult();
		return n;
	}

	@Override
	public List<Adress> getAdressByroles(String userName) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Adress as a inner join fetch a.roles as r inner join fetch r.users as u where u.usercode="+userName;
		Query query = session.createQuery(hql);
		List list = query.list();
		return list;
	}

	@Override
	public Adress updateAdress(Adress adress) {
		Session session = sessionFactory.getCurrentSession();
		Adress adress2 = session.get(Adress.class, adress.getId());
		adress2.setIPStart(adress.getIPStart());
		adress2.setIPEnd(adress.getIPEnd());
		session.merge(adress2);
		return adress2;
	}
	
	public String addWhere(String hql,Adress adress)
	{
		if(adress.getIPStart()!=null&&!("".equals(adress.getIPStart())))
		{
//			hql+=" and a.IPStart>="+adress.getIPStart();
		}
		if(adress.getIPEnd()!=null&&!("".equals(adress.getIPEnd())))
		{
//			hql+=" and a.IPEnd<="+adress.getIPEnd();
		}
		return hql;
	}
}
