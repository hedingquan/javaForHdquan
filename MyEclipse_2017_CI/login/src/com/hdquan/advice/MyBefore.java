package com.hdquan.advice;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import com.hdquan.pojo.Users;

public class MyBefore implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		// TODO Auto-generated method stub
		Users users=(Users)arg1[0];//��Ҫ�����������
		Logger logger=Logger.getLogger(MyBefore.class);
		logger.info(users.getUsername()+"��"+new Date().toLocaleString()+"���е�¼");
	}

}
