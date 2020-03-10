package com.hdquan.daoImpl;


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
	
	public User queryByNameAndPwd(String username) {
	Session session=sessionFactory.getCurrentSession();
	String hql="from User u where u.username="+username;
	User user=(User) session.createQuery(hql).list().get(0);
	return user;
	}
}