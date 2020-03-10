package com.hdquan.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
//把该类放入二级缓存中
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Course implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Course(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}