package com.hdquan.pojo;

import javax.persistence.Entity;

@Entity
public class admin extends User {
	private int type=1;

	public int getType() {
		return type;
	}
	
}
