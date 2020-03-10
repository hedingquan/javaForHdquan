package com.hdquan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdquan.pojo.ProvisionalAuthorization;
import com.hdquan.pojo.User;
import com.hdquan.service.ProvisionalAuthorizationService;
import com.hdquan.dao.ProvisionalAuthorizationDao;


@Service
@Transactional
public class ProvisionalAuthorizationServiceImpl implements ProvisionalAuthorizationService{

	@Autowired
	ProvisionalAuthorizationDao ProvisionalAuthorizationDao;

	@Override
	public List<ProvisionalAuthorization> getRoles(int page, int rows, String sort, String order, User user,ProvisionalAuthorization provisionalAuthorization) {
		// TODO Auto-generated method stub
		return ProvisionalAuthorizationDao.getRoles(page, rows, sort, order, user,provisionalAuthorization);
	}

	@Override
	public Long getTotal() {
		// TODO Auto-generated method stub
		return ProvisionalAuthorizationDao.getTotal();
	}

	@Override
	public ProvisionalAuthorization insertRole(ProvisionalAuthorization provisionalAuthorization) {
		// TODO Auto-generated method stub
		return ProvisionalAuthorizationDao.insertRole(provisionalAuthorization);
	}

	@Override
	public ProvisionalAuthorization deleteRole(String id) {
		// TODO Auto-generated method stub
		return ProvisionalAuthorizationDao.deleteRole(id);
	}

	@Override
	public ProvisionalAuthorization updateRole(ProvisionalAuthorization provisionalAuthorization) {
		// TODO Auto-generated method stub
		return ProvisionalAuthorizationDao.updateRole(provisionalAuthorization);
	}

	@Override
	public ProvisionalAuthorization getRole(String usercode) {
		// TODO Auto-generated method stub
		return ProvisionalAuthorizationDao.getRole(usercode);
	}

}
