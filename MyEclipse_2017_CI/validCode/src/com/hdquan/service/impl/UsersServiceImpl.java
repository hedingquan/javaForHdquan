package com.hdquan.service.impl;

import com.hdquan.mapper.UsersMapper;
import com.hdquan.pojo.Users;
import com.hdquan.service.UsersService;

public class UsersServiceImpl implements UsersService{
	private UsersMapper usersMapper;
	public UsersMapper getUsersMapper() {
		return usersMapper;
	}
	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}
	public Users login(Users users) {
	
		return usersMapper.selByUsersPwd(users);
	}
	
}
