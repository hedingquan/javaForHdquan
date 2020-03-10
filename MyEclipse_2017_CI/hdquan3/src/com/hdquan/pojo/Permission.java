package com.hdquan.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Permission", catalog = "table")
public class Permission{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	@Column(nullable=true)
	private Integer parentid;
	private String type;
	@Column(name = "Rejection_attribute")
	@org.hibernate.annotations.Type(type="yes_no")
	private Boolean Rejection_attribute;//拒绝属性
	@Column(name = "Mandatory_attribute")
	@org.hibernate.annotations.Type(type="yes_no")
	private Boolean Mandatory_attribute;//强制属性
	private String rank;//权限优先级
	
	@ManyToMany(fetch=FetchType.EAGER,cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	@JsonIgnore
	private Set<Role> roles=new HashSet<Role>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getRejection_attribute() {
		return Rejection_attribute;
	}

	public void setRejection_attribute(Boolean rejection_attribute) {
		Rejection_attribute = rejection_attribute;
	}

	public Boolean getMandatory_attribute() {
		return Mandatory_attribute;
	}

	public void setMandatory_attribute(Boolean mandatory_attribute) {
		Mandatory_attribute = mandatory_attribute;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
