package com.hdquan.dao;

import java.util.List;

import com.hdquan.pojo.Department;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.UserGroup;

public interface UserGroupDao {

	public UserGroup insertUserGroup(UserGroup userGroup);

	public UserGroup deleteUserGroup(String ids);
	
	public List<UserGroup> getUserGroup();
	
	public UserGroup getUserGroup(String usGId);
	
	public Long getTotal();
	
	public UserGroup updateUserGroup(UserGroup userGroup);
	
	public List<UserGroup> getUserGroupByDepartment(int number1);
	
	public List<Role> getDepartmentRoles(int usGId);
	
	public Department getDepartment(int usGId);
}
