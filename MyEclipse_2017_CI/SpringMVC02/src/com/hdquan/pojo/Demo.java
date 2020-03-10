package com.hdquan.pojo;

import java.util.List;

public class Demo {
	private List<People> peo;
	private String name;

	public List<People> getPeo() {
		return peo;
	}

	public void setPeo(List<People> peo) {
		this.peo = peo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Demo [peo=" + peo + ", name=" + name + "]";
	}
	
}
