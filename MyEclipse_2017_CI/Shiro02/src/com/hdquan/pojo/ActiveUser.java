package com.hdquan.pojo;

import java.util.List;

public class ActiveUser implements java.io.Serializable{
	private String userid;
	private String usercode;//�û��˺�
	private String username;//�û�����
	private List<SysPermission> menus;//�˵�
	private List<SysPermission> permissions;//Ȩ��
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<SysPermission> getMenus() {
		return menus;
	}
	public void setMenus(List<SysPermission> menus) {
		this.menus = menus;
	}
	public List<SysPermission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}
	
}
