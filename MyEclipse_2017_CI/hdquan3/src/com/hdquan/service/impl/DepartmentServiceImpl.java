package com.hdquan.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdquan.dao.DepartmentDao;
import com.hdquan.pojo.Department;
import com.hdquan.pojo.ExtendDepartment;
import com.hdquan.pojo.Role;
import com.hdquan.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentDao DepartmentDao;

	
	
	public Object getDepartment(String name)
	{
		return DepartmentDao.getDepartment(name);
	}

	@Override
	public List<Object> getDepartments() {
		// TODO Auto-generated method stub
		return DepartmentDao.getDepartments();
	}

	@Override
	public Long getTotal() {
		// TODO Auto-generated method stub
		return DepartmentDao.getTotal();
	}

	@Override
	public boolean deleteDepartment(String ids) {
		// TODO Auto-generated method stub
		return DepartmentDao.deleteDepartment(ids);
	}

	@Override
	public Set<Role> update(int parentDepartment){
		// TODO Auto-generated method stub
		return DepartmentDao.update(parentDepartment);
	}

	@Override
	public boolean updateDepartment(Department department,ExtendDepartment extendDepartment) {
		return DepartmentDao.updateDepartment(department,extendDepartment);
	}

	@Override
	public ExtendDepartment insert(ExtendDepartment extendDepartment) {
		// TODO Auto-generated method stub
		return DepartmentDao.insert(extendDepartment);
	}

	@Override
	public Department insert(Department department) {
		// TODO Auto-generated method stub
		return DepartmentDao.insert(department);
	}

	@Override
	public Department getDepartment(int number1) {
		// TODO Auto-generated method stub
		return DepartmentDao.getDepartment(number1);
	}

	@Override
	public Department updateDepartmentRoles(Department department) {
		// TODO Auto-generated method stub
		return DepartmentDao.updateDepartmentRoles(department);
	}

	@Override
	public ExtendDepartment getExtendDepartment(int number1) {
		// TODO Auto-generated method stub
		return DepartmentDao.getExtendDepartment(number1);
	}

}
