package com.hdquan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hdquan.mapper.UsersMapper;
import com.hdquan.pojo.Users;
import com.hdquan.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	@Resource
	private UsersMapper usersMapper;

	@Override
	public Users login(Users users) {
		
		return usersMapper.selByUsers(users);
	}
}
