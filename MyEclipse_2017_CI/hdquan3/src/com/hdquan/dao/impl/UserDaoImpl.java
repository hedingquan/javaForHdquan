package com.hdquan.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hdquan.MD5.AddWhere;
import com.hdquan.dao.UserDao;
import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public User queryByNameAndPwd(String usercode) {
	Session session=sessionFactory.getCurrentSession();
	String hql="from User u where u.usercode=?0";
	return (User) session.createQuery(hql).setParameter(0, usercode).list().get(0);
	}

	public List<User> getUser()
	{
		Session session=sessionFactory.getCurrentSession();
		String hql="from User u";
		return session.createQuery(hql).list();
	}
	
	
	public List<User> getUsers(int page,int rows,String sort,String order,User user)
	{
		Session session=sessionFactory.getCurrentSession();
		String hql="from User u  where 1=1 ";
		List<Object> values=new ArrayList<Object>();
		hql=AddWhere.addWhere(user,hql,values);
		if(sort!=null&& order!=null)
		{
			hql+=" order by "+sort+" "+order;
		}
		Query query = session.createQuery(hql);
		return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}
	
	public List<User> getUser(int page,int rows,Object...param)
	{
		Session session=sessionFactory.getCurrentSession();
		String hql="from User u";
		Query query = session.createQuery(hql);
		if(param !=null&&param.length>0)
		{
			for(int i=0;i<param.length;i++)
			{
				query.setParameter(i, param[i]);
			}
		}
		return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}
	
	public User findUserByUserId(String userid) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from User u where u.userid='"+userid+"'";
		return session.createQuery(hql, User.class).uniqueResult();
	}
	@Override
	public User insertUser(User user) {
		Session	session=sessionFactory.getCurrentSession();
			session.save(user);
			return user;
	}

	@Override
	public boolean deleteUser(String userids) {
		Session	session=sessionFactory.getCurrentSession();
		  for(String userid:userids.split(","))
			{
			  User user=session.get(User.class,userid);
					if(user!=null)
					{
						if(user.getDepartment()!=null)
						{
							user.getDepartment().getUsers().remove(user);
						}
						if(user.getUserGroup()!=null)
						{
							user.getUserGroup().getUsers().remove(user);
						}
						session.delete(user);
					}
			}
		return true;
	}

	@Override
	public User updateUser(User user) {
		Session	session=sessionFactory.getCurrentSession();
		session.merge(user);
		return user;
	}

	@Override
	public Long getTotal() {
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(*) from User";
		return (Long)session.createQuery(hql).uniqueResult();
	}

	@Override
	public List findUserDepartmentByName(String realName) {
		Session session=sessionFactory.getCurrentSession();
		String hql="select u.department.number as UDnumber,u.department.name as UDname,u.department.headerName as UDheaderName,u.department.officeLocation as UDofficeLocation,u.department.telephone as UDtelephone,u.department.lastDepartment as UDlastDepartment,u.department.parentDepart as UDparentDepart from User u where u.realName=?0";
		Query query = session.createQuery(hql);
		query.setParameter(0, "Ȩ");
		Query setResultTransformer = query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		  List list = query.list();
		  for(int i=0;i<list.size();i++)
		  {
		  Object object = list.get(i);
		  HashMap hashMap=(HashMap)object;
		    Iterator it=hashMap.keySet().iterator();
		    while(it.hasNext()) 
		    {  String j =  (String) it.next();
            System.out.print(hashMap.get(j)+"");
		    }	
		  }
		return list;
	}


	@Override
	public List<Role> findUserRoleByName(String realName) {
		Session session = sessionFactory.getCurrentSession();
		String hql="select u.roles.roleId from User u where u.realName=?0";
		Object object= session.createQuery(hql).setParameter(0, realName).list().get(0);
		return null;
	}

	@Override
	public List<Permission> findUserPermissionByName(String realName) {
		Session session = sessionFactory.getCurrentSession();
		String hql="select r.permission from User as u inner join u.roles as r where u.usercode=?0";
		return session.createQuery(hql).setParameter(0, realName).list();
	}

	@Override
	public User login(User user) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from User u where u.username=?0 and u.password=?1";
		List list = session.createQuery(hql).setParameter(0, user.getUsercode()).setParameter(1, user.getUsername()).list();
		if(list!=null)
		{
			BeanUtils.copyProperties(user, list);
			return user;
		}
		return null;
	}
}