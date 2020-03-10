package com.hdquan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		session.merge(role); 
		session.flush();
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
				role.getPermission().remove(role);
				role.getAdress().remove(role);
				role.setRoleId(null);
				role.setAdress(null);
				if(role.getDepartment()!=null)
				{
					role.getDepartment().getRoles().remove(role);
				}
				if(role.getUserGroup()!=null)
				{					
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
		String hql="select count(*) from Role as r where r.department=null";
		return (Long)session.createQuery(hql).uniqueResult();
	}
	
	@Override
	public Long getThisUserTotal(String usercode) {
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(*) from Role as r inner join  r.users as u where u.usercode='"+usercode+"' and r.department=null";
		return (Long)session.createQuery(hql).uniqueResult();
	}

	public List<Role> getRoles(int page,int rows,String sort,String order,User user)
	{
		Session session=sessionFactory.getCurrentSession();
		String hql=null;
		hql="from Role as r";
		String hql1 = addWhere(hql,user);
		if(sort!=null&& order!=null)
		{
			hql1+=" order by "+sort+" "+order;
		}
		Query query = session.createQuery(hql1);
		return query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}
	
	@Override
	public List<Role> getRoles() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role as r where r.department=null";
		return session.createQuery(hql).list();
	}

	
	@Override
	public Role getRole(String number) {
		Session session=sessionFactory.getCurrentSession();
		return session.get(Role.class,Integer.valueOf(number));
	}
	
	@Override
	public List<Role> getRoleId(String roleId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role as r where r.roleId="+roleId;
		return session.createQuery(hql).list();
	}
	
	@Override
	public List<Role> getRoles(String roleId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role as r where r.roleId="+roleId;
		return session.createQuery(hql).list();
	}
	
	@Override
	public Role getRoleId(String roleId,int number1)
	{
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role as r where r.roleId="+roleId+" and r.department.number1="+number1;
		return (Role)session.createQuery(hql).list().get(0);
	}
	
	public String addWhere (String hql,User user)
	{
		if(user.getUsercode()!=null)
		{
		 hql+=" inner join fetch  r.users u where u.usercode='"+user.getUsercode()+"' and r.department=null";
		}else{
			hql+=" where r.department=null";
		}
		 return hql;
	}

	@Override
	public List<Role> getDepartmentRoles(int number1) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role as r where r.department.number1="+number1+" and r.userGroup=null";
		return session.createQuery(hql).list();
	}

	@Override
	public List<Role> getUserGroupRoles(String usGId) {
		Session session=sessionFactory.getCurrentSession();
		List<Role> list1=new ArrayList<Role>();
		for(String usGId1:usGId.split(","))
		{
			String hql="from Role as r where r.userGroup.usGId="+usGId1;
			List list = session.createQuery(hql).list();
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
		String hql="select r from Role as r inner join r.permission as p where p.id="+permissionid+" and r.userGroup=null and r.department!=null";
		return (Role)session.createQuery(hql,Role.class).list().get(0);
	}

	@Override
	public List<Role> getRoles1() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Role as r";
		return session.createQuery(hql).list();
	}
}
