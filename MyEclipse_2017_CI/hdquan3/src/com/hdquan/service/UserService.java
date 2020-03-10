package com.hdquan.service;

import java.util.List;
import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;

public interface UserService {
	
	public List<User> getUser();
	
	public List<User> getUser(int page,int rows,Object...param);
	
	public List<User> getUsers(int page,int rows,String sort,String order, User user);
	
	public User queryByNameAndPwd(String usercode);
	
	public User findUserByUserId(String userid);
	
	public List<Object[]> findUserDepartmentByName(String realName);
	
	public User insertUser(User user);
	
	public boolean deleteUser(String userids);
	
	public User updateUser(User user);
	
	public  List<Role> findUserRoleByName(String realName);
	
	public List<Permission> findUserPermissionByName(String realName);

	public Long getTotal();
}
