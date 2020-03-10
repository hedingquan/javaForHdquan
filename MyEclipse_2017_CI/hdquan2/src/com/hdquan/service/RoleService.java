package com.hdquan.service;

import java.util.List;

import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;

public interface RoleService {

	public Role insertRole(Role role);
	
	public Role deleteRole(String ids);
	
	public List<Role> getRoles(int page,int rows,String sort,String order,User user);
	
	public Long getTotal();
	
	public Role updateRole(Role role);
	
	public Role OtherinsertRole(Role role);
	
	public Role getRole(String number);
	
	public Role getRoleId(String roleId);
	
	public List<Role> getRoles(String roleId);
	
	public Role getRoleId(String roleId,int number1);
	
	public List<Role> getDepartmentRoles(int number1);
	
	public List<Role> getUserGroupRoles(String usGId);
	
	public List<Role> getRoles();
	
	public Role getRole(int permissionid);
}
