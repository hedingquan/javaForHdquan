package com.hdquan;

import java.util.Arrays;

public class DelMaxAndMin extends DoThing{
	DoThing nextDoThing;
	@Override
	public void doThing(double[] a) {
		// TODO Auto-generated method stub
			Arrays.sort(a);
			double[] b=Arrays.copyOfRange(a, 1, a.length-1);
			System.out.println("去掉一个最高分:"+a[a.length-1]+",");
			System.out.println(a[0]);
			nextDoThing.doThing(b);
	}

	@Override
	public void setNext(DoThing next) {
		// TODO Auto-generated method stub
		nextDoThing=next;
	}

}