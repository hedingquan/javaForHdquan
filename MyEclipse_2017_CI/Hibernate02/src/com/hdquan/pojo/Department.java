package com.hdquan.pojo;

import java.util.HashSet;
import java.util.Set;
//一对多
public class Department {
	private int deptid;
	private String dname;
	private String location;
	//Employees是外键，是一个集合
	//***双向关联（既可以通过A查询到B，也可以通过B查询到A）：关键是set，创建一个set容器，里面有很多的Employee，分别指向各自的Department。这样就全部员工都在set容器中了
	private Set<Employee> Employees=new HashSet<Employee>();
	
//	由一方维护关系
	public void addEmployee(Employee e) 
	{
		this.getEmployees().add(e);
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Set<Employee> getEmployees() {
		return Employees;
	}
	public void setEmployees(Set<Employee> Employee) {
		this.Employees = Employee;
	}
	
}
