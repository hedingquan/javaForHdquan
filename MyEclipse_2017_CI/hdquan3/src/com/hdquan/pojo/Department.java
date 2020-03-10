package com.hdquan.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int number1;
	private String name;
	private String headerName;
	private String officeLocation;
	private String telephone;
	private boolean lastDepartment=true;

	@OneToMany(mappedBy="department",fetch=FetchType.EAGER,cascade={javax.persistence.CascadeType.REFRESH,javax.persistence.CascadeType.PERSIST,javax.persistence.CascadeType.MERGE}) 
	@JsonIgnore
	private Set<User> users=new HashSet<User>();
	@OneToMany(mappedBy="department",fetch=FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JsonIgnore
	private Set<Role> roles=new HashSet<Role>();
	@OneToMany(mappedBy="department",fetch=FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@JsonIgnore
	private Set<UserGroup> userGroups=new HashSet<UserGroup>();
	public boolean isLastDepartment() {
		return lastDepartment;
	}
	public void setLastDepartment(boolean lastDepartment) {
		this.lastDepartment = lastDepartment;
	}
	public String getName() {
		return name;
	}
	public int getNumber1() {
		return number1;
	}
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<UserGroup> getUserGroups() {
		return userGroups;
	}
	public void setUserGroups(Set<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}
	
}
