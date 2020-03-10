package com.hdquan.pojo;

public class MiShu implements gongneng{
	private Laozong laozong=new Laozong("云云");

	@Override
	public void zhidingxiaomubiao() {
		System.out.println("请问你要找马总吗？");
		laozong.zhidingxiaomubiao();
		System.out.println("把访客信息备注");
	}

	
}
