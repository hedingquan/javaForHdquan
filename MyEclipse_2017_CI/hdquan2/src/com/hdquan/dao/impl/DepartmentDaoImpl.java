package com.hdquan.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hdquan.dao.DepartmentDao;
import com.hdquan.pojo.Department;
import com.hdquan.pojo.ExtendDepartment;
import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;


@Repository
public class DepartmentDaoImpl implements DepartmentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean deleteDepartment(String ids) {
		Session session = sessionFactory.getCurrentSession();
		for(String id:ids.split(","))
		{
			Department department = session.get(Department.class,Integer.valueOf(id));
			if(department!=null)
			{
			try {
				Set<User> users = department.getUsers();
				for(User User:users)
				{
					User.setDepartment(null);//删除部门的时候所有在该部门的用户都变为null
					User.setUserGroup(null);
				}
				//department.getUsers().remove(department);
					session.delete(department);
					session.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				ExtendDepartment extendDepartment = session.get(ExtendDepartment.class,Integer.valueOf(id));
				if(extendDepartment!=null)
				{	
				extendDepartment.setUsers(null);
				extendDepartment.getUsers().remove(department);
					session.delete(department);
					session.flush();
				}else{
					break;
				}
			}
		}
		return true;
	}
	
	public Department insert(Department department)
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(department);
		return department;
	}
	
	public ExtendDepartment insert(ExtendDepartment extendDepartment)
	{
		Session session = sessionFactory.getCurrentSession();
		session.save(extendDepartment);
		return extendDepartment;
	}
	
	
	public Set<Role> update(int parentDepartment)
	{
		Session session = sessionFactory.getCurrentSession();
		ExtendDepartment extendDepartment = (ExtendDepartment)session.get(ExtendDepartment.class,parentDepartment);
		if(extendDepartment!=null)
		{
			extendDepartment.setLastDepartment(false);
		session.update(extendDepartment);
		Set<Role> roles = extendDepartment.getRoles();
		return roles;
		}
		else{
		Department department = (Department)session.get(Department.class,parentDepartment);
		department.setLastDepartment(false);
		session.update(department);
		Set<Role> roles = department.getRoles();
		return roles;
		}
	}
	
	
	public Object getDepartment(String name)
	{
		Session session = sessionFactory.getCurrentSession();
		String hql="from ExtendDepartment extendDepartment where extendDepartment.name like'%"+name+"%'";
		Query query = session.createQuery(hql);
		List list = query.list();
		if(list!=null&&list.size()>0)
		{
			return list.get(0);
		}else
		{
			String hql1="from Department department where department.name like'%"+name+"%'";
			Query query1 = session.createQuery(hql1);
			List list1 = query1.list();
			if(list1!=null&&list1.size()>0)
			{				
				return list1.get(0);
			}else{
				return null;
			}
		}
	}
	
	public boolean updateDepartment(Department department,ExtendDepartment extendDepartment)
	{
		Session session = sessionFactory.getCurrentSession();
		if(department!=null){			
			Department department2 = session.get(Department.class, department.getNumber1());
			try {
				BeanUtils.copyProperties(department, department2);
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.update(department2);
		}
		if(extendDepartment!=null)
		{
		Department department2 = session.get(ExtendDepartment.class, extendDepartment.getNumber1());
		BeanUtils.copyProperties(extendDepartment,department2);
			session.update(department2);
		}
		return true;
	}

	@Override
	public Department updateDepartmentRoles(Department department) {
		Session session = sessionFactory.getCurrentSession();
		session.update(department);
		return department;
	}
	
	@Override
	public List<Object> getDepartments() {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Department";
		String Otherhql="from ExtendDepartment";
		Query query = session.createQuery(hql);
		List list1 = query.list();
		Query Otherquery = session.createQuery(Otherhql);
		List list2 = Otherquery.list();
		list1.add(list2);
		return list1;
	}
	
	@Override
	public Long getTotal() {
		Session session=sessionFactory.getCurrentSession();
		String hql="select count(*) from Department";
		Query q = session.createQuery(hql);
		Long n =(Long)q.uniqueResult();
		String Otherhql="select count(*) from ExtendDepartment";
		Query Otherq = session.createQuery(Otherhql);
		Long on =(Long)Otherq.uniqueResult();
		n+=on;
		return n;
	}

	@Override
	public Department getDepartment(int number1) {
		Session session=sessionFactory.getCurrentSession();
		Department department = session.get(Department.class, number1);
		return department;
	}

}
