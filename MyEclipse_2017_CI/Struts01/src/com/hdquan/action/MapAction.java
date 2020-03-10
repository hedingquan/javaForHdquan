package com.hdquan.action;

import java.util.Map;

import com.hdquan.pojo.Users;
import com.opensymphony.xwork2.ActionSupport;

public class MapAction extends ActionSupport{

	private Map<String,Users> map;


	public Map<String, Users> getMap() {
		return map;
	}


	public void setMap(Map<String, Users> map) {
		this.map = map;
	}


	public String execute(){
		
		return NONE;
	}
}
