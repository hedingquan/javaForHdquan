package com.hdquan.advice;

import java.rmi.RemoteException;

import org.springframework.aop.ThrowsAdvice;

public class MyThrow implements ThrowsAdvice{
	 public void afterThrowing(ArithmeticException ex) throws Throwable {
	       System.out.println("执行异常通知-schema-bases方式");
	    }
}
