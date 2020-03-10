package com.hdquan.pojo;

import java.util.List;

public class Users {
	private int id;
	private String username;
	private String password;
	private int rid;
	private List<Menu> menus;

	private List<Element> element;
	
	private List<Url> url;
	
	public List<Url> getUrl() {
		return url;
	}
	public void setUrl(List<Url> url) {
		this.url = url;
	}
	public int getRid() {
		return rid;
	}
	public List<Element> getElement() {
		return element;
	}
	public void setElement(List<Element> element) {
		this.element = element;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
