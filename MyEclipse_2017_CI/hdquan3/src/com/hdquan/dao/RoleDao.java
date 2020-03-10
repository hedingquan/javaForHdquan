package com.hdquan.dao;

import java.util.List;

import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;

public interface RoleDao {

	public Role insertRole(Role role);
	
	public Role deleteRole(String ids);
	
	public Role updateRole(Role role);
	
	public List<Role> getRoles(int page,int rows,String sort,String order,User user);

	public Long getTotal();
	
	public Long getThisUserTotal(String usercode);

	public Role OtherinsertRole(Role role);
	
	public Role getRole(String number);
	
	public List<Role> getRoleId(String roleId);
	
	public List<Role> getRoles(String roleId);
	
	public Role getRoleId(String roleId,int number1);
	
	public List<Role> getDepartmentRoles(int number1);
	
	public List<Role> getUserGroupRoles(String usGId);
	
	public List<Role> getRoles();
	
	public List<Role> getRoles1();
	
	public Role getRole(int permissionid);
}
