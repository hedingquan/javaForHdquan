package com.hdquan.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * �Զ�ע��
 */
public class Test {
	public static void main(String args[])
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Teacher peo1 = ac.getBean("teacher1",Teacher.class);
		Teacher peo2 = ac.getBean("teacher1",Teacher.class);
		System.out.println(peo1==peo2);//trueΪ������false��ʾ����
	
	}
}
