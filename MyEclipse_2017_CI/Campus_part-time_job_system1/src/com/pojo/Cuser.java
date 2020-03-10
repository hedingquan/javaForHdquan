package com.pojo;

import javax.persistence.Entity;

@Entity
public class Cuser extends User{
	private String user_name;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
}
