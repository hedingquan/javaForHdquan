package com.hdquan.service;

import java.util.List;

import com.hdquan.pojo.Department;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.UserGroup;

public interface UserGroupService {

	public UserGroup insertUserGroup(UserGroup userGroup);//�����û���
	
	public UserGroup deleteUserGroup(String ids);
	
	public List<UserGroup> getUserGroup();
	
	public UserGroup getUserGroup(String usGId);
	
	public UserGroup getUserGroup1(String usGName);
	
	public Long getTotal();
	
	public UserGroup updateUserGroup(UserGroup userGroup);
	
	public List<UserGroup> getUserGroupByDepartment(int number1);
	
	public List<Role> getDepartmentRoles(int usGId);
	
	public Department getDepartment(int usGId);
}
