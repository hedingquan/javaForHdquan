package com.hdquan.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	public void mybefore(String name1,int age1)
	{
		System.out.println("前置"+name1+"  "+age1);
	}
	public void mybefore1(String name1)
	{
		System.out.println("前置"+name1);
	}
//	public void myafter()
//	{
//		System.out.println("后置1");
//	}
//	public void myaftering()
//	{
//		System.out.println("后置2");
//	}
	public void mythrow()
	{
		System.out.println("异常通知");
	}
	public Object myarround(ProceedingJoinPoint p) throws Throwable
	{
		System.out.println("执行环绕");
		System.out.println("环绕-前置");
		Object result = p.proceed();
		System.out.println("环绕-后置");
		return result;
	}
}
