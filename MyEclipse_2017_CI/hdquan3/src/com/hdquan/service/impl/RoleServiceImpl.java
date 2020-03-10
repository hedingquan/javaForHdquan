package com.hdquan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdquan.dao.RoleDao;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;
import com.hdquan.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDao RoleDao;

	

	@Override
	public Role deleteRole(String ids) {
		// TODO Auto-generated method stub
		return  RoleDao.deleteRole(ids);
	}

	@Override
	public List<Role> getRoles(int page, int rows, String sort, String order, User user) {
		// TODO Auto-generated method stub
		return RoleDao.getRoles(page, rows, sort, order, user);
	}

	@Override
	public Long getTotal() {
		// TODO Auto-generated method stub
		return RoleDao.getTotal();
	}

	@Override
	public Role insertRole(Role role) {
		// TODO Auto-generated method stub
		return RoleDao.insertRole(role);
	}

	@Override
	public Role updateRole(Role role) {
		// TODO Auto-generated method stub
		return RoleDao.updateRole(role);
	}

	@Override
	public Role OtherinsertRole(Role role) {
		// TODO Auto-generated method stub
		return RoleDao.OtherinsertRole(role);
	}

	@Override
	public Role getRole(String number) {
		// TODO Auto-generated method stub
		return RoleDao.getRole(number);
	}

	@Override
	public List<Role> getRoleId(String roleId) {
		// TODO Auto-generated method stub
		return RoleDao.getRoleId(roleId);
	}

	@Override
	public List<Role> getDepartmentRoles(int number1) {
		// TODO Auto-generated method stub
		return RoleDao.getDepartmentRoles(number1);
	}

	@Override
	public List<Role> getUserGroupRoles(String usGId) {
		// TODO Auto-generated method stub
		return RoleDao.getUserGroupRoles(usGId);
	}

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return RoleDao.getRoles();
	}

	@Override
	public Role getRoleId(String roleId, int number1) {
		// TODO Auto-generated method stub
		return RoleDao.getRoleId(roleId,number1);
	}

	@Override
	public Role getRole(int permissionid) {
		// TODO Auto-generated method stub
		return RoleDao.getRole(permissionid);
	}

	@Override
	public List<Role> getRoles(String roleId) {
		// TODO Auto-generated method stub
		return RoleDao.getRoles(roleId);
	}

	@Override
	public List<Role> getRoles1() {
		// TODO Auto-generated method stub
		return RoleDao.getRoles1();
	}

	@Override
	public Long getThisUserTotal(String usercode) {
		// TODO Auto-generated method stub
		return RoleDao.getThisUserTotal(usercode);
	}
	
	
}
