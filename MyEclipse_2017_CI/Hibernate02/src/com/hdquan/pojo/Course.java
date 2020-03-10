package com.hdquan.pojo;
//¶à¶Ô¶à
import java.util.HashSet;
import java.util.Set;

public class Course {
	private Long id;
	private String name;
	private Set students=new HashSet();
	public void addStudent(Student s)
	{
		this.students.add(s);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set getStudents() {
		return students;
	}
	public void setStudents(Set students) {
		this.students = students;
	}
	
}
