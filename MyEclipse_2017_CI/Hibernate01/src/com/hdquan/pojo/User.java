package com.hdquan.pojo;

import java.sql.Date;

public class User {
	private int id;
	private String uname;
	private Date birthday;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User(String uname, Date birthday) {
		super();
		this.uname = uname;
		this.birthday = birthday;
	}
}
