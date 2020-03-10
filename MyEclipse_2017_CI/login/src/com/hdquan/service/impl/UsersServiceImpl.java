package com.hdquan.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hdquan.mapper.UsersMapper;
import com.hdquan.pojo.Users;
import com.hdquan.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	@Value("${my.demo}")//��spring�ļ��п��ٵ�ȡ������ֵ������
	private String test;//����Ҫ��properties�ļ��������һ��
	@Value("${my.demo1}")
	private int test1;
	
	@Resource
	private UsersMapper usersmapper;
	
//	public UsersMapper getUsersmapper() {
//		return usersmapper;
//	}
//��Ҫ����Ϊ@ResourceĬ�ϰ���byNameע��
//	public void setUsersmapper(UsersMapper usersmapper) {
//		this.usersmapper = usersmapper;
//	}

	public Users login(Users users) {
		System.out.println("���"+test);
		System.out.println("���"+test1);
		return usersmapper.selByUsers(users);
	}
	
}
