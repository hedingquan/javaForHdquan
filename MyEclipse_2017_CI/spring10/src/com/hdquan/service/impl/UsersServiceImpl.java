package com.hdquan.service.impl;

import com.hdquan.pojo.Users;
import com.hdquan.service.UsersService;

public class UsersServiceImpl implements UsersService{

	@Override
	public int insert(Users users) {
		
		return 0;
	}

	@Override
	public int insUsers(Users users) {
		System.out.println("asdad");
		insert(users);
		System.out.println("fds");
		return 0;
	}
//与上面是有区别的
	public int updUsers(Users users) throws Exception {
		insert(users);
		throw new Exception();
	}
}
