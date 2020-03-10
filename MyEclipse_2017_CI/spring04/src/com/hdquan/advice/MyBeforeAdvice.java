package com.hdquan.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice{
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
	
		System.out.println("切点方法对象："+arg0+",方法名:"+arg0.getName());
		if(arg1!=null&&arg1.length>0){
			System.out.println("切点方法参数"+arg1[0]);			
		}
		else
		{
			System.out.println("切点方法无参数");	
		}
		System.out.println("对象："+arg2);
		System.out.println("执行前置通知");
	}
	
}
