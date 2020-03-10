package com.hdquan.pojo;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class UserGroup {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int usGId;
	private String usGName;
	private String descipt;
	private String leaderName;
	private String time;
	@OneToMany(mappedBy="userGroup",fetch=FetchType.EAGER,cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	@JsonIgnore
	private Set<User> users=new HashSet<User>();
	@OneToMany(mappedBy="userGroup",fetch=FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@JsonIgnore
	private Set<Role> roles=new HashSet<Role>();
	@ManyToOne(cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	private Department department;
	public int getUsGId() {
		return usGId;
	}
	public void setUsGId(int usGId) {
		this.usGId = usGId;
	}
	public String getUsGName() {
		return usGName;
	}
	public void setUsGName(String usGName) {
		this.usGName = usGName;
	}
	public String getDescipt() {
		return descipt;
	}
	public void setDescipt(String descipt) {
		this.descipt = descipt;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
