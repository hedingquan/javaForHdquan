package com.hdquan.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterAdvice implements AfterReturningAdvice{
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("arg0"+arg0);
		System.out.println("arg1"+arg1);
		System.out.println("arg2"+arg2);
		System.out.println("arg3"+arg3);
		System.out.println("执行后置");
	}
	
}
