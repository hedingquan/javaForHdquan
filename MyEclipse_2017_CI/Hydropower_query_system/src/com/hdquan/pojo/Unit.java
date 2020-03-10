package com.hdquan.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="unit")
public class Unit {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uId;
	private String uName;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="unit")
	@JsonIgnore
	private Set<Account> account;
	public Set<Account> getAccount() {
		return account;
	}
	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
}
