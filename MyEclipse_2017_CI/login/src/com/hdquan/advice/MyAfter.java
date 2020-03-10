package com.hdquan.advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import com.hdquan.pojo.Users;

public class MyAfter implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		Logger logger=Logger.getLogger(MyAfter.class);//MyAfter.class指的是当前的MyAfter类
		Users users=(Users) arg2[0];//需要参数，把参数转化过来成Users型的
		if(arg0!=null)			//这里返回的是登录的用户
		{
			logger.info(users.getUsername()+"登录成功！");
		}
		else
		{
			logger.info(users.getUsername()+"登录失败！");
		}
	}

}
