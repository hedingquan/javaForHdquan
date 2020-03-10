package com.hdquan.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//“ª∂‘“ª
@Entity
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@OneToOne(cascade=CascadeType.ALL)
	private Address address2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress2() {
		return address2;
	}
	public void setAddress2(Address address2) {
		this.address2 = address2;
	}

}
