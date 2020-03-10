package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.dao.WorkDao;
import com.pojo.Admin;
import com.pojo.Buser;
import com.pojo.Cuser;
import com.pojo.User;
import com.pojo.Work;

@Repository
public class WorkDaoImpl implements WorkDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Work AddWork(Work work) {
		Session session = sessionFactory.getCurrentSession();
		session.save(work);
		return work;
	}


	@Override
	public boolean UpdateWork(Work work) {
		Session session = sessionFactory.getCurrentSession();
		session.update(work);
		return true;
	}


	@Override
	public Work getWork(String work_id) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Work.class, Integer.parseInt(work_id));
	}


	@Override
	public boolean DeleteWork(Work work) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(work);
		return true;
	}


	@Override
	public List<Work> AllWork() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Work").list();
	}


	@Override
	public List<Work> MyWork(String user_ID) {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Work as w where w.user_id="+user_ID).list();
	}


	@Override
	public Work getWorkBywork_title(String work_title) {
		Session session=sessionFactory.getCurrentSession();
		return (Work) session.createQuery("from Work as w where w.work_title='"+work_title+"'").uniqueResult();
	}
	
}
