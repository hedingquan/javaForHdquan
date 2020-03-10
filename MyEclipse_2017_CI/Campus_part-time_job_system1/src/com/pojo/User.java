package com.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
	@Id
	@GeneratedValue(generator = "user")
	@GenericGenerator(name = "user", strategy = "assigned")
	private String user_ID;
	private String user_password;
	private String user_type;
	public String getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "User [user_ID=" + user_ID + ", user_password=" + user_password + ", user_type=" + user_type + "]";
	}

	
}
