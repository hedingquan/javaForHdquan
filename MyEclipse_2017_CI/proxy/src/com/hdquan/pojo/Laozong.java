package com.hdquan.pojo;

public class Laozong implements gongneng{
	private String name;
	
	public Laozong(String name) {
		super();
		this.name = name;
	}

	public Laozong() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void zhidingxiaomubiao()
	{
		System.out.println("指定小目标");
	}
}
