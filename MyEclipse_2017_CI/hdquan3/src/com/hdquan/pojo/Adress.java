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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Adress {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String IPStart;
	private String IPEnd;
	@ManyToMany(fetch=FetchType.EAGER,cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	@JsonIgnore
	private Set<Role> roles=new HashSet<Role>();
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getIPStart() {
		return IPStart;
	}
	public void setIPStart(String iPStart) {
		IPStart = iPStart;
	}
	public String getIPEnd() {
		return IPEnd;
	}
	public void setIPEnd(String iPEnd) {
		IPEnd = iPEnd;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
