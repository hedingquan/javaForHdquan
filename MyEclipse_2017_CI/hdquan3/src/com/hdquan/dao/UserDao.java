package com.hdquan.dao;

import java.util.List;

import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;

public interface UserDao {

	User login (User user);
	 
	List<User> getUser();
	
	List<User> getUser(int page,int rows,Object...param);
	
	public List<User> getUsers(int page,int rows,String sort,String order,User user);
	
	User queryByNameAndPwd(String usercode);
	
	public User findUserByUserId(String userid);
	
	List<Object[]> findUserDepartmentByName(String realName);
	
	List<Role> findUserRoleByName(String realName);
	
	List<Permission> findUserPermissionByName(String realName);
	
	User insertUser(User user);
	
	boolean deleteUser(String userids);//ɾ���û�
	
	User updateUser(User user);//�����û�
	
	Long getTotal();//�û�����

}
