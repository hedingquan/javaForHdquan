package com.hdquan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String args[])
	{
//		Demo demo=new Demo();
//		demo.demo1();
//		demo.demo2();
//		demo.demo3();
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo demo = ac.getBean("demo",Demo.class);
		try {
			demo.demo1();
		} catch (Exception e) {
		
//			e.printStackTrace();
		}
//		demo.demo2();
//		demo.demo3();
//		demo.demo4("传递的参数");
//		demo.demo5("demo5的参数");
//		Demo1 demo1 = ac.getBean("demo1",Demo1.class);
//		demo1.demo11();
	}
}
