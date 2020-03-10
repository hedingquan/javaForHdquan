package com.hdquan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdquan.dao.UserGroupDao;
import com.hdquan.pojo.Department;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.UserGroup;
import com.hdquan.service.UserGroupService;

@Service
@Transactional
public class UserGroupServiceImpl implements UserGroupService{

	@Autowired
	UserGroupDao userGroupDao;
	
	@Override
	public UserGroup insertUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		return userGroupDao.insertUserGroup(userGroup);
	}

	@Override
	public UserGroup deleteUserGroup(String ids) {
		// TODO Auto-generated method stub
		return userGroupDao.deleteUserGroup(ids);
	}

	@Override
	public List<UserGroup> getUserGroup() {
		// TODO Auto-generated method stub
		return userGroupDao.getUserGroup();
	}

	@Override
	public Long getTotal() {
		// TODO Auto-generated method stub
		return userGroupDao.getTotal();
	}

	@Override
	public UserGroup updateUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		return userGroupDao.updateUserGroup(userGroup);
	}

	@Override
	public UserGroup getUserGroup(String usGId) {
		// TODO Auto-generated method stub
		return userGroupDao.getUserGroup(usGId);
	}

	@Override
	public List<UserGroup> getUserGroupByDepartment(int number1) {
		// TODO Auto-generated method stub
		return userGroupDao.getUserGroupByDepartment(number1);
	}

	@Override
	public List<Role> getDepartmentRoles(int usGId) {
		// TODO Auto-generated method stub
		return userGroupDao.getDepartmentRoles(usGId);
	}

	@Override
	public Department getDepartment(int usGId) {
		// TODO Auto-generated method stub
		return userGroupDao.getDepartment(usGId);
	}

	@Override
	public UserGroup getUserGroup1(String usGName) {
		// TODO Auto-generated method stub
		return userGroupDao.getUserGroup1(usGName);
	}

}
