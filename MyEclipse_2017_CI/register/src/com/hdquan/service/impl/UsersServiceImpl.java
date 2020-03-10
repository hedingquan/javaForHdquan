package com.hdquan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdquan.mapper.UserMapper;
import com.hdquan.pojo.Users;
import com.hdquan.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	@Resource
	private UserMapper usersMapper;
	public int insRegister(Users users) {
	
		return usersMapper.insUsers(users);
	}

}
