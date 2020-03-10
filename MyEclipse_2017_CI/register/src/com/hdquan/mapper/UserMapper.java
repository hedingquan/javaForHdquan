package com.hdquan.mapper;

import org.apache.ibatis.annotations.Insert;

import com.hdquan.pojo.Users;

public interface UserMapper {
	@Insert("insert into users values (default,#{username},#{password},#{photo})")
	int insUsers(Users users);
}
