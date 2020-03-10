package com.hdquan.pojo;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Clob;

public class User2 {
	private int id;
	private String name;
	private String password;
	private Blob image;
	private Clob resume;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public Clob getResume() {
		return resume;
	}
	public void setResume(Clob resume) {
		this.resume = resume;
	}
	
}
