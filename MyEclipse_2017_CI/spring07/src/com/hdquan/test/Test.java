package com.hdquan.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String args[])
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//		String[] names = ac.getBeanDefinitionNames();
//		System.out.println(Arrays.toString(names));
		
		
		Demo demo = ac.getBean("demo",Demo.class);
		try {
			demo.demo1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	
	}
}
