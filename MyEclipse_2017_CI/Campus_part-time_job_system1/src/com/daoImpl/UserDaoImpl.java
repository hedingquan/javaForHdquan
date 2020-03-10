package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.pojo.Admin;
import com.pojo.Buser;
import com.pojo.Cuser;
import com.pojo.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Object user(String user_name) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Admin as u where u.user_name='"+user_name+"'";
		List list = session.createQuery(hql).list();
		if(list.size()==0)
		{
			 hql="from Buser as u where u.user_name='"+user_name+"'";
			 list = session.createQuery(hql).list();
				if(list.size()==0)
				{
					 hql="from Cuser as u where u.user_name='"+user_name+"'";
					 list = session.createQuery(hql).list();
				}
		}
		if(list.size()==0)
		{
			return null;
		}else
		{			
			return list.get(0);
		}
	}

	@Override
	public boolean AddCuser(Cuser user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return true;
	}

	@Override
	public boolean AddAdmin(Admin user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return true;
	}

	@Override
	public boolean AddBuser(Buser user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return true;
	}

	@Override
	public boolean AddUser(Object user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return true;
	}

	@Override
	public boolean UpdateUser(Object user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		return true;
	}

	@Override
	public boolean UpdateCuser(Cuser user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		return true;
	}

	@Override
	public boolean UpdateAdmin(Admin user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		return true;
	}

	@Override
	public boolean UpdateBuser(Buser user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		return true;
	}

	@Override
	public Cuser getCuser(String user_ID) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Cuser.class, user_ID);
	}

	@Override
	public Admin getAdmin(String user_ID) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Admin.class, user_ID);
	}

	@Override
	public Buser getBuser(String user_ID) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Buser.class, user_ID);
	}

	@Override
	public boolean DeleteCuser(Cuser user) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(user);
		return true;
	}

	@Override
	public boolean DeleteAdmin(Admin user) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(user);
		return true;
	}

	@Override
	public boolean DeleteBuser(Buser user) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(user);
		return true;
	}
	
}
