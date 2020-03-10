package com.hdquan.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	@Before("com.hdquan.test.Demo.demo1()")	
	public void mybefore()
		{
			System.out.println("前置");
		}
	@After("com.hdquan.test.Demo.demo1()")
	public void myafter()
	{
		System.out.println("后置");
	}
	@AfterThrowing("com.hdquan.test.Demo.demo1()")
	public void mythrow()
	{
		System.out.println("异常通知");
	}
	@Around("com.hdquan.test.Demo.demo1()")
	public Object myarround(ProceedingJoinPoint p) throws Throwable
	{
		System.out.println("环绕--前置");
		Object result = p.proceed();
		System.out.println("环绕--后置");
		return result;
	}
}
