package com.hdquan.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hdquan.dao.PermissionDao;
import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;

@Repository
public class PermissionDaoImpl implements PermissionDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Permission> getPermission(String id,String roleId,Permission permission) {

		String hql="";
		List param =new ArrayList();
		if(id==null||id.trim().equals(""))
		{
			hql="from Permission as p  where p.parentid is null";
		}else
		{
			hql="from Permission as p  where p.parentid =?0 ";
			param.add(Integer.valueOf(id));
		}
			if(permission.getName()!=null){
				hql="from Permission as p where 1=1 ";
			}
		String hql1 = addWhere(hql,roleId,permission);
//		hql1+=" order by p.sortString asc";
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql1);
		if(param !=null&&param.size()>0)
		{
			for(int i=0;i<param.size();i++)
			{
				query.setParameter(i, param.get(i));
			}
		}
		List list = query.list();
			return list;
	}
	public Permission getPermission(String id) {
		Session session=sessionFactory.getCurrentSession();
		if(id!=null||!id.trim().equals(""))
		{
			String hql="from Permission p where p.id="+Integer.valueOf(id);
			Query query = session.createQuery(hql);
			List list = query.list();
			if(list.size()>0)
			{
				return (Permission)list.get(0);
			}
		}
		return null;
	}
	public String addWhere(String hql,String roleId,Permission permission)
	{
		if(roleId!=null)
		{
			hql+=" and p.role.roleId="+roleId;
		}
		if(permission.getName()!=null&&!permission.getName().trim().equals(""))
		{
			hql+=" and p.name like '%"+permission.getName()+"%'";
		}
		if(permission.getType()!=null&&!permission.getType().trim().equals(""))
		{
			hql+=" and p.type like '%"+permission.getType()+"%'";
		}
		if(permission.getRank()!=null&&!permission.getRank().trim().equals(""))
		{
			hql+=" and p.rank like '%"+permission.getRank()+"%'";
		}
		return hql;
	}
	@Override
	public Long countChildren(String id) {
		 String hql = "select count(*) from Permission p where p.parentid = ?0";
		 Session session=sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(hql);
		query.setParameter(0, id);
		BigInteger  uniqueResult =(BigInteger) query.uniqueResult();
		Long n =uniqueResult.longValue();
		return n;
	}
	@Override
	public List<Role> getRoles(String id) {
		Session session=sessionFactory.getCurrentSession();
		 if(id!=null||!id.trim().equals(""))
			{ 
		 String hql ="select p.roles from Permission p where p.id="+Integer.valueOf(id);
		Query query = session.createQuery(hql);
		List list = query.list();
		if(list.size()>0)
		{
			return list;
		}
			}
		 return null;
	}
	@Override
	public List<Permission> getPermission() {
		Session session=sessionFactory.getCurrentSession();
		 String hql ="from Permission";
		 Query query = session.createQuery(hql);
		 List list = query.list();
		return list;
	}
	@Override
	public List<Permission> getPermissionByDepartment(int number1) {
		Session session=sessionFactory.getCurrentSession();
		 String hql ="from Permission as p inner join fetch p.roles as r where r.department.number1="+number1;
		 Query query = session.createQuery(hql,Permission.class);
		 List list = query.list();
		return list;
	}
	@Override
	public List<Permission> getPermissionByUserGroup(String usGId){
		Session session=sessionFactory.getCurrentSession();
		List<Permission> permissions=new ArrayList<Permission>();
		for(String usGId1:usGId.split(","))
		{
			 String hql ="from Permission as p inner join fetch p.roles as r where r.userGroup.usGId="+usGId1;
			 Query query = session.createQuery(hql,Permission.class);
			 List list = query.list();
			 for(int i=0;i<list.size();i++)
			 {				 
				 permissions.add((Permission) list.get(i));
			 }
		}
		return permissions;
	}
	@Override
	public Permission insertPermission(Permission permission) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(permission);
		return permission;
	}
	@Override
	public Permission updatePermission(Permission permission) {
		Session session = sessionFactory.getCurrentSession();
		session.update(permission);
		return permission;
	}
	@Override
	public Permission deletePermission(List<Permission> permission) {
		Session session = sessionFactory.getCurrentSession();
		for(Permission permission1:permission)
		{
			Permission permission2	=(Permission)session.get(Permission.class, permission1.getId());
			if(permission2!=null){				
				session.delete(permission2);
			}
		}
		return null;
	}
}
