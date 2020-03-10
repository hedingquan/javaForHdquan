package com.hdquan.pojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TreeNode implements java.io.Serializable{

	private String id;
	private String text;//树节点名称
	private String iconCls;//前面的小图标样式
	private Boolean checked=false;//是否勾选状态
	private Map<String,Object> attributes;//其他参数
	private List<TreeNode> children;//子节点
	private String state="open";//是否展开
	
	private String _parentId;//为了treegrid
	
	private String group;//为了PropertyGrid
	
	private Set<User> users;
	
	private Set<Role> roles;
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String get_parentId() {
		return _parentId;
	}
	public void set_parentId(String _parentId) {
		this._parentId = _parentId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
} 
