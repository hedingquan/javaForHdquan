package com.hdquan;

public class SingleTon {
	//在类加载时进行实例化，
	private static SingleTon singleTon=new SingleTon();
	private SingleTon(){}
	public static SingleTon getInstance()
	{
		return singleTon;
	}
}
