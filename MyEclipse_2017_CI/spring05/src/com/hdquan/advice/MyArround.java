package com.hdquan.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import sun.reflect.MethodAccessor;

public class MyArround implements MethodInterceptor{
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("环绕-前置");
		Object result = arg0.proceed();//放行，调用切点方法
		System.out.println("环绕-后置");
		return result;
	}
	
}
