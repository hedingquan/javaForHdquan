package com.hdquan.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.hdquan.pojo.Account;
import com.hdquan.pojo.Log;
import com.hdquan.service.AccountService;

public class AccountServiceImpl implements AccountService{
	public int transfer(Account accOut) throws IOException {
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		//先判断账号和密码是否正确
		Account accOutSelect=session.selectOne("com.hdquan.mapper.AccountMapper.selByAccnoPwd",accOut);//直接一个账号传进去
		if(accOutSelect!=null)
		{return SUCCESS;}
		{//账号和密码不正确
			return ACCOUNT_PASSWORD_NOT_MATH;
		}
	}
	
}
