package com.hdquan.pojo;

import java.util.List;

public class Teacher {
	private int id1;
	private String name;
	private List<Student> list;
	
	public int getId() {
		return id1;
	}
	public void setId(int id) {
		this.id1 = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Teacher [id1=" + id1 + ", name=" + name + ", list=" + list + "]";
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	
}
