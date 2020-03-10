package com.hdquan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdquan.dao.UserDao;
import com.hdquan.dao.impl.UserDaoImpl;
import com.hdquan.pojo.User;
import com.hdquan.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	public User queryByNameAndPwd(User user) {
		// TODO Auto-generated method stub
		return userDao.queryByNameAndPwd(user);
	}

}
