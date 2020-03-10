package com.hdquan.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ValidCode {
	public static String validCode(){
	
		List<Integer> randlist=new ArrayList<Integer>();
		Random random =new Random();
		for(int i=0;i<4;i++)
		{
			randlist.add(random.nextInt(10));
		}
		String number1=null;
	number1=randlist.get(0)+""+randlist.get(1)+""+randlist.get(2)+""+randlist.get(3);

	return number1;
	}
}
