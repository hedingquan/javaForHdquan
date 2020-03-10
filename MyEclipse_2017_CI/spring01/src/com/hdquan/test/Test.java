package com.hdquan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hdquan.pojo.People;
import com.hdquan.pojo.PeopleFactory;
import com.hdquan.pojo.peopleFactory0;

public class Test {
	public static void main(String args[])
	{
//		People people =new People();
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		People people = ac.getBean("peo2",People.class);
		System.out.println(people);
//		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//		for(String string:beanDefinitionNames)
//		{
//			System.out.println(string);
//		}
		/*
		 * 实例化工厂
		 */
//		peopleFactory0 factory=new peopleFactory0();
//		People People = factory.newInstance();
		/*
		 * 静态工厂
		 */
//		People p = peopleFactory0.newInstance();
	}
}
