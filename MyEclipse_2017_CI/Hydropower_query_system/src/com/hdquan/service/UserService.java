package com.hdquan.service;

import com.hdquan.pojo.User;

public interface UserService {
	
	public User queryByNameAndPwd(String username);
	
}
