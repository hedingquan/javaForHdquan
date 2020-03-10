package com.hdquan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hdquan.MD5.AddWhere;
import com.hdquan.dao.RoleDao;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;

@Repository
public class RoleDaoImpl implements RoleDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role insertRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(role); //调用merge方法，此时实体状态并没有被持久化  //但是数据库中的记录被更新了
		return role;
	}
	
	@Override
	public Role OtherinsertRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.save(role);
		return role;
	}
	@Override
	public Role deleteRole(String ids) {
		Session session = sessionFactory.getCurrentSession();
		for(String id:ids.split(","))
		{
			Role role = session.get(Role.class,Integer.valueOf(id));
			if(role!=null)
			{
			try {
				role.getUsers().remove(role);
				role.getAdress().remove(role);
				role.setRoleId(null);
				role.setAdress(null);
				if(role.getDepartment()!=null)
				{
					role.getDepartment().getRoles().remove(role);
					role.getUserGroup().getRoles().remove(role);
				}
					session.delete(role);
					session.flush();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public Role updateRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(role);
		session.flush();
		return role;
	}

	@Override
	public Long getTotal() {
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(*) from Role";
		Query q = session.createQuery(hql);
		Long n =(Long)q.uniqueResult();
		return n;
	}

	public List<Role> getRoles(int page,int rows,String sort,String order,User user)
	{
		Session session=sessionFactory.getCurrentSession();
		String hql=null;
			hql="from Role as r";
		List<Object> values=new ArrayList<Object>();
		String hql1 = addWhere(hql,user);
		if(sort!=null&& order!=null)
		{
			hql1+=" order by "+sort+" "+order;
		}
		Query query = session.createQuery(hql1);
		List list = query.list();
		return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}
	
	@Override
	public List<Role> getRoles() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role as r where r.department=null";
		Query query = session.createQuery(hql);
		List list = query.list();
		return list;
	}

	
	@Override
	public Role getRole(String number) {
		Session session=sessionFactory.getCurrentSession();
		Role role = session.get(Role.class,Integer.valueOf(number));
		return role;
	}
	
	@Override
	public Role getRoleId(String roleId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role as r where r.roleId="+roleId;
		Query query = session.createQuery(hql);
		List list = query.list();
		return (Role)list.get(0);
	}
	
	@Override
	public List<Role> getRoles(String roleId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role as r where r.roleId="+roleId;
		Query query = session.createQuery(hql);
		List list = query.list();
		return list;
	}
	
	@Override
	public Role getRoleId(String roleId,int number1)
	{
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role as r where r.roleId="+roleId+" and r.department.number1="+number1;
		Query query = session.createQuery(hql);
		List list = query.list();
		return (Role)list.get(0);
	}
	
	public String addWhere (String hql,User user)
	{
		if(user.getUsercode()!=null)
		{
		 hql+=" inner join fetch  r.users u where u.usercode="+user.getUsercode();
		}
		 return hql;
	}

	@Override
	public List<Role> getDepartmentRoles(int number1) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role as r where r.department.number1="+number1+" and r.userGroup=null";
		Query query = session.createQuery(hql);
		List list = query.list();
		return list;
	}

	@Override
	public List<Role> getUserGroupRoles(String usGId) {
		Session session=sessionFactory.getCurrentSession();
		List<Role> list1=new ArrayList<Role>();
		for(String usGId1:usGId.split(","))
		{
			String hql="from Role as r where r.userGroup.usGId="+usGId1;
			Query query = session.createQuery(hql);
			List list = query.list();
			for(int i=0;i<list.size();i++)
			{
				list1.add((Role) list.get(i));
			}
		}
		return list1;
	}

	@Override
	public Role getRole(int permissionid) {
		Session session=sessionFactory.getCurrentSession();
		String hql="select r from Role as r inner join r.permission as p where p.id="+permissionid+" and r.userGroup=null and r.department=null";
		Query query = session.createQuery(hql,Role.class);
		List list = query.list();
		return (Role)list.get(0);
	}



}
