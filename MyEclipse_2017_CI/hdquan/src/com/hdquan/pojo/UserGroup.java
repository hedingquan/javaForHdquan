package com.hdquan.pojo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class UserGroup {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int usGId;
	private String usGName;
	private String descipt;
	private String leaderName;
	private Date time;
	@OneToMany(mappedBy="userGroup",fetch=FetchType.LAZY)
	private Set<User> users=new HashSet<User>();
	@OneToMany(mappedBy="userGroup",fetch=FetchType.LAZY)
	private Set<Role> roles=new HashSet<Role>();
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
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
	
}
