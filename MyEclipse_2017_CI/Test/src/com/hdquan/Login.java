package com.hdquan;

public class Login {
	boolean loginSuccess=false;
	int id;
	String password;
	public boolean isLoginSuccess() {
		return loginSuccess;
	}
	public void setLoginSuccess(boolean loginSuccess) {
		this.loginSuccess = loginSuccess;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
