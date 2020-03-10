package com.hdquan.pojo;

import javax.persistence.Entity;

@Entity
public class ExtendDepartment extends Department{

	private int parentDepartment;

	public int getParentDepartment() {
		return parentDepartment;
	}

	public void setParentDepartment(int parentDepartment) {
		this.parentDepartment = parentDepartment;
	}
	
}
