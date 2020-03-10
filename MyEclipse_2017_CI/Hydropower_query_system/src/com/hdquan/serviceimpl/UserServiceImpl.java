package com.hdquan.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdquan.dao.UserDao;
import com.hdquan.pojo.User;
import com.hdquan.service.UserService;

@Service
@Transactional
public  class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	public User queryByNameAndPwd(String username) {
		// TODO Auto-generated method stub
		return userDao.queryByNameAndPwd(username);
	}
}
