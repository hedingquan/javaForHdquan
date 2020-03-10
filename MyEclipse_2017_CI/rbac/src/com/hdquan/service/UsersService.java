package com.hdquan.service;

import java.util.Map;

import com.hdquan.pojo.Users;

public interface UsersService {
	
//	(1) Users login(Users users);
	Map<String,Object> login(Users users);
}
