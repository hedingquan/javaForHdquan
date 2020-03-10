package com.hdquan.mapper;

import org.apache.ibatis.annotations.Select;

import com.hdquan.pojo.Users;

public interface UsersMapper {
	@Select("select * from users where username=#{username} and password=#{password}")
	Users selByUsersPwd(Users users);
}
