package com.hdquan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hdquan.dao.ProvisionalAuthorizationDao;
import com.hdquan.pojo.ProvisionalAuthorization;
import com.hdquan.pojo.User;

@Repository
public class ProvisionalAuthorizationDaoImpl implements ProvisionalAuthorizationDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ProvisionalAuthorization> getRoles(int page, int rows, String sort, String order, User user,ProvisionalAuthorization provisionalAuthorization) {
			Session session=sessionFactory.getCurrentSession();
			String hql="from ProvisionalAuthorization as p where 1=1 ";
			if(user.getUsercode()!=null)
			{
				hql+="and p.usercode="+user.getUsercode();
			}
			hql = addWhere(hql,provisionalAuthorization);
			List<Object> values=new ArrayList<Object>();
			if(sort!=null&& order!=null)
			{
				hql+=" order by "+sort+" "+order;
			}
			Query query = session.createQuery(hql);
			return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();	
	}

	@Override
	public Long getTotal() {
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(*) from ProvisionalAuthorization";
		return (Long)session.createQuery(hql).uniqueResult();
	}
	
	public String addWhere (String hql,ProvisionalAuthorization provisionalAuthorization)
	{
	if(provisionalAuthorization!=null){
				if(provisionalAuthorization.getUsercode()!=null&&!"".equals(provisionalAuthorization.getUsercode().trim()))
				{
				 hql+=" and p.usercode="+provisionalAuthorization.getUsercode();
				}
				if(provisionalAuthorization.getRecoveryTime()!=null&&!"".equals(provisionalAuthorization.getRecoveryTime().trim())){
					 hql+=" and p.RecoveryTime="+provisionalAuthorization.getRecoveryTime();
				}
				if(provisionalAuthorization.getRoleid()!=null&&!"".equals(provisionalAuthorization.getRoleid().trim())){
					 hql+=" and p.roleid="+provisionalAuthorization.getRoleid();
				}
	}
		 return hql;
	}

	@Override
	public ProvisionalAuthorization insertRole(ProvisionalAuthorization provisionalAuthorization) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(provisionalAuthorization);
		return provisionalAuthorization;
	}

	@Override
	public ProvisionalAuthorization deleteRole(String id) {
		Session session = sessionFactory.getCurrentSession();
		ProvisionalAuthorization provisionalAuthorization = session.get(ProvisionalAuthorization.class,id);
		if(provisionalAuthorization!=null)
		{
			session.delete(provisionalAuthorization);
		}
		return provisionalAuthorization;
	}

	@Override
	public ProvisionalAuthorization updateRole(ProvisionalAuthorization provisionalAuthorization) {
			Session session = sessionFactory.getCurrentSession();
			session.merge(provisionalAuthorization);
			return provisionalAuthorization;
	}

	@Override
	public ProvisionalAuthorization getRole(String usercode) {
		Session session = sessionFactory.getCurrentSession();
		ProvisionalAuthorization provisionalAuthorization = session.get(ProvisionalAuthorization.class,usercode);
		if(provisionalAuthorization!=null){			
			return provisionalAuthorization;
		}
		return null;
	}
}
