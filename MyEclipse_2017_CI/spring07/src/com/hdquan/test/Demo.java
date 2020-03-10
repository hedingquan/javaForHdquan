package com.hdquan.test;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	@Pointcut("execution(* com.hdquan.test.Demo.demo1())")
	public void demo1()
	{	
//		int a=5/0;
		System.out.println("demo1");
	}
}
