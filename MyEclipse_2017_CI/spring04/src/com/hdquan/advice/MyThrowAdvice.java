package com.hdquan.advice;

public class MyThrowAdvice {
	public void myexception(Exception e1)
	{
		System.out.println("执行异常通知,异常信息message："+e1.getMessage());
	}
}
