package com.hdquan.action;

import java.util.List;

import com.hdquan.pojo.Users;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport{

	private List<Users> list;
	
	public List<Users> getList() {
		return list;
	}

	public void setList(List<Users> list) {
		this.list = list;
	}

	public String execute(){
		
		return NONE;
	}
}
