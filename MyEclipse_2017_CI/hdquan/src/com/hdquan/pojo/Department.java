package com.hdquan.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int number;
	private String name;
	private String headerName;
	private String officeLocation;
	private int telephone;
	private boolean lastDepartment;
	private int parentDepart;
	@OneToMany(mappedBy="department",fetch=FetchType.LAZY)
	private Set<User> users=new HashSet<User>();
	@OneToMany(mappedBy="department",fetch=FetchType.LAZY)
	private Set<Role> roles=new HashSet<Role>();
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeaderName() {
		return headerName;
	}
	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}
	public String getOfficeLocation() {
		return officeLocation;
	}
	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public boolean isLastDepartment() {
		return lastDepartment;
	}
	public void setLastDepartment(boolean lastDepartment) {
		this.lastDepartment = lastDepartment;
	}
	public int getParentDepart() {
		return parentDepart;
	}
	public void setParentDepart(int parentDepart) {
		this.parentDepart = parentDepart;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
