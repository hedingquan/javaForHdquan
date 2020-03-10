package com.hdquan.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//一对多
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int depid;
	private String dname;
	private String location;
	//fetch=FetchType.LAZY为懒加载
	@OneToMany(mappedBy="department",fetch=FetchType.LAZY)//对方Employee的department来维护
	private Set<Employee> employees=new HashSet<Employee>();
	public int getDepid() {
		return depid;
	}
	public void setDepid(int depid) {
		this.depid = depid;
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
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
}
