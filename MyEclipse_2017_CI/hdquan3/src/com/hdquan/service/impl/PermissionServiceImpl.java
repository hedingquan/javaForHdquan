package com.hdquan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdquan.dao.PermissionDao;
import com.hdquan.pojo.Permission;
import com.hdquan.pojo.Role;
import com.hdquan.service.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	PermissionDao PermissionDao;

	@Override
	public List<Permission> getPermission(String id,String roleId,Permission permission) {
		// TODO Auto-generated method stub
		return PermissionDao.getPermission(id,roleId,permission);
	}

	@Override
	public Long countChildren(String id) {
		// TODO Auto-generated method stub
		return PermissionDao.countChildren(id);
	}

	@Override
	public Permission getPermission(String id) {
		// TODO Auto-generated method stub
		return PermissionDao.getPermission(id);
	}

	@Override
	public List<Role> getRoles(String id) {
		// TODO Auto-generated method stub
		return PermissionDao.getRoles(id);
	}

	@Override
	public List<Permission> getPermission() {
		// TODO Auto-generated method stub
		return PermissionDao.getPermission();
	}

	@Override
	public List<Permission> getPermissionByDepartment(int number1) {
		// TODO Auto-generated method stub
		return PermissionDao.getPermissionByDepartment(number1);
	}

	@Override
	public Permission insertPermission(Permission permission) {
		// TODO Auto-generated method stub
		return PermissionDao.insertPermission(permission);
	}

	@Override
	public Permission updatePermission(Permission permission) {
		// TODO Auto-generated method stub
		return PermissionDao.updatePermission(permission);
	}

	@Override
	public List<Permission> getPermissionByUserGroup(String usGId) {
		// TODO Auto-generated method stub
		return PermissionDao.getPermissionByUserGroup(usGId);
	}

	@Override
	public Permission deletePermission(List<Permission> permission) {
		// TODO Auto-generated method stub
		return PermissionDao.deletePermission(permission);
	}

	@Override
	public List<Permission> getPermissionByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return PermissionDao.getPermissionByRoleId(roleId);
	}
}
