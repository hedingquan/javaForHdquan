package com.hdquan.service;

import java.util.List;
import java.util.Set;

import com.hdquan.pojo.Department;
import com.hdquan.pojo.ExtendDepartment;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;

public interface DepartmentService {

	public boolean deleteDepartment(String ids);
		
	public Object getDepartment(String name);
	
	public List<Object> getDepartments();
	
	public ExtendDepartment insert(ExtendDepartment extendDepartment);
	
	public Department insert(Department department);
	
	public Long getTotal();

	public Set<Role> update(int parentDepartment);
	
	public boolean updateDepartment(Department department,ExtendDepartment extendDepartment);
	
	public Department getDepartment(int number1);
	
	public Department updateDepartmentRoles(Department department);
}
