package com.hdquan;

public class SingleTon {
	//�������ʱ����ʵ������
	private static SingleTon singleTon=new SingleTon();
	private SingleTon(){}
	public static SingleTon getInstance()
	{
		return singleTon;
	}
}
