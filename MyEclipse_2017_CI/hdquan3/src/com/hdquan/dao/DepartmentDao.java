package com.hdquan.dao;

import java.util.List;
import java.util.Set;

import com.hdquan.pojo.Department;
import com.hdquan.pojo.ExtendDepartment;
import com.hdquan.pojo.Role;

public interface DepartmentDao {
	public boolean deleteDepartment(String ids);
	
	public boolean updateDepartment(Department department,ExtendDepartment extendDepartment);
		
	public Object getDepartment(String name);
	
	public List<Object> getDepartments();
	
	public ExtendDepartment insert(ExtendDepartment extendDepartment);

	public Department insert(Department department);
	
	public Long getTotal();
	
	public Set<Role> update(int parentDepartment);
	
	public Department updateDepartmentRoles(Department department);
	
	public Department getDepartment(int number1);
	
	public ExtendDepartment getExtendDepartment(int number1);
}
