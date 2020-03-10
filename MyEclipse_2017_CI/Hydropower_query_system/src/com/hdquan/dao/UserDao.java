package com.hdquan.dao;


import com.hdquan.pojo.User;

public interface UserDao {
	
	public User queryByNameAndPwd(String username);

}
