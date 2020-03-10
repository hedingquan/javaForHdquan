package com.hdquan.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int number;
	private String roleId;
	
	private String RequestRole;
	private String HasUserLogin;
	
	@ManyToMany(mappedBy="roles",fetch=FetchType.EAGER,cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	@JsonIgnore
	private Set<Adress> Adress=new HashSet<Adress>();
	
	@ManyToMany(mappedBy="roles",fetch=FetchType.EAGER,cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	@JsonIgnore
	private Set<User> users=new HashSet<User>();
	
	@ManyToOne(cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	private Department department;
	
	@ManyToMany(mappedBy="roles",fetch=FetchType.EAGER,cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Permission> permission=new HashSet<Permission>();
	
	@ManyToOne(cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	private UserGroup userGroup;
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Set<Adress> getAdress() {
		return Adress;
	}
	public void setAdress(Set<Adress> adress) {
		Adress = adress;
	}
	public UserGroup getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Set<Permission> getPermission() {
		return permission;
	}
	public void setPermission(Set<Permission> permission) {
		this.permission = permission;
	}
	public String getRequestRole() {
		return RequestRole;
	}
	public void setRequestRole(String requestRole) {
		RequestRole = requestRole;
	}
	public String getHasUserLogin() {
		return HasUserLogin;
	}
	public void setHasUserLogin(String hasUserLogin) {
		HasUserLogin = hasUserLogin;
	}
	
}
