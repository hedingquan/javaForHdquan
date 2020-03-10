package com.hdquan.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleId;
	@ManyToMany(mappedBy="roles")
	private Set<Adress> Adress=new HashSet<Adress>();
	@ManyToMany(mappedBy="roles")
	private Set<Permission> permissions=new HashSet<Permission>();
	@ManyToMany(mappedBy="roles")
	private Set<User> users=new HashSet<User>();
	@ManyToOne(cascade=CascadeType.ALL)
	private Department department;
	@ManyToOne(cascade=CascadeType.ALL)
	private Permission power;
	@ManyToOne(cascade=CascadeType.ALL)
	private UserGroup userGroup;
	
	
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
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
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
	public Permission getPower() {
		return power;
	}
	public void setPower(Permission power) {
		this.power = power;
	}
	
}
