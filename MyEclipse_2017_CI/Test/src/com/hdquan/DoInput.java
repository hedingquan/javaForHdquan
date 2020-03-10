package com.hdquan;

import java.util.Scanner;

public class DoInput extends DoThing{
	DoThing nextDoThing;
	@Override
	public void doThing(double[] a) {
		// TODO Auto-generated method stub
		System.out.println("请输入裁判数");
		Scanner read=new Scanner(System.in);
		int count=read.nextInt();
		System.out.println("请输入各个裁判的分数");
		a=new double[count];
		for(int i=0;i<count;i++)
		{
			a[i]=read.nextDouble();
		}
		nextDoThing.doThing(a);
	}

	@Override
	public void setNext(DoThing next) {
		// TODO Auto-generated method stub
		nextDoThing =next;
	}
	

}