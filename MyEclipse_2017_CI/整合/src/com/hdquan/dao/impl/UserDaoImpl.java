package com.hdquan.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hdquan.dao.UserDao;
import com.hdquan.pojo.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public User queryByNameAndPwd(User user) {
	Session session=sessionFactory.getCurrentSession();
	String hql="from User u where u.uname=?0 and u.upwd=?1";
	User u=session.createQuery(hql, User.class).setParameter(0, user.getUname()).setParameter(1, user.getUpwd()).uniqueResult();
		return u;
	}
}
