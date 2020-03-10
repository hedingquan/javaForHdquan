package com.hdquan.pojo;
//¶à¶Ô¶à
import java.util.HashSet;
import java.util.Set;

public class Student {
	private int id;
	private String name;
	private Set courses=new HashSet();
	public void addCourse(Course c)
	{
		this.courses.add(c);
	}
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
	public Set getCourses() {
		return courses;
	}
	public void setCourses(Set courses) {
		this.courses = courses;
	}
	
}
