package com.hdquan;

public class ComputerAver extends DoThing{
	DoThing nextDoThing;
	@Override
	public void doThing(double[] a) {
		// TODO Auto-generated method stub
		double sum=0;
		for(int i=0;i<a.length;i++)
		{
			sum=sum+a[i];
			double aver=sum/a.length;
			System.out.println("选手最后得分"+aver);
					
		}
	}

	@Override
	public void setNext(DoThing next) {
		// TODO Auto-generated method stub
		nextDoThing=next;
	}

}
