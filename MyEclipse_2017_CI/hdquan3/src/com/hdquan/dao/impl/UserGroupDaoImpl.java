package com.hdquan.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hdquan.dao.UserGroupDao;
import com.hdquan.pojo.Department;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;
import com.hdquan.pojo.UserGroup;

@Repository
public class UserGroupDaoImpl implements UserGroupDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserGroup insertUserGroup(UserGroup userGroup)
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(userGroup);
		return userGroup;
	}

	@Override
	public UserGroup deleteUserGroup(String ids) {
		Session session = sessionFactory.getCurrentSession();
		for(String id:ids.split(","))
		{
			UserGroup userGroup =(UserGroup)session.get(UserGroup.class,Integer.valueOf(id));
			if(userGroup.getRoles()!=null)
			for(Role role:userGroup.getRoles())
			{
				role.setUserGroup(null);
			}
			Set<User> users = userGroup.getUsers();
			for(User User:users)
			{
				User.setUserGroup(null);
			}
			userGroup.getRoles().removeAll(userGroup.getRoles());
			userGroup.getDepartment().getUserGroups().remove(userGroup);
			session.delete(userGroup);
			session.flush();
		}
		return null;
	}

	@Override
	public List<UserGroup> getUserGroup() {
		Session session = sessionFactory.getCurrentSession();
		String hql="from UserGroup";
		return session.createQuery(hql).list();
	}

	@Override
	public Long getTotal() {
		Session session = sessionFactory.getCurrentSession();
		String hql="select count(*) from UserGroup";
		return (Long)session.createQuery(hql).uniqueResult();
	}

	@Override
	public UserGroup updateUserGroup(UserGroup userGroup) {
			Session session = sessionFactory.getCurrentSession();
			session.merge(userGroup);
			return userGroup;
	}

	@Override
	public UserGroup getUserGroup(String usGId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(UserGroup.class,Integer.valueOf(usGId));
	}

	@Override
	public UserGroup getUserGroup1(String usGName) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from UserGroup as ug where ug.usGName="+usGName;
		return (UserGroup) session.createQuery(hql).uniqueResult();
	}
	
	@Override
	public List<UserGroup> getUserGroupByDepartment(int number1) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from UserGroup as u where u.department.number1="+number1;
		return session.createQuery(hql).list();
	}

	@Override
	public List<Role> getDepartmentRoles(int usGId) {
		Session session = sessionFactory.getCurrentSession();
		String hql="select r from UserGroup as u inner join u.department as d inner join d.roles as r where u.usGId="+usGId+" and r.userGroup=null";
		return session.createQuery(hql).list();
	}

	@Override
	public Department getDepartment(int usGId) {
		Session session = sessionFactory.getCurrentSession();
		String hql="select u.department from UserGroup as u where u.usGId="+usGId;
		return (Department)session.createQuery(hql).list().get(0);
	}
}