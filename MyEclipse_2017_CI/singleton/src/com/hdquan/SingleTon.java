package com.hdquan;

public class SingleTon {
	//由于对象需要被静态方法调用，把方法设置为static
	//由于对象是static，必须要设置访问权限修饰符为private，如果是public可以直接调用对象，不执行访问入口
	private static SingleTon singleTon;
	private SingleTon()//其他类不能实例化这个类对象
	{
		
	}
	//，但需要对外提供访问入口
	//实例方法，实例方法必须通过对象调用，但是构造函数已经私有化了，因此外面无法取到
	//设置方法为静态方法

	public static SingleTon getInstance()
	{
		//添加逻辑如果实例化过，直接返回
		if(singleTon==null)
		{
			//多线程访问下，可能出现if同时成立的情况，添加锁
			synchronized(SingleTon.class)
			{
				//双重验证
				if(singleTon==null)
				{
					singleTon=new SingleTon();
				}
			}
		}
		return singleTon;
	}
}
