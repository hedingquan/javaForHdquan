package com.hdquan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdquan.dao.UserDao;
import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;
import com.hdquan.service.UserService;

@Service
@Transactional
public  class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	public User queryByNameAndPwd(String usercode) {
		// TODO Auto-generated method stub
		return userDao.queryByNameAndPwd(usercode);
	}
	@Override
	public User findUserByUserId(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserId(id);
	}
	@Override
	public List<Object[]> findUserDepartmentByName(String realName) {
		// TODO Auto-generated method stub
		return userDao.findUserDepartmentByName(realName);
	}
	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}
	@Override
	public boolean deleteUser(String userids) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userids);
	}
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}
	
	@Override
	public List<Role> findUserRoleByName(String realName) {
		// TODO Auto-generated method stub
		return userDao.findUserRoleByName(realName);
	}
	@Override
	public List<Permission> findUserPermissionByName(String realName) {
		// TODO Auto-generated method stub
		return userDao.findUserPermissionByName(realName);
	}
	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userDao.getUser();
	}
	@Override
	public List<User> getUser(int page, int rows, Object... param) {
		// TODO Auto-generated method stub
		return userDao.getUser(page, rows, param);
	}
	@Override
	public Long getTotal() {
		// TODO Auto-generated method stub
		return userDao.getTotal();
	}
	@Override
	public List<User> getUsers(int page, int rows, String sort, String order,User user) {
		
		return userDao.getUsers(page,rows,sort,order,user);
	}
}
