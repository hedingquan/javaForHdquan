package com.hdquan.test;

public class Test {
	public static void main(String args[])
	{
	final ThreadLocal<String> threadlocal=new ThreadLocal<>();
	threadlocal.set("测试");
	new Thread(){
		public void run(){
				String result = threadlocal.get();
					System.out.println(result);
						}
				}.start();
	}
				}