package com.hdquan.pojo;

import org.hibernate.annotations.Cascade;

public class Student extends Person{
	private String school;
	private int studentNum;
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	
}
