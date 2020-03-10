package com.hdquan.dao;

import java.util.List;
import java.util.Set;

import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;

public interface PermissionDao {
	
	//treegetPermission
	public List<Permission> getPermission(String id,String roleId,Permission Permission);

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
