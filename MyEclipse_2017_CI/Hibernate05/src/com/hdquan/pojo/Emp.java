package com.hdquan.pojo;

public class Emp {
	private Short empno;
	private String ename;
	public Short getEmpno() {
		return empno;
	}
	public void setEmpno(Short empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Emp(Short empno, String ename) {
		super();
		this.empno = empno;
		this.ename = ename;
	}
	
}
