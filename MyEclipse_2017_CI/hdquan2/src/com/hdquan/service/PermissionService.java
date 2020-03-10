package com.hdquan.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;

public interface PermissionService {

	public List<Permission> getPermission(String id,String roleId,Permission permission);

	public Long countChildren(String id);
	
	public Permission getPermission(String id);
	
	public List<Role> getRoles(String id);
	
	public List<Permission> getPermission();
	
	public List<Permission> getPermissionByDepartment(int number1);
	
	public List<Permission> getPermissionByUserGroup(String usGId);
	
	public Permission insertPermission(Permission permission);
	
	public Permission updatePermission(Permission permission);
	
	public Permission deletePermission(List<Permission> permission);
}
