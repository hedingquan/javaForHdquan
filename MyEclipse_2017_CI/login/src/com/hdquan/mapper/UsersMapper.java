package com.hdquan.mapper;

import org.apache.ibatis.annotations.Select;

import com.hdquan.pojo.Users;

public interface UsersMapper {
	
	Users selByUsers(Users users);
}
