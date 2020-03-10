package com.hdquan.advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import com.hdquan.pojo.Users;

public class MyAfter implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		// TODO Auto-generated method stub
		Logger logger=Logger.getLogger(MyAfter.class);//MyAfter.classָ���ǵ�ǰ��MyAfter��
		Users users=(Users) arg2[0];//��Ҫ�������Ѳ���ת��������Users�͵�
		if(arg0!=null)			//���ﷵ�ص��ǵ�¼���û�
		{
			logger.info(users.getUsername()+"��¼�ɹ���");
		}
		else
		{
			logger.info(users.getUsername()+"��¼ʧ�ܣ�");
		}
	}

}
