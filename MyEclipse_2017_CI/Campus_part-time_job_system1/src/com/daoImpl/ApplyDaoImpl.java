package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ApplyDao;
import com.pojo.Apply;

@Repository
public class ApplyDaoImpl implements ApplyDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Apply AddApply(Apply apply) {
			Session session = sessionFactory.getCurrentSession();
			session.save(apply);
			return apply;
	}


	@Override
	public boolean UpdateApply(Apply apply) {
			Session session = sessionFactory.getCurrentSession();
			session.update(apply);
			return true;
	}


	@Override
	public Apply getApply(String apply_id) {
			Session session=sessionFactory.getCurrentSession();
			return session.get(Apply.class, Integer.parseInt(apply_id));
	}


	@Override
	public boolean DeleteApply(Apply apply) {
			Session session=sessionFactory.getCurrentSession();
			session.delete(apply);
			return true;
	}


	@Override
	public List<Apply> getApplyUser(String work_id) {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Apply as a where a.work_id='"+work_id+"'").list();
	}


	@Override
	public List<Apply> getMyApply(String user_id) {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Apply as a where a.user_id='"+user_id+"'").list();
	}


	@Override
	public List<Apply> getAllApply() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Apply").list();
	}


	@Override
	public List<Apply> getToBeAuditedApply(String work_id) {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Apply as a where a.apply_state='ToBeAudited' and a.work_id='"+work_id+"'").list();
	}
	
}
