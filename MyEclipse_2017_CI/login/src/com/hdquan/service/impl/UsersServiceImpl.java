package com.hdquan.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hdquan.mapper.UsersMapper;
import com.hdquan.pojo.Users;
import com.hdquan.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	@Value("${my.demo}")//从spring文件中快速的取出来赋值给变量
	private String test;//不需要和properties文件里面的名一样
	@Value("${my.demo1}")
	private int test1;
	
	@Resource
	private UsersMapper usersmapper;
	
//	public UsersMapper getUsersmapper() {
//		return usersmapper;
//	}
//主要是因为@Resource默认按照byName注入
//	public void setUsersmapper(UsersMapper usersmapper) {
//		this.usersmapper = usersmapper;
//	}

	public Users login(Users users) {
		System.out.println("输出"+test);
		System.out.println("输出"+test1);
		return usersmapper.selByUsers(users);
	}
	
}
