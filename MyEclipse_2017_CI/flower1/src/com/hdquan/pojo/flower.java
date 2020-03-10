package com.hdquan.pojo;

public class flower {
	private int id;
	private String name;
	private double price;
	private String production;	
	public flower(int id, String name, double price, String production) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.production = production;
	}
	public flower()
	{
		
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getname()
	{
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getprice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getproduction() {
		return this.production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
}
