package com.hdquan.pojo;

public class Account {
	private int id;
	private String accNO;
	private int password;
	private String name;
	private double balance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccNO() {
		return accNO;
	}
	public void setAccNO(String accNO) {
		this.accNO = accNO;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
